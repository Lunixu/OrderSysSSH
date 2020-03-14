<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>点餐服务</title>
	<link rel="stylesheet" type="text/css" href="../css/wright.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body onload="showPage(1)">
	<div class="main">
		<div class="top">
			<img src="../images/coin01.png" class="icon1"/>
			<a href="wright.jsp" target="right">点餐服务</a>
			<div class="refresh">
				<img src="../images/refresh.png" class="icon2">
				<a href="<%=request.getContextPath()%>/waiterDishAction?currentPage4=${sessionScope.currentPage4 }" target="right">刷新</a>
			</div>
		</div>
		<form action="javascript:void(0)" method="post">
		<div class="dishes">
			<table cellpadding="0" cellspacing="0" >

				<c:set var="i" scope="page" value="1"/>
				<c:forEach var="wdish" items="${sessionScope.wdishes }" varStatus="status">
				<c:if test="${status.count%3==1 }">
					<tr>
				</c:if>	
						<td>
							<img src="${wdish.img }" alt="">
							<p>${wdish.name }</p>
							<p class="intro">${wdish.description }</p>
							<p>价格：${wdish.price } RMB</p>
							<input type="button" value="-" class="sub${i}" onclick="calc('.dishnum${i}','sub')"/>
							<input type="text" name="${wdish.id}" value="0" class="dishnum${i}"/>
							<input type="button" value="+" class="add${i}" onclick="calc('.dishnum${i}','add')"/>
							<c:set var="i" scope="page" value="${i+1}"/>
						</td>
					<c:if test="${status.count%3==0 }">	
					</tr>
					</c:if>
				</c:forEach>	
			</table>
		</div>
		<div class="page" id="page">
			
		</div>
		</form>
		<div class="real" style="display: none;">
			<form action="<%=request.getContextPath()%>/orderOkWaiterAction" method="post">
				<input type="text" name="tableId" class="htable">
				<input type="text" name="waiterId" value="${sessionScope.waiterId }">
				<input type="text" name="stateId" value="4">
			</form>
		</div>
		<input type="submit" value="确认订单" class="orderOk"/>
	</div>
	<script type="text/javascript">
$(".orderOk").click(function(){
	$(".htable").val(window.parent.head.document.getElementById("mytable").value);
	$(".dishes input[type='text']").each(function(i){
		if($(this).val()!=0){
			$(".real form").append("<input type='text' name='dishId' value="+$(this).attr("name")+">");
			$(".real form").append("<input type='text' name='dishNumber' value="+$(this).val()+">");
		}
	});	
	$(".real form").submit();
});
function calc(textCls,oper){
	var myvalue=$(textCls).val();
	if(oper=="add"){
			myvalue++;
			$(textCls).val(myvalue);
		if(myvalue>10000)
			$(textCls).val(10000);
	}
	if(oper=="sub"){
			myvalue--;
			$(textCls).val(myvalue);
			if(myvalue<0)
				$(textCls).val(0);
	}
}
function showPage(pageIndex){
		
	var pageTotal=(parseInt($(".dishes")[0].scrollHeight)+parseInt($(".dishes")[0].offsetHeight)-1)/parseInt($(".dishes")[0].offsetHeight);
		
	$(".dishes")[0].scrollTop=(pageIndex-1)*parseInt($(".dishes table tr")[0].offsetHeight);
	
	var tempStr="";	
	if(pageIndex>1){
        tempStr += "<a href=\"javascript:showPage("+1+");\">首页</a>";
        tempStr += "<a href=\"javascript:showPage("+(pageIndex-1)+");\"><上一页</a>"
    }else{
        tempStr += "首页";
        tempStr += "<上一页";    
    }
 
    if(pageIndex<pageTotal){
        tempStr += "<a href=\"javascript:showPage("+(pageIndex+1)+");\">下一页></a>";
        tempStr += "<a href=\"javascript:showPage("+(pageTotal)+");\">尾页</a>";
	}else{
        tempStr += "下一页>";
        tempStr += "尾页";    
    }
    document.getElementById("page").innerHTML = tempStr;
   }
</script>
</body>
</html>