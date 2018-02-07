<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="IE=edge">
<title>登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" media="screen" />
</head>
<body>
	 <div class="div_from_aoto" style="width: 500px;">
	 	
	    <form action="${pageContext.request.contextPath }/user_login.action" method="post">
	        <div class="control-group">
	            <label class="laber_from">用户名</label>
	            <div  class="controls" ><input class="input_from" type=text name="username" placeholder=" 请输入用户名"></input><p class=help-block></p></div>
	        </div>
	        <div class="control-group">
	            <label class="laber_from" >密码</label>
	            <div  class="controls" ><input class="input_from" type=password name="password" placeholder=" 请输入密码"></input><p class=help-block></p></div>
	        </div>
	       
	        <div class="control-group">
	            <label class="laber_from" ></label>
	            <div class="controls" >
	            	<button class="btn btn-success" style="width:120px;" >确认</button>	       
	            </div>
	        </div>
	    </form>
	</div>
</body>
</html>
