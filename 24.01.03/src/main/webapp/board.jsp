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
<jsp:useBean id="dto" class="board.BoardDTO" />
<jsp:s	etProperty property="*" name="dto"/>
<c:set var="list" value="${BoardDAO.selectList(dto) }" />


<a href="${cpath }write.jsp"><button>게시글 작성</button></a>
<a></a>
</body>
</html>