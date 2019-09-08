<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="/css/main.css" rel="stylesheet"/>
    <link href="/css/productList.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class=content>
    <form:form action="login" method="post" class="form">
        <h1 class="form__heading">Login form</h1>
        <div class="form__item">
            <label for="username" class="form__item-label">Username</label>
            <input type="text" name="username" class="form__item-input" required/>
        </div>
        <div class="form__item">
            <label for="password" class="form__item-label">Password</label>
            <input type="password" name="password" class="form__item-input" required/>
        </div>
        <input type="submit" value="Sign in" class="form__button form__button--blue"/>
        <input type="button" onclick="location.href='/registration';" value="Registration" class="form__button form__button--blue"/>
    </form:form>
    <c:if test="${errorMessage != null}">
        <div class="form__error">${errorMessage}</div>
    </c:if>
</div>
<jsp:include page="common/footer.jsp"/>
</body>

</html>