$(document).ready(function() {
	loadData(1)
});

function loadData(pageNum) {
	myAjax('/note/data.json', {}, function(data) {

		showHtml(data && data.list ? data.list : []);

		laypage({
			cont : 'div_page',
			pages : data.pages, // 总页数
			curr : pageNum || currPage, // 当前页
			jump : function(obj, first) {
				currPage = obj.curr;
				if (!first) { // 点击跳页触发函数自身，并传递当前页：obj.curr
					loadData(obj.curr);
				}
			}
		});
	});
}

function showHtml(items) {
	var html = '';

	html += '<table style="width: 100%;">';
	html += '<thead>';
	html += '<tr>';
	html += '<th>标题</th>';
	html += '<th>标签</th>';
	html += '<th>时间</th>';
	html += '</tr>';
	html += '</thead>';
	html += '<tbody>';

	for (var i=0;i< items.length;i++) {
		html += '<tr>';
		
		html += '<td>';
		html += items[i].title;
		html += '</td>';
		
		html += '<td>';
		html += items[i].tags;
		html += '</td>';
		
		html += '<td>';
		html += getFormatDateByLong(items[i].gmtCreated);
		html += '</td>';
		
		html += '</tr>';
	}
	html += '</tbody>';
	html += '</table>';

	$('#div_content').html(html);
}