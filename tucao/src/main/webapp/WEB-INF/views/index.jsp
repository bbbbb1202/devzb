<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>欢迎登录</title>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body style="text-align: center;padding-top: 100px;">

<h1><a href="<c:url value="/" />">HELLO</a></h1>

<script type="text/javascript" src="<c:url value="/resources/jquery/1.11/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/devzb/common.js" />"></script>

<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
</body>
</html>