<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h3>회원가입</h3>
	
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="PW" required></p>
		<p><input type="text" name="username" placeholder="NAME" required></p>
		<p><input type="email" name="email" placeholder="abc@def2.com" required></p>
		<p>
			<label><input type="radio" name="gender" value="남성">남성</label>
			<label><input type="radio" name="gender" value="여성">여성</label>
		</p>
		<p><input type="submit" value="가입하기"></p>
	</form>
</section>

</body>
</html>