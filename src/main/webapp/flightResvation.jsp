<%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 10/20/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="sweetalert2.min.js"></script>
    <link rel="stylesheet" href="sweetalert2.min.css">

</head>
<body>

<div class="w-full min-h-screen">

    <div class="w-full h-[70px] bg-white flex justify-around  z-10">
        <div class="bg-blue-400">
            <h1>Logo</h1>
        </div>
        <div class="w-3/4 h-full flex justify-around items-center">
            <div class="w-1/2">
                <ul class="flex justify-evenly items-center  w-full h-full">
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">HOME</a>
                    </li>
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">Your Cart</a>
                    </li>
                    <li>
                        <a href="" style="font-family: 'Poppins', sans-serif">Favourites</a>
                    </li>
                </ul>
            </div>
            <div class="w-1/4 flex justify-end items-end">
                <div class="w-1/2 flex items-center justify-around">
                    <a href="admin/Auth.jsp" style="font-family: 'Poppins', sans-serif">Login</a>

                    <a href="#" style="font-family: 'Poppins', sans-serif">Sign up</a>
                </div>
            </div>
        </div>
    </div>




    <div class="w-full h-1/2 bg-blue-400 flex justify-center items-center">

        <c:forEach var="items" items="${flightData}">
            <div class="bg-white space-x-2 w-1/2 flex justify-center items-center h-fit py-2 px-4 rounded-md shadow-xl">
                <div class="w-1/2 space-y-3">
                    <div class="flex space-x-2  items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">Airline Number: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">#${items.getAirline_id()} </h1>
                    </div>
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">Flight Number: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getFlight_number()} </h1>

                    </div>
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">depart Airport: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getDeparture_time()} </h1>
                    </div>
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base" style="font-family: 'Poppins', sans-serif">arrival Airport: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getArrival_time()} </h1>
                    </div>

                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base" style="font-family: 'Poppins', sans-serif">depart Hour: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getDeparture_hour()}H </h1>
                    </div>
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">arrival Hour: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getArrival_hour()}H </h1>
                    </div>
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">class: </h1>
                        <h1 class="text-base font-semibold" style="font-family: 'Poppins', sans-serif">${items.getSeatClass()}</h1>
                    </div>
                </div>
                <div class="w-1/2 relative h-40">
                    <form action="${pageContext.request.contextPath}/ReservationController" method="post">
                    <div class="flex space-x-2 items-center">
                        <h1 class="text-gray-400 text-base " style="font-family: 'Poppins', sans-serif">Flight
                            price: </h1>
                        <h1 class="text-base font-semibold"
                            style="font-family: 'Poppins', sans-serif">${items.getPrice()} MAD </h1>
                    </div>

                        <button onclick="reserve()" class="w-1/3 bg-indigo-700 h-14 py-2 absolute bottom-0 hover:bg-indigo-600 text-white rounded-md">Reserve</button>
                    </form>
                </div>

            </div>


        </c:forEach>

    </div>

    <script>
        const reserve = () => {
            Swal.fire({
                title: "confirmation email has been sent",
                html: "flight has been reserved successfully ",
                confirmButtonText: "<a href='#'>ok</a>",
            });
        }

    </script>
</div>

</body>
</html>
