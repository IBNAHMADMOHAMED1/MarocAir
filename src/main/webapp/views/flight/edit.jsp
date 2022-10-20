<%@ page import="com.marocair.models.table.TableFlight" %>
<%@ page import="com.marocair.controller.PriceController" %>
<%@ page import="com.marocair.models.model.Price" %>
<%@ page import="com.marocair.controller.AirlineController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.marocair.models.model.Airline" %>
<%@ page import="com.marocair.models.table.TableAirport" %>
<%@ page import="com.marocair.controller.AirportController" %><%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 20/10/2022
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%  //get filghts request
        TableFlight flight = (TableFlight) request.getAttribute("flight");
        PriceController priceController = new PriceController();
        List<Price> prices = priceController.getPrices();
        AirlineController airlineController = new AirlineController();
        List<Airline> airlines = airlineController.getAirlines();
        List<TableAirport> airports = AirportController.getAllAirports();

    %>
    <form method="post" action="http://localhost:8080/MarocAir_war_exploded/flight?action=update">
        <table>
            <tr>
                <td>Departure</td>
                <td>
                    <select name="departure_airport_id">
                        <option value="<%=flight.getDeparture_airport_id()%>"><%=flight.getDeparture_airport_name()%></option>
                        <% for (TableAirport airport : airports) { %>
                            <option value="<%=airport.getAirport_id()%>"><%=airport.getAirport_name()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Arrival</td>
                <td>
                    <select name="arrival_airport_id">
                        <option value="<%=flight.getArrival_airport_id()%>"><%=flight.getArrival_airport_name()%></option>
                        <% for (TableAirport airport : airports) { %>
                            <option value="<%=airport.getAirport_id()%>"><%=airport.getAirport_name()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Departure Date</td>
                <td><input type="date" name="departure_time" value="<%=flight.getDeparture_time()%>"></td>
            </tr>
            <tr>
                <td>Arrival Date</td>
                <td><input type="date" name="arrival_time" value="<%=flight.getArrival_time()%>"></td>
            </tr>
            <tr>
                <td>departure_hour</td>
                <td><input type="time" name="departure_hour" value="<%=flight.getHeure_depart()%>"></td>
            </tr>
            <tr>
                <td>arrival_hour</td>
                <td><input type="time" name="arrival_hour" value="<%=flight.getHeure_arrivee()%>"></td>
            </tr>
            <tr>
                <td>flight_max_capacity</td>
                <td><input type="number" name="flight_max_capacity" value="<%=flight.getFlight_max_capacity()%>"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <select name="flight_price_id">
                        <option value="<%=flight.getPrice_id()%>"><%=flight.getPrice_value()%></option>
                        <% for (Price price : prices) { %>
                            <option value="<%=price.getPrice_id()%>"><%=price.getPrice_value()%></option>
                        <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Airline</td>
                <td>
                    <select name="airline_id">
                        <option value="<%=flight.getAirline_id()%>"><%=flight.getArrival_airport_name()%></option>
                        <% for (Airline airline : airlines) { %>
                            <option value="<%=airline.getAirline_id()%>"><%=airline.getAirline_name()%></option>
                        <% } %>
                    </select>
                </td>
                <input type="hidden" name="id" value="<%=flight.getFlight_id()%>">
            </tr>
        </table>
        <input type="submit" value="Update">
    </form>


</head>
<body>

</body>
</html>
