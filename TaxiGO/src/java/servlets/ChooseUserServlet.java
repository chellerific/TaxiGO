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
import service.Bookings;
import service.Taxioperator;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "ChooseUser", urlPatterns = {"/ChooseUser"})

public class ChooseUserServlet extends HttpServlet {

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

        } else if (clickBtn.equals("Taxi Operator")) {

        } else if (clickBtn.equals("Administrator")) {

        }

    }
}
