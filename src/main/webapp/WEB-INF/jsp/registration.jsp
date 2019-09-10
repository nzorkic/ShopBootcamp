<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Form</title>

    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <c:if test="${errorMessage != null}">
        <div class="form__error">${errorMessage}</div>
    </c:if>
    <form:form action="registration" method="post" class="form">
        <h1 class="form__heading">Register Form</h1>
        <div class="form__item">
            <label for="firstName" class="form__item-label">First Name</label>
            <input type="text" name="firstName" class="form__item-input" required/>
        </div>
        <div class="form__item">
            <label for="lastName" class="form__item-label">Last Name</label>
            <input type="text" name="lastName" class="form__item-input" required/>
        </div>
        <div class="form__item">
            <label for="username" class="form__item-label">Username</label>
            <input type="text" name="username" class="form__item-input" required/>
        </div>
        <div class="form__item">
            <label for="password" class="form__item-label">Password</label>
            <input type="password" name="password" class="form__item-input" required/>
        </div>
        <input type="submit" value="Register" class="form__button form__button--blue"/>
        <div class="form__delimiter--div">
          <span class="form__delimiter--span">
            OR
          </span>
        </div>
        <input type="button" onclick="location.href='/login';" value="Sign in" class="form__button form__button--blue"/>
    </form:form>
</div>
<jsp:include page="common/footer.jsp"/>

</body>

</html>