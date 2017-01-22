/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Database_Service;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "ChooseUser", urlPatterns = {"/ChooseUser"})

public class ChooseUserServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;

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
        //The logic that checks which type of user the client wants to log in as

        String clickBtn = request.getParameter("click");
        if (clickBtn.equals("Guest")) {
            request.getSession().setAttribute("booker", "guest"); //Sets the current session as a guest
            request.getRequestDispatcher("guestbooking.jsp").forward(request, response);

        } else if (clickBtn.equals("Customer")) {
            request.getRequestDispatcher("customerlogin.jsp").forward(request, response);

        } else if (clickBtn.equals("Taxi Operator")) {
            request.getRequestDispatcher("operatorlogin.jsp").forward(request, response);
        } else if (clickBtn.equals("Administrator")) {
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }

    }


}
