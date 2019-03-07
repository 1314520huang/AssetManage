<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<%@ include file="../common.jsp"%>
<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../left.jsp"></jsp:include>
		<div class="layui-body">
			<form class="layui-form" action="" id="userForm1" style="margin: 10px;">
				<div class="layui-form-item" style="margin-top: 40px;" id="searchDiv">
					<div class="layui-inline">
					   	<label class="layui-form-label">用户名：</label>
					   	<div class="layui-input-inline">
					     	<input type="text" name="userName" id="userName" lay-verify="required|phone" autocomplete="off" class="layui-input">
					   	</div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">学院：</label>
					   	<div class="layui-input-inline">
					      	<select name="deptId" id="dept">
					      		<option value="">请选择学院</option>
<!-- 					      		<option v-for="dept in depts" :value="dept.id">{{dept.name}}</option> -->
								<c:forEach var="dept" items="${menu.depts }">
									<option value="${dept.id }">${dept.name }</option>
								</c:forEach>
					      	</select>
					    </div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">角色：</label>
					   	<div class="layui-input-inline">
					      	<select name="level" id="role">
					   			<option value="">请选择角色</option>
<!-- 					      		<option v-for="role in roles" :value="role.id">{{role.name}}</option> -->
								<c:forEach var="role" items="${menu.roles }">
									<option value="${role.id }">${role.name }</option>
								</c:forEach>
					      	</select>
					    </div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">状态：</label>
					   	<div class="layui-input-inline">
					      	<select name="state" id="state">
					     		<option value="">请选择状态</option>
					     		<option value="1">正常</option>
					     		<option value="0">禁止</option>
					      	</select>
					   	</div>
					 </div>
				</div>
				</form>
				<div style="margin-left: 80px;">
					<button class="layui-btn layui-btn-radius" onclick="addUser()">&nbsp;新&nbsp;增&nbsp;</button>&nbsp;&nbsp;&nbsp;
					<button class="layui-btn layui-btn-radius layui-btn-normal" onclick="searchUser()">&nbsp;查&nbsp;询&nbsp;</button>&nbsp;&nbsp;&nbsp;	
					<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateUser(0)">&nbsp;删&nbsp;除&nbsp;</button>&nbsp;&nbsp;&nbsp;
					<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateUser(1)">&nbsp;激&nbsp;活&nbsp;</button>&nbsp;&nbsp;&nbsp;
				</div>
				<div class="table-container" style="width: 90%; margin: 0 auto; height: 600px; overflow:auto;">
					<table id="table" class="table layui-table">
						<thead style="text-align: center;">
							<tr>
								<th style="text-align: center;"><input type="checkbox" name="all"></th>
								<th style="text-align: center;">工号 / 学号</th>
								<th style="text-align: center;">用户名</th>
								<th style="text-align: center;">角色</th>
								<th style="text-align: center;">学院</th>
								<th style="text-align: center;">联系方式</th>
								<th style="text-align: center;">状态</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody id="tbody" style="text-align: center;">
							<tr v-for="user in users">
								<td><input type="checkbox" :value="user.id" name="id" onclick="userCheck(this)"></td>
								<td>{{user.loginName}}</td>
								<td>{{user.userName}}</td>
								<td>{{user.levelName}}</td>
								<td>{{user.deptName}}</td>
								<td>{{user.phone}}</td>
								<td v-if="user.state == 1">正常</td>
								<td v-if="user.state == 0">禁止</td>
								<td>
									<button class="layui-btn layui-btn-radius layui-btn-sm" @click="updateRole(user.id)">&nbsp;权&nbsp;限&nbsp;</button>&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</tbody>
						<tbody id="noData" style="display: none;">
							<tr><td colspan="7" align="center">暂无相关数据</td></tr>
						</tbody>
					</table>
				</div>
			</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
	var vm = new Vue({
		el : '#tbody',
		data : {
			users : {}
		}
	});
	
	layui.use('form', function(){
		var form = layui.form;
		form.render();
	});
	
	function getData(data) {

		$.ajax({
			url : '${ctx}/users',
			method : 'GET',
			cache : false,
			dataType : 'json',
			data:data,
			success : function(res) {
				if (res.code == 0) {
					var data = res.data;
					if(data == null || data.length == 0) {
						$("#tbody").hide();
						$("#noData").show();
					} else
						vm.users = data;
				} else 
					layer.alert("网络连接有误，请稍后！")
			},
			error : function() {
				layer.alert("网络连接有误，请稍后！")
			}
		});
	}
	
	function userCheck(ths) {
	    if (this.checked == false) {
	        $("input[name=all]:checkbox").prop('checked', false);
	    }
	    else {
	        var count = $("input[name='id']:checkbox:checked").length;
	        if (count == $("input[name='id']:checkbox").length) {
	            $("input[name=all]:checkbox").prop("checked", true);
	        }
	    }
	}
	function updateUser(state) {
		
		var ids = "";
		$("input[name=id]").each(function() {
			if(this.checked)	ids +=  $(this).val() + ',';
		});
		if(ids == "") {
			layer.alert("未选中任何数据项");
			return false;
		}
		ids = ids.substr(0,  ids.length);
		$.ajax({
			url : '${ctx}/users/' + ids + "/" + state, 
			method : 'PATCH',
			dataType : 'json',
			success : function(res) {
				if (res.code == 0) 
					location.reload();
				else 
					layer.alert(res.message)
			}
		});
	}
	
	function searchUser() {
		
		var userName = $("#userName").val();
		var level = $("#role  option:selected").val();
		var dept = $("#dept  option:selected").val();
		var state = $("#state  option:selected").val();
		getData({userName:userName, level:level, deptId:dept, state:state});
	}
	
	</script>
