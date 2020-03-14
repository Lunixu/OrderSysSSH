<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>客户信息管理</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="/OrderSysSSH/admin/admin.jsp" target="right">首页</a>
			<span id="">--客户管理</span>
		</div>
		<div class="add">
			<p>
				<a href="/OrderSysSSH/admin/customer/vip_add.jsp">添加</a>
			</p>
			<form action="/OrderSysSSH/customerAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询客户的名字" autocomplete="off"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="stus users">
			<table border="1" cellspacing="0" cellpadding="">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>联系方式</th>
					<th>消费次数</th>
					<th>消费总额</th>
					<th>操作</th>
				</tr>
				<c:forEach var="customer" items="${sessionScope.customers }">
					<tr>
						<td>${customer.id }</td>
						<td>${customer.name }</td>
						<td>${customer.sex }</td>
						<td>${customer.phoneNumber }</td>
						<td>${customer.dinningTimes }</td>
						<td>${customer.dinningSum }</td>
						<td>
							<a href="/OrderSysSSH/customerAction-upd?id=${customer.id }" target="right">
								<img src="<%=path %>/images/update.png"/>
							</a>
							<a href="/OrderSysSSH/customerAction-delete?id=${customer.id }" target="right">
								<img src="<%=path %>/images/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a  href="/OrderSysSSH/customerAction-list?vipCurPage=1">首页</a>
			<a  id = "first" href="/OrderSysSSH/customerAction-list?vipCurPage=${sessionScope.vipCurPage - 1 }">上一页</a>
			<a  id = "last" href="/OrderSysSSH/customerAction-list?vipCurPage=${sessionScope.vipCurPage + 1 }">下一页</a>
			<a  href="/OrderSysSSH/customerAction-list?vipCurPage=${sessionScope.vipPageTotal }">尾页</a>
		</div>
		<div class="info">
			<span id="">当前第${sessionScope.vipCurPage }页</span>
			<span id="">总共${sessionScope.vipPageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
		
		var curPage = ${sessionScope.vipCurPage };
		var total = ${sessionScope.vipPageTotal };
		if(curPage >= total){
			$("#last").attr('href','javscript:;');
			$("#last").css("color","gray");
		}
		if(curPage <= 1){
			$("#first").attr('href','javscript:;');
			$("#first").css("color","gray");
		}
	</script>
</html>
