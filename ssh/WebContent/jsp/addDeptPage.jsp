<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" media="screen" />
<title>增加部门页面</title>
</head>
<body>
	<div style="width: 500px;">
		<form id="addPage"action="${pageContext.request.contextPath }/dept_addDept.action" method="post">
		  <!-- <div class="form-group">
		    <input type="hidden" name="eid" class="form-control">
		  </div> -->
		  <div class="form-group">
		    <label for="exampleInputDname">部门名称</label>
		    <input type="text" name="dname" class="form-control" placeholder="请输入部门名称">
		  </div>
		  <button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
</body>
</html>