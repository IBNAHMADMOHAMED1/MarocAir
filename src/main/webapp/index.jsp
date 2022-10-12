<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World !!!</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="Components/Navbar.js" type="module"></script>
</head>
<body>

<%--<nav-component></nav-component>--%>
<div class="w-full min-h-screen bg-gray-400">
    <div class="w-full h-[70px] bg-white flex justify-around">
        <div class="bg-blue-400">
            <h1>Logo</h1>
        </div>
        <div class="w-3/4 h-full bg-red-400 flex justify-around items-center">
            <div class="w-1/2">
                <ul class="flex justify-evenly items-center bg-blue-300 w-full h-full">
                    <li>
                        <a>HOME</a>
                    </li>
                    <li>
                        <a>Your Cart</a>
                    </li>
                    <li>
                        <a>Favourites</a>
                    </li>
                </ul>
            </div>
            <div class="w-1/4 flex justify-end items-end">
                <div class="w-1/2 flex items-center justify-around">
                    <a href="#">Login</a>

                    <a href="#">Sign up</a>
                </div>
            </div>
        </div>
    </div>

    <div>

    </div>


</div>


</body>
</html>