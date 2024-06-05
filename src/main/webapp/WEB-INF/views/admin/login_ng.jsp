<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin Login Failed!!</h2>
	<ul>
		<li>
			<a href="<c:url value='/admin/createAccountForm'></c:url>">create account form</a>
		</li>
		<li>
			<a href="<c:url value='/admin/loginForm'></c:url>"> login</a>
		</li>
	</ul>
</body>
</html>