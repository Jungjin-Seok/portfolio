<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day07</title>
</head>
<body>

<header>
	<h1><a href="${cpath }">day07</a></h1>
	<div>
		<c:if test="${empty login }">
			<a href="${cpath }/member/login">로그인</a>
			<a href="${cpath }/member/join">회원가입</a>
		</c:if>
		<c:if test="${not empty login}">
			${username }님 환영합니다.
			<a href="${cpath }/member/logout">로그아웃</a>
		</c:if>
	</div>

	<div>
		<c:if test="${userid == 'admin'}">
			<a href="${cpath }/member/list">멤버 목록</a>
		</c:if>		
	</div>

	<nav>
		<ul>
				<li><a href="${cpath }/survey/list">설문목록</a></li>
				<li><a href="${cpath }">설문결과</a></li>
			<c:if test="${not empty login }">
				<li><a href="${cpath }">설문등록</a></li>
				<li><a href="${cpath }">설문참여</a></li>
			</c:if>
		</ul>
	</nav>
</header>

</body>
</html>