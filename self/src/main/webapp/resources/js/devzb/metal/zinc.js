$(document).ready(function() {
	myAjax('/metal/zinc/data.json', null, function(data){
		var myChart = new JSChart('graph', 'bar');
		myChart.setTitle('锌价格表');
		myChart.setSize(800, 500);
		myChart.setAxisNameX('日期');
		myChart.setAxisNameY('');
		//myChart.set3D(true);
		
		var datas = data;
		var myData = new Array();
		for(var i=0; i < datas.length; i++){
			myData.push([datas[i].unit, datas[i].value - 0]);
		}
		
		myChart.setDataArray(myData);
		myChart.draw();
		
		hideJscharts('graph');
	})
});