</body>

<div id="addUser" style="display: none;">
	<form class="layui-form" action="" id="userForm" style="margin: 10px;">
		<div class="layui-form-item">
		    <div class="layui-inline">
		      	<label class="layui-form-label">工号 /学号</label>
		      	<div class="layui-input-inline">
		        	<input type="text" name="loginName" lay-verify="required" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
		    <div class="layui-inline">
		      	<label class="layui-form-label">用户名</label>
		      	<div class="layui-input-inline">
		        	<input type="text" name="userName" lay-verify="required" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
  		</div>
		<div class="layui-form-item">
		    <div class="layui-inline">
		      	<label class="layui-form-label">密码</label>
		      	<div class="layui-input-inline">
		        	<input type="password" name="password" lay-verify="required" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
		    <div class="layui-inline">
		      	<label class="layui-form-label">手机号码：</label>
		      	<div class="layui-input-inline">
		        	<input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" >
		      	</div>
		    </div>
	  	</div>
		<div class="layui-form-item">
		    <div class="layui-inline">
		      	<label class="layui-form-label">选择角色</label>
			    <div class="layui-input-inline">
				  	<select name="level" id="roleSelect">
				  		<option value="">请选择角色</option>
<!-- 				  		<option v-for="role in roles" :value="role.id">{{role.name}}</option> -->
							<c:forEach var="role" items="${menu.roles }">
								<option value="${role.id }">${role.name }</option>
							</c:forEach>
				  	</select>
				</div>
		    </div>
		    <div class="layui-inline">
		      	<label class="layui-form-label">选择部门</label>
			    <div class="layui-input-inline">
				  	<select name="deptId" id="deptSelect">
				  		<option value="">请选择学院</option>
<!-- 				  		<option v-for="dept in depts" :value="dept.id">{{dept.name}}</option> -->
						<c:forEach var="dept" items="${menu.depts }">
							<option value="${dept.id }">${dept.name }</option>
						</c:forEach>
				  	</select>
				</div>
			</div>
	  	</div>
	  	<div class="layui-form-item layui-form-text">
    		<label class="layui-form-label">备注</label>
    		<div class="layui-input-block">
      			<textarea placeholder="请输入内容" class="layui-textarea" name="remark"></textarea>
    		</div>
  		</div>
  		<div class="layui-form-item">
   	 		<div class="layui-input-block">
      			<button class="layui-btn" lay-submit="" lay-filter="demo1" id="submit">新增用户</button>
      			<button type="reset" class="layui-btn layui-btn-primary" id="reset">重置</button>
    		</div>
  		</div>
	</form>
</div>

<script type="text/javascript">

function updateRole(id) {
	
	$("#userId").val(id);
	layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        var index  = layer.open({
            type:1,//类型
            area:['400px','500px'],//定义宽和高
            title:'修改权限',//题目
            shadeClose:false,//点击遮罩层关闭
            content: $('#updateRoleDiv'),//打开的内容
            end:function(){
            	  $("#updateRoleDiv").hide();
           	},
           	success:function() {
           		vm3.roles = vm1.roles;
           		layui.use('form', function(){
           			var form = layui.form;
					form.render('select');
           		});
           	}
        });
    })
}
</script>

