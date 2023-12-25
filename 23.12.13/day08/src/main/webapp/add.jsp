<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section class="frame">
	<h3>항목 추가</h3>
	
	<form action="add-action.jsp">
		<p>
			<label><input type="radio" name ="category" value="음악" required>음악</label>
			<label><input type="radio" name ="category" value="뉴스" required>뉴스</label>
			<label><input type="radio" name ="category" value="일상" required>일상</label>
			<label><input type="radio" name ="category" value="게임" required>게임</label>
		</p>
		<p><textarea name="title" placeholder="타이틀" required></textarea></p>
		<p><input type="text" name="chName" placeholder="채널 이름" required></p>
		<p><input type="text" name="imgName" placeholder="그림파일이름" required></p>
		<p><input type="text" name="videoTag" placeholder="영상태그" required></p>
		<p><input type="submit"></p>
	</form>
	
	
</section>
	
	
</body>
</html>