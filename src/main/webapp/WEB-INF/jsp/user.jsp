<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <div class="user">
        <img src="<%=request.getContextPath()%>/images/users/${user.image}" class="user__image" alt="User image">
        <div class="user__image">
            <h1>${user.username}</h1>
            <p class="user__details">First name: ${user.firstName}</p>
            <p class="user__details">Last name: ${user.lastName}</p>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>