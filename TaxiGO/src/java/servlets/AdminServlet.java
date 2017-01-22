/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
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
import service.Taxiinfo;
import taxigoresource.HashMD5;

/**
 *
 * @author Sara
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;

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
        //This method will add a new operator, with info being sent to two different tables: 
        //Taxiinfo and Taxioperator
        List<Taxiinfo> taxis = getOperators();
        boolean isFree = true;
        String name = request.getParameter("number1");
        String baseRate = request.getParameter("number2");
        String pricePerKm = request.getParameter("number3");
        String weekendFee = request.getParameter("number4");
        String rating = request.getParameter("number5");

        String email = request.getParameter("number6");
        String phone = request.getParameter("number7");
        String password = HashMD5.md5(request.getParameter("number8"));

        String temp;
        
        //Loop that checks that the operator doesn't already exist
        for (int i = 0; i < taxis.size(); i++) {
            temp = taxis.get(i).getUsername();
            if (temp.equalsIgnoreCase(name)) {
                isFree = false;
            }
        }

        if (isFree) { //If username was not taken, add values to database
            double base = 0;
            double perkm = 0;
            double wknd = 0;
            int rate = 0;

            try {
                base = Double.parseDouble(baseRate);
                perkm = Double.parseDouble(pricePerKm);
                wknd = Double.parseDouble(weekendFee);
                rate = Integer.parseInt(rating);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            String result = addoperator(name, base, perkm, wknd, rate);
            System.out.println("Adding taxi: " + result);
            String res = addoperatorlogin(name, password, email, phone);
            System.out.println("Adding user: " + res);

            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/updated.jsp");

            rd.forward(request, response);
        } else { //If username was already taken. 
            request.setAttribute("error", "Taxi operator already exists");
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/adminaddoperator.jsp");

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

    private String addoperator(String operator, double baserate, double priceperkm, double weekendfee, int rating) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();

        return port.addoperator(operator, baserate, priceperkm, weekendfee, rating);
    }

    private String addoperatorlogin(java.lang.String operator, java.lang.String password, java.lang.String email, java.lang.String phone) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.addoperatorlogin(operator, password, email, phone);
    }

    private java.util.List<service.Taxiinfo> getOperators() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getOperators();
    }

}
