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
import service.Taxioperator;
import taxigoresource.HashMD5;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "CustomerLogIn", urlPatterns = {"/CustomerLogIn"})
public class CustomerLogIn extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;
    private boolean isReported;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("uname");
//        String password = request.getParameter("pass");
        String clickBtn = request.getParameter("click");

        HashMD5 md5 = new HashMD5();
        String password = md5.md5(request.getParameter("pass"));

        List<Clientinfo> customers = getCustomer();
        boolean found = false;
        ServletContext sc = null;
        RequestDispatcher rd = null;
        String uname;
        String pass;

        if (clickBtn.equals("Log In")) {
            for (int i = 0; i < customers.size(); i++) {
                uname = customers.get(i).getUsername();
                pass = customers.get(i).getPassword();
                if (uname.equalsIgnoreCase(username)
                        && pass.equals(password)) {
                    isReported = customers.get(i).isReported();

                    found = true;
                    break;

                }
            }
            if (found) {
                request.getSession().setAttribute("uname", username);
                request.getSession().setAttribute("pass", password);
                request.getSession().setAttribute("booker", username);
                request.getSession().setAttribute("status", isReported);
                request.getRequestDispatcher("customermain.jsp").forward(request, response);
            } else {
                sc = getServletContext();
                rd = sc.getRequestDispatcher("/customerlogin.jsp");
                request.setAttribute("error", "Invalid username or password.");
                rd.forward(request, response);
            }
        } else if (clickBtn.equals("Register")) {
            request.getRequestDispatcher("customerregister.jsp").forward(request, response);

        }
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

    }

    private java.util.List<Clientinfo> getCustomer() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }
}
