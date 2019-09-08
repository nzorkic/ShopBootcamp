<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <c:if test="${user != null}">
        <a href="/user/${user.username}">
            <div class="header__item header__item-link">
                <span>Hello, ${user.username}</span>
            </div>
        </a>
        <a href="/cart">
            <div class="header__item header__item-link">
                <span>Cart</span>
            </div>
        </a>
        <a href="/products">
            <div class="header__item header__item-link">
                <span>Product List</span>
            </div>
        </a>
        <a href="/logout">
            <div class="header__item header__item-link">
                <span>Logout</span>
            </div>
        </a>
    </c:if>
    <div class="header__item header__item--right">
        <a href="http://www.msgnetconomy.net" target="_blank">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="msgNetconomy logo" class="header__image">
        </a>
    </div>
</header>