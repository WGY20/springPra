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
<jsp:include page="./nav.jsp"></jsp:include>
	<h2>Modify Account Form</h2>
	<form action="<c:url value='/admin/modifyAccountConFirm'></c:url>" name="modifyAccountConFirm" method="get">
		<input type="hidden" name="a_id" value="${adminLoginedDto.a_id}"/> <br>
		<input type="text" name="a_id" value="${adminLoginedDto.a_id}" readonly disabled/> <br>
		<input type="text" name="a_password" value="*******" readonly disabled/> <br>
		<input type="text" name="a_name" value="${adminLoginedDto.a_name}"/> <br>
		<input type="text" name="a_phone" value="${adminLoginedDto.a_phone}"/> <br>
		<input type="submit" value="modify account">
		<input type="reset" value="reset">
	</form>
</body>
</html>