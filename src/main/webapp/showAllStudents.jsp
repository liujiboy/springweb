<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
key --> value<br>
<c:forEach var="student" items="${students}"> 
${student.key} --> (${student.value.id},${student.value.name}) <br> 
</c:forEach>
</body>
</html>