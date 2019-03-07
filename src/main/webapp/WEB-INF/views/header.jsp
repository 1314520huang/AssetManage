<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="common.jsp"%>

<div class="layui-header" id="userDivTmp">
	<div class="layui-logo"><h1><font style="color: white;">&nbsp;&nbsp;&nbsp;资&nbsp;产&nbsp;管&nbsp;理&nbsp;平&nbsp;台&nbsp;&nbsp;&nbsp;</font></h1></div>
	<ul class="layui-nav layui-layout-right">
		<input type="hidden" id="userId"/>
		<li class="layui-nav-item">
			<a href="javascript:;"><span id="userNameSpan"></span></a>
			<dl class="layui-nav-child">
				<dd>
					<a href="${ctx }/info">基本资料</a>
				</dd>
				<dd>
					<a href="javascript:openPass()">修改密码</a>
				</dd>
			</dl></li>
		<li class="layui-nav-item"><a href="${ctx }/logout">注销</a></li>
	</ul>
</div>

<div id="modifyPass" style="display: none;">
	<form class="layui-form" action="javascript:;" id="userForm0" style="margin: 10px;">
		<div class="layui-form-item">
		    <div class="layui-inline">
		      	<label class="layui-form-label">密码：</label>
		      	<div class="layui-input-inline">
		        	<input type="password" id="passwd" name="password" lay-verify="required" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
		</div>
		<div class="layui-form-item">
		    <div class="layui-inline">
		      	<label class="layui-form-label">确认密码：</label>
		      	<div class="layui-input-inline">
		        	<input type="password" id="rePass" name="password" lay-verify="required" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
		</div>
  		<div class="layui-form-item">
   	 		<div class="layui-input-block">
      			<button class="layui-btn" lay-submit="" lay-filter="demo1" id="submitBtn">确认修改</button>
      			<button type="reset" class="layui-btn layui-btn-primary" id="resetBtn">重置</button>
    		</div>
  		</div>
	</form>
</div>
<script type="text/javascript">
var user = new Vue({
	el : '#userDivTmp',
	data : {
		user : ''
	}
});
var ctx = "${ctx}";
var index;
function openPass() {
	
	index = layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        var index  = layer.open({
            type:1,//类型
            area:['400px','300px'],//定义宽和高
            title:'修改密码',//题目
            shadeClose:false,//点击遮罩层关闭
            content: $('#modifyPass'),//打开的内容
            end:function(){
            	  $("#modifyPass").hide();
           	}
        });
	});
}
</script>
<script type="text/javascript">
$(function() {
	$("#submitBtn").on('click', function() {
		var passwd = $("#passwd").val();
		var rePass = $("#rePass").val();
		if(passwd == "" || rePass == "") {
			layer.alert("数据不能为空");
			return false;
		} else if(passwd != rePass) {
			layer.alert("两次输入不一致");
			$("#passwd").val("");
			$("#rePass").val("");
			return false;
		} else {
			var userId = $("#userId").val();
			$.ajax({
				url : '${ctx }/users/update',
				type : 'POST',
				data : {id:userId, password : passwd},
				success : function(res) {
					if(res.code == 0) {
						$("#modifyPass").hide();
						layer.close(index);
						layer.alert("密码已修改完毕，下次登录生效");
					}
					else
						layer.alert(res.message);
				}
			});
		}
	});
	$("#resetBtn").on('click', function() {
		$("#passwd").val("");
		$("#rePass").val("");
	});
	
	$.ajax({
		url : "${ctx }/users/info",
		type : 'GET',
		success : function (res) {
			if(res.code == 0) {
				user.user = res.data;
				$("#userNameSpan").html(res.data.userName);
				$("#userId").val(res.data.id);
			}
			else
				layer.alert("获取个人信息出错，请稍后再试");
		}
	});
});
</script>
