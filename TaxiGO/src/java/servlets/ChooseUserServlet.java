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
import service.Bookings;
import service.Clientinfo;
import service.Database_Service;
import service.Taxiinfo;
import service.Taxioperator;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "ChooseUser", urlPatterns = {"/ChooseUser"})

public class ChooseUserServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        ServletContext sc = getServletContext();
//        RequestDispatcher rd = sc.getRequestDispatcher("/operatormain.jsp");
//
//        rd.forward(request, response);
//
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

//        String guestBtn = request.getParameter("guest");
//        String customerBtn = request.getParameter("customer");
//        String taxiBtn = request.getParameter("taxiOperator");
//        String adminBtn = request.getParameter("admin");
        String clickBtn = request.getParameter("click");
        if (clickBtn.equals("Guest")) {
            request.getRequestDispatcher("guestbooking.jsp").forward(request, response);

        } else if (clickBtn.equals("Customer")) {

        } else if (clickBtn.equals("TaxiOperator")) {
            request.getRequestDispatcher("start.jsp").forward(request, response);
        } else if (clickBtn.equals("Administrator")) {
            List <Clientinfo> clients = getclients();
            List <Taxiinfo> taxis = getOperators();
            
            int size = clients.size();
            for (int i = 0; i < size; i++) {
                request.setAttribute("client" + i, clients.get(i));
            }
            
            int taxisize = taxis.size();
            for (int i = 0; i < taxisize; i++) {
                request.setAttribute("taxi" + i, taxis.get(i));
            }
            
            request.getRequestDispatcher("adminmain.jsp").forward(request, response);
        }

    }

    private java.util.List<service.Clientinfo> getclients() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }

    private java.util.List<service.Taxiinfo> getOperators() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getOperators();
    }

}
