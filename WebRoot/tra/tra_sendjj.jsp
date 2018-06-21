<%@ page language="java" import="java.util.*" pageEncoding="gbk"
	contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/tra/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>物流配送管理系统---派车交接</title>

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
	<link href="../bootstrap_template/css/font-awesome.css"
		rel="stylesheet">
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
body {
	font-size: 15px;
	margin: 0px;
	padding: 0px;
	background: #ccc;
	background-image: url(../images/bk.png);
}

a {
	text-decoration: none;
	color: #000;
}

.wl_container {
	width: 1002px;
	margin: 0px auto;
	background: #fff;
}

.wl_head {
	height: 122px;
	background: url(../images/wl_head_01.jpg) no-repeat;
}

.wl_separater {
	background: url(../images/wl_vline_04.jpg) repeat-x;
	margin-top: 1px;
	color: #fff;
	text-align: center;
	line-height: 2.3em;
	font-weight: bold;
}

.wl_main {
	height: 645px;
	background: #01a333;
	float: left;
}

.wl_left {
	float: left;
	width: 209px;
	margin-left: 1px;
	margin-right: 2px;
	display: inline;
}

.wl_item {
	display: block;
	width: 169px;
	height: 24px !important;
	height: 23px;
	background: url(../images/wl_item_04.jpg) no-repeat;
	padding: 9px 0px 0px 40px !important;
	padding: 10px 0px 0px 40px;
	margin-bottom: 2px;
	font-size: 14px;
	font-weight: bold;
}

.wl_right {
	width: 790px;
	height: 645px;
	float: left;
	background: #fff;
}

.wl_foot {
	clear: both;
	background: pink;
	text-align: center;
	color: #fff;
	font-weight: bold;
	line-height: 2em;
}

.wl_table {
	width: 700px;
	border-collapse: collapse;
	border: 1px solid #ccc;
	margin: 30px auto 0px;
}

.wl_table th, .wl_table td {
	border: 1px solid #ccc;
	text-align: center;
	padding: 3px;
}

.wl_page {
	width: 700px;
	margin: 5px auto;
	text-align: center;
}

.wl_page span {
	font-weight: bold;
}

.wl_selStyle {
	width: 120px;
}

.wl_table_query {
	width: 700px;
	margin: 20px auto 0px;
}

.wl_table_query .first {
	background-color: #eceff1;
}

.wl_table_query td {
	padding: 6px 0px;
}

.wl_content_nav {
	font-size: 14px;
	font-family: 'Microsoft Yahei', PMingLiU, Verdana;
	padding: 13px 0px 0px 20px;
}

.wl_table td.lastTd {
	text-align: left;
}

