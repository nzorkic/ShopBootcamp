<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User</title>
    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <div class="user">
        <img src="<%=request.getContextPath()%>/images/users/${user.image}" class="user__image" alt="User image">
        <h1>${user.username}</h1>
        <form:form action="changeUser" method="post" class="form">
            <p class="user__details">First name: </p> <input type="text" name="firstName" value="${user.firstName}">
            <p class="user__details">Last name: ${user.lastName}</p>
            <input type="submit" value="Update">
        </form:form>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>