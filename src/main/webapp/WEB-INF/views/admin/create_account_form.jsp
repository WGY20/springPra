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
	<h2>Sign Up</h2>
	<form action="<c:url value='/admin/createAccountConFirm'></c:url>" method="post">
		<input type="text" name="a_id" placeholder="Input Admin Id"/> <br>
		<input type="text" name="a_password" placeholder="Input Admin password"/> <br>
		<input type="text" name="a_password_again" placeholder="Input password again"/> <br>
		<input type="text" name="a_name" placeholder="Input name"/> <br>
		<input type="text" name="a_phone" placeholder="Input phone"/> <br>
		<input type="submit" value="create account">
		<input type="reset" value="reset">
	</form>
</body>
</html>