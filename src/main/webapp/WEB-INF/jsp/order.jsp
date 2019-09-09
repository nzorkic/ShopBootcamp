<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Order</title>
    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content order">
    <img class="order__image" src="images/shopping-cart.png">
    <h2 class="order__message">Congratulations, order has been successfully placed!</h2>
    <a href="/products">
        <button class="form__button form__button--blue order__button">Continue Shopping</button>
    </a>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>