<%@ page language="java" import="java.util.*" pageEncoding="gbk"
	contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jd/";
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
	<form id="form1" name="myForm" action="querystore" method="post">
		<input type="hidden" name="curStore"
			value="${requestScope.store.storeId }" /> <input type="hidden"
			name="curGoods" value="${requestScope.goodDto.goodId }" />
		<div class="wl_content_nav">查询库存</div>
		<table class="wl_table_query" cellspacing="0">
			<tr class="first">
				<th width="50">仓库</th>
				<td width="120"><select name="selLibrary" class="wl_selStyle"
					id="selStore">
						<option value=""></option>
						<c:forEach items="${requestScope.listStore }" var="store"
							varStatus="s">
							<option value="${store.storeId }">${store.storeName }</option>
						</c:forEach>
				</select></td>
				<th width="50">商品</th>
				<td width="120"><select name="selGooks" class="wl_selStyle"
					id="selGood">
						<option value=""></option>
						<c:forEach items="${requestScope.listGoodsDto2 }" var="goodsDto"
							varStatus="s">
							<option value="${goodsDto.goodId }">${goodsDto.goodName }</option>
						</c:forEach>
				</select></td>
				<td width="200"><input type="submit" value="查询" /></td>
			</tr>
		</table>
		<table class="table table-striped"
			style="margin-left: 400px; margin-right: 200px; width: 800px">
			<caption>条纹表格布局</caption>
			<thead>
				<tr>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>所属仓库</th>
					<th>入库时间</th>
					<th>存储数量</th>
					<th>计件单位</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listGoodsDto }" var="goodsDto"
					varStatus="s">
					<tr>
						<td>${goodsDto.goodId }</td>
						<td>${goodsDto.goodName }</td>
						<td>${goodsDto.storeId }</td>
						<td>${goodsDto.inDate }</td>
						<td>${goodsDto.num }</td>
						<td>${goodsDto.goodUnit }</td>
					</tr>
				</c:forEach>
				<c:if test="${requestScope.goodDto != null }">
					<tr>
						<td>${requestScope.goodDto.goodId }</td>
						<td>${requestScope.goodDto.goodName }</td>
						<td>${requestScope.goodDto.storeId }</td>
						<td>${requestScope.goodDto.inDate }</td>
						<td>${requestScope.goodDto.num }</td>
						<td>${requestScope.goodDto.goodUnit }</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<c:if test="${requestScope.goodDto == null}">
			<div class="wl_page">
				<c:if test="${requestScope.maxPageNum == 1 }">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPageNum }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 [<a
						disabled="disabled">首页</a>][<a disabled="disabled">上一页</a>][<a
						disabled="disabled">下一页</a>][<a disabled="disabled">末页</a>]
                        	</c:if>
				<c:if
					test="${requestScope.maxPageNum > 1 && requestScope.curPage == 1}">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPageNum }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 [<a
						disabled="disabled">首页</a>][<a disabled="disabled">上一页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage + 1 }">下一页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.maxPageNum}">末页</a>]
                        	</c:if>
				<c:if
					test="${requestScope.maxPageNum > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPageNum }">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPageNum }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 [<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=1">首页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage - 1}">上一页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage + 1 }">下一页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.maxPageNum}">末页</a>]
                        	</c:if>
				<c:if
					test="${requestScope.maxPageNum > 1 && requestScope.curPage == requestScope.maxPageNum }">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPageNum }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 [<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=1">首页</a>][<a
						href="querystore?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage - 1}">上一页</a>][<a
						disabled="disabled">下一页</a>][<a disabled="disabled">末页</a>]
                        	</c:if>
			</div>
		</c:if>
	</form>
	<div class="wl_foot" style="color:black;margin-top: 50px;font-size: 18px;margin-bottom: 50px;">- 冷链物流仓储管理系统   -</div>
		<script src="../js/Util.js"></script>
		<script src="../js/showServerTime.js"></script>
		<script type="text/javascript">
			$("selStore").onchange = function() {
				var storeId = $("selStore").options[$("selStore").selectedIndex].value;
				var xhr = createXHR();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						var jsonList = xhr.responseText.split(";");
						$("selGood").length = 0;
						$("selGood").add(new Option("", ""), undefined);
						for (var i = 0; i < jsonList.length; i++) {
							var json = jsonList[i];
							var items = json.split(":");
							var id = items[0];
							var name = items[1];
							var option = new Option(name, id);
							$("selGood").add(option, undefined);
						}

					}
				};
				xhr.open("get", "getgoods?" + encodeURI("storeId=")
						+ encodeURI(storeId), true);
				xhr.send(null);
			};

			var myForm = document.myForm;
			window.onload = function() {
				var curStoreId = myForm.curStore.value;
				var curGoodsId = myForm.curGoods.value;
				var storeOptions = $("selStore").options;
				var goodsOptions = $("selGood").options;
				for (var i = 0; i < storeOptions.length; i++) {
					if (curStoreId == storeOptions[i].value) {
						storeOptions[i].selected = true;
						break;
					}
				}
				for (var i = 0; i < goodsOptions.length; i++) {
					if (curGoodsId == goodsOptions[i].value) {
						goodsOptions[i].selected = true;
						break;
					}
				}
			};
		</script>

		<%-- 网页模板的js模块代码 --%>
		<script>
			var toggle = true;

			$(".sidebar-icon").click(
					function() {
						if (toggle) {
							$(".page-container").addClass("sidebar-collapsed")
									.removeClass("sidebar-collapsed-back");
							$("#menu span").css({
								"position" : "absolute"
							});
						} else {
							$(".page-container").removeClass(
									"sidebar-collapsed").addClass(
									"sidebar-collapsed-back");
							setTimeout(function() {
								$("#menu span").css({
									"position" : "relative"
								});
							}, 400);
						}

						toggle = !toggle;
					});
		</script>
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
		<!-- /Bootstrap Core JavaScript -->
		<!-- real-time -->
		<script language="javascript" type="text/javascript"
			src="js/jquery.flot.js"></script>
		<!-- /real-time -->
		<script src="js/jquery.fn.gantt.js"></script>
		<script>
			$(function() {

				"use strict";

				$(".gantt").gantt(
						{
							source : [ {
								name : "Sprint 0",
								desc : "Analysis",
								values : [ {
									from : "/Date(1320192000000)/",
									to : "/Date(1322401600000)/",
									label : "Requirement Gathering",
									customClass : "ganttRed"
								} ]
							}, {
								name : " ",
								desc : "Scoping",
								values : [ {
									from : "/Date(1322611200000)/",
									to : "/Date(1323302400000)/",
									label : "Scoping",
									customClass : "ganttRed"
								} ]
							}, {
								name : "Sprint 1",
								desc : "Development",
								values : [ {
									from : "/Date(1323802400000)/",
									to : "/Date(1325685200000)/",
									label : "Development",
									customClass : "ganttGreen"
								} ]
							}, {
								name : " ",
								desc : "Showcasing",
								values : [ {
									from : "/Date(1325685200000)/",
									to : "/Date(1325695200000)/",
									label : "Showcasing",
									customClass : "ganttBlue"
								} ]
							}, {
								name : "Sprint 2",
								desc : "Development",
								values : [ {
									from : "/Date(1326785200000)/",
									to : "/Date(1325785200000)/",
									label : "Development",
									customClass : "ganttGreen"
								} ]
							}, {
								name : " ",
								desc : "Showcasing",
								values : [ {
									from : "/Date(1328785200000)/",
									to : "/Date(1328905200000)/",
									label : "Showcasing",
									customClass : "ganttBlue"
								} ]
							}, {
								name : "Release Stage",
								desc : "Training",
								values : [ {
									from : "/Date(1330011200000)/",
									to : "/Date(1336611200000)/",
									label : "Training",
									customClass : "ganttOrange"
								} ]
							}, {
								name : " ",
								desc : "Deployment",
								values : [ {
									from : "/Date(1336611200000)/",
									to : "/Date(1338711200000)/",
									label : "Deployment",
									customClass : "ganttOrange"
								} ]
							}, {
								name : " ",
								desc : "Warranty Period",
								values : [ {
									from : "/Date(1336611200000)/",
									to : "/Date(1349711200000)/",
									label : "Warranty Period",
									customClass : "ganttOrange"
								} ]
							} ],
							navigate : "scroll",
							scale : "weeks",
							maxScale : "months",
							minScale : "days",
							itemsPerPage : 10,
							onItemClick : function(data) {
								alert("Item clicked - show some details");
							},
							onAddClick : function(dt, rowId) {
								alert("Empty space clicked - add an item!");
							},
							onRender : function() {
								if (window.console
										&& typeof console.log === "function") {
									console.log("chart rendered");
								}
							}
						});

				$(".gantt").popover({
					selector : ".bar",
					title : "I'm a popover",
					content : "And I'm the content of said popover.",
					trigger : "hover"
				});

				prettyPrint();

			});
		</script>
		<script src="js/menu_jquery.js"></script>
</body>
</html>
