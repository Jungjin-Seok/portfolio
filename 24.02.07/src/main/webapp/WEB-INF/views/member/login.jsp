<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>로그인</h3>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="submit" value="로그인"></p>
	<p><a href="${cpath }/member/join">회원가입</a></p>
	<p><a href="${cpath }/member/resetpass">비밀번호변경</a></p>
</form>

</body>
</html>