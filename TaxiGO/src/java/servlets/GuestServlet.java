/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.sun.net.httpserver.HttpServer;
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
@WebServlet(name = "Guest", urlPatterns = {"/Guest"})
public class GuestServlet extends HttpServlet {

    String origin;
    String dest;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        origin = request.getParameter("origin");
        dest = request.getParameter("dest");
        String clickBtn = request.getParameter("click");

        request.setAttribute("originLoc", origin);
        request.setAttribute("destLoc", dest);

        if (clickBtn.equals("Book a Travel")) {

            request.getRequestDispatcher("results.jsp").forward(request, response);
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
}
