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
<title>�������͹���ϵͳ---�����������</title>
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
        	��ӭ����${sessionScope.loginUser.userName }
        </div>
        <div class="wl_main">
        	<div class="wl_left">
            	<a class="wl_item" href="querystore2">��ѯ���</a>
                <a class="wl_item" href="queryyl">��ѯ����</a>
                <a class="wl_item" href="queryoutstorerequest">��ѯ��������</a>
                <a class="wl_item" href="queryinstore">��ѯ�������</a>
                <a class="wl_item" href="querytra">��ѯ��������</a>
                <a class="wl_item" href="ddserv">ִ�е���</a>
                <a class="wl_item" href="canceldd">ȡ������</a>
                <a class="wl_item" href="examineoss">��˳�������</a>
                <a class="wl_item" href="examinetra">�����������</a>
                <a class="wl_item" href="exit">�˳�ϵͳ</a>
                <div></div>
                <div id="ServerTimeArea"></div>
			</div>
            <div class="wl_right">
            	<form id="form1" name="myForm" action="examinetra" method="post">
                		<div class="wl_content_nav">�����������</div>
                        <table class="wl_table" cellspacing="0">
                            <tr>
                            	<th width="30">����ѡ��</th>
                                <th width="120">�����</th>
                                <th>������������</th>
                                <th width="120">��������</th>
                                <th>�µ�ʱ��</th>
                                <th width="30">��������</th>
                                <th width="120">����״̬</th>
                            </tr>
                            
                            <c:forEach items="${requestScope.listTransferRequestDto }" var="transferRequestDto">
                            <tr>
                                <td><input type="checkbox" name="chkItem" value="${transferRequestDto.transferRequestId }"/></td>
                               	<td>${transferRequestDto.transferName }</td>
                                <td>${transferRequestDto.transferModel }</td>
                                <td>${transferRequestDto.transferTool }</td>
                                <td>${transferRequestDto.orderDate }</td>
                                <td>${transferRequestDto.requestNum }</td>
                                <td>${transferRequestDto.stateName }</td>
                            </tr>
                            </c:forEach>
                            
                            <tr>
                              <td colspan="7" class="lastTd">
								  <input type="button" value="ȫ��ѡ��" id="btnSelAll"/>
                                  <input type="button" value="ȫ��ѡ��" id="btnSelNot"/>	
                                  <input type="submit" value="�ύ" />
                              </td>
                            </tr>
                        </table>
                        <div class="wl_page">
                        	<c:if test="${requestScope.maxPage == 1 }">
                        		����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a disabled = "disabled">��ҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == 1}">
                        	����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a disabled = "disabled">��ҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a href="examinetra?pageNum=1">��ҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a href="examinetra?pageNum=1">��ҳ</a>]
                        	[<a href="examinetra?pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">ĩҳ</a>]
                        	</c:if>
                        </div>
                </form>
            </div>
        </div>
        <div class="wl_foot">
        	�������͹���ϵͳ   -- 
        </div>
    </div>
    <script src="../js/Util.js"></script>
    <script src="../js/showServerTime.js"></script>
  	<script type="text/javascript">
  		var myForm = document.myForm;
    	var chkItems = $N("chkItem");
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
  	</script>
</body>
</html>
