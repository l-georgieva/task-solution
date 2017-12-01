<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/action.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <br/>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <form method="post">
                        <div class="form-group">
                            <input name="name" type="text" class="form-control" placeholder="Enter name">
                            <input name="name" type="text" class="form-control" placeholder="Enter type">
                            <input name="name" type="text" class="form-control" placeholder="Enter quantity">
                            <input name="name" type="text" class="form-control" placeholder="Enter single price">

                        </div>




                        <div class="form-group">
                            <input class="btn btn-primary" type="submit" value="Add">
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