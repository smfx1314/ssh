<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户列表</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="screen" />
<script type="text/javascript">
	function del() {
	    var msg = "您确定要删除吗？";
	    if (confirm(msg) == true) {
	        return true;
	    } else {
	        return false;
	    }
	}
</script>
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
                 <form class="form-inline" action="${pageContext.request.contextPath }/emp_findByName.action" method="post">
                     <label>姓名:</label>&nbsp;&nbsp;<input class="form-control" type="text" name="userName">&nbsp;&nbsp;
                     <input class="btn btn-default" type="submit" value="查询" style="cursor:hand">
                     <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath }/emp_addPage.action">
                         <%--<span class="glyphicon glyphicon-zoom-in" ></span>--%>
                         添加用户
                     </a>
                 </form>
             </div>
         </div>
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
					  <th>所属部门</th>
					  <th>操作</th>
	              </tr>
	                 <c:forEach items="${list}" var="emp" >
	                  <tr>                  
	                      <th>${emp.eid }</th>
						  <th>${emp.eusername }</th>
						  <th>${emp.eage }</th>
						  <th>${emp.esex}</th>
						  <th>${emp.ecity}</th>
						  <th>${emp.dept.dname }</th>
	                      <th>
	                      	  <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath }/emp_addPage.action">
	                              <span class="glyphicon glyphicon-plus" ></span>  添加
	                          </a> 
	                          <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath }/emp_updatePage.action?eid=${emp.eid}">
	                              <span class="glyphicon glyphicon-pencil" ></span>  修改
	                          </a>
	                          <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath }/emp_delete.action?eid=${emp.eid}" onclick="del()">
	                              <span class="glyphicon glyphicon-trash" ></span>  删除
	                          </a> 
	                          
	                      </th>
	                  </tr>
	              </c:forEach>
	          </table> 
	       </div>
		</div>
	</div>
</body>
</html>