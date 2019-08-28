<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link href="/css/home.css" rel="stylesheet"/>
</head>
<body>
<img src="/images/products/${product.image}">
<p>Code: ${product.code}</p>
<p>Name: ${product.name}</p>
<p>Category: ${product.category.name}</p>
<p>Description: ${product.description}</p>
<p>Price: ${product.price}</p>
<p>Qty: ${product.quantity}</p>
</body>