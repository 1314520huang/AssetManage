/**
 * 关于资产相关的事件处理
 */

function getAsset(url, data) {
	
	$.ajax({
		url : url,
		data : data,
		type : "GET",
		success : function(res) {
			if (res.code == 0) {

			} else {

			}
		}
	});
}
