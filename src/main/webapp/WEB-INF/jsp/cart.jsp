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
    <c:forEach items="${cartItems}" var="item">
        <form:form action="/cart/remove/${item.code}" method="post">
            <p>Product Name: ${item.product.name}</p>
            <p>Qty: ${item.quantity}</p>
            <p>Price: ${item.quantity * item.product.price} RSD</p>
            <input type="submit" value="Remove Item">
        </form:form>

    </c:forEach>
    <h2>Total: ${total}</h2>
    <c:if test="${total gt 0}">
        <form:form action="/cart/purchase" method="post">
            <input type="submit" value="Make Order">
        </form:form>
    </c:if>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>