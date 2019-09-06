<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
    <link href="/css/main.css" rel="stylesheet" />
    <link href="/css/productList.css" rel="stylesheet" />
</head>

<body>
    <jsp:include page="common/header.jsp" />
    <div class=content>
        <h1 class="heading--bold">Guru Register Form</h1>
        <form:form action="login" method="post" class="form">
            <div class="form__item">
                <label for="username" class="form__label">UserName</label>
                <input type="text" name="username" class="form__input"/>
                <div class="form__error">Error message</div>
            </div>
            <div class="form__item">
                <label for="password" class="form__label">Password</label>
                <input type="password" name="password" class="form__input"/>
            </div>
            <input type="submit" value="Submit" class="button button--cta form__button"/>
        </form:form>
    </div>
    <jsp:include page="common/footer.jsp" />

</body>

</html>