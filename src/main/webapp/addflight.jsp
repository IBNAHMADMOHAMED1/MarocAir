<%@ page import="com.marocair.models.model.Airport" %>
<%@ page import="com.marocair.controller.AirportController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.marocair.models.table.TableAirport" %><%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 19/10/2022
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    // form creation a flight
    <%
        // getAllAirports method static in the class controller
        List<TableAirport> airports = AirportController.getAllAirports();
    %>
    <form action="http://localhost:8080/flight" method="post">
        <%--@declare id="airport"--%><label for="airport">Airport</label>
        <slect name="departure" id="departure">
            <% for (TableAirport airport : airports) { %>
                <option value="<%=airport.getAirport_id()%>"><%=airport.getAirport_name()%></option>
        </slect>
        <label for="airport">Airport Arrival</label>
        <slect name="arrival" id="arrival">
            <% for (TableAirport airportA : airports) { %>
                <option value="<%=airportA.getAirport_id()%>"><%=airportA.getAirport_name()%></option>
        </slect>
        <label for="date">Date</label>
        <input type="date" name="date" id="date">
        <label for="time">Time</label>
        <input type="time" name="time" id="time">
    </form>



</head>
<body>

</body>
</html>
