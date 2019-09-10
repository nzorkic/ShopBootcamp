<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
    <a href="/user">
        <div class="header__item header__item-link">
            <span>Hello, User</span>
        </div>
    </a>
    <a href="/cart">
        <div class="header__item header__item-link header__item--fixed">
            <span>Cart</span>
        </div>
    </a>
    <a href="/products">
        <div class="header__item header__item-link header__item--fixed">
            <span>Product List</span>
        </div>
    </a>
    <a href="/logout">
        <div class="header__item header__item-link header__item--fixed">
            <span>Logout</span>
        </div>
    </a>
    <div class="header__item header__item--right">
        <a href="http://www.msgnetconomy.net" target="_blank">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="msgNetconomy logo" class="header__image">
        </a>
    </div>
</header>