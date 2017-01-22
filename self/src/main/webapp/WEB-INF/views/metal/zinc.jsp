<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
	<title>锌价格表</title>
	<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="devzb_main">
		<div id="graph">载入中...</div>
	</div>
	<%@include file="../common/footer.jsp"%>
	<script type="text/javascript" src="/resources/js/jscharts.js"></script>
	<script type="text/javascript" src="/resources/js/devzb/metal/zinc.js"></script>
</body>
</html>