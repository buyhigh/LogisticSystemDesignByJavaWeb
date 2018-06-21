<%@ page language="java" import="java.util.*" pageEncoding="gbk"
	contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/tra/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>物流配送管理系统---运输指派</title>
		
		
		
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

.wl_table th,.wl_table td {
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

.wl_detail {
	color: blue;
	cursor: pointer;
}

.wl_detail_table {
	width: 500px;
	border-collapse: collapse;
	border: 1px solid #ccc;
	margin: 20px auto 0px;
}

.wl_detail_table td {
	border: 1px solid #ccc;
	padding: 3px;
}

.wl_detail_tdone {
	width: 70px;
	font-weight: bold;
}
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
	<form id="form1" name="myForm" action="queryyl" method="post">
						<div class="wl_content_nav">
							运输指派
						</div>
		<table class="table table-striped"
			style="margin-left: 400px; margin-right: 200px; width: 800px">
			<caption>条纹表格布局</caption>
			<thead>
				<tr>
								<th>
									配送员编号
								</th>
								<th width="120">
									配送员姓名
								</th>
								<th>
									配送商品名称
								</th>
								<th>
									配送商品数量
								</th>
								<th>
									操作
								</th>
							</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listTraDto }" var="traDto">
								<tr>
									<td>
										${traDto.dispUserId }
									</td>
									<td>
										${traDto.dispUserName }
									</td>
									<td>
										${traDto.goodName }
									</td>
									<td>
										${traDto.goodQuantity }
									</td>
									<td>
										<span class="wl_detail" onclick="showDetail(${traDto.traId})">查看详情...</span>
									</td>
								</tr>
							</c:forEach>
			</tbody>
			<div id="showDetail">
							<table class="wl_detail_table" id="dataDetail">
								<tr>
									<td class="wl_detail_tdone">
										配送员编号
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										配送员姓名
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										商品名称
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										商品数量
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										收货人
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										所在省
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										所在市
									</td>
									<td></td>
								</tr>
								<tr>
									<td class="wl_detail_tdone">
										街道
									</td>
									<td></td>
								</tr>
							</table>
						</div>
		</table>
	</form>
	<div class="wl_foot"
		style="color: black; margin-top: 50px; font-size: 18px; margin-bottom: 50px">-
		冷链物流仓储管理系统 -</div>
	
	
	
	

		<script src="../js/Util.js"></script>
    	<script src="../js/showServerTime.js"></script>
		<script type="text/javascript">
    		
    	
    	
    	
    	function showDetail(id){
    		
    		//创建异步请求对象
    		var xhr = createXHR();
    		//设置请求参数
    		var uri = "gettra?" + encodeURIComponent("traId") + "=" + encodeURIComponent(id);
    		xhr.onreadystatechange = function(){
    			if(xhr.readyState == 4){
    				if(xhr.status == 200){
    					var result = xhr.responseText;
    					var resultArray = result.split(":");
    					//获取用来显示数据的容器，这里是表格
    					var resultConta = $("dataDetail");
    					//循环遍历表格中的每行，将数据显示在每行的第二个单元格中
    					for(var i = 0 ; i < resultConta.rows.length ; i++){
    						//每次填充内容前都需要清空原有的内容
    						var conCell = resultConta.rows[i].cells[1];
    						clear(conCell);
    						conCell.appendChild(document.createTextNode(resultArray[i]));
    					}
    					//显示表格
    					$("dataDetail").style.display = "block";
    				}
    			}
    		};
    		xhr.open("get",uri,true);
    		xhr.send(null);
    	}
    	
    	window.onload = function(){
    		$("dataDetail").style.display = "none";
    	};
    	
    	function clear(pra){
    		while(pra.childNodes.length != 0){
    			pra.removeChild(pra.childNodes[0]);
    		}
    	}
    	
    </script>
	</body>
</html>
