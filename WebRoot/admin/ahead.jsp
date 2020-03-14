<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>头页面</title>
	<link rel="stylesheet" type="text/css" href="../css/ahead.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body onload="getDate01()">
	<div class="top">
		<div class="top_logo">
			<img alt="logo" src="../images/logo.png" >
		</div>
		<div class="msgdiv">
			<input type="text" name="msg" class="msg" placeholder="发布公告" />
		</div>
		<div class="msgsend">
			<input type="button" class="send" value="提交"/>
		</div>
		<div class="top_links">
			<div class="top_op">
				<ul>
					<li>
						<img alt="当前用户" src="../images/common/user.jpg">：
						<span>${sessionScope.admin.name }</span>
					</li>
					<li>
						<img alt="当前角色" src="../images/common/month.jpg">：
						<span id="yue_fen">${sessionScope.acount }</span>
					</li>
					<li>
						<img alt="今天是" src="../images/common/date.jpg">：
						<span id="day_day"></span>
					</li>
				</ul> 
			</div>
			<div class="top_close">
				<img id="layout" alt="退出系统" title="退出系统" src="../images/common/close.jpg">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	/**获得当前日期**/
	function  getDate01(){
		var time = new Date();
		var myYear = time.getFullYear();
		var myMonth = time.getMonth()+1;
		var myDay = time.getDate();
		if(myMonth < 10){
			myMonth = "0" + myMonth;
		}
		document.getElementById("day_day").innerHTML =  myYear + "." + myMonth + "." + myDay;
	}

	$.ajaxSetup({
		contenType:"application/x-www-form-urlencoded;charset=utf-8"
	});
	$(".send").click(function(){
		var message = $(".msg").val();
		$.post(
				"/OrderSysSSH/managerNoticeAction",
				{"message":message},
				function(data){
					alert("公告发送成功");
				},
				"text"
		);
	});
</script>
</html>