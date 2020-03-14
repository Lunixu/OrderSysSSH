<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改订单</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/user.css"/>
		<script type="text/javascript" src="<%=path %>/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
			.stus p{
				margin-top: 15px ;
			}
			.stus p input[type='submit']{
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
			.num input[type='text']{
				font-family: "微软雅黑";
				font-size: 15px;
				color: #333333;
				width: 135px;
				height: 40px;
				outline:none;
			}
			.users select{
				font-family: "微软雅黑";
				font-size: 15px;
				color: #333333;
				width: 80px;
				height: 30px;
				outline:none;
			}
		</style>
	</head>
	<body>
		<div class="top">
			<img src="<%=path %>/images/coin01.png" class="icon1"/>
			<a href="wright.jsp" target="right">首页</a>
			<span>--</span>
			<a href="order_showorders.jsp" target="right">结账服务--</a>
			<a href="javascript:void(0)" target="right">修改订单</a>
		</div>
		<div class="users stus">
		<form action="/OrderSysSSH/orderPayAction-update?id=${updateorder.id }" method="post">
			<table border="1" cellpadding="0" cellspacing="0" class="mytable">
				<tr>
					<th>订单ID</th>
					<th>订单开始时间</th>
					<th>订单结束时间</th>
					<th>订单状态</th>
					<th>处理订单的服务员编号</th>
					<th>订单所在桌号</th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td>${updateorder.id }</td>
					<td>${updateorder.beginTime }</td>
					<td>${updateorder.endTime }</td>
					<td>
						<select name="stateId" id="state">
							<option value="1">传菜</option>
							<option value="2">取消</option>
							<option value="3">烹饪</option>
							<option value="4">确认</option>
						</select>
					</td>
					<td>${updateorder.waiterId }</td>
					<td>
					<select name="tableId" id="setTable">
						<c:forEach var="table" items="${sessionScope.wtables}">
							<option value="${table.id }">${table.id }</option>
						</c:forEach>
					</select>
					</td>				
				</tr>
				<tr>
					<th colspan="8">订单详细信息</th>
				</tr>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>简述</th>
					<th>详述</th>
					<th>是否被推荐</th>
					<th>价格</th>
					<th>图片</th>
					<th>数量</th>
				</tr>	
				<c:forEach var="content" items="${updateorder.food }">
					<tr>
						<td>${content.dish.id }</td>
						<td>${content.dish.name }</td>
						<td>${content.dish.description }</td>
						<td>${content.dish.txt }</td>
						<td>${content.dish.isRecommended }</td>
						<td>${content.dish.price }</td>
						<td><img alt="" src="${content.dish.img }" width="60px" height="60px"></td>
						<td class="num">
							<input type="hidden" name="dishId" value="${content.dish.id }"/>
							<input type="text" name="dishNumber" value="${content.dishNumber }"/>
						</td>
					</tr>
				</c:forEach>	
			</table>
			<p style="text-align: center;margin-top:5px"><input type="submit" value="更新"/></p>
			</form>
		</div>
		
	</body>
	<script type="text/javascript">
		$().ready(function(){
			var stateid = "${sessionScope.updateorder.state.id }";
			var tableid = "${sessionScope.updateorder.tableId }";
			setOption("state", stateid);
			setOption("setTable", tableid);
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
	</script>
</html>
