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
		<title>添加客户信息</title>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			.top{
				width: 97.5%;
				top: 60px;
				background-color: #DDDDDD;
				
				padding-left: 30px;
			}
			.top a,span{
				font-family: "微软雅黑";
				font-size: 18px;
				line-height: 60px;
			}
			
			.top a{
				text-decoration: none;
				color: #3695CC;
			}
			.top img{
				position: relative;
				top: 3px;
			}
			.top .icon1{
				position: relative;
				top: 2px;
			}
			.addstu{
				width: 96%;
				height: 80%;
				border: 1px solid #ddd;
				margin: 20px 30px;
			}
			.addstu form{
				margin-top: 30px;
				margin-left: 30px;
			}
			.addstu form span{
				font-family: "微软雅黑";
				font-size: 20px;
			}
			.addstu form input[type='text']{
				width: 300px;
				height: 40px;
			}
			.addstu p{
				margin-top: 15px ;
			}
			.addstu form input[type='reset'],input[type='submit']{
				font-family: "微软雅黑";
				font-size: 20px;
				color: #333333;
				width: 135px;
				height: 40px;
				background-color: #3695CC;
				border: none;
				border-radius: 10px;
				outline:none;
			}
			.addstu form p:last-child{
				padding-left: 4%;
			}
			.addstu form select{
				font-family: "微软雅黑";
				font-size: 20px;
				width: 305px;
				height: 40px;
			}
			.addstu form .img{
				width: 480px;

			}
		</style>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="<%=path %>/admin/aright.jsp" target="right">首页</a>
			<span id="">-- 客户管理 --</span>
			<span id="">
				<a href="#" target="right">添加客户信息</a>
			</span>
		</div>
		<div class="addstu">
			<form action="/OrderSysSSH/customerAction-add" method="post">
				<p>
					<span>
						<span id="">客户姓名:</span>
						<input type="text" name="name" value="" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">客户性别:</span>
						<select name="sex">
							<option class="male" value="男">男</option>
							<option class="fmale" value="女">女</option>
						</select>
					</span>
				</p>
				<p>
					<span>
						<span id="">联系方式:</span>
						<input type="text" name="phoneNumber" value="" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">消费次数:</span>
						<input type="text" name="dinningTimes" value="" />
					</span>
				</p>
				<p>
					<span>
						<span id="">消费总额:</span>
						<input type="text" name="dinningSum" value="" />
					</span>
				</p>
				<p style="text-align: center;margin-top:5px">
					<input type="submit" value="添加"/>
					<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</body>
</html>
