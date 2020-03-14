<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>左边栏</title>
	<link rel="stylesheet" type="text/css" href="../css/aleft.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="container">
		<dl>
			<dt class="main">
				<img src="../images/coin01.png" class="icon1">
				<span><a href="" target="right">首页</a></span>
			</dt>
		</dl>
		<dl>
			<dt class="main">
				<img src="../images/coin17.png" class="icon2">
				<span>运营服务</span>
				<img src="../images/coin19.png" class="icon3">
			</dt>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="" target="right">排号服务</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin112.png" class="icon21">
				<span class="stu"><a href="../login.jsp" target="right">结账服务</a></span>
			</dd>
		</dl>
		<dl>
			<dt class="main">
				<img src="../images/coin03.png" class="icon4">
				<span>餐厅管理</span>
				<img src="../images/coin19.png" class="icon3">
			</dt>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="/OrderSysSSH/userAction-list" target="right">员工管理</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="/OrderSysSSH/dishAction-list" target="right">菜品管理</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="/OrderSysSSH/customerAction-list" target="right">客户管理</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin111.png" class="icon21">
				<span class="stu"><a href="/OrderSysSSH/tableAction-list" target="right">餐桌管理</a></span>
			</dd>
			<dd class="sub">
				<img src="../images/coin112.png" class="icon21">
				<span class="stu"><a href="../login.jsp" target="right">经营数据</a></span>
			</dd>
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
	$(".main:eq(2)").click(function(){
		$(".sub:eq(2),.sub:eq(3),.sub:eq(4),.sub:eq(5),.sub:eq(6)").toggle();
	});
	$(".main:eq(3)").click(function(){
		$(".sub:eq(7),.sub:eq(8)").toggle();
	});		
</script>
</html>