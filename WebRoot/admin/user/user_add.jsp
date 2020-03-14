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
		<title>添加学生信息</title>
		<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
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
			.addstu form .FacaImg{
				width: 450PX;
			}
		</style>
	</head>
	<body>
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="#" target="right">首页</a>
			<span id="">-- 用户管理 --</span>
			<span id="">
				<a href="#" target="right">添加用户信息</a>
			</span>
		</div>
		<div class="addstu">
			<form action="/OrderSysSSH/userAction-add" method="post" enctype="multipart/form-data">
				<p>
					<span>
						<span id="">账号:</span>
						<input type="text" name="acount" value="" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">密码:</span>
						<input type="text" name="pwd" value="" />
					</span>
				</p>
				<p>
					<span>
						<span id="">姓名:</span>
						<input type="text" name="name" value="" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">性别:</span>
						<input type="text" name="sex" value="" />
					</span>
				</p>
				<p>
					<span>
						<span id="">电话:</span>
						<input type="text" name="phoneNumber" value="" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">地址:</span>
						<input type="text" name="address" value="" />
					</span>
				</p>
				<p>
					<span id="">职位:</span>
					<select name="myposition">
						<c:forEach var="eposition" items="${sessionScope.positions }">
							<option value="${eposition.id }">${eposition.name }</option>
						</c:forEach>
					</select>
				</p>
				<p class="FacaImg">
					<span>
						<span id="">头像:</span>
						<input type="file" name="img" class="filess" style="display:none">
						<input type="text" class="fileText" value="" />
						<button class="selectBtn" style="width:55px;height:33px"
							onclick="$('.filess').click();return false;">选择</button>
					</span>
					<span>
						<img src="#" style="width: 100px;height: 100px;margin: 10px 50px;"/>
					</span>
				</p>
				<p style="text-align: center;">
					<input type="submit" value="添加"/>
					<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</body>
	<script type="text/javascript">
		$(".filess").change(function(){
			$(".fileText").val($(".filess").val());
		});
	</script>
</html>
