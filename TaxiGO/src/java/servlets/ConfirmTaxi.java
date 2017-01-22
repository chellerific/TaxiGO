/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Clientinfo;
import service.Database_Service;
import service.Taxioperator;
import taxigoresource.CalculatePriceEJB;
import taxigoresource.EmailSenderEJB;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "ConfirmTaxi", urlPatterns = {"/ConfirmTaxi"})
public class ConfirmTaxi extends HttpServlet {

    @EJB
    private CalculatePriceEJB calculatePriceEJB;

    @EJB
    private EmailSenderEJB emailSenderEJB;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;
    private double totalPrice;
    private double distance;
    private String origin;
    private String destination;
    private ArrayList<Double> priceArr;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/confirmtaxi.jsp");
        String clickBtn = (String) request.getParameter("click");
        origin = (String) request.getSession().getAttribute("originStr"); //retrieves the session's specified origin
        destination = (String) request.getSession().getAttribute("destStr"); //retrieves the sessions's specified destination
        String tempDist = request.getParameter("distance");
        
        //Sets up the list of taxi companies and prices which is retrieved by the confirmtaxi JSP
        List<Taxioperator> prices = getpriceinfo();
        int size = prices.size();
        for (int i = 0; i < size; i++) {
            request.setAttribute("price" + i, prices.get(i));
        }
         
        if (clickBtn.equals("Confirm Booking Plan")) {
            //Checks which type of booker is booking and wants to confirm a travel plan
            String booker = (String) request.getSession().getAttribute("booker");

            if (booker.equals("guest")) {
                
                //Guest session
                String chosen = request.getParameter("chosen"); //Chosen taxi company
                String[] temp = chosen.split(" ");
                chosen = temp[0];
                totalPrice = Double.parseDouble(temp[1]);

                System.out.println("Taxi Operator: " + chosen);
                String date = request.getParameter("date");
                String time = request.getParameter("time");

                String booking = addBooking(chosen, "guest", origin, destination, totalPrice, date, time);
                System.out.println("Origin: " + origin);
                System.out.println("Destination: " + destination);
                System.out.println("Booked by: " + booker);
                System.out.println("Booking saved: " + booking);
                System.out.println("Date: " + date);
                System.out.println("Time: " + time);
                
                //sets the specific variables to the current session which can be retrieved later in receipts

                request.getSession().setAttribute("origin", origin);
                request.getSession().setAttribute("dest", destination);
                request.getSession().setAttribute("operator", chosen);
                request.getSession().setAttribute("totalPrice", totalPrice);
                request.getSession().setAttribute("booker", booker);
                request.getRequestDispatcher("receipt.jsp").forward(request, response);
            } else {
                
                //Customer session
                String chosen = request.getParameter("chosen");
                String customer = (String) request.getSession().getAttribute("booker");
                String[] temp = chosen.split(" ");
                chosen = temp[0];
                totalPrice = Double.parseDouble(temp[1]);

                System.out.println("Taxi Operator: " + chosen);
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                String booking = addBooking(chosen, booker, origin, destination, totalPrice, date, time);
                System.out.println("Origin: " + origin);
                System.out.println("Destination: " + destination);
                System.out.println("Booked by: " + booker);
                System.out.println("Booking saved: " + booking);
                System.out.println("Date: " + date);
                System.out.println("Time: " + time);
                System.out.println("Price: " + totalPrice);
                sendConfirmEmail(customer, chosen, origin, destination, totalPrice);
                request.getSession().removeAttribute("originStr");
                request.getSession().removeAttribute("destStr");
                request.getRequestDispatcher("receipt.jsp").forward(request, response);
            }
        } else {
            //If the user hasn't chosen yet, calculate the prices for each taxi company and display it
            String parsedDist = parseDist(tempDist);
            distance = Double.parseDouble(parsedDist);

            priceArr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                priceArr.add(calculatePriceEJB.calculatePrice(prices.get(i), distance));
            }
            request.setAttribute("priceArr", priceArr);
            rd.forward(request, response);

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<Taxioperator> getpriceinfo() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getpriceinfo();
    }

    private String addBooking(String companyName, String customer, String origin,
            String destination, double price, String date, String time) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();

        return port.addBooking(companyName, customer, origin, destination, price, date, time);
    }

    private java.util.List<service.Clientinfo> getclients() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }

    private String parseDist(String distance) {
        String[] numbers = distance.split(" ");

        return numbers[0];
    }

    private void sendConfirmEmail(String username, String operator, String origin,
            String destination, double price) {
        //Confirmation email sent to the registered customer immediately after booking
        List<Clientinfo> clients = getclients();
        String uname;
        String tempEmail;
        String title = "Your booking has now been completed";
        String message = "Hello, " + username + "." + "\n" + "You have made the following taxi booking: " + "\n"
                + "Origin: " + origin + "\n"
                + "Destination: " + destination + "\n"
                + "Taxi Operator: " + operator + "\n"
                + "Price: " + price + " SEK" + "\n"
                + "You may pay your trip within a time period limit of 7 days. " + "\n"
                + "Pay through the following bank giro number: xxxx-xxxx-xxxx-xxxx";

        for (int i = 0; i < clients.size(); i++) {
            uname = clients.get(i).getUsername();
            if (uname.equals(username)) {
                tempEmail = clients.get(i).getEmail();
                System.out.println("Email: " + tempEmail);
                emailSenderEJB.sendEmail(tempEmail, title, message);

            }
        }

    }

}
