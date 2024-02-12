<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day07</title>
<style>
	body {
		background-color: black;
		color: white;
	}
</style>
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
			${login.username }님 환영합니다.
			<a href="${cpath }/member/logout">로그아웃</a>
		</c:if>
	</div>

	<div>
		<c:if test="${login.userid == 'admin'}">
			<a href="${cpath }/member/list">멤버 목록</a>
		</c:if>		
	</div>

	<nav>
		<ul>
			<li><a href="${cpath }/survey/list">설문목록</a></li>
		</ul>
	</nav>
</header>

</body>
</html>