<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Items</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/items.css"/>
    <body>
    <jsp:include page="menu.jsp"/>
        <br/>
        <div class="container">
            <form method="get">
                <div class="row">
                    <div class="col-sm-2">
                        <div class="form-group">

                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="form-group">
                            <input name="name" type="text" class="form-control" placeholder="Search">
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </div>
                <div class="row">
                    <a class="btn btn-success" href="/items/add-item">Add Item</a>
                </div>
            </form>
            <div class="row">
                <table class="table table-hover">
                    <thead>
                    <tr>



                        <th>Name</th>
                        <th>Type</th>
                        <th>Quantity</th>

                        <th>Single Price</th>



                        <th></th>
                        <th></th>
                    </tr>
                    </thead>



                    <tbody>

                    <c:forEach items="${itemViewModels}" var="itemViewModel">
                        <tr>

                            <td>${itemViewModel.name}</td>
                            <td>${itemViewModel.type}</td>

                            <td>${itemViewModel.quantity}</td>

                            <td>${itemViewModel.singlePrice}</td>


                            <c:choose>
                                <c:when test="${sessionScope.currentUser.getRole() == \"ADMIN\" || sessionScope.currentUser.getUsername()==itemViewModel.authorUsername}">
                                    <td>
                                        <a href="/items/edit/${itemViewModel.id}" class=" btn btn-success">Edit</a>

                                    </td>
                                    <td>
                                        <a href="/items/${itemViewModel.id}" class="btn btn-info">Details</a>

                                    </td>
                                    <td>
                                        <a href="/items/delete/${itemViewModel.id}" class="confirm-delete btn btn-danger">Delete</a>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td></td>
                                    <td></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script  src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
        <script  src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

    </body>
</html>