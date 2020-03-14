<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>搜索结果显示</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="/OrderSysSSH/admin/aright.jsp" target="right">首页</a>
			<span>--餐桌管理-- 搜索结果</span>
		</div>
		<div class="add">
			<span>总共搜索到${sessionScope.counttablebykey }条信息</span>
		</div>
		<div class="stus">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>编号</th>
					<th>餐桌大小</th>
					<th>是否空闲</th>
				</tr>
				<c:forEach var="table" items="${sessionScope.tablesbykey }">
					<tr>
						<td>${table.id }</td>
						<td>${table.size }</td>
						<td>${table.isFree }</td>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
