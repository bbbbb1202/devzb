$(document).ready(function() {
	loadData(1)
});
function loadData(pageNum){
	myAjax('/note/data.json',{},function(data){
		console.log(data);
		laypage({
		    cont: 'div_page',
		    pages: data.pageSize, //总页数
		    curr : pageNum || currPage, // 当前页
		    jump: function(obj, first){
		    	currPage = obj.curr;
				if (!first) { // 点击跳页触发函数自身，并传递当前页：obj.curr
					loadData(obj.curr);
				}
		    }
		  });
	});
}