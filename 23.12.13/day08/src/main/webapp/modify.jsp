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

<c:set var="dto" value="${dao.selectOne(param.idx) }"/>
<section class="frame">
	<h3>수정</h3>
    <form action="modify-action.jsp">
    	<input type="hidden" name="idx" value="${dto.idx }">
    	<p>
    		<label><input type="radio" name="category" ${dto.category == '음악' ? 'checkde' : ""} value="음악" required >음악</label>
    		<label><input type="radio" name="category" ${dto.category == '뉴스' ? 'checkde' : ""} value="뉴스" required >뉴스</label>
    		<label><input type="radio" name="category" ${dto.category == '일상' ? 'checkde' : ""} value="일상" required >일상</label>
    		<label><input type="radio" name="category" ${dto.category == '게임' ? 'checkde' : ""} value="게임" required >게임</label>
    	</p>
    	<p><textarea name="title" placeholder="타이틀" value="${dto.title }" required></textarea></p>
		<p><input type="text" name="chName" placeholder="채널 이름" value="${dto.chName }" required></p>
		<p><input type="text" name="imgName" placeholder="그림파일이름" value="${dto.imgName }" required></p>
		<p><input type="text" name="videoTag" placeholder="영상태그" value="${dto.videoTag }" required></p>
		<p><input type="submit"></p>
    </form>
</section>

</body>
</html>