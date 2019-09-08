<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <c:if test="${user != null}">
        <div class="header__item header__item-link">
            Hello, <a href="/user/${user.username}">${user.username}</a>
        </div>
        <div class="header__item header__item-link">
            <a href="/cart">Cart</a>
        </div>
        <div class="header__item header__item-link">
            <a href="/products">Product List</a>
        </div>
        <div class="header__item header__item-link">
            <a href="/logout">Logout</a>
        </div>
    </c:if>
    <div class="header__item header__item--right">
        <a href="http://www.msgnetconomy.net" target="_blank">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="msgNetconomy logo" class="header__image">
        </a>
    </div>
</header>