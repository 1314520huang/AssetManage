<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>资产管理</title>
<%@ include file="../common.jsp"%>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../left.jsp"></jsp:include>
		<div class="layui-body">
			<form class="layui-form" action="" id="assetForm1" style="margin: 10px;">
				<div class="layui-form-item" style="margin-top: 40px;" id="searchDivAsset">
					<div class="layui-inline">
					   	<label class="layui-form-label">资产名：</label>
					   	<div class="layui-input-inline">
					     	<input type="text" name="name" id="name" lay-verify="required" autocomplete="off" class="layui-input">
					   	</div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">资产类型：</label>
					   	<div class="layui-input-inline">
					      	<select name="level" id="type">
					   			<option value="">请选择类型</option>
<!-- 					      		<option v-for="type in types" :value="type.id">{{type.name}}</option> -->
								<c:forEach var="type" items="${menu.types }">
									<option value="${type.id }">${type.name }</option>
								</c:forEach>
					      	</select>
					    </div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">所属院系 /部门：</label>
					   	<div class="layui-input-inline">
					      	<select name="deptId" id="dept">
					      		<option value="">请选择所属</option>
<!-- 					      		<option v-for="dept in depts" :value="dept.id">{{dept.name}}</option> -->
								<c:forEach var="dept" items="${menu.depts }">
									<option value="${dept.id }">${dept.name }</option>
								</c:forEach>
					      	</select>
					    </div>
					 </div>
				</div>
				</form>
				<div style="margin-left: 80px;">
					<button class="layui-btn layui-btn-radius layui-btn-normal" onclick="searchAsset()">&nbsp;查&nbsp;询&nbsp;</button>&nbsp;&nbsp;&nbsp;	
				</div>
				<div class="table-container" style="width: 90%; margin: 0 auto; height: 600px; overflow:auto;">
					<table id="table" class="table layui-table">
						<thead style="text-align: center;">
							<tr>
								<th style="text-align: center;">资产名</th>
								<th style="text-align: center;">资产类型</th>
								<th style="text-align: center;">所在院系</th>
								<th style="text-align: center;">总数量</th>
								<th style="text-align: center;">生产商</th>
							</tr>
						</thead>
						<tbody id="tbody" style="text-align: center;">
							<tr v-for="asset in assets">
								<td>{{asset.name}}</td>
								<td>{{asset.typeName}}</td>
								<td>{{asset.deptName}}</td>
								<td>{{asset.sumNum}}</td>
								<td>{{asset.remark}}</td>
							</tr>
						</tbody>
						<tbody id="noData" style="display: none;">
							<tr><td colspan="5" align="center">暂无相关数据</td></tr>
						</tbody>
					</table>
				</div>
			</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>

<script type="text/javascript">

	var vm1 = new Vue({
		el : '#tbody',
		data : {
			assets : {}
		}
	});
	var vm2 = new Vue({
		el : '#searchDivAsset',
		data : {
			depts : {},
			types : {}
		}
	});

	layui.use('form', function(){
		var form = layui.form;
		form.render();
	});

	function getData(data) {
	
		$.ajax({
			url : '${ctx }/assets',
			method : 'GET',
			cache : false,
			dataType : 'json',
			data:data,
			success : function(res) {
				debugger;
				if (res.code == 0) {
					var data = res.data;
					if(data == null || data.length == 0) {
						$("#tbody").hide();
						$("#noData").show();
					} else
						vm1.assets = data;
				} else 
					layer.alert(res.message)
			},
			error : function() {
				layer.alert("网络连接有误，请稍后！")
			}
		});
	}
	
 	function searchAsset() {
		
		var userName = $("#name").val();
		var level = $("#type  option:selected").val();
		var dept = $("#dept  option:selected").val();
		getData({userName:userName, level:level, deptId:dept});
	}
 
	function initSearch() {
		
		var index = layer.msg('正在加载菜单，请稍后', { icon: 16, shade: 0.01,shadeClose:false,time:5000});
		$.ajax({
			url : '${ctx }/menus/asset',
			type : 'GET',
			data : {},
			success : function(res) {
				if(res.code == 0) {
 					vm2.types = res.data.types;
					vm2.depts = res.data.depts;
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
	});
</script>
</html>
