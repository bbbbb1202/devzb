<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>欢迎登录</title>
	<%@include file="./common/head.jsp"%>
	<link href="/resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<form class="form-signin" role="form">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="email" class="form-control" placeholder="Email address"
				required autofocus> <input type="password"
				class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
	<!-- /container -->
	<%@include file="./common/footer.jsp"%>
</body>
</html>