<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<section>
	<h3>login.jsp</h3>
	<form method="POST" action="${cpath }/login-action.jsp">
		<p><input type="text" name="userId" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userPw" placeholder="Password" required></p>
		<p><input type="submit" value="로그인"></p>
	</form>
</section>


</body>
</html>