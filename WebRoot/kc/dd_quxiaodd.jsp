<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/kc/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>物流配送管理系统---取消调度</title>
<style type="text/css">
	body{font-size:12px;margin:0px;padding:0px;background:#ccc;}
	a{text-decoration:none;color:#000;}
	.wl_container{width:1002px;margin:0px auto;background:#fff;}
	.wl_head{height:122px;background:url(../images/wl_head_01.jpg) no-repeat;}
	.wl_separater{background:url(../images/wl_vline_04.jpg) repeat-x;margin-top:1px;color:#fff;text-align:center;line-height:2.3em;font-weight:bold;}
	.wl_main{height:645px;background:#01a333;float:left;}
	.wl_left{float:left;width:209px;margin-left:1px;margin-right:2px;display:inline;}
	.wl_item{display:block;width:169px;height:24px !important;height:23px;background:url(../images/wl_item_04.jpg) no-repeat;padding:9px 0px 0px 40px !important;padding:10px 0px 0px 40px;margin-bottom:2px;font-size:14px;font-weight:bold;}
	.wl_right{width:790px;height:645px;float:left;background:#fff;}
	.wl_foot{clear:both;background:#01a333;text-align:center;color:#fff;font-weight:bold;line-height:2em;}
	.wl_table{width:700px;border-collapse:collapse;border:1px solid #ccc;margin:30px auto 0px;}
	.wl_table th,.wl_table td{border:1px solid #ccc;text-align:center;padding:3px;}
	.wl_table .lastTd{text-align:left;}
	.wl_page{width:700px;margin:5px auto;text-align:center;}
	.wl_page span{font-weight:bold;}
	.wl_content_nav{font-size:14px;font-family:'Microsoft Yahei',PMingLiU,Verdana;padding:13px 0px 0px 20px;}
	#ServerTimeArea{margin-top:30px;font-size:14px;color:#fff;font-weight:bold;}
</style>
</head>
<body>
	<div class="wl_container">
    	<div class="wl_head"></div>
        <div class="wl_separater">
        	欢迎您，${sessionScope.loginUser.userName }
        </div>
        <div class="wl_main">
        	<div class="wl_left">
        		<%-- <a class="wl_item" >调度模块</a>--%>
            	<a class="wl_item" href="querystore3">查询库存</a>
                <a class="wl_item" href="queryyl">查询运力</a>
                <a class="wl_item" href="queryoutstorerequest">查询出库请求单</a>
                <a class="wl_item" href="queryinstore">查询入库请求单</a>
                <a class="wl_item" href="querytra">查询运输请求单</a>
                <a class="wl_item" href="querycuku">查询出库任务单</a>
				<a class="wl_item" href="queryinstoretask">查询入库任务单</a>
                <%--<a class="wl_item" href="ddserv">执行调度</a>--%>
                <%--<a class="wl_item" href="canceldd">取消调度</a>--%>
                <a class="wl_item" href="examineoss">审核出库请求</a>
                <a class="wl_item" href="examinetra">审核运输请求</a>
                <%--<a class="wl_item" >仓管模块</a>--%>
				<a class="wl_item" href="examineoutstoretask">审核出库任务单</a>
				<a class="wl_item" href="examineinstore">审核入库任务单</a>
				<a class="wl_item" href="execchuku">执行出库</a>
				<a class="wl_item" href="execruku">执行入库</a>
				<a class="wl_item" href="backgoods">退换货</a>
                <a class="wl_item" href="exit">退出系统</a>
                <div></div>
                <div id="ServerTimeArea"></div>
			</div>
            <div class="wl_right">
            	<form id="form1" name="myForm" action="canceldd" method="post">
            			<input type="hidden" name="flag" value=""/>
                		<div class="wl_content_nav">取消调度</div>
                        <table class="wl_table" cellspacing="0">
                            <tr>
                                <th width="30">批量选择</th>
                                <th width="">配送单ID</th>
                                <th>单据名称</th>
                                <th width="">出库仓库</th>
                                <th width="">出库商品</th>
                                <th>商品数量</th>
                                <th>单据状态</th>
                                <th>下单时间</th>
                            </tr>
                            
                            <c:forEach items="${requestScope.listOutStoreRequestDto }" var="outStoreRequestDto">
                            <tr>
                                <td><input type="checkbox" name="chkItem" value="${outStoreRequestDto.outStoreRequestId }"/></td>
                                <td>${outStoreRequestDto.dispatchId }</td>
                                <td>出库请求单</td>
                                <td>${outStoreRequestDto.storeStr }</td>
                                <td>${outStoreRequestDto.goodName }</td>
                                <td>${outStoreRequestDto.goodQuantity }</td>
                                <td>${outStoreRequestDto.stateStr }</td>
                                <td>${outStoreRequestDto.orderDate }</td>
                            </tr>
                            </c:forEach>
                            
                            <tr>
                              <td colspan="8" class="lastTd">
								  <input type="button" value="全部选择" id="btnSelAll"/>
                                  <input type="button" value="全不选择" id="btnSelNot"/>	
                                  <input type="button" value="提交" id="btnSub1"/>
                              </td>
                            </tr>
                        </table>
                        <div class="wl_page">
                        	<c:if test="${requestScope.maxPage == 1 }">
                        		共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled = "disabled">首页</a>]
                        	[<a disabled = "disabled">上一页</a>]
                        	[<a disabled = "disabled">下一页</a>]
                        	[<a disabled = "disabled">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == 1}">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a disabled = "disabled">首页</a>]
                        	[<a disabled = "disabled">上一页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="canceldd?pageNum=1">首页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="canceldd?pageNum=1">首页</a>]
                        	[<a href="canceldd?pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a disabled = "disabled">下一页</a>]
                        	[<a disabled = "disabled">末页</a>]
                        	</c:if>
                        </div>
                        
                        
                        
                        
                        
                        <table class="wl_table" cellspacing="0">
                            <tr>
                                <th width="30">批量选择</th>
                                <th width="120">运输点</th>
                                <th>运力工具类型</th>
                                <th width="120">运力工具</th>
                                <th>下单时间</th>
                                <th width="30">需求数量</th>
                                <th width="120">单据状态</th>
                            </tr>
                            
                            <c:forEach items="${requestScope.listTransferRequestDto }" var="transferRequestDto">
                            <tr>
                                <td><input type="checkbox" name="chkItem2" value="${transferRequestDto.transferRequestId }"/></td>
                               	<td>${transferRequestDto.transferName }</td>
                                <td>${transferRequestDto.transferModel }</td>
                                <td>${transferRequestDto.transferTool }</td>
                                <td>${transferRequestDto.orderDate }</td>
                                <td>${transferRequestDto.requestNum }</td>
                                <td>${transferRequestDto.stateName }</td>
                            </tr>
                            </c:forEach>
                            
                            <tr>
                              <td colspan="8" class="lastTd">
								  <input type="button" value="全部选择" id="btnSelAll2"/>
                                  <input type="button" value="全不选择" id="btnSelNot2"/>	
                                  <input type="button" value="提交" id="btnSub2"/>
                              </td>
                            </tr>
                        </table>
                        <div class="wl_page">
                        	<c:if test="${requestScope.maxPage2 == 1 }">
                        		共有<span>${requestScope.count2 }</span>条，分为<span>${requestScope.maxPage2 }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage2 }</span>页 
                        	[<a disabled = "disabled">首页</a>]
                        	[<a disabled = "disabled">上一页</a>]
                        	[<a disabled = "disabled">下一页</a>]
                        	[<a disabled = "disabled">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 == 1}">
                        	共有<span>${requestScope.count2 }</span>条，分为<span>${requestScope.maxPage2 }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage2 }</span>页 
                        	[<a disabled = "disabled">首页</a>]
                        	[<a disabled = "disabled">上一页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.curPage2 + 1 }">下一页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.maxPage2 }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 > 1 && requestScope.curPage2 < requestScope.maxPage2 }">
                        	共有<span>${requestScope.count2 }</span>条，分为<span>${requestScope.maxPage2 }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage2 }</span>页 
                        	[<a href="canceldd?pageNum2=1">首页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.curPage2 - 1 }">上一页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.curPage2 + 1 }">下一页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.maxPage2 }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 == requestScope.maxPage2 }">
                        	共有<span>${requestScope.count2 }</span>条，分为<span>${requestScope.maxPage2 }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage2 }</span>页 
                        	[<a href="canceldd?pageNum2=1">首页</a>]
                        	[<a href="canceldd?pageNum2=${requestScope.curPage2 - 1 }">上一页</a>]
                        	[<a disabled = "disabled">下一页</a>]
                        	[<a disabled = "disabled">末页</a>]
                        	</c:if>
                        </div>
                        
                        
                        
                        
                        
                        
                </form>
            </div>
        </div>
        <div class="wl_foot">
        	物流配送管理系统   -- 
        </div>
    </div>
    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script>
    <script type="text/javascript">
    	
    	var myForm = document.myForm;
    	var flag = myForm.flag;
    	var chkItems = $N("chkItem");
    	var chkItems2 = $N("chkItem2");
    	$("btnSelAll").onclick = function(){
    		for(var i = 0 ; i < chkItems.length ; i++){
    			if(chkItems[i].type == "checkbox"){
    				chkItems[i].checked = true;
    			}
    		}
    	};
    	$("btnSelNot").onclick = function(){
    		for(var i = 0 ; i < chkItems.length ; i++){
    			if(chkItems[i].type == "checkbox"){
    				chkItems[i].checked = false;
    			}
    		}
    	};
    	$("btnSelAll2").onclick = function(){
    		for(var i = 0 ; i < chkItems2.length ; i++){
    			if(chkItems2[i].type == "checkbox"){
    				chkItems2[i].checked = true;
    			}
    		}
    	};
    	$("btnSelNot2").onclick = function(){
    		for(var i = 0 ; i < chkItems2.length ; i++){
    			if(chkItems2[i].type == "checkbox"){
    				chkItems2[i].checked = false;
    			}
    		}
    	};
    	$("btnSub1").onclick = function(){
    		flag.value = "1";
    		myForm.submit();
    	};
    	$("btnSub2").onclick = function(){
    		flag.value = "2";
    		myForm.submit();
    	};
    	
    </script>
</body>
</html>
