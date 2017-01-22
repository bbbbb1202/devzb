$(document).ready(function() {
	$.ajax({
		url : '/metal/zinc/data.json',
		dataType : "json",
		beforeSend : function(req) {
			req.setRequestHeader("Accept", "application/json");
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
			
			myChart.setDataArray(myData);
			myChart.draw();
			hideJscharts('graph');
		},
		error : function(xhr) {
			MvcUtil.showErrorResponse(xhr.responseText, link);
		}
	});
});