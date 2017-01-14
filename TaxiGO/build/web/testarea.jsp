<%-- 
    Document   : newjsp
    Created on : Jan 14, 2017, 5:12:05 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyBNbG6ORa4A8nX8VEAoufHiWn_LC9LsPk0"></script>
        <script type="text/javascript">
            var origin = "Västra Rönneholmsvägen, Malmö",
                    destination = "Triangeln, Malmö",
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
    </head>
    <body>
        <br>
        Basic example for using the Distance Matrix.<br><br>
        Origin: <input id="orig" type="text" style="width:35em"><br><br>
        Destination: <input id="dest" type="text" style="width:35em"><br><br>
        Distance from Statue of Liberty to Washington DC, USA (by car): <input id="dist" type="text" style="width:35em">
    </body>
</html>