function ajaxFun(url, data, type, func) {
	
	$.ajax({
		url : url,
		type : type,
		data : data,
		success : func
	});
}
