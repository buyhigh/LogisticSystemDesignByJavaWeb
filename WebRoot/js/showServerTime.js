function showServerDate(){
    		var xhr = createXHR();
    		//��Ӧ�¼�
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						$("ServerTimeArea").innerHTML = xhr.responseText;
					}
				}
			}; 
			//����ķ�ʽ�������URL���Ƿ�����첽����
			xhr.open("get","getServerDate?fresh=" + new Date().getTime(),true);
			//��Ϊgetʱдnull����ΪpostʱдgetParameter()
			xhr.send(null);
    	}
    	window.setInterval("showServerDate()",1000);