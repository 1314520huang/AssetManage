<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人信息</title>
	<%@ include file="../common.jsp"%>
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../left.jsp"></jsp:include>
		<div class="layui-body">
			<div id="userDiv" style=" margin: 50px;">
				<form class="layui-form" action="" id="userForm" style="margin: 10px;">
					<input type="hidden" :value="user.id" id="userId"/>
					<div class="layui-form-item">
					    <div class="layui-inline">
					      	<label class="layui-form-label">工号 /学号</label>
					      	<div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.loginName" class="layui-input">
					      	</div>
					    </div>
					    <div class="layui-inline">
					      	<label class="layui-form-label">用户名</label>
					      	<div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.userName" class="layui-input">
					      	</div>
					    </div>
			  		</div>
					<div class="layui-form-item">
					    <div class="layui-inline">
					      	<label class="layui-form-label">手机号码：</label>
					      	<div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.phone" class="layui-input">
					      	</div>
					    </div>
					    <div class="layui-inline">
					      	<label class="layui-form-label">创建时间：</label>
					      	<div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.createTime" class="layui-input">
					      	</div>
					    </div>
				  	</div>
					<div class="layui-form-item">
					    <div class="layui-inline">
					      	<label class="layui-form-label">角色：</label>
						    <div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.levelName" class="layui-input">
					      	</div>
					    </div>
					    <div class="layui-inline">
					      	<label class="layui-form-label">部门：</label>
						    <div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.deptName" class="layui-input">
					      	</div>
						</div>
				  	</div>
					<div class="layui-form-item">
					    <div class="layui-inline">
					      	<label class="layui-form-label">最后登录时间：</label>
						    <div class="layui-input-inline">
					        	<input type="text"  readonly="readonly" :value="user.lastLoginTime" class="layui-input">
					      	</div>
					    </div>
				  	</div>
				  	<div class="layui-form-item layui-form-text">
			    		<label class="layui-form-label">备注</label>
			    		<div class="layui-input-block">
			      			<textarea placeholder="请输入内容" class="layui-textarea" name="remark" readonly="readonly">{{user.remark}}</textarea>
			    		</div>
			  		</div>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		var vm = new Vue({
			el : '#userDiv',
			data : {
				user : ""
			}
		});
	</script>
</body>
<script type="text/javascript">
$(function() {
	$.ajax({
		url : "${ctx }/users/info",
		type : 'GET',
		success : function (res) {
			if(res.code == 0) {
				vm.user = res.data;
				layui.use('form', function(){
					var form = layui.form;
					form.render();
				});	
			}
			else
				layer.alert("获取个人信息出错，请稍后再试");
		}
	});
});
</script>
</html>