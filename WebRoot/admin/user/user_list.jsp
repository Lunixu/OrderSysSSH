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
		<title>用户信息管理</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="/OrderSysSSH/admin/aright.jsp" target="right">首页</a>
			<span id="">--餐厅管理</span>
		</div>
		<div class="add">
			<p>
				<a href="/OrderSysSSH/admin/user/user_add.jsp">添加</a>
			</p>
			<form action="/OrderSysSSH/userAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询员工的名字"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="stus">
			<table border="1" cellspacing="0" cellpadding="">
				<tr>
					<th>编号</th>
					<th>账号</th>
					<th>密码</th>
					<th>姓名</th>
					<th>性别</th>
					<th>电话</th>
					<th>地址</th>
					<th>角色</th>
					<th>头像</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${sessionScope.users }">
					<tr>
						<td>${user.id }</td>
						<td>${user.acount }</td>
						<td>${user.pwd }</td>
						<td>${user.name }</td>
						<td>${user.sex }</td>
						<td>${user.phoneNumber }</td>
						<td>${user.address }</td>
						<td>${user.position.name }</td>
						<td><img src="${user.faceImg }" style="width:50px;height:50px"></td>
						<td>
							<a href="/OrderSysSSH/userAction-upd?id=${user.id }" target="right">
								<img src="<%=path %>/images/update.png"/>
							</a>
							<a href="/OrderSysSSH/userAction-delete?id=${user.id }" target="right">
								<img src="<%=path %>/images/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a  href="/OrderSysSSH/userAction-list?currentPage=1">首页</a>
			<a  id = "first" href="/OrderSysSSH/userAction-list?currentPage=${sessionScope.currentPage - 1 }">上一页</a>
			<a  id = "last" href="/OrderSysSSH/userAction-list?currentPage=${sessionScope.currentPage + 1 }">下一页</a>
			<a  href="/OrderSysSSH/userAction-list?currentPage=${sessionScope.pageTotal }">尾页</a>
		</div>
		<div class="info">
			<span id="">当前第${sessionScope.currentPage }页</span>
			<span id="">总共${sessionScope.pageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
		
		var curPage = ${sessionScope.currentPage };
		var total = ${sessionScope.pageTotal };
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
