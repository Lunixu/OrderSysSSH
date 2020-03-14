<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>头页面</title>
	<link rel="stylesheet" type="text/css" href="../css/whead.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="logo">
		<img src="../images/logo.jpg">
	</div>
	<div class="msgdiv">
		<input type="text" name="msg" class="msg" placeholder="公告" readonly="readonly" />
		<span>桌号：</span>
		<select id="mytable">
			<c:forEach var="table" items="${sessionScope.wtables}">
				<option value="${table.id }">${table.id }</option>
			</c:forEach>
		</select>
	</div>
	<div class="user">
		<img src="../images/coin09.png" alt="">
		<span>当前身份：${sessionScope.acount }</span>
		<span>账号：${sessionScope.waiter.name }</span>
	</div>
	<div class="btn">
		<span><a href="" target="_parent">退出</a></span>
	</div>
</body>
<script type="text/javascript">
	$.ajaxSetup({
		contenType:"application/x-www-form-urlencoded;charset=utf-8"
	});
	setInterval(function(){
		$.post(
			"/OrderSysSSH/waiterNoticeAction",
			{},
			function(data){
				$(".msg").val(data);
			},
			"text"
		);
	},1000);
	
	$("#mytable").mouseenter(function(){
		$.post(
			"/OrderSysSSH/testWaiterAction",
			{},
			function(tables){
				var wtables=eval(tables);
				$("#mytable").empty();
				for(var i = 0; i < wtables.length; i++){
					$("#mytable").append("<option value="+wtables[i].id+">"+wtables[i].id+"</option>");
				}
			},
			"text"
		);
	});
</script>
</html>