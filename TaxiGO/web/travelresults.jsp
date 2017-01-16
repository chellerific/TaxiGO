<%-- 
    Document   : results
    Created on : Jan 14, 2017, 5:59:12 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guest Booking</title>
    </head>


    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyBNbG6ORa4A8nX8VEAoufHiWn_LC9LsPk0"></script>
    <script type="text/javascript">
        var origin = "<%= request.getAttribute("originLoc")%>",
                destination = "<%= request.getAttribute("destLoc")%>",
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
        <form method="POST" action="ConfirmTaxi"> 
            <h1>Travel Results</h1>
            <br>
            <br><br>
            Origin: <input id="orig" type="text" style="width:35em"><br><br>
            Destination: <input id="dest" type="text" style="width:35em"><br><br>
            Distance : <input id="dist" type="text" style="width:35em">
            <input type="submit" name="click" value="Confirm your Booking" /> 
        </form>

    </body>
</html>
