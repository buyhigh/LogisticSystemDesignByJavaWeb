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
<title>�������͹���ϵͳ---��������֪ͨ��</title>
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
			<!-- ���Ա��� -->
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!-- top_bg -->
					<div class="top_bg">

						<div class="header_top">
							<div class="top_right">
								<ul>
									<li><a href="../switch?msg=1">�ӵ�ϵͳ</a></li>|
									<li><a href="../switch?msg=3">�ֹ�ϵͳ</a></li>|
									<li><a href="../switch?msg=4">����ϵͳ</a></li>|
									<li><a href="../switch?msg=5">�ͻ�����ϵͳ</a></li>|
									<li><a href="../switch?msg=6">����Ա��̨</a></li>
								</ul>
							</div>
							<div class="top_left">
								<h2>
									<span></span> ��ӭ����${sessionScope.loginUser.userName }
								</h2>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
					<div class="clearfix"></div>
					<!-- /top_bg -->
				</div>
				<div class="header_bg">
					<!-- ���Ա���-->

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
							class="fa fa-file-text-o"></i> <span>��ѯ���</span></a></li>
					<li id="menu-academico"><a href="querydispatch"><i
							class="fa fa-file-text-o"></i> <span>��ѯ����֪ͨ��</span></a></li>
					<li id="menu-academico"><a href="adddispatch"><i
							class="fa fa-file-text-o"></i> <span>��������֪ͨ��</span></a></li>
					<li id="menu-academico"><a href="AddSubTransport"><i
							class="fa fa-file-text-o"></i> <span>���Ӵ���֪ͨ��</span></a></li>
					<c:if test="${sessionScope.loginUser.userType!=1 }">
						<li id="menu-academico"><a href="examinedispatch"><i
								class="fa fa-file-text-o"></i> <span>�������֪ͨ��</span></a></li>
						<li id="menu-academico"><a href="cancel"><i
								class="fa fa-file-text-o"></i> <span>��������֪ͨ��</span></a></li>
					</c:if>
					<li id="menu-academico"><a href="exit"><i
							class="fa fa-file-text-o"></i> <span>�˳�ϵͳ</span></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<form id="form1" name="myForm" action="cancel" method="post">
            			<input type="hidden" name="operate" value=""/>
            			<input type="hidden" name="curState" value="${requestScope.curState.stateId }"/>
                		<div class="wl_content_nav">��������֪ͨ��</div>
		<table class="wl_table_query" cellspacing="0">
			<tr class="first">
				<th width="100">����֪ͨ��״̬</th>
				<td width="120"><select name="stateList" class="wl_selStyle">
						<option value=""></option>
						<c:forEach items="${listState }" var="state">
							<option value="${state.stateId }">${state.stateName }</option>
						</c:forEach>
				</select></td>
				<td width="440"><input type="button" value="�� ѯ" id="btnQuery" /></td>
			</tr>
		</table>
		<table class="table table-striped"
			style="margin-left: 400px; margin-right: 200px; width: 800px">
			<caption>���Ʊ��񲼾�</caption>
			<thead>
				<tr>
					<th>����ѡ��</th>
					<th>����ID</th>
					<th>��������</th>
					<th>�µ�ʱ��</th>
					<th>����״̬</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.listDispatchDto }"
					var="dispatchDto" varStatus="s">
					<tr>
						<td><input type="checkbox" name="chkItem"
							value="${dispatchDto.dispatchId }" /></td>
						<td>${dispatchDto.dispatchId }</td>
						<td>����֪ͨ��</td>
						<td>${dispatchDto.orderDate }</td>
						<td>${dispatchDto.stateName }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" class="lastTd"><input type="button"
						value="ȫ��ѡ��" id="btnSelAll" /> <input type="button" value="ȫ��ѡ��"
						id="btnSelNot" /> <input type="button" value="ɾ����ѡ" id="btnDel" /></td>
				</tr>
			</tbody>
		</table>
		<div class="wl_page">
			<c:if test="${requestScope.maxPage == 1 }">
                        		����<span>${requestScope.rowCount }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a disabled="disabled">��ҳ</a>]
                        	[<a disabled="disabled">��һҳ</a>]
                        	[<a disabled="disabled">��һҳ</a>]
                        	[<a disabled="disabled">ĩҳ</a>]
                        	</c:if>
			<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == 1}">
                        	����<span>${requestScope.rowCount }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a disabled="disabled">��ҳ</a>]
                        	[<a disabled="disabled">��һҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	����<span>${requestScope.rowCount }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=1">��ҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
			<c:if
				test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	����<span>${requestScope.rowCount }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=1">��ҳ</a>]
                        	[<a
					href="querydispatch?curState=${requestScope.curState.stateId }&pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a disabled="disabled">��һҳ</a>]
                        	[<a disabled="disabled">ĩҳ</a>]
                        	</c:if>
		</div>
	</form>
	<div class="wl_foot"
		style="color: black; margin-top: 50px; font-size: 18px; margin-bottom: 50px">-
		���������ִ�����ϵͳ -</div>

    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script> 
    <script type="text/javascript">
    	var myForm = document.myForm;
		var operate = myForm.operate;
    	$("btnQuery").onclick = function(){
			operate.value = "1";//��ʶ��ѯ����
			myForm.submit();
		};
		$("btnCancel").onclick = function(){
			operate.value = "2";//��ʶ���ϲ���
			myForm.submit();
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
		window.onload = function(){
    		var stateOptions = myForm.stateList.options;
    		var selOptionValue = myForm.curState.value;
    		for(var i = 0 ; i < stateOptions.length ; i++){
    			if(stateOptions[i].value == selOptionValue){
    				stateOptions[i].selected = true;
    				break;
    			}
    		}
    	};
    </script>
</body>
</html>