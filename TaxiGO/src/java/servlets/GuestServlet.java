/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import javax.servlet.ServletContext;
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
        
        /*retrieves the origin and destinations specified by the user and sets them to be
        retievable throughout the session*/

        origin = request.getParameter("origin");
        dest = request.getParameter("dest");
        String clickBtn = request.getParameter("click");
        String guest = (String) request.getSession().getAttribute("booker");

        request.setAttribute("originLoc", origin);
        request.setAttribute("destLoc", dest);

        if (clickBtn.equals("Book a Travel")) {
            request.getSession().setAttribute("destStr", dest);
            request.getSession().setAttribute("originStr", origin);
            request.getSession().setAttribute("booker", guest);
            request.getRequestDispatcher("guesttravelresults.jsp").forward(request, response);
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
