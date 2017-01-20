  function defaultCallback(data){
	  console.log(data);
  }
  function showSystemMessage(){
	  alert('系统维护中');
  }
  function showMessage(msg){
	  alert(msg);
  }
 function myAjax(url, params, callback, method){
	  if (typeof params == 'undefined') {
	        params = {};
	    }
	    if (typeof method == 'undefined') {
	        method = 'GET';
	    }

	    if (typeof callback != 'function') {
	        callback = defaultCallback;
	    }

	    $.ajax({
	        url: url,
	        data: params,
	        method: method,
	        dataType : "json",
			beforeSend : function(req) {
				req.setRequestHeader("Accept", "application/json");
			},
	        success: function (res) {
	            console.log(res)
	            if (!res) {
	                showSystemMessage()
	                return;
	            }

	            var protocol = res.data;
	            if (protocol) {
	                //console.log(protocol.code)
	                if (200000 == protocol.code) {//ok
	                    callback(protocol.data)
	                } else {//error
	                    if (200401 == protocol.code) {//没有登录
	                        showMessage('未登录！')
	                    } else if (protocol.msg) {
	                        showMessage(protocol.msg)
	                    } else {
	                        showSystemMessage()
	                    }
	                }
	            } else {
	                showSystemMessage()
	            }
	        },
	        error: function (e) {
	            // console.log(e)
	            showSystemMessage()
	        },
	        complete: function (res) {
	            //console.log(res)
	        }
	    })
  });
