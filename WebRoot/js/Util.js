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
    				xmlHttp = new ActiveXObject("MSXML2.XMLHTTP");//����Ƿ���IE
    			}catch(e){
    				try{
    					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//���������Ƿ���Firefox��opera 8.0��safari
    				}catch(e){
    					alert("�����������֧��AJAX��");
    					return false;
    				}
    			}
    		}
    		return xmlHttp;
    	}