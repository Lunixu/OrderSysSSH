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
			<span>--菜品管理-- 搜索结果</span>
		</div>
		<div class="add">
			<span>总共搜索到${sessionScope.countdishbykey }条信息</span>
		</div>
		<div class="stus">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详细描述</th>
					<th>推荐</th>
					<th>价格</th>
					<th>图鉴</th>
				</tr>
				<c:forEach var="dish" items="${sessionScope.dishsbykey }">
					<tr>
						<td>${dish.id }</td>
						<td>${dish.name }</td>
						<td>${dish.description }</td>
						<td>${dish.txt }</td>
						<td>${dish.isRecommended }</td>
						<td>${dish.price }</td>
						<td><img src="${dish.img }" style="width:50px;height:50px"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
