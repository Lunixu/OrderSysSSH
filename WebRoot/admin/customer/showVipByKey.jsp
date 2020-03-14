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
			<span>--客户管理-- 搜索结果</span>
		</div>
		<div class="add">
			<span>总共搜索到${sessionScope.customercountbykey }条信息</span>
		</div>
		<div class="stus">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>联系方式</th>
					<th>消费次数</th>
					<th>消费总额</th>
				</tr>
				<c:forEach var="customer" items="${sessionScope.customersbykey }">
					<tr>
						<td>${customer.id }</td>
						<td>${customer.name }</td>
						<td>${customer.sex }</td>
						<td>${customer.phoneNumber }</td>
						<td>${customer.dinningTimes }</td>
						<td>${customer.dinningSum }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
