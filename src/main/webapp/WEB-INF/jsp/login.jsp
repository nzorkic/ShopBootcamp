<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="/css/main.css" rel="stylesheet" />
    <link href="/css/productList.css" rel="stylesheet" />
</head>

<body>
    <jsp:include page="common/header.jsp" />
    <div class="content">
        <form:form action="login" method="post" class="form">
            <h1 class="form__heading">Login form</h1>
            <div class="form__item">
                <label for="username" class="form__item-label">User Name</label>
                <input type="text" name="username" class="form__item-input" />
            </div>
            <div class="form__item">
                <label for="password" class="form__item-label">Password</label>
                <input type="password" name="password" class="form__item-input" />
            </div>
            <input type="submit" value="Submit" class="form__button" />
        </form:form>
    </div>
    <jsp:include page="common/footer.jsp" />
</body>

</html>