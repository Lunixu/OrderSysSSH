<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>备菜服务</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="aright.html" target="right">备菜服务</a>
		</div>
	</div>
	<div class="users stus">
		<c:forEach var="order" items="${sessionScope.ordersByStateId }">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>桌号</th>
					<th>菜名</th>
					<th>数量</th>
					<th>取消</th>
					<th>烹饪</th>
					<th>传菜</th>
				</tr>
				<c:forEach var="food1" items="${order.food }">
					<tr>
						<td>${order.tableId }</td>
						<td>${food1.dish.name }</td>
						<td>${food1.dishNumber }</td>
						<td>
							<a href="/OrderSysSSH/kitchenDishAction-deldish?id=${food1.dish.id }" target="right">
								<img src="<%=path %>/images/delete.png" style="width: 25px;height: 25px;"/>
							</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/userAction-delete?id=${user.id }" target="right">
								<img src="<%=path %>/images/wait.png" style="width: 27px;height: 27px;position: relative;top: 2px;"/>
							</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/userAction-delete?id=${user.id }" target="right">
								<img src="<%=path %>/images/coin11.png" style="width: 25px;height: 25px;"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>