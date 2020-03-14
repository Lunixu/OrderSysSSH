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
		<title>添加餐桌信息</title>
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
			<span id="">-- 餐桌管理 --</span>
			<span id="">
				<a href="#" target="right">添加餐桌信息</a>
			</span>
		</div>
		<div class="addstu">
			<form action="/OrderSysSSH/tableAction-add" method="post" enctype="multipart/form-data">
				<p>
					<span>
						<span id="">餐桌大小:</span>
						<select name="size">
							<option value="">-----请选择-----</option>
							<option value="4">4人桌</option>
							<option value="8">8人桌</option>
							<option value="12">12人桌</option>
							<option value="16">16人桌</option>
						</select>
					</span>
				</p>
				<p>
					<span>
						<span id="">是否空闲:</span>
						<select name="isFree">
							<option value="">-----请选择-----</option>
							<option value="是">空闲</option>
							<option value="否">有客</option>
						</select>
					</span>
				</p>
				<p style="style="style="margin-left:50px;margin-top:5px"">
					<input type="submit" value="添加"/>
					<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</body>
</html>
