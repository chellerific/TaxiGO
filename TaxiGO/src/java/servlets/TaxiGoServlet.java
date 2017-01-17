package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Bookings;
import service.Database_Service;
import service.Taxiinfo;
import service.Taxioperator;
import taxigoresource.HashMD5;

/**
 *
 * @author Sara
 */
public class TaxiGoServlet extends HttpServlet {

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
        ServletContext sc = null;
        RequestDispatcher rd = null;
        boolean found = false;
        String function = (String) request.getParameter("function");
        String username = "";
        String password = "";
        HashMD5 md5 = new HashMD5();

        if (function.equals("Report")) {
            String name = request.getParameter("chosen");
            System.out.println("Checkbox value = " + name);
            String res = reportuser(name);
            System.out.println("The reporting is: " + res);
            username = (String)request.getSession().getAttribute("username");
            password = (String)request.getSession().getAttribute("password");
            System.out.println("User after reporting: " + username);
            System.out.println("Pass after reporting: " + password);
            request.getSession().setAttribute("reported", true);
        } else {
            username = request.getParameter("username");
            password = md5.md5(request.getParameter("password"));
            request.getSession().setAttribute("reported", false);
        }
        

        List<Taxiinfo> taxis = getOperators();
        int s = taxis.size();
        String tempUser = null;
        String tempPass = null;
        found = false;

        for (int i = 0; i < s; i++) {
            tempUser = taxis.get(i).getUsername();
            tempPass = taxis.get(i).getPassword();
            if (tempUser.equalsIgnoreCase(username) && tempPass.equals(password)) {
                found = true;
                break;
            }

        }
        if (found) {
            sc = getServletContext();
            rd = sc.getRequestDispatcher("/operatormain.jsp");
            List<Bookings> bookings = getbookings(username, "operator");

            int size = bookings.size();
            for (int i = 0; i < size; i++) {
                request.setAttribute("data" + i, bookings.get(i));
            }

            Taxioperator prices = getpriceinfoforoperator(username);
            request.setAttribute("price", prices);
            
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);

            rd.forward(request, response);
        } else {
            sc = getServletContext();
            rd = sc.getRequestDispatcher("/operatorlogin.jsp");
            request.setAttribute("error", "Username and password don't match database!");
            rd.forward(request, response);
        }

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

    private java.util.List<Bookings> getbookings(String username, String usertype) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getbookings(username, usertype);
    }

    private java.util.List<service.Taxiinfo> getOperators() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getOperators();
    }

    private Taxioperator getpriceinfoforoperator(java.lang.String operator) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service.Database port = service.getDatabasePort();
        return port.getpriceinfoforoperator(operator);
    }

    private String reportuser(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.reportuser(username);
    }

}
