<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <div class="cart__wrapper">
        <c:forEach items="${cartItems}" var="item">
            <form:form action="/cart/remove/${item.code}" method="post" class="cart__item">
                <div class="cart__item-details">
                    <p class="cart__item-product">Product Name: ${item.product.name}</p>
                    <p class="cart__item-quantity">Qty: ${item.quantity}</p>
                    <p class="cart__item-price">Price: ${item.quantity * item.product.price} RSD</p>
                </div>
                <div class="cart__item-button">
                    <input type="submit" value="Remove Item" class="form__button form__button--blue">
                </div>
            </form:form>
        </c:forEach>

        <h2>Total: ${total}</h2>
        <c:if test="${total gt 0}">
            <form:form action="/cart/purchase" method="post">
                <input type="submit" value="Make Order" class="form__button form__button--blue">
            </form:form>
        </c:if>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>