<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/home.css"/>
    </head>
    <jsp:include page="menu.jsp"/>
    <body>
        <div class="container">
            <h1 id="welcome" class="h1">Inventory App</h1>
        </div>
        <script  src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
        <script  src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
        <script>
            $("#home").addClass("active");
        </script>
    </body>
</html>