<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath }/addPerson" method="POST" modelAttribute="person">
		
		LastName: <form:input path="lastName"/>
		<br><br>
		Email: <form:input path="email"/>
		<br><br>
		Birth: <form:input path="birthday"/>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>