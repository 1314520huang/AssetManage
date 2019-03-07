<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>主页</title>
	<%@ include file="common.jsp"%>
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="left.jsp"></jsp:include>
		<div class="layui-body">
			<img alt="主页图片" src="${ctx  }/static/images/index.png"/>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>