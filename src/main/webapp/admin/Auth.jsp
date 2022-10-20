<%--
  Created by IntelliJ IDEA.
  User: cosmi
  Date: 10/19/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div
        class="min-h-screen bg-gray-100 w-full flex justify-center items-center"
>
    <div
            class="w-1/4 space-y-6 flex-col bg-white flex shadow-md items-center justify-center h h-[550px] rounded-md"
    >
        <h1 class="text-4xl">Welcome back</h1>
        <form action="${pageContext.request.contextPath}/Auth" method="post" class="space-y-6 w-full h-fit flex flex-col justify-center items-center">
            <input
                    type="text"
                    class="w-5/6 py-4 outline-none rounded border-[1px] px-4 text-base focus:ring-2 focus:ring-offset-4 focus:ring-blue-400"
                    placeholder="Email"
                    name="email"
            />
            <input
                    type="text"
                    class="w-5/6 py-4 outline-none rounded border-[1px] px-4 text-base focus:ring-2 focus:ring-offset-4 focus:ring-blue-400"
                    placeholder="password"
                    name="password"
            />
            <button name="submit" type="submit" class="w-1/2 bg-indigo-700 py-4 rounded-md text-white hover:bg-indigo-900">Login</button>
        </form>

    </div>
</div>

</body>
</html>
