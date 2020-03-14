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
		<title>修改学生信息</title>
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
			.addstu form .FacaImg{
				width: 450PX;

			}
		</style>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="#" target="right">首页</a>
			<span id="">-- 用户管理 --</span>
			<span id="">
				<a href="#" target="right">修改用户信息</a>
			</span>
		</div>
		<div class="addstu">
			<form action="/OrderSysSSH/userAction-update?id=${sessionScope.oneuser.id}" method="post" enctype="multipart/form-data">
				<p>
					<span>
						<span id="">账号:</span>
						<input type="text" name="acount" value="${sessionScope.oneuser.acount}" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">密码:</span>
						<input type="text" name="pwd" value="${sessionScope.oneuser.pwd}" />
					</span>
				</p>
				<p>
					<span>
						<span id="">姓名:</span>
						<input type="text" name="name" value="${sessionScope.oneuser.name}" />
					</span>
					<span style="margin: 0 100px;">
						<span>性别:</span>
						<select name="sex" id="setSex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</span>
				</p>
				<p>
					<span>
						<span id="">电话:</span>
						<input type="text" name="phoneNumber" value="${sessionScope.oneuser.phoneNumber}" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">地址:</span>
						<input type="text" name="address" value="${sessionScope.oneuser.address}" />
					</span>
				</p>
				<p>
					<span id="">职位:</span>
					<select name="myposition" id="setPosition">
						<c:forEach var="eposition" items="${sessionScope.positions }">
							<option value="${eposition.id }">${eposition.name }</option>
						</c:forEach>
					</select>
				</p>
				<p class="FacaImg">
					<span>
						<span id="">头像:</span>
						<input type="file" name="img" class="filess" style="display:none">
						<input type="text" name="fileText" class="fileText" value="${sessionScope.oneuser.faceImg }" />
						<button class="selectBtn" style="width:55px;height:33px"
							onclick="$('.filess').click();return false;">选择</button>
					</span>
					<span>
						<img src="${sessionScope.oneuser.faceImg}" id="icon" style="width: 100px;height: 100px;margin: 10px 50px;"/>
					</span>
				</p>
				<p style="text-align: center;">
					<input type="submit" value="更新"/>
					<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</body>
	<script type="text/javascript">
		$().ready(function(){
			var sexid = "${sessionScope.oneuser.sex }";
			var postionid = "${sessionScope.oneuser.position.id}";
			setOption("setSex", sexid);
			setOption("setPosition", postionid);
		});
		function setOption(args,flag){
			$("#"+args+" option").each(function(){
				 //遍历所有option  
				var value = $(this).val();   //获取option值  
				if(value == flag){   
					$(this).attr("selected","true");
				} 
			});
		}
		$(".filess").change(function(){
			$(".fileText").val($(".filess").val());
			handleFiles(this,'icon');
		});
		function handleFiles(obj,id) {
		    file = document.getElementById("icon");
		    var files = obj.files;
		    img = new Image();
		    if(window.URL){
		        //File API
		        img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
		        img.onload = function(e) {
		        window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
		        };
		    }
		    file.src=img.src; 
		}
	</script>
</html>