#ServerTimeArea {
	margin-top: 30px;
	font-size: 14px;
	color: #fff;
	font-weight: bold;
}
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
					<li id="menu-academico"><a href="queryyl2"><i
							class="fa fa-file-text-o"></i> <span>查询运力</span></a></li>
					<li id="menu-academico"><a href="querysendtratask"><i
							class="fa fa-file-text-o"></i> <span>查询派车任务单</span></a></li>
					<li id="menu-academico"><a href="CarManager"><i
							class="fa fa-file-text-o"></i> <span>车辆管理</span></a></li>
					<li id="menu-academico"><a href="estts"><i
							class="fa fa-file-text-o"></i> <span>审核派车任务单</span></a></li>
					<li id="menu-academico"><a href="sendzp"><i
							class="fa fa-file-text-o"></i> <span>派车指派运输</span></a></li>
					<li id="menu-academico"><a href="sendjj"><i
							class="fa fa-file-text-o"></i> <span>派车交接工作配送员</span></a></li>
					<li id="menu-academico"><a href="querytratask"><i
							class="fa fa-file-text-o"></i> <span>查询配送员任务单</span></a></li>
					<li id="menu-academico"><a href="examinetft"><i
							class="fa fa-file-text-o"></i> <span>审核配送员任务单</span></a></li>
					<li id="menu-academico"><a href="trapz"><i
							class="fa fa-file-text-o"></i> <span>配送员指派</span></a></li>
					<li id="menu-academico"><a href="trajj"><i
							class="fa fa-file-text-o"></i> <span>确认配送完成</span></a></li>
					<li id="menu-academico"><a href="exit"><i
							class="fa fa-file-text-o"></i> <span>退出系统</span></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<form id="form1" name="myForm" action="sendjj" method="post">
		<input type="hidden" name="curDriverId"
			value="${requestScope.curDriverId }" id="hdnDriverId" /> <input
			type="hidden" name="flag" value="" id="f" />
		<div class="wl_content_nav">派车交接</div>
		<table class="wl_table_query" cellspacing="0">
			<tr class="first">
				<th width="70">司机编号</th>
				<td width="120"><input type="text" name="txtDriverId"
					id="stateDriver" /></td>
				<td width="500"><input type="button" value="查询" id="btnQuery" />
				</td>
			</tr>
		</table>
		<table class="table table-striped"
			style="margin-left: 400px; margin-right: 200px; width: 800px">
			<caption>条纹表格布局</caption>
			<thead>
				<tr>
					<th width="30">批量选择</th>
					<th>司机编号</th>
					<th>司机</th>
					<th>车辆</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listSendCarDto }" var="sendCarDto">
					<tr>
						<td><input type="checkbox" name="chkItem"
							value="${sendCarDto.driverId }"
							${sendCarDto.state == 6 ? 'disabled' : '' } /></td>
						<td>${sendCarDto.driverId }</td>
						<td>${sendCarDto.driverName }</td>
						<td>${sendCarDto.transferName }</td>
						<td>${sendCarDto.stateStr }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7" class="lastTd"><input type="button"
						value="全部选择" id="btnSelAll" /> <input type="button" value="全不选择"
						id="btnSelNot" /> <input type="button" value="提交" id="btnSubmit" />
					</td>
				</tr>
			</tbody>
		</table>
		<div class="wl_page">
			<c:if test="${requestScope.maxPage == 1 }">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled="disabled">首页</a>]
                        	[<a disabled="disabled">上一页</a>]
                        	[<a disabled="disabled">下一页</a>]
                        	[<a disabled="disabled">末页</a>]
                        	</c:if>
			<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == 1}">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled="disabled">首页</a>]
                        	[<a disabled="disabled">上一页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="sendjj?pageNum=1">首页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="sendjj?pageNum=1">首页</a>]
                        	[<a
					href="sendjj?pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a disabled="disabled">下一页</a>]
                        	[<a disabled="disabled">末页</a>]
                        	</c:if>
		</div>
	</form>
	<div class="wl_foot"
		style="color: black; margin-top: 50px; font-size: 18px; margin-bottom: 50px">-
		冷链物流仓储管理系统 -</div>



	<script src="../js/Util.js"></script>
	<script src="../js/showServerTime.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			var hdnValue = $("hdnDriverId").value;
			$("stateDriver").value = hdnValue;
		};

		$("btnQuery").onclick = function() {
			//表示查询操作
			$("f").value = "1";
			document.myForm.submit();
		};
		$("btnSubmit").onclick = function() {
			//表示提交操作
			$("f").value = "2";
			document.myForm.submit();
		};

		var chkItems = $N("chkItem");
		$("btnSelAll").onclick = function() {
			for (var i = 0; i < chkItems.length; i++) {
				if (chkItems[i].type == "checkbox") {
					chkItems[i].checked = true;
				}
			}
		};
		$("btnSelNot").onclick = function() {
			for (var i = 0; i < chkItems.length; i++) {
				if (chkItems[i].type == "checkbox") {
					chkItems[i].checked = false;
				}
			}
		};
	</script>
</body>
</html>
