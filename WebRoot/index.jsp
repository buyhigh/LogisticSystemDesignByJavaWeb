<%@ page language="java" contentType="text/html;charset=gbk" pageEncoding="gbk" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统入口</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords"
		content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script type="bootstrap_template/application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- Bootstrap Core CSS -->
	<link href="bootstrap_template/css/bootstrap.min.css"
		rel='stylesheet' type='text/css' />
	<!-- Custom CSS -->
	<link href="bootstrap_template/css/style.css" rel='stylesheet'
		type='text/css' />
	<!-- Graph CSS -->
	<link href="bootstrap_template/css/font-awesome.css"
		rel="stylesheet">
		<!-- jQuery -->
		<!-- lined-icons -->
		<link rel="stylesheet" href="bootstrap_template/css/icon-font.min.css"
			type='text/css' />
		<script src="bootstrap_template/js/amcharts.js"></script>
		<script src="bootstrap_template/js/serial.js"></script>
		<script src="bootstrap_template/js/light.js"></script>
		<!-- //lined-icons -->
		<script src="bootstrap_template/js/jquery-1.10.2.min.js"></script>
		<!--pie-chart--->
		<script src="bootstrap_template/js/pie-chart.js"
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
	body{margin:0px;padding:0px;background-image: url(images/bk.png); background-repeat:repeat;}
	<%--a:link,a:visited{color:#dd1515;font-size:24px;text-align:center;text-decoration:none;width:302px;line-height:2.2em;background:url(images/sys_08.jpg) no-repeat;float:left;}
	a:hover{background:url(images/syshover_08.jpg) no-repeat;color:#fff;}--%>
	.wl_container{width:1002px;margin:0px auto;}
	.wl_foot {
	clear: both;
	background: pink;
	text-align: center;
	color: #fff;
	font-weight: bold;
	line-height: 2em;
}
	.wl_main{width:692px;margin:24px auto;}
	.sysmb{margin-bottom:47px;}
	.sysleft{margin-left:86px;}
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
									<li><a href="switch?msg=1">接单系统</a></li>|
									<li><a href="switch?msg=3">仓管系统</a></li>|
									<li><a href="switch?msg=4">运输系统</a></li>|
									<li><a href="switch?msg=5">客户管理系统</a></li>|
									<li><a href="switch?msg=6">管理员后台</a></li>
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
					<li id="menu-academico"><a href="exit"><i
							class="fa fa-file-text-o"></i> <span>退出系统</span></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>


<div class="col-md-6 skil" style="margin-left: 500px">
									<div class="content-top-1">
									<div class="col-md-9 top-content" style="margin-left: 50px;color:black;">
										<h5 style="color:black;">请选择你要进入的系统</h5>
									</div>



<a href="switch?msg=1"><button type="button" class="btn btn-primary btn-lg btn-block">接单系统</button></a>
<a href="switch?msg=3"><button type="button" class="btn btn-default btn-lg btn-block">库存系统</button>
<a href="switch?msg=4"><button type="button" class="btn btn-primary btn-lg btn-block">运输点系统</button>
<a href="switch?msg=5"><button type="button" class="btn btn-default btn-lg btn-block">客户信息中心</button>
<a href="switch?msg=6"><button type="button" class="btn btn-primary btn-lg btn-block">管理员后台</button>
<div style="font-size:14px;color:red;margin-left: 100px">${requestScope.privilegeMsg }</div>
</div>
</div>
									
<div class="wl_foot" style="color:black;margin-top: 400px;font-size: 18px;margin-bottom: 50px">- 冷链物流仓储管理系统   -</div>

</body>
</html>
