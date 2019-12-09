<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextroot" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eShopping</title>
</head>
<body>
	${contextroot } says -${greeting} 
</body>
</html>