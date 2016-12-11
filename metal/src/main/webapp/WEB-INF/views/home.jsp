<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>欢迎登录</title>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<h1><a href="<c:url value="/" />">HELLO</a></h1>
<div>

	<form action="<c:url value="/login" />">
		用户名：<input id="username" name="username" type="text" />
		密 码：<input id="password" name="password" type="password" />
	
	</form>
	
</div>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.11/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/devzb/common.js" />"></script>

<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
</body>
</html>