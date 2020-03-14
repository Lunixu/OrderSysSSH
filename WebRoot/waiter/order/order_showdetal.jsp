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
		<title>订单详情</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
			.stus p{
				margin-top: 15px ;
			}
			.stus p input[type='reset'],input[type='submit']{
				font-family: "微软雅黑";
				font-size: 20px;
				color: #333333;
				width: 135px;
				height: 40px;
				background-color: #3695CC;
				border: none;
				border-radius: 10px;
				outline:none;
			}
		</style>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="wright.jsp" target="right">首页</a>
			<span>--</span>
			<a href="order_showorders.jsp" target="right">结账服务--</a>
			<a href="javascript:void(0)" target="right">订单详情</a>
		</div>
		<div class="stus users">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>订单ID</th>
					<th>订单开始时间</th>
					<th>订单结束时间</th>
					<th>订单状态</th>
					<th>处理订单的服务员编号</th>
					<th>订单所在桌号</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td>${sessionScope.detalorder.id }</td>
					<td>${sessionScope.detalorder.beginTime }</td>
					<td>${sessionScope.detalorder.endTime }</td>
					<td>${sessionScope.detalorder.state.name }</td>
					<td>${sessionScope.detalorder.waiterId }</td>
					<td>${sessionScope.detalorder.tableId }</td>				
				</tr>
				<tr>
					<th colspan="8">订单详细信息</th>
				</tr>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详述</th>
					<th>是否被推荐</th>
					<th>价格</th>
					<th>图片</th>
					<th>数量</th>
				</tr>	
				<c:forEach var="content" items="${sessionScope.detalorder.food }">
					<tr>
						<td>${content.dish.id }</td>
						<td>${content.dish.name }</td>
						<td>${content.dish.description }</td>
						<td>${content.dish.txt }</td>
						<td>${content.dish.isRecommended }</td>
						<td>${content.dish.price }</td>
						<td><img alt="" src="${content.dish.img }" width="60px" height="60px"></td>
						<td>${content.dishNumber }</td>
					</tr>
				</c:forEach>
				<tr>
					<th colspan="8" align="right"><p style="margin-right:240px">总共消费:${sessionScope.totalAmount }￥</p></th>
				</tr>
			</table>
			<form action="">
				<p style="text-align: center;margin-top:5px">
					<input type="submit" value="买单"/>
				</p>
			</form>
		</div>
		
	</body>
	<script type="text/javascript">
	
	</script>
</html>
