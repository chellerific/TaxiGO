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

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "Results", urlPatterns = {"/Results"})

public class Results extends HttpServlet {

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
        if (clickBtn.equals("Confirm your Booking")) {
            request.getRequestDispatcher("confirmtaxi.jsp").forward(request, response);

        }

    }
}