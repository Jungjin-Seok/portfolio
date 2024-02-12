<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	
	<h3>설문 추가</h3>
	
	<form method="POST">
		<p><input type="text" name="title" placeholder="제목" required autofocus></p>
		<br>
		<p><input type="file" name="image1" placeholder="이미지1" required></p>
		<p><input type="text" name="question1" placeholder="항목1" required></p>
		<h4>VS</h4>
		<p><input type="file" name="image2" placeholder="이미지2" required></p>
		<p><input type="text" name="question2" placeholder="항목2" required></p>
		<p><input type="submit" value="확인"></p>
	</form>
	
</section>

</body>
</html>