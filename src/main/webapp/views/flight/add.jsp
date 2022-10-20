<%@ page import="com.marocair.models.table.TableAirport" %>
<%@ page import="com.marocair.controller.AirportController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.marocair.models.model.Price" %>
<%@ page import="com.marocair.controller.PriceController" %>
<%@ page import="com.marocair.models.model.Airline" %>
<%@ page import="com.marocair.controller.AirlineController" %>
<%@ page import="com.marocair.models.table.TableFlight" %><%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 19/10/2022
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New flight </title>
    <%  List<TableAirport> airports = AirportController.getAllAirports();
        PriceController priceController = new PriceController();
        List<Price> prices = priceController.getPrices();
        AirlineController airlineController = new AirlineController();
        List<Airline> airlines = airlineController.getAirlines();

    %>


            <form method="post">
        <table>
            <tr>
                <td>Departure</td>
                <td>
                    <select name="departure_airport_id">
                        <option value="0"> -- please choose option --</option>
                        <%
                            for(TableAirport airport: airports){
                             %>
                            <option value="<%=airport.getAirport_id()%>"><%=airport.getAirport_name()%></option>
                        <% } %>

                    </select>
                </td>
            </tr>
            <tr>
                <td>Arrival</td>
                <td>

                    <select name="arrival_airport_id">
                        <option value="0"> -- please choose option --</option>
                        <%
                            for(TableAirport airport: airports){
                             %>
                            <option value="<%=airport.getAirport_id()%>"><%=airport.getAirport_name()%></option>
                        <% } %>

                    </select>
                </td>

            </tr>
            <tr>
                <td>Departure Date</td>
                <td><input type="date" name="departure_time"></td>
            </tr>
            <tr>
                <td>Arrival Date</td>
                <td><input type="date" name="arrival_time"></td>
            </tr>
            <tr>
                <td>Departure Time</td>
                <td><input type="time" name="departure_hour"></td>
            </tr>
            <tr>
                <td>Arrival Time</td>
                <td><input type="time" name="arrival_hour"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                <select name="flight_price_id">
                    <option value="0"> -- Please choose one --</option>
                    <% for (Price price : prices) { %>
                     <option value="<%= price.getPrice_id() %>"> <p>  <%=price.getPrice_value()%> </p>  <%} %> </option>
                </select>
                </td>
            </tr>
            </tr>
            <tr>
                <td>Maximum capacity</td>
                <td><input type="number" name="flight_max_capacity"></td>
            </tr>
            </tr>
            <tr>
                <td>Airlines</td>
                <td>
                <select name="airline_id">
                    <option value="0"> -- Please choose one --</option>
                    <% for (Airline airline : airlines) { %>
                    <option value="<%= airline.getAirline_id() %>"> <p>  <%=airline.getAirline_name()%> </p>  <%} %> </option>
                </select>
                </td>
            </tr>

        </table>
        <input type="submit" value="Add">
    </form>




</head>
<body>

</body>
</html>
