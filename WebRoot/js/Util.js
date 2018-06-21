function $(id){
    		return document.getElementById(id);
    	}
function $N(name){
	return document.getElementsByName(name);
}
    	
    	function createXHR(){
    		var xmlHttp;
    		try{
    			xmlHttp = new XMLHttpRequest();
    		}catch(e){
    			try{
    				xmlHttp = new ActiveXObject("MSXML2.XMLHTTP");//检查是否是IE
    			}catch(e){
    				try{
    					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//检查浏览器是否是Firefox，opera 8.0，safari
    				}catch(e){
    					alert("您的浏览器不支持AJAX！");
    					return false;
    				}
    			}
    		}
    		return xmlHttp;
    	}