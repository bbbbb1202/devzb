<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>锌价格表</title>
	<link href="http://static.devzb.com/resources/form.css" rel="stylesheet"  type="text/css" />
</head>
<body>
<div id="graph">Loading graph...</div>

<script type="text/javascript" src="http://static.devzb.com/resources/jquery/1.11/jquery.js"></script>
<script type="text/javascript" src="http://static.devzb.com/resources/main/common.js"></script>
<script type="text/javascript" src="<c:url value="/resources/jscharts.js" />"></script>

<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url : '<c:url value="/zinc/data" />',
		dataType : "json",
		beforeSend : function(req) {
			req.setRequestHeader("Accept",
			"application/json");
		},
		success : function(form) {
			var myChart = new JSChart('graph', 'bar');
			myChart.setTitle('锌价格表');
			myChart.setSize(800, 500);
			myChart.setAxisNameX('日期');
			myChart.setAxisNameY('');
			//myChart.set3D(true);
			var datas = form.data;
			var myData = new Array();
			for(var i=0; i < datas.length; i++){
				console.log(datas[i].unit, datas[i].value)
				myData.push([datas[i].unit, datas[i].value - 0]);
			}
			//console.log(myData);

			/* myData = new Array();
			myData.push([10, 20]);
			myData.push([15, 10]);
			myData.push([20, 30]);
			myData.push([25, 10]);
			myData.push([30, 5]);
			console.log(myData) */
			myChart.setDataArray(myData);
			myChart.draw();
			hideJscharts('graph');
		},
		error : function(xhr) {
			MvcUtil.showErrorResponse(xhr.responseText, link);
		}
	});
});
</script>
</body>
</html>