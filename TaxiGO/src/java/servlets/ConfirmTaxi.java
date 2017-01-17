/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Bookings;
import service.Database_Service;
import service.Taxioperator;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "ConfirmTaxi", urlPatterns = {"/ConfirmTaxi"})
public class ConfirmTaxi extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;
    private double totalPrice;
    private double distance;

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
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String tempDist = request.getParameter("distance");

        List<Taxioperator> prices = getpriceinfo();
        int size = prices.size();
        for (int i = 0; i < size; i++) {
            request.setAttribute("price" + i, prices.get(i));
        }

//        Scanner scan = new Scanner(tempDist);
//        if (scan.hasNextDouble()) {
//            distance = scan.nextDouble();
//        } else {
//            distance = 0;
//        }
        if (clickBtn.equals("Confirm Booking Plan")) {
            String chosen = request.getParameter("chosen");
            System.out.println("Taxi Operator: " + chosen);
            String booking = addBooking(chosen, "guest", origin, destination, totalPrice);
            System.out.println("Booking saved: " + booking);
        } else {

            String parsedDist = parseDist(tempDist);
            System.out.println(parsedDist);
            distance = Double.parseDouble(parsedDist);
            System.out.println(distance);
            double baseRate;
            double pricePerKm;

            ArrayList<Double> priceArr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                baseRate = prices.get(i).getBaserate();
                System.out.println("Base rate: " + baseRate);
                pricePerKm = prices.get(i).getPriceperkm();
                System.out.println("Price / km: " + pricePerKm);
                totalPrice
                        = Double.parseDouble(new DecimalFormat("##.##").format(baseRate
                                        + (pricePerKm * distance)));
                priceArr.add(totalPrice);
                System.out.println("Total Price: " + totalPrice);
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
            String destination, double price) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();

        return port.addBooking(companyName, customer, origin, destination, price);
    }

    private String parseDist(String distance) {
        Pattern p = Pattern.compile("[a-z]+|\\d+\\.\\d+");
        Matcher m = p.matcher(distance);
        ArrayList<String> allMatches = new ArrayList<>();
        while (m.find()) {
            allMatches.add(m.group());
        }
        return allMatches.get(0);
    }

}
