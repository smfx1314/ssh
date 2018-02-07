<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen" />
<title>分页查询结果</title>
<style type="text/css">
	.table th{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container" style="width: 100%;">
		<%--表格--%>
		<div class="row" style="text-align: center">
	      <div class="col-md-12">
	          <table class="table table-bordered table-hover">
	            <tr>
					<th>编号</th>
					<th>用户名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>城市</th>
					<th colspan="3">操作</th>
				</tr>
				
	         	 <c:forEach items="${pageBean.list }" var="emp">
					<tr>
						<th>${emp.eid }</th>
						<th>${emp.eusername }</th>
						<th>${emp.eage }</th>
						<th>${emp.esex}</th>
						<th>${emp.ecity}</th>
						<th><a href="${pageContext.request.contextPath }/emp_addPage.action">添加</a></th>
						<th><a href="${pageContext.request.contextPath }/emp_delete.action?eid=${emp.eid}">删除</a></th> 
						<th><a href="${pageContext.request.contextPath }/emp_updatePage.action?eid=${emp.eid}">修改</a></th>
					</tr>
				</c:forEach>
			  </table>
				共[${pageBean.totalCount }]条记录,共[${pageBean.totalPage }]页,当前第[${pageBean.currenPage }]页
				
				<c:if test="${pageBean.currenPage !=1 }">
					<a href="${pageContext.request.contextPath }/emp_listPage.action?currenPage=${pageBean.currenPage-1}">上一页</a>
				</c:if>
				<c:if test="${pageBean.currenPage !=pageBean.totalPage }">
					<a href="${pageContext.request.contextPath }/emp_listPage.action?currenPage=${pageBean.currenPage+1}">下一页</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>