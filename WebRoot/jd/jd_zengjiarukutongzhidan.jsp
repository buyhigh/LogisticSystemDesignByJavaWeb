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
<title>物流配送管理系统---增加配送通知单</title>
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
	.wl_table th,.wl_table td{border:1px solid #ccc;padding:3px;}
	.wl_page span{font-weight:bold;}
	.wl_content_nav{font-size:14px;font-family:'Microsoft Yahei',PMingLiU,Verdana;padding:13px 0px 0px 20px;}
	.wl_inputStyle{width:220px;}
	.wl_spnTip{color:#ff0000;}
	.wl_rowback{background:#eceff1;font-size:14px;font-weight:bold;}
	.wl_borderStyle{border:none;border-bottom:1px solid #09F;}
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
	<form id="form1" name="myForm" action="AddInStore" method="post" style="margin-left: 330px">
		<div class="wl_content_nav">退换货</div>
		<div class="wl_hywwt">货有无问题</div>
		<table class="wl_table" cellspacing="0">
			<tr>
				<td><input type="radio" name="rdque" value="0" id="noexist" />
					<label for="noexist"> 有 </label> <input type="radio" name="rdque"
					value="1" id="yesexist" checked="checked" /> <label for="yesexist">
						无 </label></td>
			</tr>
		</table>
		<table class="wl_table" cellspacing="0" id="">
			<tr>
				<td width="60">商品名称</td>
				<td><input type="text" name="goodName" class="wl_inputstyle"
					id="searchGoodName" /> <span class="wl_tip" id="tipStr">*</span></td>
			</tr>
			<tr>
				<td>商品数量</td>
				<td><input type="text" name="goodQuantity"
					class="wl_inputstyle" /> <span class="wl_tip">*</span></td>
			</tr>
			<tr>
				<td>商品重量</td>
				<td><input type="text" name="goodWeight" class="wl_inputStyle"
					id="goodWeightId" /> 斤</td>
			</tr>
			<tr>
				<td>商品体积</td>
				<td><input type="text" name="goodBulk" class="wl_inputStyle"
					id="goodBulkId" /> 立方厘米</td>
			</tr>
			<tr>
				<td>计件单位</td>
				<td><input type="text" name="goodUnit" class="wl_inputStyle"
					id="goodUnitId" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="goodPrice" class="wl_inputStyle"
					id="goodPriceId" /></td>
			</tr>
			<tr>
				<td>仓库</td>
				<td><select name="selStore" id="selStoreOptions">
						<option value=""></option>
						<c:forEach items="${requestScope.listStore }" var="store">
							<option value="${store.storeId }">${store.storeName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="确定"
					class="wl_buttonstyle" id="mitId" /></td>
			</tr>
		</table>

	</form>
		<div class="wl_foot"
		style="color: black; margin-top: 50px; font-size: 18px; margin-bottom: 50px">-
		冷链物流仓储管理系统 -</div>
		
		
		
    </div>
    <script src="../js/ckcity.js"></script>
    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script>
    <script type="text/javascript">
	
    $("searchGoodName").onblur = handler1;
	function handler1() {
		var xhr = createXHR();
		var rdques = $N("rdque");
		var uri = "existsgoods?" + encodeURIComponent("goodsName") + "="
				+ encodeURIComponent($("searchGoodName").value);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var result = xhr.responseText;
					if (rdques[0].checked) {
						//有问题
						if (result == "0") {
							$("tipStr").innerHTML = "必须要已存在的商品！"
							$("searchGoodName").focus();
							$("searchGoodName").select();
							$("mitId").disabled = true;
						} else {
							$("tipStr").innerHTML = "*";
							$("mitId").disabled = false;
						}
					} else if (rdques[1].checked) {
						//没有问题
						//如果添加的是已存在的产品，则只需输入入库数量即可
						if (result == "1") {
							$("goodWeightId").disabled = true;
							$("goodBulkId").disabled = true;
							$("goodUnitId").disabled = true;
							$("goodPriceId").disabled = true;
						} else {
							$("goodWeightId").disabled = false;
							$("goodBulkId").disabled = false;
							$("goodUnitId").disabled = false;
							$("goodPriceId").disabled = false;
						}
					}
				}

			}
		};
		xhr.open("get", uri, true);
		xhr.send(null);
	}

	//货有问题
	$("noexist").onclick = function() {
		var storeOptions = $("selStoreOptions").options;
		for (var i = 0; i < storeOptions.length; i++) {
			if (storeOptions[i].text == "退货仓库") {
				storeOptions[i].selected = true;
				break;
			}
		}
		$("selStoreOptions").disabled = true;
		$("goodWeightId").disabled = true;
		$("goodBulkId").disabled = true;
		$("goodUnitId").disabled = true;
		$("goodPriceId").disabled = true;
	};
	//货没有问题
	$("yesexist").onclick = function() {
		$("selStoreOptions").options[0].selected = true;
		$("selStoreOptions").disabled = false;
		$("goodWeightId").disabled = false;
		$("goodBulkId").disabled = false;
		$("goodUnitId").disabled = false;
		$("goodPriceId").disabled = false;
		$("tipStr").innerHTML = "*";
		$("mitId").disabled = false;
	};
		
    </script>
</body>
</html>
