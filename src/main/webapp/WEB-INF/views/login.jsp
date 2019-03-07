<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登入</title>
	<%@ include file="common.jsp"%>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="https://www.layui.com/admin/std/dist/layuiadmin/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="https://www.layui.com/admin/std/dist/layuiadmin/style/admin.css" media="all">
	<link rel="stylesheet" href="https://www.layui.com/admin/std/dist/layuiadmin/style/login.css" media="all">
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

	<div class="layadmin-user-login-main">
		<div class="layadmin-user-login-box layadmin-user-login-header">
			<img src="${ctx }/static/images/logo.png" width="196" height="46"/>
		</div>
		<div class="layadmin-user-login-box layadmin-user-login-body layui-form">
			<div class="layui-form-item">
				<label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
				<input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
			</div>
			<div class="layui-form-item">
				<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
				<input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
			</div>
 			<div class="layui-form-item">
				<button class="layui-btn layui-btn-fluid" id="loginBtn">登 入</button>
			</div>
			<div class="layui-trans layui-form-item layadmin-user-login-other">
				<a href="javascript:showMsg()" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</div>
<script>
$(function() {
	$("#loginBtn").on("click", function () {
		var ctx = "${ctx}";
		var loginName = $("#LAY-user-login-username").val();
		var passwd = $("#LAY-user-login-password").val();
		if (loginName == "" || passwd == "") {
			layer.alert("登录信息不能为空");
			$("#LAY-user-login-password").val("");
		} else {
			$.ajax({
				url : "${ctx }/users/login",
				type : "POST",
				data : {
					loginName : loginName,
					password : passwd
				},
				success : function(res) {
					if (res.code == 0) {
						window.location.href = ctx + "/index";
						// 解决跳转失效
						return false;
					} else {
						layer.alert(res.message);
					}
				}
			});
		}
	});
});

function showMsg() {
	
	layer.alert("请联系管理员进行账号注册");
}
</script>
</body>
</html>