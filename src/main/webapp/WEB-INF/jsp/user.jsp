<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
    <link href="/css/main.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<p>User page</p>

<img src="<%=request.getContextPath()%>/images/users/${user.image}"> <br>
${user.firstName} ${user.lastName} <br>
${user.username} <br>
<jsp:include page="common/footer.jsp"/>
</body>
</html>