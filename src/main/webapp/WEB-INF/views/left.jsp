<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="common.jsp"%>

<div class="layui-side layui-bg-black">
	<div class="layui-side-scroll">
		<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		<ul class="layui-nav layui-nav-tree" lay-filter="test">
			<li class="layui-nav-item"><a href="${ctx }/index">主页</a></li>
			<li class="layui-nav-item">
				<a class="" href="javascript:;">个人管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;">待办业务</a></dd>
					<dd><a href="javascript:;">已办业务</a></dd>
					<dd><a href="javascript:;">我的资产</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a class="" href="javascript:;">资产管理</a>
				<dl class="layui-nav-child">
					<dd><a href="${ctx }/asset/search">资产查询</a></dd>
					<dd><a href="javascript:;">资产借出</a></dd>
					<dd><a href="javascript:;">资产归还</a></dd>
					<dd><a href="javascript:;">资产调拨</a></dd>
					<dd><a href="${ctx }/asset/lab">实验室预约</a></dd>
					<dd><a href="${ctx }/asset/purchase">资产采购</a></dd>
					<dd><a href="javascript:;">资产报废</a></dd>
					<dd><a href="javascript:;">资产维修</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a class="" href="javascript:;">系统管理（完成）</a>
				<dl class="layui-nav-child">
					<dd><a href="${ctx }/system/user">用户管理</a></dd>
					<dd><a href="${ctx }/system/type">类别管理</a></dd>
					<dd><a href="${ctx }/system/role">角色管理</a></dd>
					<dd><a href="${ctx }/system/dept">部门管理</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="${ctx }/report/assetReport">报表管理</a></li>
		</ul>
	</div>
</div>
