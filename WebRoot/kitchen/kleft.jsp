<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>左边栏</title>
	<link rel="stylesheet" type="text/css" href="../css/kleft.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="container">
		<dl>
			<dt class="main">
				<img src="../images/coin01.png" class="icon1">
				<span><a href="" target="right">备菜服务</a></span>
			</dt>
		</dl>
		<dl>
			<dt class="main">
				<img src="../images/coinL1.png" class="icon8">
				<span>系统管理</span>
				<img src="../images/coin19.png" class="icon3">
			</dt>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="../login.jsp" target="right">修改密码</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin112.png" class="icon21">
				<span class="stu"><a href="../login.jsp" target="_parent">退出</a></span>
			</dd>					
		</dl>
	</div>
</body>
<script type="text/javascript">
	$(".main:eq(0)").css({"border-top":"1px solid #dedede"});
	$(".main:eq(1)").click(function(){
		$(".sub:eq(0),.sub:eq(1)").toggle();//在显示与隐藏之间切换
	});			
</script>
</html>