/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Database_Service;

/**
 *
 * @author Sara
 */

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
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
        String name = request.getParameter("number1");
        String baseRate = request.getParameter("number2");
        String pricePerKm = request.getParameter("number3");
        String weekendFee = request.getParameter("number4");
        String rating = request.getParameter("number5");
        
        String email = request.getParameter("number6");
        String phone = request.getParameter("number7");
        String password = request.getParameter("number8");
    
        double base = 0;
        double perkm = 0;
        double wknd = 0;
        int rate = 0;
        
        try {
            base = Double.parseDouble(baseRate);
            perkm = Double.parseDouble(pricePerKm);
            wknd = Double.parseDouble(weekendFee);
            rate = Integer.parseInt(rating);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        String result = addoperator(name, base, perkm, wknd, rate);
        System.out.println("Adding taxi: " + result);
        String res = addoperatorlogin(name, password, email, phone);
        System.out.println("Adding user: " + res);
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/updated.jsp");

        rd.forward(request, response);
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

    private String addoperator(String operator, double baserate, double priceperkm, double weekendfee, int rating) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        
        return port.addoperator(operator, baserate, priceperkm, weekendfee, rating);
    }

    private String addoperatorlogin(java.lang.String operator, java.lang.String password, java.lang.String email, java.lang.String phone) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.addoperatorlogin(operator, password, email, phone);
    }
    
    private void sendEmail(List <String> sendTo) {
        try {
            //This properties are valid for gmail.  You need to check for other mail providers/servers/agents.
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            System.out.println("So far so good -1 setting up session parameters");

            //  Authentication is performed here.  
            MyAuth auth = new MyAuth("SENDER", "PASSWORD");
            System.out.println("So far so good-2 authenticator called....");

            //  The mail session is instantiated
            //  The rest is copied from Java Mail documentation.
            String messageBody = "MESSAGE FROM INPUT";

            Session mailConnection = Session.getInstance(props, auth);
            Message msg = new MimeMessage(mailConnection);
            Address sender = new InternetAddress("SENDER EMAIL HERE", "Travel Reservation System");
            Address receiver = new InternetAddress("DESTINATION EMAIL HERE FROM INPUT");
            Session session = Session.getInstance(props);
            msg.setContent(messageBody, "text/plain");
            msg.setFrom(sender);
            msg.setRecipient(Message.RecipientType.TO, receiver);
            msg.setSubject("Booking");

            Transport transport = session.getTransport("smtp");
            transport.connect("SENDER EMAIL HERE", "PASSWORD");


            Transport.send(msg);
        } catch (MessagingException e) {
            System.out.printf("Messaging Exception: " + e.getMessage());
//          throw new RuntimeException(e);
        } catch (Exception ex) {
            System.out.printf("General Exception: ");
            ex.printStackTrace();
        }
        
    }
    
    private class MyAuth extends Authenticator {

        private PasswordAuthentication authentication;

        public MyAuth(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

}
