<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="dto" value="${dao.selectOne(param.userId) }" />
<section>
	<h3>modify.jsp</h3>
	<form method="POST"  action="modify-action.jsp">
		<p><input type="text" name="userId"		value="${dto.userId }" required readonly ></p>
		<p><input type="password" name="userPw"	value="${dto.userPw}" required autofocus ></p>
		<p><input type="text" name="userName"	value="${dto.Name}" required ></p>
		<p><input type="text" name="email"  	value="${dto.email }" required ></p>
		<p>
			<label><input type="radio" name="gender" value="남성" ${dto.gender == '남성' ? 'checked' : '' }required>남성</label>
			<label><input type="radio" name="gender" value="여성" ${dto.gender == '여성' ? 'checked' : '' }required>여성</label>
		</p>
		<p><input type="submit" value="수정"></p>
	</form>
</section>


</body>
</html>