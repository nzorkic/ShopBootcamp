<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link href="/css/home.css" rel="stylesheet"/>
</head>
<body>

<div class="container">
    <div class="starter-template">
        <h1>Categories:</h1>
        <c:forEach items="${categories}" var="category">
            <p>${category.name}</p>
        </c:forEach>
        <h1>Products:</h1>
        <c:forEach items="${products}" var="product">
            <img src="/images/products/${product.image}">
            <p>Code: ${product.code}</p>
            <p>Name: ${product.name}</p>
            <p>Category: ${product.category.name}</p>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Qty: ${product.quantity}</p>
            <br>
            <hr>
            <br>
        </c:forEach>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/home.js"></script>

</body>

</html>
