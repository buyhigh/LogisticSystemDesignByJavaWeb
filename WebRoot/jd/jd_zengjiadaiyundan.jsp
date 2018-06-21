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
	<form id="form1" name="myForm" action="AddSubTransport" method="post">
                		<div class="wl_content_nav">增加代运通知单</div>

		<table class="wl_table" cellspacing="0">
                        	<tr class="wl_rowback">
                            	<td colspan="3">订单信息</td>
                            </tr>
                        	<tr>
                            	<td width="106">订单ID</td>
                                <td width="226">
                                	<input type="text" name="orderId" class="wl_inputStyle" value="${requestScope.dispatchDto.orderId }" id="orderIdId"/>
                                </td>
                                <td width="360">
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>货物名称</td>
                                <td>
                                	<input type="text" name="goodName" class="wl_inputStyle" value="${requestScope.dispatchDto.goodName }" id="goodNameId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>货物数量</td>
                                <td>
                                	<input type="text" name="goodQuantity" class="wl_inputStyle" onblur="checkout()" value="${requestScope.dispatchDto.goodQuantity }" id="goodQuantityId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr> 
                            <tr>
                            	<td>货品保存最终时间</td>
                                <td>
                                	<input type="datetime-local" name="sendtime" class="wl_inputStyle"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr> 
                            <tr>
                            	<td>运力工具选择</td>
                                <td colspan="2">
                                	<select name="transferModel" id="selModel">
                                		<option></option>
                                		<c:forEach items="${requestScope.listTransferModel }" var="transferModel" varStatus="s">
                                			<option value="${transferModel.trmoId }">${transferModel.trmoName }</option>
                                		</c:forEach>
                                	</select>
                                	<select name="transferTool" id="selTool">
                                		<option></option>
                                		<c:forEach items="${requestScope.listTransferToolDto }" var="transferToolDto">
                                			<option value="${transferToolDto.transferId }">${transferToolDto.transferName }</option>
                                		</c:forEach>
                                    </select>
                                </td>
                            </tr> 
                            <tr class="wl_rowback">
                            	<td colspan="3">发人信息</td>
                            </tr> 
                            <tr>
                            	<td>发货人姓名</td>
                                <td>
                                	<input type="text" name="sendName" class="wl_inputStyle" value="${requestScope.dispatchDto.sendName }" id="sendNameId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>发货人电话</td>
                                <td>
                                	<input type="text" name="sendTel" class="wl_inputStyle" value="${requestScope.dispatchDto.sendTel }" id="sendTelId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>收货人姓名</td>
                                <td>
                                	<input type="text" name="receiverName" class="wl_inputStyle" value="${requestScope.dispatchDto.receiverName }" id="receiverNameId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>发货人电话</td>
                                <td>
                                	<input type="text" name="receiverTel" class="wl_inputStyle" value="${requestScope.dispatchDto.receiverTel }" id="receiverTelId"/>
                                </td>
                                <td>
                                	<span class="wl_spnTip">*</span>
                                </td>
                            </tr>
                            <tr>
                            	<td>发货地址</td>
                                <td colspan="2">
                                	省份
                                    <select name="selProvince" onchange="cityName(this.selectedIndex)">
                                    	<option value="">请选择省名</option>
                                    </select>
                                    城市
                                    <select name="selCity">
                                    	<option value="">请选择城名</option>
                                    </select>
                                    街道：
                                    <input type="text" name="receiverStreet" class="wl_inputStyle wl_borderStyle" id="receiverStreetId"/>
                                    <span class="wl_spnTip">*</span>
                                </td>
                            </tr> 
                            <tr>
                            	<td>需要运费额</td>
                                <td>
                                	<span id="tramoney" style="display:none;color:black" class="label">需要多少运送费</span>
                                </td>
                            </tr>
                            <tr>
                            	<td colspan="3">
                                	<input type="submit" value="增加" id="btnAddDispatch" onclick="return check()"/>
                                    <input type="reset" value="重置"/>
                                </td>
                                <span id="tramoney" style="display:none;margin-left:300px" class="label label-important">需要多少运送费</span>
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
	
		
		$("selModel").onchange = function(){
			var transferModel = $("selModel").options[$("selModel").selectedIndex].value;	
			var xhr = createXHR();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					var resultList = xhr.responseText.split(";");
					$("selTool").length = 0;
					$("selTool").add(new Option("",""),undefined);
					for(var i = 0 ; i < resultList.length ; i++){
						var item = resultList[i].split(":");
						var toolId = item[0];
						var toolName = item[1];
						var option = new Option(toolName,toolId);
						$("selTool").add(option,undefined);
					}
				}
			};
			xhr.open("get","gettools?transferModelStr=" + transferModel,true);
			xhr.send(null);
		};
		
		
		
		
		$("goodNameId").onblur = function(){
			var xhr = createXHR();
			var uri = "existsgoods?" + encodeURIComponent("goodsName") + "=" + encodeURIComponent($("goodNameId").value) + "&fresh=" + new Date().getTime();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						var f = xhr.responseText;
						if(f == "0"){
							//表示不存在此商品
							$("btnAddDispatch").disabled = true;
							$("errorTip").innerHTML = "必须要是已存在的商品";
							$("goodNameId").focus();
							$("goodNameId").select();
						}else if(f == "1"){
							//表示存在此商品
							$("btnAddDispatch").disabled = false;
							$("errorTip").innerHTML = "*";
						}
					}
				}
			};
			xhr.open("get",uri,true);
			xhr.send();
		};
		
		function checkOrderId(){
			var val = $("orderIdId").value;
			var reg = /^\d{11}$/;
			if(reg.test(val)){
				return true;
			}
			alert("订单ID必须为11位数字");
			$("orderIdId").select();
			return false;
			
		}
		
		function checkGoodName(){
			var val = $("goodNameId").value;
			var reg = /^\S+$/;
			if(reg.test(val)){
				return true;
			}
			$("goodNameId").select();
			alert("商品名称不能为空");
			return false;
		}
		
		function checkQuantity(){
			var val = $("goodQuantityId").value;
			var reg = /^\d+$/;
			if(reg.test(val)){
				return true;
			}
			alert("货物数量必须为数字");
			$("goodQuantityId").select();
			return false;
		}
		
		function checkSendName(){
			var val = $("sendNameId").value;
			var reg = /^\S+$/;
			if(reg.test(val)){
				return true;
			}
			$("sendNameId").focus();
			alert("发货人改名不能为空");
			return false;
		}
		
		function checkSendTel(){
			var val = $("sendTelId").value;
			var reg = /^\d{11}$/;
			if(reg.test(val)){
				return true;
			}
			$("sendTelId").select();
			alert("手机号应为11位");
			return false;
		}
		
		function checkReceName(){
			var val = $("receiverNameId").value;
			var reg = /^\S+$/;
			if(reg.test(val)){
				return true;
			}
			$("receiverNameId").focus();
			alert("收货人姓名不能为空");
			return false;
		}
		
		function checkReceTel(){
			var val = $("receiverTelId").value;
			var reg = /^\d{11}$/;
			if(reg.test(val)){
				return true;
			}
			$("receiverTelId").select();
			alert("手机号应为11位");
			return false;
		}
		
		function checkStreet(){
			var val = $("receiverStreetId").value;
			var reg = /^\S+$/;
			if(reg.test(val)){
				return true;
			}
			$("receiverStreetId").focus();
			alert("街道地址不能为空");
			return false;
			
		}
		
		function check(){
			if(checkOrderId() && checkGoodName() && checkQuantity() && checkSendName() && checkSendTel() && checkReceName() && checkReceTel() && checkStreet()){
				return true;
			}
			return false;
		}
		
		function checkout() {
	        var quantity = document.getElementById("goodQuantity");
	        alert(quantity)
	        if (quantity.value > 0) {
	            document.getElementById("tramoney").style.display = "";
	        } else {
	            document.getElementById("tramoney").style.display = "none";
	        }
	    }
    </script>
</body>
</html>
