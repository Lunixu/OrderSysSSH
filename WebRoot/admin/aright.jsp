<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="../css/aright.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="aright.jsp" target="right">首页</a>
		</div>
	</div>
	<div class="dish">
		<span>今日推荐菜品</span>
		<img src="../images/img_3.jpg">
	</div>
	<div class="paihao">
		<span>排号</span>
		<div class="free">
			<img src="../images/coin03.png" alt="">
			<span>当前空余桌数：</span>
		</div>
		<div class="queue">
			<img src="../images/coin10.png" alt="">
			<span>当前排队人数：</span>
		</div>
		<div class="info">
			<img src="../images/coin11.png" alt="">
			<span>当前尚有空桌，请就坐！</span>
			<span>当前尚无空桌，请排号，耐心等候！</span>
		</div>
		<div class="order">
			<button>进行排号</button>
		</div>
	</div>
</body>
</html>