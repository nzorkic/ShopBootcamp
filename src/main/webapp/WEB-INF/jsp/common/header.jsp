<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <c:if test="${user != null}">
        <p>Hello, <a href="/user/${user.username}">${user.username}</a></p>
        <a href="/cart">Cart</a>
        <a href="/logout">Logout</a>
    </c:if>
    <img src="<%=request.getContextPath()%>/images/logo.png" alt="msgNetconomy logo" class="header__image">
</header>