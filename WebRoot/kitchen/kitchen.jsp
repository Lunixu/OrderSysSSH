<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>主页</title>
</head>
	<frameset rows="10%,*" border="none">
		<frame src="khead.jsp" name="head"></frame>
		<frameset cols="16%,*" border="none">
			<frame src="kleft.jsp" name="left"></frame>
			<frame src="/OrderSysSSH/kitchenDishAction-list" name="right"></frame>
		</frameset>
	</frameset>
</html>