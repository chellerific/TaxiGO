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
import javax.xml.ws.WebServiceRef;
import service.Admininfo;
import service.Clientinfo;
import service.Database_Service;
import service.Taxiinfo;
import taxigoresource.HashMD5;

/**
 *
 * @author Sara
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {
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

        String username = "";
        String password = "";      
        String function = (String) request.getParameter("function");
        
        if (function.equals("Remove")) {
            String name = request.getParameter("chosen");
            System.out.println("Checkbox value = " + name);
            String res = removeuser(name);
            System.out.println("The reporting is: " + res);
            username = (String)request.getSession().getAttribute("username");
            password = (String)request.getSession().getAttribute("password");
            System.out.println("User after removing: " + username);
            System.out.println("Pass after removing: " + password);
            request.getSession().setAttribute("reported", true);
        } else {
            username = request.getParameter("username");
            password = HashMD5.md5(request.getParameter("password"));
            request.getSession().setAttribute("reported", false);
        }
        
        List<Admininfo> admins = getadmininfo();
        int s = admins.size();
        String tempUser = null;
        String tempPass = null;
        found = false;

        for (int i = 0; i < s; i++) {
            tempUser = admins.get(i).getUsername();
            tempPass = admins.get(i).getPassword();
            if (tempUser.equalsIgnoreCase(username) && tempPass.equals(password)) {
                found = true;
                break;
            }

        }
        if (found) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            sc = getServletContext();
            rd = sc.getRequestDispatcher("/adminmain.jsp");
            List <Clientinfo> clients = getclients();
            List <Taxiinfo> infos = getOperators();
            
            int size = clients.size();
            for (int i = 0; i < size; i++) {
                request.setAttribute("client" + i, clients.get(i));
            }
            
            int infosize = infos.size();
            for (int i = 0; i < infosize; i++) {
                request.setAttribute("taxi" + i, infos.get(i));
            }
            
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);

            rd.forward(request, response);
        } else {
            sc = getServletContext();
            rd = sc.getRequestDispatcher("/adminlogin.jsp");
            request.setAttribute("error", "Username and password don't match database!");
            rd.forward(request, response);
        }
        }

    private java.util.List<service.Clientinfo> getclients() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getclients();
    }

    private java.util.List<service.Taxiinfo> getOperators() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getOperators();
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

    private java.util.List<service.Admininfo> getadmininfo() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.getadmininfo();
    }

    private String removeuser(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        service = new Database_Service();
        service.Database port = service.getDatabasePort();
        return port.removeuser(username);
    }

}
