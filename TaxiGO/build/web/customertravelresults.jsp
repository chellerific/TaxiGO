<%-- 
    Document   : customertravelresults
    Created on : Jan 17, 2017, 8:49:51 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Booking - Taxi GO</title>
    </head>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyBNbG6ORa4A8nX8VEAoufHiWn_LC9LsPk0"></script>
    <script type="text/javascript">
        var origin = "<%= request.getAttribute("custOriginLoc")%>",
                destination = "<%= request.getAttribute("custDestLoc")%>",
                service = new google.maps.DistanceMatrixService();

        service.getDistanceMatrix(
                {
                    origins: [origin],
                    destinations: [destination],
                    travelMode: google.maps.TravelMode.DRIVING,
                    avoidHighways: false,
                    avoidTolls: false
                },
        callback
                );

        function callback(response, status) {
            var orig = document.getElementById("orig"),
                    dest = document.getElementById("dest"),
                    dist = document.getElementById("dist");

            if (status == "OK") {
                orig.value = response.originAddresses[0];
                dest.value = response.destinationAddresses[0];
                dist.value = response.rows[0].elements[0].distance.text;
            } else {
                alert("Error: " + status);
            }
        }

    </script>
    <body>
        <br>
        <br>
        <br>
    <center>
        <form method="POST" action="ConfirmTaxi"> 
            <h1><font face="Trebuchet MS">Travel Results</h1>
            <br>
            Origin: <input id="orig" type="text" name="origin" readonly="true" style="height:50px; width:500px; font-size: 18px"><br><br>
            Destination: <input id="dest" type="text" name="destination" readonly="true" style="height:50px; width:500px; font-size: 18px"><br><br>
            Distance : <input id="dist" type="text" name="distance" readonly="true" style="height:50px; width:500px; font-size: 18px"><br>
            <br>
            <input type="submit" name="click" value="Confirm Your Booking" style="height:50px; width:250px; font-size: 18px"/> 
        </form>
    </center>
    </body>
</html>
