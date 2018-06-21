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
<title>�������͹���ϵͳ---��ѯ���</title>
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
            	<form id="form1" name="myForm" action="querystore2" method="post">
            			<input type="hidden" name="curStore" value="${requestScope.store.storeId }"/>
            			<input type="hidden" name="curGoods" value="${requestScope.goodDto.goodId }"/>
                		<div class="wl_content_nav">��ѯ���</div>
                        <table class="wl_table_query" cellspacing="0">
                        	<tr class="first">
                            	<th width="50">�ֿ�</th>
                                <td width="120">
                                	<select name="selLibrary" class="wl_selStyle" id="selStore">
                                		<option value=""></option>
                                        <c:forEach items="${requestScope.listStore }" var="store" varStatus="s">
                                        	<option value="${store.storeId }">${store.storeName }</option>
                                        </c:forEach>
                                	</select>
                                </td>
                                <th width="50">��Ʒ</th>
                                <td width="120">
                                	<select name="selGooks" class="wl_selStyle" id="selGood">
                                    	<option value=""></option>
                                        <c:forEach items="${requestScope.listGoodsDto2 }" var="goodsDto" varStatus="s">
                                    		<option value="${goodsDto.goodId }">${goodsDto.goodName }</option>
                                    	</c:forEach>
                                    </select>
                                </td>
                                <td width="200">
                                	<input type="submit" value="��ѯ" />
                                </td>
                            </tr>
                        </table>
                        <table class="wl_table" cellspacing="0">
                            <tr>
                                <th width="50">��ƷID</th>
                                <th width="280">��Ʒ����</th>
                                <th>�����ֿ�</th>
                                <th width="170">���ʱ��</th>
                                <th width="70">�洢����</th>
                                <th width="30">�Ƽ���λ</th>
                            </tr>
                            
                            <c:forEach items="${requestScope.listGoodsDto }" var="goodsDto" varStatus="s">                            
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
                            
                        </table>
                        <c:if test="${requestScope.goodDto == null}">
                        <div class="wl_page">
                        	<c:if test="${requestScope.maxPageNum == 1 }">
                        		����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPageNum }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ [<a disabled = "disabled">��ҳ</a>][<a disabled = "disabled">��һҳ</a>][<a disabled = "disabled">��һҳ</a>][<a disabled = "disabled">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPageNum > 1 && requestScope.curPage == 1}">
                        		����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPageNum }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ [<a disabled = "disabled">��ҳ</a>][<a disabled = "disabled">��һҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage + 1 }">��һҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.maxPageNum}">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPageNum > 1 && requestScope.curPage > 1 && requestScope.curPage < requestScope.maxPageNum }">
                        		����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPageNum }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ [<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=1">��ҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage - 1}">��һҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage + 1 }">��һҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.maxPageNum}">ĩҳ</a>]
                        	</c:if>
                        	<c:if test="${requestScope.maxPageNum > 1 && requestScope.curPage == requestScope.maxPageNum }">
                        		����<span>${requestScope.count }</span>������Ϊ<span>${requestScope.maxPageNum }</span>ҳ��ÿҳ<span>10</span>������ǰ��ʾ��<span>${requestScope.curPage }</span>ҳ [<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=1">��ҳ</a>][<a href="querystore2?storeId=${requestScope.store.storeId }&pageNum=${requestScope.curPage - 1}">��һҳ</a>][<a disabled ="disabled">��һҳ</a>][<a disabled ="disabled">ĩҳ</a>]
                        	</c:if>
                        </div>
                        </c:if>
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
    	
    	$("selStore").onchange = function(){
    		var storeId = $("selStore").options[$("selStore").selectedIndex].value;
    		var xhr = createXHR();
    		xhr.onreadystatechange = function(){
    			if(xhr.readyState == 4 ){
    				var jsonList = xhr.responseText.split(";");
    				$("selGood").length = 0;
    				$("selGood").add(new Option("",""),undefined);
    				for(var i = 0 ; i < jsonList.length ; i++){
    					var json = jsonList[i];
    					var items = json.split(":");
    					var id = items[0];
    					var name = items[1];
    					var option = new Option(name,id);
    					$("selGood").add(option,undefined);
    				}
   
    			}
    		};
    		xhr.open("get","getgoods?" + encodeURI("storeId=") + encodeURI(storeId),true);
    		xhr.send(null);
    	};
		
    	var myForm = document.myForm;
    	window.onload = function(){
    		var curStoreId = myForm.curStore.value;
    		var curGoodsId = myForm.curGoods.value;
    		var storeOptions = $("selStore").options;
    		var goodsOptions = $("selGood").options;
    		for(var i = 0 ; i < storeOptions.length ; i++){
    			if(curStoreId == storeOptions[i].value){
    				storeOptions[i].selected = true;
    				break;
    			}
    		}
    		for(var i = 0 ; i < goodsOptions.length ; i++){
    			if(curGoodsId == goodsOptions[i].value){
    				goodsOptions[i].selected = true;
    				break;
    			}
    		}
    	};
    </script>
</body>
</html>
