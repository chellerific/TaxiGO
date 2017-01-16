<%-- 
    Document   : customerlogin
    Created on : Jan 14, 2017, 11:21:46 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taxi GO</title>
    </head>
    <body>
        <h1>Welcome Customer!</h1>
        <form action="CustomerLogIn" method="GET">
            <input type="text" placeholder="username" name="uname" />
            <input type="password" placeholder="password" name="pass" />
            <input type='submit' name="click" value="Log In" />
            <input type='submit' name="click" value="Register" />
            <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b></form>
    </body>
</html>
