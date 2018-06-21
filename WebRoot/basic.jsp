<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
        background-image: url("{{ url_for('static', filename='img/bk1.jpg') }}");
        background-attachment: fixed;
        background-position: right;
      }
    </style>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">  
<link rel=stylesheet type=text/css href="bootstrap/other/css/bootstrap.css">
<link rel=stylesheet type=text/css href="bootstrap/other/css/bootstrap-responsive.css">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">  
    <div class="container"> 
        <div class="navbar-header">  
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  
                data-target="#navbar" aria-expanded="false" aria-controls="navbar">  
                <span class="sr-only"></span>  
                <span class="icon-bar"></span>  
                <span class="icon-bar"></span>  
                <span class="icon-bar"></span>  
            </button>  
            <a class="navbar-brand" href="#">物流运输系统</a>  
        </div>  
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false">  
            <ul class="nav navbar-nav">  
                <li><a href="switch?msg=1">接单系统</a></li>  
                <li><a href="switch?msg=2">调度系统</a></li>  
                <li><a href="switch?msg=3">库存系统</a></li>  
                <li><a href="switch?msg=4">运输点系统</a></li> 
            </ul>  
        </div>  
    </div>  
</nav>  
<script src="bootstrap/js/jquery.js"></script> 
<script src="bootstrap/other/js/bootstrap-alert.js"></script> 
<script src="bootstrap/other/js/bootstrap-button.js"></script> 
<script src="bootstrap/other/js/bootstrap-carousel.js"></script> 
<script src="bootstrap/other/js/bootstrap-collapse.js"></script> 
<script src="bootstrap/other/js/bootstrap-dropdown.js"></script> 
<script src="bootstrap/other/js/bootstrap-modal.js"></script> 
<script src="bootstrap/other/js/bootstrap-popover.js"></script> 
<script src="bootstrap/other/js/bootstrap-scrollspy.js"></script> 
<script src="bootstrap/other/js/bootstrap-tab.js"></script> 
<script src="bootstrap/other/js/bootstrap-tooltip.js"></script> 
<script src="bootstrap/other/js/bootstrap-transition.js"></script> 
<script src="bootstrap/other/js/bootstrap-typeahead.js"></script> 
<script src="bootstrap/js/bootstrap.js"></script> 
</body>
</html>