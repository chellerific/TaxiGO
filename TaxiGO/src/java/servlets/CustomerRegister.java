/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Clientinfo;
import service.Database_Service;
import taxigoresource.HashMD5;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "CustomerRegister", urlPatterns = {"/CustomerRegister"})
public class CustomerRegister extends HttpServlet {

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
        List <Clientinfo> customers = getclients();
        boolean isFree = true;

        String username = request.getParameter("uname");
        String password = HashMD5.md5(request.getParameter("pass"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String temp = "";
        
        for (int i = 0; i < customers.size(); i++) {
            temp = customers.get(i).getUsername();
            if (temp.equalsIgnoreCase(username)) {
                isFree = false;
            } 
        }

        String clickBtn = request.getParameter("click");

        if (clickBtn.equals("Register") && isFree == true) {
            String result = addCustomer(username, password, email, phone, false);
            System.out.println("Adding customer: " + result);
            request.getRequestDispatcher("confirmregister.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "username already taken!");
            request.getRequestDispatcher("customerregister.jsp").forward(request, response); 
        }

    }

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

    private String addCustomer(String username, String password, String email, String phone, boolean reported) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();

        return port.addCustomer(username, password, email, phone, reported);
    }

    private java.util.List<service.Clientinfo> getclients() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }

}
