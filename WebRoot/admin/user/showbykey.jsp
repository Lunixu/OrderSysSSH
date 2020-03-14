<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>搜索结果显示</title>
		<link rel="stylesheet" type="text/css" href="../css/user.css"/>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.jsp" target="right">首页</a>
			<span>--员工管理-- 搜索结果</span>
		</div>
		<div class="add">
			<span>总共搜索到${sessionScope.countbykey }条信息</span>
		</div>
		<div class="stus">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>编号</th>
					<th>账号</th>
					<th>密码</th>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>地址</th>
					<th>职位</th>
					<th>头像</th>
				</tr>
				<c:forEach var="user" items="${sessionScope.usersbykey }">
				<tr>
					<td>${user.id }</td>
					<td>${user.acount }</td>
					<td>${user.pwd }</td>
					<td>${user.name }</td>
					<td>${user.sex }</td>
					<td>${user.phoneNumber }</td>
					<td>${user.address }</td>
					<td>${user.position.name }</td>
					<td><img src="${user.faceImg }" width="50px" height="50px"></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
