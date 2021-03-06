<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jd/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>物流配送管理系统---审核配送通知单</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="../bootstrap_template/application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../bootstrap_template/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../bootstrap_template/css/style.css" rel='stylesheet'
	type='text/css' />
<!-- Graph CSS -->
<link href="../bootstrap_template/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="bootstrap_template/css/icon-font.min.css"
	type='text/css' />
<script src="../bootstrap_template/js/amcharts.js"></script>
<script src="../bootstrap_template/js/serial.js"></script>
<script src="../bootstrap_template/js/light.js"></script>
<!-- //lined-icons -->
<script src="../bootstrap_template/js/jquery-1.10.2.min.js"></script>
<!--pie-chart--->
<script src="../bootstrap_template/js/pie-chart.js"
	type="text/javascript"></script>
<script type="text/javascript">
			$(document)
					.ready(
							function() {
								$('#demo-pie-1')
										.pieChart(
												{
													barColor : '#3bb2d0',
													trackColor : '#eee',
													lineCap : 'round',
													lineWidth : 8,
													onStep : function(from, to,
															percent) {
														$(this.element)
																.find(
																		'.pie-value')
																.text(
																		Math
																				.round(percent)
																				+ '%');
													}
												});

								$('#demo-pie-2')
										.pieChart(
												{
													barColor : '#fbb03b',
													trackColor : '#eee',
													lineCap : 'butt',
													lineWidth : 8,
													onStep : function(from, to,
															percent) {
														$(this.element)
																.find(
																		'.pie-value')
																.text(
																		Math
																				.round(percent)
																				+ '%');
													}
												});

								$('#demo-pie-3')
										.pieChart(
												{
													barColor : '#ed6498',
													trackColor : '#eee',
													lineCap : 'square',
													lineWidth : 8,
													onStep : function(from, to,
															percent) {
														$(this.element)
																.find(
																		'.pie-value')
																.text(
																		Math
																				.round(percent)
																				+ '%');
													}
												});

							});
		</script>
