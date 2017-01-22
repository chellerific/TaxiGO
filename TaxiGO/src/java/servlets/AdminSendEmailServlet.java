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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Clientinfo;
import service.Database_Service;
import taxigoresource.EmailSenderEJB;

/**
 *
 * @author Sara
 */
@WebServlet (name = "AdminSendEmailServlet", urlPatterns = {"/AdminSendEmailServlet"})
public class AdminSendEmailServlet extends HttpServlet {
    @EJB
    private EmailSenderEJB emailSenderEJB;
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
        //Gets all clients, and sends email to them via EJB. 
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        List <Clientinfo> clients = getclients();
        
        List <String> receiver = new ArrayList<>();
        
        int size = clients.size();
        for (int i = 0; i < size; i++) {
            receiver.add(clients.get(i).getEmail());
        }
        
        emailSenderEJB.setRecipientsAndSendEmail(receiver, title, message);
        
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/updated.jsp").forward(request, response);
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

    private java.util.List<service.Clientinfo> getclients() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }

}
