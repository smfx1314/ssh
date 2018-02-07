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
<title>显示部门信息</title>
<style type="text/css">
	.table th{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container" style="width: 100%;">
        <%--标题--%>
        <div class="row">
            <div class="col-md-12">
                <h1 style="text-align: center;">欢迎</h1>
            </div>
        </div>
            <%--查询行--%>
         <div class="row" style="text-align: center">
             <div class="col-md-12">
               <a href="${pageContext.request.contextPath }/dept_addDeptPage.action">添加部门</a>
             </div>
         </div>
		<%--表格--%>
		<div class="row" style="text-align: center">
	      <div class="col-md-12">
	          <table class="table table-bordered table-hover">
	              <tr>
	                  <th>部门名称</th>
	                  <th  colspan="3">操作</th>
	              </tr>
	    <c:forEach items="${list }" var="dept">
			<tr>
				<td>${dept.dname }</td>
				<td><a href="${pageContext.request.contextPath }/dept_addDeptPage.action">添加</a></td>
				<td><a href="${pageContext.request.contextPath }/dept_deleteDept.action?did=${dept.did}">删除</a></td> 
				<td><a href="${pageContext.request.contextPath }/dept_updateDeptPage.action?did=${dept.did}">修改</a></td>
			</tr>
		</c:forEach> 
	</table>

	       </div>
		</div>
	</div>
</body>
</html>