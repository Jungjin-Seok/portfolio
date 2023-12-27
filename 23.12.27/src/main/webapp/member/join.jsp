<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<section>
	<form action="join-action.jsp">
		<p><input type="text" name="userId"		placeholder="ID" required /></p>
		<p><input type="password" name="userPw"	placeholder="PW" required /></p>
		<p><input type="text" name="userName"	placeholder="Name" required /></p>
		<p><input type="text" name="email"  	placeholder="Email" required /></p>
		<p>
			<select name="gender" required>
				<option value="">성별</option>
				<option value="남성">남성</option>
				<option value="여성">여성</option>
			</select>
		</p>
		<p><input type="submit"/></p>
	</form>
</section>


</body>
</html>