<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<title>物流配送管理系统---查询库存</title>
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
	body{font-size:12px;margin:0px;padding:0px;background:#ccc;background:url(images/bk.png) ;}
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
	.wl_page{width:700px;margin:5px auto;text-align:center;}
	.wl_page span{font-weight:bold;}
	.wl_selStyle{width:120px;}
	.wl_table_query{width:700px;margin:20px auto 0px;}
	.wl_table_query .first{background-color:#eceff1;}
	.wl_table_query td{padding:6px 0px;}
	.wl_content_nav{font-size:14px;font-family:'Microsoft Yahei',PMingLiU,Verdana;padding:13px 0px 0px 20px;}
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
				<!-- //header-ends -->

				<!--content-->

				<!--content-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1"> <a href="querystore"
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
	
	
	<form class="form-horizontal" role="form" name="myForm" action="AddConsumer" method="post" id="form1" style="margin-left: 300px;margin-right: 450px;color:black">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">客户名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" 
				   placeholder="请输入名字" name="regconsumerId" style="color:black" autocomplete="off" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">账号密码</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" name="regconsumerpwd"
				   placeholder="请输入密码" autocomplete="off" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">真实名字</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" 
				   placeholder="请输入真实名字" name="regrealname" style="color:black" autocomplete="off" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">电话</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" 
				   placeholder="请输入电话" name="regtelphone" style="color:black" autocomplete="off" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">常用住址</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" 
				   placeholder="请输入住址" name="regaddress" style="color:black" autocomplete="off" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">客户注册</button>
		</div>
	</div>
</form>
	
	
	
	
	
	
	
	
	<%-- 
<form id="form1" class="form-horizontal" name="myForm" action="addmarketer" method="post">
                		<div class="form-group">

		<table class="wl_table" cellspacing="0">
                        	<tr class="wl_rowback">
                            	<td colspan="3">添加接单员</td>
                            </tr>
                        	<tr>
                            	<td width="106">注册名称</td>
                                <td width="226">
                                	<input type="text" name="regmarketerId" class="wl_inputStyle" value="接单员名称" />
                                </td>
                                <td width="360">
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>注册密码</td>
                                <td>
                                	<input type="password" name="regmarketerpwd" class="wl_inputStyle" value="接单员密码"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td colspan="3">
                                	<input type="submit" value="增加" id="btnAddDispatch" onclick="return check()"/>
                                    <input type="reset" value="重置"/>
                                </td>
                            </tr> 
                        </table>
		</form>--%>


<div class="wl_foot" style="color:black;margin-top: 400px;font-size: 18px;margin-bottom: 50px">- 冷链物流仓储管理系统   -</div>


    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script>
    <script type="text/javascript">
</body>
</html>
