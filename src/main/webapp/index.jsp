<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World !!!</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://kit.fontawesome.com/8464c41458.js" crossorigin="anonymous"></script>

    <script src="Components/Navbar.js" type="module"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto+Mono:wght@700&display=swap"
          rel="stylesheet">
</head>
<body>

<%--<nav-component></nav-component>--%>
<div class="w-full min-h-screen bg-gray-400">


    <div class="w-full h-[70px] bg-white flex justify-around">
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
                    <a href="#" style="font-family: 'Poppins', sans-serif">Login</a>

                    <a href="#" style="font-family: 'Poppins', sans-serif">Sign up</a>
                </div>
            </div>
        </div>
    </div>

    <div class="w-full relative bg-gray-100 h-[680px] flex">
        <div class="w-1/2 bg-[#D2ECF6] flex flex-col items-center justify-center">
            <h1 style="font-family: 'Roboto Mono', monospace" class="text-6xl leading-relaxed">Life is Short And <br>
                The World is Wide!</h1>
            <div class="w-3/4 pl-10 flex items-center">
                <p style="font-family: 'Poppins', sans-serif" class="text-base">To get the best of your adventure you
                    just need to leave and<br> go where you like . we are waiting for
                    you.</p>
            </div>
            <div class="w-3/4 pl-10 mt-10">
                <button class="w-36 h-16 bg-[#040406] rounded-md text-white" style="font-family: 'Poppins', sans-serif">
                    Book now
                </button>
            </div>
        </div>
        <div class="w-1/2 h-full">
            <img src="Images/31226.jpg" class="object-fit h-full w-full">
        </div>


        <div class="w-full h-fit justify-center items-center absolute -bottom-28">
            <div class="w-3/4 h-56 bg-white shadow-xl mx-auto rounded-md p-4">
                <div id="backgroundOverlay" class="fixed inset-0 bg-transparent"></div>
                <div class="flex items-center justify-around w-full ">
                    <div class="w-full h-fit flex justify-between">

                        <div class="w-2/3 flex space-x-6">
                            <div class="flex w-fit justify-center relative items-center">
                                <i class="fa-solid fa-plane absolute left-0"></i>
                                <select class="px-8 py-2 border-none outline-none">
                                    <option value="Round-trip">Round-trip</option>
                                    <option value="one-way">one-way</option>
                                </select>
                            </div>
                            <div class="flex w-40 justify-center relative items-center">
                                <div class="flex justify-between space-x-3 items-center">
                                    <i class="fa-solid fa-user"></i>

                                    <div class="w-2/3 flex h-fit py-2 items-center justify-center relative">
                                        <div class="flex items-center space-x-2">
                                            <h1 id="totalPassengers">1</h1>
                                            <p class="">passengers</p>
                                        </div>
                                    </div>
                                    <div id="open">
                                        <i class="fa-solid fa-chevron-down cursor-pointer"></i>
                                    </div>
                                </div>

                                <div class="w-[300px] z-10 shadow-lg bg-white space-y-5 px-4 py-6 absolute top-0 -left-4 rounded-lg "
                                     id="addingBar">
                                    <div class="flex justify-between">
                                        <div class="flex justify-center space-x-1 items-center">
                                            <h1 class="" style="font-family: 'Poppins', sans-serif">Adults</h1>
                                            <p class="text-sm text-gray-400" style="font-family: 'Poppins', sans-serif">
                                                18 ans et +</p>
                                        </div>

                                        <div class="flex justify-center space-x-3">
                                            <div class="w-5 h-5 cursor-pointer rounded border-[1px] border-gray-300 flex items-center justify-center"
                                                 onclick="subsTrack('Adults',document.getElementById('adultNumber'))">
                                                <h1 class="text-[#008b8b]">-</h1>
                                            </div>
                                            <h1 id="adultNumber">1</h1>
                                            <div class="w-5 h-5 cursor-pointer rounded border-[1px] border-gray-300 flex items-center justify-center"
                                                 onclick="addtional('Adults',document.getElementById('adultNumber'))">
                                                <h1 class="text-[#008b8b]">+</h1>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="flex justify-between">
                                        <div class="flex justify-center space-x-1 items-center">
                                            <h1 class="" style="font-family: 'Poppins', sans-serif">Etudiants</h1>
                                            <p class="text-sm text-gray-400" style="font-family: 'Poppins', sans-serif">
                                                > 18 </p>
                                        </div>

                                        <div class="flex justify-center space-x-3">
                                            <div class="w-5 h-5 cursor-pointer rounded border-[1px] border-gray-300 flex items-center justify-center"
                                                 onclick="subsTrack('Students',document.getElementById('studentNumber'))">
                                                <h1 class="text-[#008b8b]">-</h1>
                                            </div>
                                            <h1 id="studentNumber">0</h1>
                                            <div class="w-5 h-5 cursor-pointer rounded border-[1px] border-gray-300 flex items-center justify-center"
                                                 onclick="addtional('Students',document.getElementById('studentNumber'))">
                                                <h1 class="text-[#008b8b]">+</h1>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="flex relative px-2 justify-between space-x-2 items-center">
                                <i class="fa-solid fa-tag"></i>
                                <select class="px-5 py-2 border-none outline-none">
                                    <option value="Economy">Economy</option>
                                    <option value="Business-class">Business-class</option>
                                    <option value="First-class">First-class</option>
                                </select>

                            </div>
                        </div>

                        <div class="flex justify-center mr-4 space-x-2 items-center">
                            <h1 class="text-[#008b8b]" style="font-family: 'Poppins', sans-serif">Looking for Travel
                                ideas?</h1>
                            <div class="flex justify-center space-x-2 items-center">
                                <i class="fa-solid fa-globe"></i>
                                <h1 class="text-black" style="font-family: 'Poppins', sans-serif">Explore Map</h1>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="w-full h-fit flex justify-center items-center">
                    <div class="w-11/12 mt-10 rounded flex bg-gray-400 h-20 px-4">
                        <div class="flex w-2/3 justify-around  h-full items-center">
                            <div class="w-1/2 h-full flex items-center  justify-center border-r-[1px] border-white">
                                <%--                            <div class=" w-1/2 flex items-center justify-center h-3/4 rounded bg-white">--%>
                                <%--                                <h1>Thakurgaon</h1>--%>
                                <%--                            </div>--%>
                                <input class=" z-10 w-3/4 h-3/4 bg-white rounded pl-4 outline-none ring-2 focus:ring-blue-700 focus:ring-offset-4"
                                       placeholder="depart" style="font-family: 'Poppins', sans-serif">
                            </div>
                            <div class="w-1/2 h-full flex items-center justify-center border-l-[1px] border-white">
                                <input class=" z-10 w-3/4 h-3/4 bg-white rounded pl-4 outline-none ring-2 focus:ring-blue-700 focus:ring-offset-4"
                                       placeholder="return" style="font-family: 'Poppins', sans-serif">
                            </div>
                        </div>
                        <div class="w-1/3 flex justify-center items-center space-x-2 pl-4 h-full">
                            <div class="z-10 w-1/2 flex justify-center items-center h-full rounded">
                                <input type="date" class="bg-white w-full h-3/4 rounded pl-3 outline-none">
                            </div>
                            <div class="z-10 flex justify-center items-center w-1/2 h-full rounded">
                                <input type="date" class="bg-white w-full h-3/4 rounded pl-3 outline-none">
                            </div>
                        </div>
                    </div>
                    <div class="bg-black w-24 h-20 mt-10 flex cursor-poin                                                                                                                                                                                                                                                               ter justify-center rounded-md items-center ml-6">
                        <i class="fa-solid fa-magnifying-glass text-white text-lg "></i>
                    </div>
                </div>


            </div>
        </div>
    </div>


</div>


</body>
<script src="js/Style.js"></script>
</html>