<div id="updateRoleDiv" style="display: none;">

	<form class="layui-form" action="" id="userForm3" style="margin: 10px;">
		<div class="layui-form-item">
			<div class="layui-inline" style="margin: 20px;">
				<input type="hidden" id="userId">
			  	<label class="layui-form-label">选择角色</label>
			    <div class="layui-input-inline">
				  	<select id="roleSelectDiv">
				  		<option value="">请选择角色</option>
<!-- 				  		<option v-for="role in roles" :value="role.id">{{role.name}}</option> -->
							<c:forEach var="role" items="${menu.roles }">
								<option value="${role.id }">${role.name }</option>
							</c:forEach>
				  	</select>
				</div>
			</div>
		</div>
	</form>
  	<div class="layui-form-item">
	   	<div class="layui-input-block">
	    	<button class="layui-btn" lay-submit="" lay-filter="demo1" id="updateRoleBtn">修改权限</button>
	   	</div>
	</div>
</div>

<script type="text/javascript">

	var vm1 = new Vue({
		el : '#searchDiv',
		data : {
			roles:{},
			depts:{}
		}
	});
	
	var vm2 = new Vue({
		el : '#addUser',
		data : {
			roles:{},
			depts:{}
		}
	});

	var vm3 = new Vue({
		el : '#updateRoleDiv',
		data : {
			roles:{}
		}
	});
	
	var show = function() {

   		layui.use('form', function(){
   			var form = layui.form;
			form.render('select');
   		});
	}

	vm1.$watch("searchDiv", show, {deep:true});
	vm2.$watch("addUser", show, {deep:true});
	vm3.$watch("updateRoleDiv", show, {deep:true});
	var index;
	function addUser() {
	
		layui.use(['layer'],function () {
	        var layer = layui.layer,$=layui.$;
	        index = layer.open({
	            type:1,//类型
	            area:['900px','550px'],//定义宽和高
	            title:'新增用户',//题目
	            shadeClose:false,//点击遮罩层关闭
	            content: $('#addUser'),//打开的内容
	            end:function(){
	            	  $("#addUser").hide();
	           	},
	           	success:function() {
	           		$("#userForm").reset();
	        		var index = layer.msg('正在加载菜单，请稍后', { icon: 16, shade: 0.01,shadeClose:false,time:5000});
	           		vm2.roles = vm1.roles;
	           		vm2.depts = vm1.depts;
	           	}
	        });
	    })
	}
	
	function initSearch() {
		
		var index = layer.msg('正在加载菜单，请稍后', { icon: 16, shade: 0.01,shadeClose:false,time:5000});
		$.ajax({
			url : '${ctx }/menus/user',
			type : 'GET',
			data : {},
			success : function(res) {
				if(res.code == 0) {
 					vm1.roles = res.data.roles;
					vm1.depts = res.data.depts;
					layui.use('form', function(){
						var form = layui.form;
						form.render('select');
						layer.close(index);
					});
				}
				else
					layer.alert(res.message);
			}
		});
	}

	$(function() {
		getData({});
		initSearch();
		$("#submit").on("click", function () {
			var data = $("#userForm").serialize() + "&levelName=" + $("#roleSelect option:selected").text() + "&deptName=" + $("#deptSelect  option:selected").text();
			$.ajax({
				url : '${ctx }/users',
				type : 'POST',
				data : data,
				success : function(res) {
					if(res.code == 0)
						location.reload();
					else
						layer.alert(res.message);
				}
			});
		});

		$("#reset").on("click", function () {
			$("#userForm").reset();
		});

		$("input[name=all]").click(function () {
	        if (this.checked) {
	            $("#tbody :checkbox").prop("checked", true);
	        } else {
	            $("#tbody :checkbox").prop("checked", false);
	        }
	    });

		$("#resetRole").on("click", function () {
			$("#roleSelectDiv").empty();
		});

		$("#updateRoleBtn").on("click", function () {
			var userId = $("#userId").val();
			var role = $("#roleSelectDiv option:selected").val();
			var roleName = $("#roleSelectDiv option:selected").text();
			$.ajax({
				url : '${ctx}/users/update', 
				method : 'POST',
				data:{id : userId, level : role, levelName:roleName},
				dataType : 'json',
				success : function(res) {
					if (res.code == 0) 
						location.reload();
					else 
						layer.alert(res.message)
				}
			});
		});
	});
</script>
</html>
