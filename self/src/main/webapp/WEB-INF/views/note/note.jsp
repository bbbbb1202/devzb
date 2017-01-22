<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>我的笔记</title>
	<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="devzb_main container">
		<div id="div_content"></div>
		<div id="div_page"></div>
	</div>
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="http://static.devzb.com/resources/laypage/laypage.js"></script>
	<script src="/resources/js/devzb/note/note.js"></script>
</body>
</html>