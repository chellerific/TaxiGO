<%-- 
    Document   : customersendpassword
    Created on : Jan 20, 2017, 3:25:32 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Welcome Customer!</font></h1><br>
        <h2><font face="Trebuchet MS"><b>Write down username and email, so an email can be sent with a link to the page where you can change password. </b></h2><br>
        <form action="CustomerLogIn" method="GET">
            <input type="text" placeholder="username" name="username" required style="height:25px; width:300px; font-size: 18px"/><br>
            <br>
            <input type="text" placeholder="email" name="email" required style="height:25px; width:300px; font-size: 18px" /><br>
            <br>
            <input type='submit' name="click" value="Send" required style = "height:30px; width:100px; font-size: 16px" /><br>
            <br>
            <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b></form> </center>
    </body>
</html>
