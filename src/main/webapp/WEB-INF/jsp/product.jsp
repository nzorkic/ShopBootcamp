<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <link href="/css/main.css" rel="stylesheet"/>
    <link href="/css/product.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <div class="product">
        <img src="/images/products/${product.image}" class="product__image">
        <div class="product__wrapper">
            <h1 class="product__name">${product.name}</h1>
            <div class="product__details">
                <div class="product__label product__label--blue product__code">Code: <span
                        class="product__code--bold">${product.code}</span></div>
                <div class="product__label product__label--blue product__category">Category: ${product.category.name}</div>
                <p class="product__description">${product.description}</p>
                <div class="product__price">Price
                    <span class="product__badge product__badge--green">
                        ${product.price} $
                    </span>
                </div>
                <div class="product__quantity">Quantity
                    <span class="product__badge product__badge--orange">
                        ${product.quantity}
                    </span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>