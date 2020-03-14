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
		<title>菜品信息管理</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="/OrderSysSSH/admin/aright.jsp" target="right">首页</a>
			<span id="">--菜品管理</span>
		</div>
		<div class="add">
			<p>
				<a href="/OrderSysSSH/admin/dish/dish_add.jsp">添加</a>
				<a href="javascript:void(0)" target="right" class="aimport">导入菜品</a>
				<a href="/OrderSysSSH/dishAction-export" target="right">导出菜品</a>
			</p>
			<form action="/OrderSysSSH/dishAction-search" method="post">
				<input type="text" name="keyword" placeholder="请输入你要查询菜品的名字" autocomplete="off"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div class="stus users">
			<div class="dimport">
				<span>请选择你要导入的数据文件:</span>
				<form action="/OrderSysSSH/dishAction-dimport" method="post" enctype="multipart/form-data">
					<input type="file" name="dishfile" class="filess" style="display:none">
					<input type="text" class="fileText" />
					<button class="selectBtn" style="width:55px;height:33px"
						onclick="$('.filess').click();return false;">选择</button>
					<input type="submit" value="提交" class="myfilesubmit"/>
				</form>
			</div>
			<table border="1" cellspacing="0" cellpadding="">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详细描述</th>
					<th>推荐</th>
					<th>价格</th>
					<th>图鉴</th>
					<th>操作</th>
				</tr>
				<c:forEach var="dish" items="${sessionScope.dishs }">
					<tr>
						<td>${dish.id }</td>
						<td>${dish.name }</td>
						<td>${dish.description }</td>
						<td style="overflow:hidden; text-overflow:ellipsis; ">${dish.txt }</td>
						<td>${dish.isRecommended }</td>
						<td>${dish.price }</td>
						<td><img src="${dish.img }" style="width:50px;height:50px"></td>
						<td>
							<a href="/OrderSysSSH/dishAction-upd?id=${dish.id }" target="right">
								<img src="<%=path %>/images/update.png"/>
							</a>
							<a href="/OrderSysSSH/dishAction-delete?id=${dish.id }" target="right">
								<img src="<%=path %>/images/delete.png"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="page">
			<a  href="/OrderSysSSH/dishAction-list?dishCurPage=1">首页</a>
			<a  id = "first" href="/OrderSysSSH/dishAction-list?dishCurPage=${sessionScope.dishCurPage - 1 }">上一页</a>
			<a  id = "last" href="/OrderSysSSH/dishAction-list?dishCurPage=${sessionScope.dishCurPage + 1 }">下一页</a>
			<a  href="/OrderSysSSH/dishAction-list?dishCurPage=${sessionScope.dishPageTotal }">尾页</a>
		</div>
		<div class="info">
			<span id="">当前第${sessionScope.dishCurPage }页</span>
			<span id="">总共${sessionScope.dishPageTotal }页</span>
		</div>
	</body>
	<script type="text/javascript">
	
	"<c:if test='${sessionScope.exportinfo != null }'>"
		alert("${sessionScope.exportinfo}")
	"</c:if>"
	"<c:remove var='exportinfo' scope='session'/>"

		$(".filess").change(function(){
			$(".fileText").val($(".filess").val());
		});
		
		$(".aimport").click(function(){
			$(".dimport").toggle();
		});
		
		var curPage = ${sessionScope.dishCurPage };
		var total = ${sessionScope.dishPageTotal };
		if(curPage >= total){
			$("#last").attr('href','javscript:;');
			$("#last").css("color","gray");
		}
		if(curPage <= 1){
			$("#first").attr('href','javscript:;');
			$("#first").css("color","gray");
		}
	</script>
</html>
