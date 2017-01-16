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
        <title>Main page</title>
    </head>
    <body>
        <b>Here are lists of users:</b><br><br>
        <b>The users:</b><br>
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
                    <td><input type="checkbox" name="chosen"value= "<%=client.getUsername()%>" </td>

                </tr>
                <%

                            client = (Clientinfo) request.getAttribute("client" + index);
                        }
                    }
                %>
            </table>
            <input type="submit" value="Remove" name="function"> 
        </form> <br><br>

        <b>The taxi operators:</b><br>
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
        <form method="POST" action=adminaddoperator.jsp> 
            <input type="submit" value="Add operator" name="function" />
        </form><br>

        <b>Send e-mail to registered users: </b><br>
        <form method="POST" action=sendemail.jsp> 
            <input type="submit" value="Send e-mail" name="function" />
        </form><br>
    </body>
</html>
