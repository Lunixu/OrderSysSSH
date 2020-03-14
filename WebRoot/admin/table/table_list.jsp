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
		<title>餐桌信息管理</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="/OrderSysSSH/admin/aright.jsp" target="right">首页</a>
			<span id="">--餐桌管理</span>
		</div>
		<div class="add">
			<p>
				<a href="/OrderSysSSH/admin/table/table_add.jsp">添加</a>
			</p>
			<form action="/OrderSysSSH/tableAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询餐桌的ID" autocomplete="off"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="stus users">
			<table border="1" cellspacing="0" cellpadding="">
				<tr>
					<th>编号</th>
					<th>餐桌大小</th>
					<th>是否空闲</th>
					<th>操作</th>
				</tr>
				<c:forEach var="table" items="${sessionScope.tables }">
					<tr>
						<td>${table.id }</td>
						<td>${table.size }</td>
						<td>${table.isFree }</td>
						<td>
							<a href="/OrderSysSSH/tableAction-upd?id=${table.id }" target="right">
								<img src="<%=path %>/images/update.png"/>
							</a>
							<a href="/OrderSysSSH/tableAction-delete?id=${table.id }" target="right">
								<img src="<%=path %>/images/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a  href="/OrderSysSSH/tableAction-list?tableCurPage=1">首页</a>
			<a  id = "first" href="/OrderSysSSH/tableAction-list?tableCurPage=${sessionScope.tableCurPage - 1 }">上一页</a>
			<a  id = "last" href="/OrderSysSSH/tableAction-list?tableCurPage=${sessionScope.tableCurPage + 1 }">下一页</a>
			<a  href="/OrderSysSSH/tableAction-list?tableCurPage=${sessionScope.tablePageTotal }">尾页</a>
		</div>
		<div class="info">
			<span id="">当前第${sessionScope.tableCurPage }页</span>
			<span id="">总共${sessionScope.tablePageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
		
		var curPage = ${sessionScope.tableCurPage };
		var total = ${sessionScope.tablePageTotal };
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
