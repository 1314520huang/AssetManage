<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>类别管理</title>
<%@ include file="../common.jsp"%>
<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../left.jsp"></jsp:include>
		<div class="layui-body">
			<div style="margin-left: 80px; margin-top: 40px;">
				<button class="layui-btn layui-btn-radius layui-btn-normal" onclick="addType()">&nbsp;新&nbsp;增&nbsp;</button>&nbsp;&nbsp;&nbsp;
				<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateType(0)">&nbsp;删&nbsp;除&nbsp;</button>&nbsp;&nbsp;&nbsp;
				<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="updateType(1)">&nbsp;激&nbsp;活&nbsp;</button>&nbsp;&nbsp;&nbsp;
			</div>
			<div class="table-container" style="width: 90%; margin: 0 auto; height: 600px; overflow:auto;">
				<table id="table" class="table layui-table">
					<thead style="text-align: center;">
						<tr>
							<th style="text-align: center;"><input type="checkbox" name="all"></th>
							<th style="text-align: center;">ID</th>
							<th style="text-align: center;">类别</th>
							<th style="text-align: center;">状态</th>
						</tr>
					</thead>
					<tbody id="tbody" style="text-align: center;">
						<tr v-for="type in types">
							<td><input type="checkbox" :value="type.id" name="id" onclick="userCheck(this)"></td>
							<td>{{type.id}}</td>
							<td>{{type.name}}</td>
							<td v-if="type.state == 1">激活中</td>
							<td v-if="type.state == 0">隐藏中</td>
						</tr>
					</tbody>
					<tbody id="noData" style="display: none;">
						<tr><td colspan="4" align="center">暂无相关数据</td></tr>
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
			types : {}
		}
	});
	
	function getData() {

		$.ajax({
			url : '${ctx}/types',
			method : 'GET',
			dataType : 'json',
			success : function(res) {
				debugger;
				if (res.code == 0) {
					var data = res.data;
					if(data == null || data.length == 0) {
						$("#tbody").hide();
						$("#noData").show();
					} else
						vm.types = data;
				} else 
					layer.alert("网络连接有误，请稍后！")
			}
		})
	}
	
	function addType() {
		
		layui.use(['layer'],function () {
            var layer = layui.layer,$=layui.$;
            var index  = layer.open({
                type:1,//类型
                area:['500px','400px'],//定义宽和高
                title:'新增类别',//题目
                shadeClose:false,//点击遮罩层关闭
                anim:6,
                content: $('#addtype'),//打开的内容
                end:function(){
                	  $("#addtype").hide();
               	},
            });
        })
	}
	
	function updateType(state) {
		
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
			url : '${ctx}/types/' + ids + "/" + state,
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
	</script>
</body>
<div id="addtype" style="display: none;">
    <div class="layui-inline" style="margin-top: 20px;">
      	<label class="layui-form-label">名称：</label>
      	<div class="layui-input-inline">
        	<input type="text" id="name" autocomplete="off" class="layui-input">
      	</div>
    </div>
	<div class="layui-form-item layui-form-text" style="margin-top: 20px;">
	   	<label class="layui-form-label">备注:</label>
	   	<div class="layui-input-block">
	    		<textarea placeholder="请输入内容" class="layui-textarea" id="remark"></textarea>
	   	</div>
	</div>
  	<div class="layui-form-item" style="margin-top: 50px;">
	    <div class="layui-input-block">
	      	<button class="layui-btn" lay-submit="" lay-filter="demo1" id="submit">立即提交</button>
	      	<button type="reset" class="layui-btn layui-btn-primary" id="reset">重置</button>
	    </div>
  	</div>
</div>
<script type="text/javascript">
$(function() {
	getData(1);
	$("#addtype").hide();
	$("#submit").on("click", function () {
		var ctx = "${ctx}";
		var name = $("#name").val();
		var remark = $("#remark").val();
		if (name == "") {
			layer.alert("类别信息不能为空");
		} else {
			$.ajax({
				url : "${ctx }/types",
				type : "POST",
				data : { name : name, remark: remark},
				success : function(res) {
					if (res.code == 0) {
						location.reload();
						// 解决跳转失效
						return false;
					} else {
						layer.alert(res.message);
					}
				}
			});
		}
	});
	$("#reset").on("click", function () {
		$("#name").val("");
	});
	$("input[name=all]").click(function () {
		debugger;
        if (this.checked) {
            $("#tbody :checkbox").prop("checked", true);
        } else {
            $("#tbody :checkbox").prop("checked", false);
        }
    });
});
</script>
</html>