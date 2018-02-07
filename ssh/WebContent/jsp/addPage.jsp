<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" media="screen" />
<title>添加员工页面</title>
</head>
<body>
	<div style="width: 500px;">
		<form id="addPage" action="${pageContext.request.contextPath }/emp_add.action" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <!-- <label for="exampleInputEmail1">id</label> -->
		    <input type="hidden" name="eid" class="form-control">
		  </div>
		  <div class="form-group">
		    <label>部门</label>
		    <select class="form-control" name="dept.did">
			    <c:forEach items="${list }" var="dept">
			    	<option value="${dept.did }">${dept.dname }</option>
			    </c:forEach>	
		    </select>
		  </div>
		  <div class="form-group">
		    <label>姓名</label>
		    <input type="text" name="eusername" class="form-control" placeholder="请输入姓名">
		  </div>
		  <div class="form-group">
		    <label>年龄</label>
		    <input type="text" name="eage" class="form-control" placeholder="请输入年龄">
		  </div>
		  <div class="form-group">
		    <label>性别</label>
		    <input type="text" name="esex" class="form-control" placeholder="请输入性别">
		  </div>
		  <div class="form-group">
		    <label>城市</label>
		    <input type="text" name="ecity" class="form-control" placeholder="请输入城市">
		  </div>
		  <div class="form-group">
		    <label>上传文件</label>
		    <input type="file" name="upload" class="form-control">
		  </div>
		  <button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</body>
</html>