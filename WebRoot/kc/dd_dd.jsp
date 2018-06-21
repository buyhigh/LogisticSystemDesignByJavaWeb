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
<title>�������͹���ϵͳ---ȡ������</title>
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
        		<%-- <a class="wl_item" >����ģ��</a>--%>
            	<a class="wl_item" href="querystore3">��ѯ���</a>
                <a class="wl_item" href="queryyl">��ѯ����</a>
                <a class="wl_item" href="queryoutstorerequest">��ѯ��������</a>
                <a class="wl_item" href="queryinstore">��ѯ�������</a>
                <a class="wl_item" href="querytra">��ѯ��������</a>
                <a class="wl_item" href="querycuku">��ѯ��������</a>
				<a class="wl_item" href="queryinstoretask">��ѯ�������</a>
                <%--<a class="wl_item" href="ddserv">ִ�е���</a>--%>
                <%--<a class="wl_item" href="canceldd">ȡ������</a>--%>
                <a class="wl_item" href="examineoss">��˳�������</a>
                <a class="wl_item" href="examinetra">�����������</a>
                <%--<a class="wl_item" >�ֹ�ģ��</a>--%>
				<a class="wl_item" href="examineoutstoretask">��˳�������</a>
				<a class="wl_item" href="examineinstore">����������</a>
				<a class="wl_item" href="execchuku">ִ�г���</a>
				<a class="wl_item" href="execruku">ִ�����</a>
				<a class="wl_item" href="backgoods">�˻���</a>
                <a class="wl_item" href="exit">�˳�ϵͳ</a>
                <div></div>
                <div id="ServerTimeArea"></div>
			</div>
            <div class="wl_right">
            	<form id="form1" name="myForm" action="" method="post">
                		<div class="wl_content_nav">����</div>
                        <table class="wl_table" cellspacing="0">
                            <tr>
                                <th width="">��������ID</th>
                                <th>��������</th>
                                <th width="">����ֿ�</th>
                                <th width="">������Ʒ</th>
                                <th>��Ʒ����</th>
                                <th>����״̬</th>
                                <th>�µ�ʱ��</th>
                           </tr>
                           
                           <c:forEach items="${requestScope.listOutStoreTaskDto }" var="outStoreTaskDto">
                           		<tr>
                           			<td>${outStoreTaskDto.outStoreRequestId }</td>
                           			<td>��������</td>
                           			<td>${outStoreTaskDto.storeStr }</td>
                           			<td>${outStoreTaskDto.goodName }</td>
                           			<td>${outStoreTaskDto.goodQuantity }</td>
                           			<td>${outStoreTaskDto.stateStr }</td>
                           			<td>${outStoreTaskDto.orderDate }</td>
                           		</tr>
                           </c:forEach>
                           
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
                        	[<a href="ddcukupage?pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPage }">
                        	����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a href="ddcukupage?pageNum=1">��ҳ</a>]
                        	[<a href="ddcukupage?pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum=${requestScope.curPage + 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum=${requestScope.maxPage }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage > 1 && requestScope.curPage == requestScope.maxPage }">
                        	����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPage }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ 
                        	[<a href="ddcukupage?pageNum=1">��ҳ</a>]
                        	[<a href="ddcukupage?pageNum=${requestScope.curPage - 1 }">��һҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">ĩҳ</a>]
                        	</c:if>
                        </div>
                        
                        
                        
                        
                        
                        <table class="wl_table" cellspacing="0">
                            <tr>
                            	<th>��������ID</th>
                                <th width="">�����</th>
                                <th>������������</th>
                                <th width="">��������</th>
                                <th>�µ�ʱ��</th>
                                <th>��������</th>
                                <th width="">����״̬</th>
                           </tr>
                           
                           <c:forEach items="${requestScope.listTransferTaskDto }" var="transferTaskDto">
                           		<tr>
                           			<td>${transferTaskDto.transferRequestId }</td>
                           			<td>${transferTaskDto.transferName }</td>
                           			<td>${transferTaskDto.transferModel }</td>
                           			<td>${transferTaskDto.transferTool }</td>
                           			<td>${transferTaskDto.orderDate }</td>
                           			<td>${transferTaskDto.requestNum }</td>
                           			<td>${transferTaskDto.stateName }</td>
                           		</tr>
                           </c:forEach>
                           
                        </table>
                        <div class="wl_page">
                        	<c:if test="${requestScope.maxPage2 == 1 }">
                        		����<span>${requestScope.count2 }</span>������Ϊ<span>${requestScope.maxPage2 }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage2 }</span>ҳ 
                        	[<a disabled = "disabled">��ҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a disabled = "disabled">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 == 1}">
                        	����<span>${requestScope.count2 }</span>������Ϊ<span>${requestScope.maxPage2 }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage2 }</span>ҳ 
                        	[<a disabled = "disabled">��ҳ</a>]
                        	[<a disabled = "disabled">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.curPage2 + 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.maxPage2 }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 > 1 && requestScope.curPage2 < requestScope.maxPage2 }">
                        	����<span>${requestScope.count2 }</span>������Ϊ<span>${requestScope.maxPage2 }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage2 }</span>ҳ 
                        	[<a href="ddcukupage?pageNum2=1">��ҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.curPage2 - 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.curPage2 + 1 }">��һҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.maxPage2 }">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPage2 > 1 && requestScope.curPage2 == requestScope.maxPage2 }">
                        	����<span>${requestScope.count2 }</span>������Ϊ<span>${requestScope.maxPage2 }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage2 }</span>ҳ 
                        	[<a href="ddcukupage?pageNum2=1">��ҳ</a>]
                        	[<a href="ddcukupage?pageNum2=${requestScope.curPage2 - 1 }">��һҳ</a>]
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
</body>
</html>
