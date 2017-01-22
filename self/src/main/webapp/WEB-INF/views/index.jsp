<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>欢迎登录</title>
	<%@include file="./common/head.jsp"%>
</head>
<body>
	<h1>
		<a href="<c:url value="/" />">HELLO</a>
	</h1>
	<div>
		<form action="<c:url value="/login" />">
			用户名：<input id="username" name="username" type="text" />
			密 码：<input id="password" name="password" type="password" />
		</form>
	</div>
	<%@include file="./common/footer.jsp"%>
</body>
</html>