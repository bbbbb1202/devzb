if (typeof (JSON) == 'undefined') {
    //如果浏览器不支持JSON，则载入json2.js
    $.getScript('/resources/json2.js');
}

MvcUtil = {};
$(document).ready(function() {
	
	MvcUtil.showSuccessResponse = function (text, element) {
		MvcUtil.showResponse("success", text, element);
	};
	MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
		MvcUtil.showResponse("error", text, element);
	};
	MvcUtil.showResponse = function(type, text, element) {
		var responseElementId = element.attr("id") + "Response";
		var responseElement = $("#" + responseElementId);
		if (responseElement.length == 0) {
			responseElement = $('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>').insertAfter(element);
		} else {
			responseElement.replaceWith('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>');
			responseElement = $("#" + responseElementId);
		}
		responseElement.fadeIn("slow");
	};
	MvcUtil.xmlencode = function(xml) {
		//for IE 
		var text;
		if (window.ActiveXObject) {
		    text = xml.xml;
		 }
		// for Mozilla, Firefox, Opera, etc.
		else {
		   text = (new XMLSerializer()).serializeToString(xml);
		}			
		    return text.replace(/\&/g,'&'+'amp;').replace(/</g,'&'+'lt;')
	        .replace(/>/g,'&'+'gt;').replace(/\'/g,'&'+'apos;').replace(/\"/g,'&'+'quot;');
	};
	
	// Include CSRF token as header in JQuery AJAX requests
	// See http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf-include-csrf-token-ajax
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	if(header && token){
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}
});

function hideJscharts(divId){
	var time = 100;
	function timeCountDown() {
		var $div = $('#' + divId + ' div');
		if ($div.length) {
			$div.hide();
			clearInterval(timer);
			return true;
		}
		time--;
		return false;
	}
	timeCountDown();
	var timer = setInterval(timeCountDown, 10);
}

function myAjax(url,params,callback,type,isLoading){
    if(!url){
        layer.alert('链接地址异常，请稍后重试');
        return;
    }
    if(!params){
        params = {};
    }

    params.randomT = new Date().getTime();
    if(!type){
        type = "post";
    }
    if(typeof isLoading == 'undefined' || async == null){
        async = true;
    }

    var loadLayer;
    var isShow = typeof isLoading == 'undefined' || isLoading;
    if(isShow){
        loadLayer = layer.load(2, {time: 10*1000});
    }
    var loadLayer;
    var isShow = typeof isLoading == 'undefined' || null == isLoading || isLoading;
    if(isShow){
        loadLayer = layer.load(2, {time: 30*1000});
    }
    $.ajax({
        type : type,
        url : url,
        async : async,
        data : params,
        timeout : 20000,
        dataType : "json",
        success : function(response) {
            if(typeof finallyFunction == 'function'){
            	finallyFunction(response ? response.code : 200444);
            }
            if(isShow){
                layer.close(loadLayer);
            }
            if(!response){
            	alertMsg('系统维护中...');
            	return;
            }
            if(200000 == response.code){
                if(response.msg){
                    layer.msg(response.msg);
                    setTimeout(function(){
                        callback(response.data);
                    }, 1500);
                } else {
                    callback(response.data);
                }
            } else {
                showErrorMessage(response);
                if(typeof errorCallback == 'function'){
                	errorCallback(response.data);
                }
            }
        },
        error : function(req, textStatus, error) {
            if(typeof finallyFunction == 'function'){
            	finallyFunction(200444);
            }
        	if(isShow){
                layer.close(loadLayer);
            }
            try{
                console.error(error && error.message?error.message:error);
            } catch (e){}
        }
    });
}

function showErrorMessage(data){
	var returnUrl;
    if(parent){
        returnUrl = parent.window.location.href;
    } else {
        returnUrl = window.location.href;
    }
    
    if (data && 200401 == data.code){
    	if(typeof kksAppLogin != 'undefined'){
    		kksAppLogin();
    	} else {
    		var index = parent.layer.getFrameIndex(window.name);
        	var rul_login = '/oauth/kks?returnTo=' + encodeURIComponent(returnUrl);
            if(index && parent.layer){
                parent.window.location = rul_login;
            } else {
                window.location = rul_login;
            }
    	}
    } else if(data && 400001 == data.code){
    	history.back();
    } else if(data && 200502 == data.code){
    	window.location = '/oauth/access/denied';
    } else {
        if(data && data.msg){
        	alertMsg(data.msg ? data.msg : '系统繁忙，请稍后重试');
        } else {
        	alertMsg('系统维护中...');
        }
    }
}

function alertMsg(msg){
    layer.msg(msg);
}

function showKksLoading(){
	var kksLayer = layer.load(2, {time: 30*1000});
}

//日期格式转换
function getFormatDateByLong(l, pattern) {
	return getFormatDate(new Date(l-0), pattern);
};
function getFormatDate(date, pattern) {
	if (date == undefined) {
		date = new Date();
	}
	if (pattern == undefined) {
		pattern = "yyyy-MM-dd";
	}
	return date.format(pattern);
};
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		"d+" : this.getDate(),
		"h+" : this.getHours(),
		"m+" : this.getMinutes(),
		"s+" : this.getSeconds(),
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		"S" : this.getMilliseconds()
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};