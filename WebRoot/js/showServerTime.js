function showServerDate(){
    		var xhr = createXHR();
    		//响应事件
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						$("ServerTimeArea").innerHTML = xhr.responseText;
					}
				}
			}; 
			//请求的方式，请求的URL，是否可以异步请求
			xhr.open("get","getServerDate?fresh=" + new Date().getTime(),true);
			//当为get时写null，当为post时写getParameter()
			xhr.send(null);
    	}
    	window.setInterval("showServerDate()",1000);