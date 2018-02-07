<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工信息</title>
</head>
<body>
	<div style="padding:3px 2px;border-bottom:1px solid #ccc">修改员工信息</div>
	<form id="updatePage" action="${pageContext.request.contextPath }/emp_update.action" method="post">
		<table>
			<tr>
				<!-- <td>编号:</td> -->
				<td><input type="hidden" name="eid" value="${emp.eid }"></input></td>
			</tr>
			<tr>
				<td>部门:</td>
				<td>
					<select name="dept.did">
						<c:forEach items="${list }" var="dept">
							<option value="${dept.did }"<c:if test="${dept.did==emp.dept.did }">selected</c:if>>${dept.dname }</option>
						</c:forEach>					
					</select>
				</td>
			</tr> 
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="eusername" value="${emp.eusername }"></input></td>
			</tr>
			<tr>
				<td>年龄:</td>
				<td><input type="text" name="eage" value="${emp.eage }"></input></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<input type="radio" name="esex" value="${emp.esex }" <c:if test="${emp.esex }=='男' ">checked</c:if>>男</input>
					<input type="radio" name="esex" value="${emp.esex }" <c:if test="${emp.esex }=='女' ">checked</c:if>>女</input>
				</td>
			</tr>
			<tr>
				<td>城市:</td>
				<td><input type="text" name="ecity" value="${emp.ecity }"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="保存"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>