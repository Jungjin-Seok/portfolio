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


<jsp:useBean id="dto" class="youtube.YouTubeDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${dao.update(dto) }" />

<h3>${row != 0 ? '성공' : '실패' }</h3>
<a href="${cpath }/view.jsp?idx=${dto.idx"><button>상세 페이지</button></a>


</body>
</html>