<%-- 
    Document   : newjsp
    Created on : Jan 11, 2017, 5:23:41 PM
    Author     : Sara
--%>

<%@page import="service.Clientinfo"%>
<%@page import="service.Taxiinfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator - Taxi GO</title>
    </head>
    <body>
    <center><h2><font face="Trebuchet MS"><b>List of Customers</b></h2><br><br>
        <form method="POST" action="AdminLoginServlet" >
            <table border="2">
                <tr>
                    <td>Username</td>
                    <td>Email</td>
                    <td>Phone</td>
                    <td>Reported</td>
                </tr>
                <%
                    Clientinfo client = (Clientinfo) request.getAttribute("client0");
                    int index = 0;

                    if (client != null) {
                        while (client != null) {
                            index = index + 1;

                %>
                <tr>
                    <td><%=client.getUsername()%></td>
                    <td><%=client.getEmail()%></td>
                    <td><%=client.getPhone()%></td>
                    <td><%=client.isReported()%></td>
                    <td><input type="radio" name="chosen"value= "<%=client.getUsername()%>" required </td>

                </tr>
                <%

                            client = (Clientinfo) request.getAttribute("client" + index);
                        }
                    }
                %>
            </table>
            <br>
            <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
            <br>
            <input type="submit" value="Remove" name="function"> 
        </form> <br><br>

        <h2><b>List of Taxi Operators</b></h2><br>
        <table border="2">
            <tr>
                <td>Username</td>
                <td>E-mail</td>
                <td>Phone</td>
            </tr>
            <%
                Taxiinfo taxi = (Taxiinfo) request.getAttribute("taxi0");
                int i = 0;

                if (taxi != null) {
                    while (taxi != null) {
                        i = i + 1;

            %>
            <tr>
                <td><%=taxi.getUsername()%></td>
                <td><%=taxi.getEmail()%></td>
                <td><%=taxi.getPhone()%></td>
            </tr>
            <%

                        taxi = (Taxiinfo) request.getAttribute("taxi" + i);
                    }
                }
            %>
        </table>
        <br>
        <form method="POST" action=adminaddoperator.jsp> 
            <input type="submit" value="Add operator" name="function" />
        </form><br>

        <b>Send E-mail to Registered Users</b><br>
        <form method="POST" action=sendemail.jsp> 
            <input type="submit" value="Send e-mail" name="function" />
        </form><br></center>
    </body>
</html>