<style type="text/css">
	body{font-size:15px;margin:0px;padding:0px;background:#ccc;background-image: url(../images/bk.png);}
	a{text-decoration:none;color:#000;}
	.wl_container{width:1002px;margin:0px auto;background:#fff;}
	.wl_head{height:122px;background:url(../images/wl_head_01.jpg) no-repeat;}
	.wl_separater{background:url(../images/wl_vline_04.jpg) repeat-x;margin-top:1px;color:#fff;text-align:center;line-height:2.3em;font-weight:bold;}
	.wl_main{height:645px;background:#01a333;float:left;}
	.wl_left{float:left;width:209px;margin-left:1px;margin-right:2px;display:inline;}
	.wl_item{display:block;width:169px;height:24px !important;height:23px;background:url(../images/wl_item_04.jpg) no-repeat;padding:9px 0px 0px 40px !important;padding:10px 0px 0px 40px;margin-bottom:2px;font-size:14px;font-weight:bold;}
	.wl_right{width:790px;height:645px;float:left;background:#fff;}
	.wl_foot{clear:both;background:pink;text-align:center;color:#fff;font-weight:bold;line-height:2em;}
	.wl_table{width:700px;border-collapse:collapse;border:1px solid #ccc;margin:30px auto 0px;}
	.wl_table th,.wl_table td{border:1px solid #ccc;text-align:center;padding:3px;}
	.wl_table .lastTd{text-align:left;}
	.wl_page{width:700px;margin:5px auto;text-align:center;}
	.wl_page span{font-weight:bold;}
	.wl_content_nav{font-size:14px;font-family:'Microsoft Yahei',PMingLiU,Verdana;padding:13px 0px 0px 20px;}
	.wl_detailsty{cursor:pointer;}
	.wl_detaildata{border:1px solid #ccc;border-collapse:collapse;width:300px;margin:10px auto;}
	.wl_detaildata td{border:1px solid #ccc;}
	#ServerTimeArea{margin-top:30px;font-size:14px;color:#fff;font-weight:bold;}
</style>
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<!-- 可以保留 -->
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!-- top_bg -->
					<div class="top_bg">

						<div class="header_top">
							<div class="top_right">
								<ul>
									<li><a href="../switch?msg=1">接单系统</a></li>|
									<li><a href="../switch?msg=3">仓管系统</a></li>|
									<li><a href="../switch?msg=4">运输系统</a></li>|
									<li><a href="../switch?msg=5">客户管理系统</a></li>|
									<li><a href="../switch?msg=6">管理员后台</a></li>
								</ul>
							</div>
							<div class="top_left">
								<h2>
									<span></span> 欢迎您，${sessionScope.loginUser.userName }
								</h2>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
					<div class="clearfix"></div>
					<!-- /top_bg -->
				</div>
				<div class="header_bg">
					<!-- 可以保留-->

					<div class="header">
						<div class="head-t">
							<div class="logo">
								<a href="index.html"><img src="images/logo.png"
									class="img-responsive" alt=""></a>
							</div>
							<!-- start header_right -->
							<div class="header_right">
								<div class="rgt-bottom">
									<div id="ServerTimeArea" style="color: black"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1"> <a href="querydispatch"
				class="sidebar-icon"> <span class="fa fa-bars"></span>
			</a> </header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				<ul id="menu">
					<li id="menu-academico"><a href="querystore"><i
							class="fa fa-file-text-o"></i> <span>查询库存</span></a></li>
					<li id="menu-academico"><a href="querydispatch"><i
							class="fa fa-file-text-o"></i> <span>查询配送通知单</span></a></li>
					<li id="menu-academico"><a href="adddispatch"><i
							class="fa fa-file-text-o"></i> <span>增加配送通知单</span></a></li>
					<li id="menu-academico"><a href="AddSubTransport"><i
							class="fa fa-file-text-o"></i> <span>增加代运通知单</span></a></li>
					<c:if test="${sessionScope.loginUser.userType!=1 }">
						<li id="menu-academico"><a href="examinedispatch"><i
								class="fa fa-file-text-o"></i> <span>审核配送通知单</span></a></li>
						<li id="menu-academico"><a href="cancel"><i
								class="fa fa-file-text-o"></i> <span>作废配送通知单</span></a></li>
					</c:if>
					<li id="menu-academico"><a href="exit"><i
							class="fa fa-file-text-o"></i> <span>退出系统</span></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	
	
	
	
	
	
	
	<form id="form1" name="myForm" action="" method="post">
            			<input type="hidden" name="operate" value="" id="flag"/>
                		<div class="wl_content_nav">审核配送通知单</div>
		<table class="table table-striped"
			style="margin-left: 400px; margin-right: 200px; width: 800px">
			<caption>审核配送通知单</caption>
			<thead>
				<tr>
					<th>批量选择</th>
					<th>单据ID</th>
					<th>单据名称</th>
					<th>下单时间</th>
					<th>单据状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listDispatchDto }" var="dispatchDto">
					<tr>
						<td><input type="checkbox" name="chkItem" value="${dispatchDto.dispatchId }" /></td>
						<td>${dispatchDto.dispatchId }</td>
						<td>配送通知单</td>
						<td>${dispatchDto.orderDate }</td>
						<td>${dispatchDto.stateName }</td>
						<td><a
							href="modifydispatch?dispatch=${dispatchDto.dispatchId }">修改</a>
							<span class="wl_detailsty" onclick="showDetail(${dispatchDto.dispatchId})">详情...</span></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" class="lastTd">
						<input type="button" value="全部选择" id="btnSelAll"/>
                                  <input type="button" value="全不选择" id="btnSelNot"/>
                                  <input type="button" value="删除所选" id="delSel"/>
                                  <input type="button" value="提    交" id="btnExamine"/>
						</td>
				</tr>
			</tbody>
		</table>
		<div class="wl_page">
			<c:if test="${requestScope.maxPage == 1 }">
                        		共有<span>${requestScope.rowCount }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled="disabled">首页</a>]
                        	[<a disabled="disabled">上一页</a>]
                        	[<a disabled="disabled">下一页</a>]
                        	[<a disabled="disabled">末页</a>]
                        	</c:if>
			<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == 1}">
                        	共有<span>${requestScope.rowCount }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled="disabled">首页</a>]
                        	[<a disabled="disabled">上一页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	共有<span>${requestScope.rowCount }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=1">首页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	共有<span>${requestScope.rowCount }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=1">首页</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a disabled="disabled">下一页</a>]
                        	[<a disabled="disabled">末页</a>]
                        	</c:if>
		</div>
		<table class="wl_detaildata" id="dataarea">
                        	<tr>
                        		<td>订单号</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>货物名称</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>货物数量</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>运力工具</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>发货人</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>发货人电话</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>收货人姓名</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>收货人电话</td>
                        		<td></td>
                        	</tr>
                        	<tr>
                        		<td>收货地址</td>
                        		<td></td>
                        	</tr>
                        </table>
</form>

<div class="wl_foot"
		style="color: black; margin-top: 50px; font-size: 18px; margin-bottom: 50px">-
		冷链物流仓储管理系统 -</div>

    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script>
    <script type="text/javascript">
    window.onload = function(){
    	
    	$("dataarea").style.display = "none";
    };
    
    
    
    
    $("delSel").onclick = function(){
    	$("flag").value = "1";//标识删除操作
    	document.myForm.submit();
    };
    $("btnExamine").onclick = function(){
    	$("flag").value = "2";//标识审核操作
    	document.myForm.submit();
    };
    
    
    
    $("btnSelAll").onclick = function(){
		var chkItems = $N("chkItem");
		for(var i = 0 ; i < chkItems.length ; i++){
			if(chkItems[i].type == "checkbox"){
				chkItems[i].checked = true;
			}
		}
	};
	$("btnSelNot").onclick = function(){
		var chkItems = $N("chkItem");
		for(var i = 0 ; i < chkItems.length ; i++){
			if(chkItems[i].type == "checkbox"){
				chkItems[i].checked = false;
			}
		}
	};
	
	
	
	function showDetail(id){
		var xhr = createXHR();
		var uri = "getdispatchdetail?" + encodeURIComponent("dispatch") + "=" + encodeURIComponent(id) + "&fresh=" + Math.random();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var result = xhr.responseText.split(":");
					var detailTable = $("dataarea");
					for(var i = 0 ; i < detailTable.rows.length ; i++){
						clear(detailTable.rows[i].cells[1]);
						detailTable.rows[i].cells[1].appendChild(document.createTextNode(result[i]));
					}
					$("dataarea").style.display = "block";
				}
			}
		};
		xhr.open("get",uri,true);
		xhr.send(null);
	}
	
	function clear(par){
		while(par.childNodes.length > 0){
			par.removeChild(par.childNodes[0]);
		}
	}
    </script>
</body>
</html>
