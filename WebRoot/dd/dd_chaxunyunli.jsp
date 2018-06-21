<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html;charset=gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/dd/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>物流配送管理系统---查询运力</title>
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
	<div class="wl_container">
    	<div class="wl_head"></div>
        <div class="wl_separater">
        	欢迎您，${sessionScope.loginUser.userName }
        </div>
        <div class="wl_main">
        	<div class="wl_left">
            	<a class="wl_item" href="querystore2">查询库存</a>
                <a class="wl_item" href="queryyl">查询运力</a>
                <a class="wl_item" href="queryoutstorerequest">查询出库请求单</a>
                <a class="wl_item" href="queryinstore">查询入库请求单</a>
                <a class="wl_item" href="querytra">查询运输请求单</a>
                <a class="wl_item" href="ddserv">执行调度</a>
                <a class="wl_item" href="canceldd">取消调度</a>
                <a class="wl_item" href="examineoss">审核出库请求</a>
                <a class="wl_item" href="examinetra">审核运输请求</a>
                <a class="wl_item" href="exit">退出系统</a>
                <div></div>
                <div id="ServerTimeArea"></div>
			</div>
            <div class="wl_right">
            	<form id="form1" name="myForm" action="queryyl" method="post">
            			<input type="hidden" name="curSelPlace" value="${requestScope.curTransferPlace}"/>
            			<input type="hidden" name="curSelModel" value="${requestScope.curTransferModel}"/>
            			<input type="hidden" name="curSelTool" value="${requestScope.curTransferTool}"/>
                		<div class="wl_content_nav">查询运力</div>
                        <table class="wl_table_query" cellspacing="0">
                        	<tr class="first">
                            	<th width="70">运输点</th>
                                <td width="120">
                                	<select name="selPlace" class="wl_selStyle" id="selP">
                                		<option value=""></option>
                                        <c:forEach items="${requestScope.listTransferPlace }" var="transferPlace">
                                        	<option value="${transferPlace.transferPlaceId }">${transferPlace.transferPlaceName }</option>
                                        </c:forEach>
                                	</select>
                                </td>
                                <th width="100">运力类型</th>
                                <td>
                                	<select name="selModel" class="wl_selStyle" id="selM">
                                    	<option value=""></option>
                                        <c:forEach items="${requestScope.listTransferToolDto2 }" var="transferToolDto2">
                                        	<option value="${transferToolDto2.transferModel }">${transferToolDto2.modelStr }</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <th width="100">运力工具</th>
                                <td>
                                	<select name="selTool" class="wl_selStyle" id="selT">
                                    	<option value=""></option>
                                    	<c:forEach items="${requestScope.listTransferToolDto3 }" var="transferToolDto3">
                                        	<option value="${transferToolDto3.transferId }">${transferToolDto3.transferName }</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td width="330">
                                	<input type="submit" value="查询" />
                                </td>
                            </tr>
                        </table>
                        <table class="wl_table" cellspacing="0">
                            <tr>
                                <th width="280">运输点</th>
                                <th width="120">运力工具</th>
                                <th>可用数量</th>
                                <th>当前状态</th>
                            </tr>
                            
                            
                            <c:forEach items="${requestScope.listTransferToolDto }" var="transferToolDto">
                            <tr>
                            	<td>${transferToolDto.placeStr }</td>
                                <td>${transferToolDto.transferName }</td>
                                <td>${transferToolDto.quantity }</td>
                                <td>${transferToolDto.stateStr }</td>
                            </tr>
                            </c:forEach>
                            
                            <c:if test="${requestScope.curTransferToolDto != null }">
                            <tr>
                            	<td>${curTransferToolDto.placeStr }</td>
                                <td>${curTransferToolDto.transferName }</td>
                                <td>${curTransferToolDto.quantity }</td>
                                <td>${curTransferToolDto.stateStr }</td>
                            </tr>	
                            </c:if>
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
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=1">首页</a>]
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.curPage - 1 }">上一页</a>]
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.curPage + 1 }">下一页</a>]
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.maxPage }">末页</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	共有<span>${requestScope.count }</span>条，分为<span>${requestScope.maxPage }</span>页，每页<span>10</span>条，当前显示第<span>${requestScope.curPage }</span>页 
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=1">首页</a>]
                        	[<a href="queryyl?curSelPlace=${requestScope.curTransferPlace }&curSelModel=${requestScope.curTransferModel}&pageNum=${requestScope.curPage - 1 }">上一页</a>]
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
		//Ajax级联
		$("selP").onchange = function(){
			var transferPlace = $("selPlace").options[$("selPlace").selectedIndex].value;	
			var xhr = createXHR();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					var resultList = xhr.responseText.split(";");
					$("selModel").length = 0;
					$("selModel").add(new Option("",""),undefined);
					$("selTool").length = 0;
					$("selTool").add(new Option("",""),undefined);
					for(var i = 0 ; i < resultList.length ; i++){
						var item = resultList[i].split(":");
						var toolId = item[0];
						var toolName = item[1];
						var option = new Option(toolName,toolId);
						$("selModel").add(option,undefined);
					}
				}
			};
			xhr.open("get","gettools2?transferPlaceStr=" + transferPlace,true);
			xhr.send(null);
		};
		$("selM").onchange = function(){
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
		
		window.onload = function(){
			var curSelPlaceValue = $("curSelPlace").value;
			var curSelModelValue = $("curSelModel").value;
			var curSelToolValue = $("curSelTool").value;
			var selPOptions = $("selP").options;
			var selMOptions = $("selM").options;
			var selTOptions = $("selT").options;
			for(var i = 0 ; i < selPOptions.length ; i++){
				if(curSelPlaceValue == selPOptions[i].value){
					selPOptions[i].selected = true;
					break;
				}
			}
			for(var i = 0 ; i < selMOptions.length ; i++){
				if(curSelModelValue == selMOptions[i].value){
					selMOptions[i].selected = true;
					break;
				}
			}
			for(var i = 0 ; i < selTOptions.length ; i++){
				if(curSelToolValue == selTOptions[i].value){
					selTOptions[i].selected = true;
					break;
				}
			}
		};
		
    </script>
</body>
</html>
