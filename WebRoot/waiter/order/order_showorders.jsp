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
		<title>结账服务</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="wright.jsp" target="right">首页</a>
			<span>--</span>
			<a href="order-list.jsp" target="right">结账服务</a>
		</div>
		<div class="stus">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr><th colspan="8" style="margin-left:10px;font-size:18px;color: #3695CC;">顾客订单列表</th></tr>
				<tr>
					<th>订单ID</th>
					<th>桌号</th>
					<th>服务员</th>
					<th>下单时间</th>
					<th>查看</th>
					<th>修改</th>
					<th>取消</th>
					<th>买单</th>
				</tr>
				<c:forEach var="order" items="${sessionScope.orders }">
					<tr>
						<td>${order.id }</td>
						<td>${order.tableId }</td>
						<td>${order.waiterId }</td>
						<td>${order.beginTime }</td>
						<td>
							<a href="/OrderSysSSH/orderPayAction-showdetal?id=${order.id }" target="right">
								<img src="<%=path %>/images/search.png" style="width: 30px;height: 30px;position: relative;top:4px;"/>
							</a>
						</td>
						<td>
							<a href="/OrderSysSSH/orderPayAction-upd?id=${order.id }" target="right">
								<img src="<%=path %>/images/update.png"/>
							</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/userAction-delete?id=${order.id }" target="right">
								<img src="<%=path %>/images/delete.png"/>
							</a>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/userAction-delete?id=${order.id }" target="right">
								<img src="<%=path %>/images/pay.png" style="width: 27px;height: 27px;position: relative;top:2px;"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a href="<%=request.getContextPath()%>/userAction-list?currentPage=1">首页</a>
			<a id="firstpage" href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.currentPage-1 }">上一页</a>
			<a id="lastpage" href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.currentPage+1 }">下一页</a>
			<a href="<%=request.getContextPath()%>/userAction-list?currentPage=${sessionScope.pageTotal }">尾页</a>
		</div>
		<div class="info">
			<span>当前是第${sessionScope.currentPage }页</span>
			<span>总共${sessionScope.pageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
	
	</script>
</html>
