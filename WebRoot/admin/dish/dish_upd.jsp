<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改菜品信息</title>
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
			<span id="">-- 用户管理 --</span>
			<span id="">
				<a href="#" target="right">添加用户信息</a>
			</span>
		</div>
		<div class="addstu">
			<form action="/OrderSysSSH/dishAction-update?id=${sessionScope.onedish.id }" method="post" enctype="multipart/form-data">
				<p>
					<span>
						<span id="">菜品名称:</span>
						<input type="text" name="name" value="${sessionScope.onedish.name }" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">菜品简述:</span>
						<input type="text" name="description" value="${sessionScope.onedish.description }" />
					</span>
				</p>
				<p>
					<span>
						<span id="">菜品价格:</span>
						<input type="text" name="price" value="${sessionScope.onedish.price }" />
					</span>
					<span style="margin: 0 100px;">
						<span id="">是否推荐:</span>
						<select name="isRecommended" id="setRe">
							<option class="recommend" value="是">推荐该菜品</option>
							<option class="noRecommend" value="否">不推荐该菜品</option>
						</select>
					</span>
				</p>
				<span id="">菜品详述:</span>
				<p style="margin:0px 0px 0px 90px;width:50%">
					<textarea id="txt" name="txt" clos="10" rows="7" warp="physical" 
						  style="width:100%;resize:none;font-family: '微软雅黑';">${sessionScope.onedish.txt }</textarea>
				</p>
				<p class="img">
					<span>
						<span id="">菜品图鉴:</span>
						<input type="file" name="dishimg" class="filess" style="display:none">
						<input type="text" name="fileText" class="fileText" value="${sessionScope.onedish.img }" />
						<button class="selectBtn" style="width:55px;height:33px"
							onclick="$('.filess').click();return false;">选择</button>
					</span>
					<span>
						<img src="${sessionScope.onedish.img }" id="icon" style="width: 100px;height: 100px;margin: 10px 90px;"/>
					</span>
				</p>
				<p style="text-align: center;margin-top:5px">
					<input type="submit" value="修改"/>
					<input type="reset" value="重置"/>
				</p>
			</form>
		</div>
	</body>
	<script type="text/javascript">
		$().ready(function(){
			var reid = "${sessionScope.onedish.isRecommended }";
			setOption("setRe", reid);
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
