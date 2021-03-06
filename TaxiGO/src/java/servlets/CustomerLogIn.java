/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
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
import taxigoresource.EmailSenderEJB;
import taxigoresource.HashMD5;

/**
 *
 * @author Chelsi
 */
@WebServlet(name = "CustomerLogIn", urlPatterns = {"/CustomerLogIn"})
public class CustomerLogIn extends HttpServlet {
    @EJB
    private EmailSenderEJB emailSenderEJB;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TaxiGOServerNew/Database.wsdl")
    private Database_Service service;
    private boolean isReported;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clickBtn = request.getParameter("click");

        List<Clientinfo> customers = getCustomer();
        boolean found = false;
        ServletContext sc = null;
        RequestDispatcher rd = null;
        String uname;
        String pass;

        if (clickBtn.equals("Log In")) {
            String username = request.getParameter("uname");
            String password = HashMD5.md5(request.getParameter("pass"));
            //Compares the username and password if they do exist in the database
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
                //If the user is found, lead them to their homepage
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

        } else if (clickBtn.equals("Send")) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            boolean isMatch = false;
            
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUsername().equalsIgnoreCase(username)){
                    if (customers.get(i).getEmail().equalsIgnoreCase(email)) {
                        isMatch = true;
                    }
                }
            }
            
            if (isMatch) {
                emailSenderEJB.sendEmail(email, "Change password", getEmail());
                request.setAttribute("error", "An e-mail has been sent");
                request.getRequestDispatcher("/customersendpassword.jsp").forward(request, response); 
            } else {
                request.setAttribute("error", "Username and/or email don't match the database.");
                request.getRequestDispatcher("/customersendpassword.jsp").forward(request, response); 
                
            }
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
    
    private String getEmail () {
        //For retrieving lost passwords
        String message = "Hello! \n\n You can change your password by clicking on the link below: \n"
                + "'http://localhost:8080/TaxiGO/customerchangepassword.jsp'";
        
        return message;
    }
}
