<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아 어렵다</title>
</head>
<body>
<h1>
	<a href="index.jsp">아 어렵다</a>
</h1>
<div>
	사용자 : ${login.userid } 
</div>

<a href="${cpath }/login.jsp">로그인</a>
<a href="${cpath }/logout.jsp">로그아웃</a>
<a href="${cpath }/join.jsp">회원가입</a>
<a href="${cpath }/board.jsp">게시글</a>
</body>
</html>