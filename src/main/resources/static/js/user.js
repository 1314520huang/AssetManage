var vm1 = new Vue({
	el : '#searchDiv',
	data : {
		roles : {},
		depts : {}
	}
});

var vm2 = new Vue({
	el : '#addUser',
	data : {
		roles : {},
		depts : {}
	}
});

var vm3 = new Vue({
	el : '#updateRoleDiv',
	data : {
		roles : {}
	}
});

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

function addUser() {

	layui.use([ 'layer' ], function() {
		var layer = layui.layer, $ = layui.$;
		var index = layer.open({
			type : 1,// 类型
			area : [ '900px', '550px' ],// 定义宽和高
			title : '新增用户',// 题目
			shadeClose : false,// 点击遮罩层关闭
			content : $('#addUser'),// 打开的内容
			end : function() {
				$("#addUser").hide();
			},
			success : function() {
				var index = layer.msg('正在加载菜单，请稍后', {
					icon : 16,
					shade : 0.01,
					shadeClose : false,
					time : 5000
				});
				vm2.roles = vm1.roles;
				vm2.depts = vm1.depts;
				layer.close(index);
			}
		});
	})
}

function initSearch() {

	var index = layer.msg('正在加载菜单，请稍后', {
		icon : 16,
		shade : 0.01,
		shadeClose : false,
		time : 5000
	});
	$.ajax({
		url : '${ctx }/getSearch',
		type : 'GET',
		data : {},
		success : function(res) {
			if (res.code == 0) {
				vm1.roles = res.data.roles;
				vm1.depts = res.data.depts;
				layui.use('form', function() {
					var form = layui.form;
					form.render('select');
					layer.close(index);
				});
			} else
				layer.alert(res.message);
		}
	});
}

$(function() {
	getData({});
	initSearch();
	$("#submit").on(
			"click",
			function() {
				var data = $("#userForm").serialize() + "&levelName="
						+ $("#roleSelect option:selected").text()
						+ "&deptName="
						+ $("#deptSelect  option:selected").text();
				$.ajax({
					url : '${ctx }/users',
					type : 'POST',
					data : data,
					success : function(res) {
						if (res.code == 0)
							location.reload();
						else
							layer.alert(res.message);
					}
				});
			});

	$("#reset").on("click", function() {
		$("#userForm").reset();
	});

	$("input[name=all]").click(function() {
		if (this.checked) {
			$("#tbody :checkbox").prop("checked", true);
		} else {
			$("#tbody :checkbox").prop("checked", false);
		}
	});

	$("#resetRole").on("click", function() {
		$("#roleSelectDiv").empty();
	});

	$("#updateRoleBtn").on("click", function() {
		debugger;
		var userId = $("#userId").val();
		var role = $("#roleSelectDiv option:selected").val();
		$.ajax({
			url : '${ctx}/users',
			method : 'PATCH',
			data : {
				id : userId,
				level : role
			},
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
