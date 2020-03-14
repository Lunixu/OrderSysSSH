<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>登录页面</title>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="main">
		<div class="info">
			<span>点餐系统</span>
		</div>
		<form action="loginAction" method="post">
			<p>
				<span>用户名</span>
			</p>
			<p>
				<input type="text" name="acount" autocomplete="off"/>
			</p>
			<p>
				<span>密码</span>
			</p>
			<p>
				<input type="password" name="pwd" autocomplete="off"/>
			</p>
			<p>
				<span>验证码</span>
			</p>
			<p>
				<input type="text" class="codenum" name="codenum" autocomplete="off"/>
			</p>
			<p>
				<!-- 第几图片，重新加载图片资源，因为IE会有缓存，若果同样的请求路径，有时不会重新请求
				解决这个问题，可以每次请求是换一个请求路径，所以加上newDate().getTime参数 -->
				<img class="codeImg" src="image.jsp" onclick="this.src='image.jsp?'+new Date().getTime()">
				<span><img class="codeOK" src="images/ok.png"></span>
				<span><img class="codeNO" src="images/no.png"></span>
			</p>
			<p>
				<input type="submit" value="登录"/>
			</p>
		</form>
		<div class="err" style="color:red">
			${sessionScope.error }
			<c:remove var="error" scope="session"/><!-- 移除session中的 -->
		</div>
	</div>
</body>
<script type="text/javascript">
	var flag = false;
	$("form").submit(function(){
		$(".codenum").blur();//手动失去焦点
		var acount = $("input[name='acount']").val();
		var pass = $("input[name='pwd']").val();
		var codenum = $("input[name='codenum']").val();
		alert(msg);
		if ((acount == null || acount == "") || (pass==null||pass=="") || (codenum==null||codenum=="") || flag==false) {
			$(".err").html("请输入用户名、密码和正确验证码").css({"font-family":"微软雅黑","font-size":"18px","color":"red"});
			$("input[name='acount']").val("");
			$("input[name='pwd']").val("");
			$("input[name='codenum']").val("");
			$("input[name='acount']").focus();
			return false;
		}
	});
	
	$(".codenum").blur(function(){
		//获取表单codenum的值
		var codenum = $(".codenum").val();
		//发送AJAX的一部post请求
		$.post(
			"codeVerify",
			{"codenum":codenum},
			function(msg){
				if(msg=="yes"){
					$(".codeOK").show();
					$(".codeNO").hide();
					flag = true;
				}
				if(msg=="no"){
					$(".codeOK").hide();
					$(".codeNO").show();
					flag = false;
				}
			},
			"text"
		);
	});
</script>
</html>