<%@ page import="com.marocair.models.model.Flight" %>
<%@ page import="com.marocair.models.table.TableFlight" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 18/10/2022
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://kit.fontawesome.com/8464c41458.js" crossorigin="anonymous"></script>

<script src="Components/Navbar.js" type="module"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto+Mono:wght@700&display=swap"
      rel="stylesheet">
<head>
    <title>Title</title>
    <p>List Flights</p>
    <%
        Flight flight = new Flight();
        List<TableFlight> flights = new ArrayList<TableFlight>();
        flights = flight.getAllFlight();
    %>
    // message
    <%
        if (request.getAttribute("message") != null) {
            %>
            <div class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded relative"
                 role="alert">
                <strong class="font-bold">Success!</strong>
                <span class="block sm:inline"><%= request.getAttribute("message") %></span>
                <span class="absolute top-0 bottom-0 right-0 px-4 py-3">
                    <alert:svg class="fill-current h-6 w-6 text-green-500" role="button" xmlns:alert="http://www.w3.org/2000/svg"
                               xmlns:alert="http://www.w3.org/2000/svg"
                               viewBox="0 0 20 20">
                        <alert:title>Close</alert:title>
                        <alert:path
                                d="M14.348 14.849a1.2 1.2 0 0 1-1.697 0L10 11.819l-2.651 3.029a1.2 1.2 0 1 1-1.697-1.697l2.758-3.15-2.759-3.152a1.2 1.2 0 1 1 1.697-1.697L10 8.183l2.651-3.031a1.2 1.2 0 1 1 1.697 1.697l-2.758 3.152 2.758 3.15a1.2 1.2 0 0 1 0 1.698z"/>
                    </alert:svg>
                </span>
            </div>
            <%
        }
            %>
        }


    <div class="flex justify-end">
        <form method="get" action="flight?action=add">
            <input type="hidden" name="action" value="add">
            <button type="submit"
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
                Add Flight
            </button>
        </form>
    </div>
    <table class="w-full text-sm text-left text-gray-500 ">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50  ">
        <tr>
            <th class="px-4 py-3">ID</th>
            <th class="px-4 py-3">Departure</th>
            <th class="px-4 py-3">Arrival</th>
            <th class="px-4 py-3">Date</th>
            <th class="px-4 py-3">Time</th>
            <th class="px-4 py-3">Price</th>
            <th class="px-4 py-3">Max capacity</th>
            <th class="px-4 py-3">Actions</th>
        </tr>
        </thead>
        <tbody class="divide-y  ">
        <%
            for (TableFlight tableFlight : flights) {
        %>
        <tr>
            <td class="px-4 py-3"><%= tableFlight.getFlight_id() %></td>
            <td class="px-4 py-3"><%= tableFlight.getDeparture_airport_name() %></td>
            <td class="px-4 py-3"><%= tableFlight.getArrival_airport_name() %></td>
            <td class="px-4 py-3"><%= tableFlight.getDeparture_time() %></td>
            <td class="px-4 py-3"><%= tableFlight.getHeure_depart() %></td>
            <td class="px-4 py-3"><%= tableFlight.getPrice_value() %></td>
            <td class="px-4 py-3"><%= tableFlight.getFlight_max_capacity() %></td>

            <td class="px-4 py-3">
            <div class="flex gap-3 cursor-pointer">
                <form method="get" action="flight">
                    <input type="hidden" name="id" value="<%= tableFlight.getFlight_id() %>">
                    <input type="hidden" name="action" value="edit">
                    <button class="text-blue-500 hover:text-blue-600" type="submit">
                        <i class="fas fa-edit"></i>
                    </button>
                </form>
                <form method="get" action="flight?action=delete">
                    <input type="hidden" name="id" value="<%= tableFlight.getFlight_id() %>">
                    <input type="hidden" name="action" value="delete">
                    <button class="text-red-500 hover:text-red-600" type="submit">
                        <i class="fas fa-trash"></i>
                    </button>
                </form>



            </div>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</head>
<body>

</body>
</html>
