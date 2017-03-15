if (typeof (JSON) == 'undefined') {
    $.getScript('/resources/json2.js');
}

MvcUtil = {};
$(document).ready(
    function () {
        MvcUtil.showSuccessResponse = function (text, element) {
            MvcUtil.showResponse("success", text, element);
        };
        MvcUtil.showErrorResponse = function showErrorResponse(text,
            element) {
            MvcUtil.showResponse("error", text, element);
        };
        MvcUtil.showResponse = function (type, text, element) {
            var responseElementId = element.attr("id") + "Response";
            var responseElement = $("#" + responseElementId);
            if (responseElement.length == 0) {
                responseElement = $(
                    '<span id="' + responseElementId + '" class="'
                    + type + '" style="display:none">' + text
                    + '</span>').insertAfter(element);
            } else {
                responseElement.replaceWith('<span id="'
                    + responseElementId + '" class="' + type
                    + '" style="display:none">' + text + '</span>');
                responseElement = $("#" + responseElementId);
            }
            responseElement.fadeIn("slow");
        };
        MvcUtil.xmlencode = function (xml) {
            // for IE
            var text;
            if (window.ActiveXObject) {
                text = xml.xml;
            }
            // for Mozilla, Firefox, Opera, etc.
            else {
                text = (new XMLSerializer()).serializeToString(xml);
            }
            return text.replace(/\&/g, '&' + 'amp;').replace(/</g,
                '&' + 'lt;').replace(/>/g, '&' + 'gt;').replace(/\'/g,
                '&' + 'apos;').replace(/\"/g, '&' + 'quot;');
        };

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        if (header && token) {
            $(document).ajaxSend(function (e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
        }
    });

function hideJscharts(divId) {
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

function isNull(str) {
    if (typeof str == 'undefined' || str == undefined || str == null
        || str == '') {
        return true;
    }

    return false;
}

function isNotNull(str) {
    if (typeof str != 'undefined' && str != undefined && str != null
        && str != '') {
        return true;
    }

    return false;
}

var devzbLayer;
function showDevzbLoading() {
	devzbLayer = layer.load(2, {
		time : 30 * 1000
	});
}
function hiddenDevzbLoading() {
	if (devzbLayer) {
		layer.close(devzbLayer);
	}
}

/**
 * ajax
 * @param url
 * @param params
 * @param callback
 * @param type
 * @param complete
 * @param loading
 * @returns
 */
function myAjax(url, params, callback, type, complete, loading) {
    if (!url) {
        layer.alert('链接地址异常，请稍后重试');
        return;
    }
    if (isNull(params)) {
        params = {};
    }

    params.randomT = new Date().getTime();
    if (isNull(type)) {
        type = "POST";
    }

    if (typeof loading == 'boolean') {
        // nothing
    } else {
        loading = true
    }

    if (loading) {
    	showDevzbLoading();
    }

    var isSuccess = false;
    $.ajax({
        type: type,
        url: url,
        async: false,
        data: params,
        timeout: 30000,
        dataType: "json",
        success: function (response) {
            if (!response) {
                alertMsg('系统维护中...');
                return;
            }
            if (200000 == response.code) {
                isSuccess = true
                if (response.msg) {
                    alertModel(response.msg, function () {
                        callback(response.data);
                    });
                } else {
                    callback(response.data);
                }
            } else {
                showErrorMessage(response);
            }
        },
        error: function (req, textStatus, error) {
            if ('Full authentication is required to access this resource' == error) {
                alertModel('登录已失效，请重新登录！', function () {
                    callback({
                        code: 200401
                    });
                });
            } else {
                layer.msg(error);
            }
        },
        complete: function (res) {
            if (isSuccess && loading) {
            	hiddenDevzbLoading()
            }
            typeof complete == "function" && complete(res);
        }
    });
}

function showErrorMessage(data) {
    if (data && 200401 == data.code) {
        var returnUrl;
        if (parent) {
            returnUrl = parent.window.location.href;
        } else {
            returnUrl = window.location.href;
        }

        if (typeof kksAppLogin != 'undefined') {
            kksAppLogin();
        } else {
            var index = parent.layer.getFrameIndex(window.name);
            var rul_login = '/oauth/kks?returnTo='
                + encodeURIComponent(returnUrl);
            if (index && parent.layer) {
                parent.window.location = rul_login;
            } else {
                window.location = rul_login;
            }
        }
    } else if (data && 400001 == data.code) {// 返回上一页
        history.back();
    } else if (data && 200502 == data.code) {// 登录拒绝
        window.location = '/oauth/access/denied';
    } else {
        if (data && data.msg) {
            alertModel(data.msg);
        } else {
            alertModel('系统繁忙，请稍后重试');
        }
    }
}

function alertMsg(msg) {
    layer.msg(msg);
}

function alertModel(msg, callback) {
    $.layer({
        shade: [0],
        area: ['auto', 'auto'],
        dialog: {
            msg: response.msg,
            btns: 1,
            type: 4,
            btn: ['确定'],
            yes: function () {
                typeof callback == "function" && callback();
            }
        }
    });
}

function getFormatDateByLong(l, pattern) {
    return getFormatDate(new Date(l - 0), pattern);
}
function getFormatDate(date, pattern) {
    if (date == undefined) {
        date = new Date();
    }
    if (pattern == undefined) {
        pattern = "yyyy-MM-dd";
    }
    return date.format(pattern);
}
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};