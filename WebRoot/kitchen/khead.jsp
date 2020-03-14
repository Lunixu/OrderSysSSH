<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>头页面</title>
	<link rel="stylesheet" type="text/css" href="../css/khead.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="logo">
		<img src="../images/logo.jpg">
	</div>
	<div class="msgdiv">
		<input type="text" name="msg" class="msg" placeholder="公告" readonly="readonly" />
	</div>
	<div class="user">
		<img src="../images/coin09.png" alt="">
		<span>当前身份：${sessionScope.acount }</span>
		<span>账号：${sessionScope.kitchen.name }</span>
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
			"/OrderSysSSH/kitchenNoticeAction",
			{},
			function(data){
				$(".msg").val(data);
			},
			"text"
		);
	},1000);
</script>
</html>