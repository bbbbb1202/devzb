<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<jsp:include page="head.jsp"/>
	<title>欢迎登录</title>
</head>
<body>
<h1><a href="<c:url value="/" />">HELLO</a></h1>
<div>
	<form action="<c:url value="/login" />">
		用户名：<input id="username" name="username" type="text" />
		密 码：<input id="password" name="password" type="password" />
	</form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>