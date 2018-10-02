<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = this.href;
			$("#hiddenForm").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<body>

	<form action="" method="POST" id="hiddenForm">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<br>
	<form action="emps" method="GET">
		<table border="0" cellPadding="3" cellSpacing="0">
		    <tr>
		        <th>姓名</th>
		        <td>
		            <input type="text" name="search_LIKES_lastName" />
		        </td>
		        <th>邮箱</th>
		        <td>
		            <input type="text" name="search_LIKES_email" />
		        </td>
		        <th>生日</th>
		        <td>
		            <input type="text" name="search_EQD_birth" />
		        </td>
		        <th>部门</th>
		        <td>
		            <input type="text" name="search_LIKES_department.departmentName" />
		        </td>
		        <th>
		            <button onclick="document.forms[1].submit();">查询</button>
		        </th>
		    </tr>
		</table>
	</form>
	<br><br>

	<c:if test="${empty page.content }">
		没有任何记录
	</c:if>
	<c:if test="${! empty page.content }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>Id</td>
				<td>LastName</td>
				<td>Email</td>
				<td>Birth</td>
				<td>CreateTime</td>
				<td>Department</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach items="${page.content }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>
						<fmt:formatDate value="${emp.birth }" pattern="yyyy-MM-dd"/>
					</td>
					<td>
						<fmt:formatDate value="${emp.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="emp/${emp.id}" class="delete">Delete</a></td>
					<td><a href="emp/${emp.id}">Edit</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
				          共 ${page.totalElements } 条记录 
					&nbsp;&nbsp;
					当前第 ${page.number + 1 } 页/共 ${page.totalPages } 页
					&nbsp;&nbsp;
				    <a href="emps?pageNo=1&${queryString }">首页</a>
					&nbsp;&nbsp;
					<c:if test="${!page.firstPage }">
						<a href="emps?pageNo=${page.number + 1 - 1 }&${queryString }">上一页</a>
						&nbsp;&nbsp;
					</c:if>
					<c:if test="${!page.lastPage }">
						<a href="emps?pageNo=${page.number + 1 + 1 }&${queryString }">下一页</a>
						&nbsp;&nbsp;
				    </c:if>
				    <a href="emps?pageNo=${page.totalPages }&${queryString }">末页</a>
				    &nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</c:if>
	
	<br><br>
    <a href="${pageContext.request.contextPath }/emp">Add New Employee</a>

</body>
</html>