<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/action.css"/>
    </head>

    <body>
        <jsp:include page="menu.jsp"/>
        <br/>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <c:set value="${itemViewModel}" var="itemViewModel"></c:set>
                    <form method="post">
                        <div class="form-group">
                            <input name="name" type="text" class="form-control" placeholder="Enter issue name" value="${issueViewModel.name}">
                            <input name="type" type="text" class="form-control" placeholder="Enter issue name" value="${issueViewModel.type}">
                            <input name="quantity" type="number" class="form-control" placeholder="Enter issue name" value="${issueViewModel.quantity}">
                            <input name="singlePrice" type="number" class="form-control" placeholder="Enter issue name" value="${issueViewModel.singlePrice}">


                        </div>





                        <div class="form-group">
                            <input class="confirm-edit btn btn-primary" type="submit" value="Edit">
                            <a href="/" class="btn btn-primary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script  src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
        <script  src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
        <script>
            $("#items").addClass("active");
        </script>
    </body>
</html>