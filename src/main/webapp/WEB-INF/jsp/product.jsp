<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <link href="/css/main.css" rel="stylesheet" />
</head>

<body>
    <jsp:include page="common/header.jsp" />
    <div class="content">
        <img src="/images/products/${product.image}">
        <p>Code: ${product.code}</p>
        <p>Name: ${product.name}</p>
        <p>Category: ${product.category.name}</p>
        <p>Description: ${product.description}</p>
        <p>Price: ${product.price}</p>
        <p>Qty: ${product.quantity}</p>
    </div>
    <jsp:include page="common/footer.jsp" />
</body>