<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>资产采购</title>
	<%@ include file="../common.jsp"%>
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../left.jsp"></jsp:include>
		<div class="layui-body">
			<form class="layui-form" action="" id="assetForm1" style="margin: 10px;">
				<div class="layui-form-item" style="margin-top: 40px;" id="searchDivAsset">
					<div class="layui-inline">
					   	<label class="layui-form-label">资产名称：</label>
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
					   	<label class="layui-form-label">状态：</label>
					   	<div class="layui-input-inline">
					      	<select name="state" id="state">
					     		<option value="">请选择状态</option>
					     		<option value="0">已保存</option>
					     		<option value="1">审核中</option>
					     		<option value="-1">已拒绝</option>
					     		<option value="2">审核完成</option>
					      	</select>
					   	</div>
					 </div>
				</div>
				<div class="layui-form-item" >
					<div class="layui-inline">
					   	<label class="layui-form-label">申请日期：由：</label>
					   	<div class="layui-input-inline">
					      	 <input type="text" name="date" id="bgDate" autocomplete="off" class="layui-input">
					    </div>
					 </div>
					 <div class="layui-inline">
					   	<label class="layui-form-label">至：</label>
					   	<div class="layui-input-inline">
					      	 <input type="text" name="date" id="edDate" autocomplete="off" class="layui-input">
					    </div>
					 </div>
				</div>
			</form>
			<div style="margin-left: 80px;">	
				<button class="layui-btn layui-btn-radius" onclick="openAddAsset()">&nbsp;新&nbsp;增&nbsp;</button>&nbsp;&nbsp;&nbsp;	
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
	<script type="text/javascript">
		layui.use(['form', 'layedit', 'laydate'], function(){
			  var form = layui.form
			  ,layer = layui.layer
			  ,layedit = layui.layedit
			  ,laydate = layui.laydate;
			  
			  //日期
			  laydate.render({
			    elem: '#bgDate'
			  });
			  laydate.render({
			    elem: '#edDate'
			  });
			  form.render();
		});
	</script>
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
		types : {}
	}
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
		url : '${ctx }/menus/assetType',
		type : 'GET',
		data : {},
		success : function(res) {
			if(res.code == 0) {
				vm2.types = res.data.types;
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
	$("#addNewAssetMore").on('click', function() {
		layer.alert("正在新增当中");
	});
});
</script>

<div id="addNewAsset" style="display: none;">
	<form class="layui-form" action="" id="userForm" style="margin: 10px;">
		<label>基本信息</label><hr/>
		<div class="layui-form-item" id="AssetAddUser">
		 	<div class="layui-inline">
			   	<label class="layui-form-label">录入人：</label>
			   	<div class="layui-input-inline">
			   		<input type="text" readonly="readonly" id="userNameLR" class="layui-input" value="${menu.user.userName }">
			    </div>
			 </div>
			 <div class="layui-inline">
			   	<label class="layui-form-label">申请日期：</label>
			   	<div class="layui-input-inline">
			   		<% 
				   		Date d = new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String now = df.format(d);
			   		%>
					<input class="layui-input" readonly="readonly" id="nowDate" class="layui-input" value="<%=now%>">
			    </div>
			 </div>
			 <div class="layui-inline">
			   	<label class="layui-form-label">学院：</label>
			   	<div class="layui-input-inline">
			   		<input type="text" readonly="readonly" id="userNameLR" class="layui-input" value="${menu.user.deptName }">
			    </div>
			 </div>
		</div>
		<label>资产采购申请</label><hr/>
		<div style="margin-left: 80px;">
			<button class="layui-btn layui-btn-radius" id="addNewAssetMore">&nbsp;新&nbsp;增&nbsp;资&nbsp;产&nbsp;</button>&nbsp;&nbsp;&nbsp;	
		</div>
		<div class="table-container" style="width: 90%; margin: 0 auto; height: 500px; overflow:auto;">
			<form class="layui-form" action="" id="userForm1" style="margin: 10px;">
				<div class="layui-form-item">
		
		
				</div>
			</form>
		</div>
	</form>
	<div style="margin-left: 80px; margin-top: 20px;">
		<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateAsset(0)">&nbsp;保&nbsp;存&nbsp;</button>&nbsp;&nbsp;&nbsp;
		<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateAsset(1)">&nbsp;提&nbsp;交&nbsp;</button>&nbsp;&nbsp;&nbsp;
	</div>
</div>
<script type="text/javascript">
var index;
var vmUser = new Vue({
	el : '#AssetAddUser',
	data : {
		user : ''
	}
});
function openAddAsset() {
	
	layui.use(['layer'],function () {
        var layer = layui.layer,$=layui.$;
        var index  = layer.open({
            type:1,//类型
            area:['1100px','600px'],//定义宽和高
            title:'资产采购申请单',//题目
            shadeClose:false,//点击遮罩层关闭
            content: $('#addNewAsset'),//打开的内容
            end:function(){
            	  $("#addNewAsset").hide();
           	},
           	success:function() {
           		layui.use('form', function(){
           			var form = layui.form;
					form.render('select');
           		});
           	}
        });
    })
}

function updateAsset(state) {
	
	
	
}
</script>
</html>