<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day04-header.jsp</title>
<style>
	header, section {
		width: 900px;
		margin: auto;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day04</a></h1>
	<div id="login" style="heigth: 40px; text-align: right; font-size: 24px;">
		<c:if test="${not empty login }">
			<p>
				ヾ(•ω•`)o  ${login.username }님   ヾ(•ω•`)o
				<a href="${cpath }/member/logout"><button>로그아웃</button></a>
			</p>
		</c:if>
	</div>
	
	<nav>
		<ul style="display: flex; padding: 0; list-style: none; justify-content: space-around;">
			<li><a href="${cpath }/member/list">회원목록</a></li>
			<li><a href="${cpath }/member/login">로그인</a></li>
			<li><a href="${cpath }/board/list">게시판</a></li>
		</ul>
	</nav>
	
	
	
</header>
