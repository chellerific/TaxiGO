<%-- 
    Document   : guestbooking
    Created on : Jan 9, 2017, 7:51:59 PM
    Author     : Chelsi
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Guest - Taxi GO</title>
    <h1>Welcome Guest. Choose your travel.</h1>
    <form action="Guest" method="GET">
        <input type="text" placeholder="Your location.." name="origin" />
        <input type="text" placeholder="Your destination.." name="dest" />
        <input type='submit' name="click" value="Book a Travel" /> 
    </form>
</head>
</html>
