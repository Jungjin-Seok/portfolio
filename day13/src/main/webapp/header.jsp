<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>

<c:set var="cpath" value="${pageContext.request.contextPath }" />

<c:set var="dao" value="${MemberDAO.getInstance() }" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>MEMBER header</title>

<style>
	body{
		background-color: hotpink;
		font-size: 17px;
	}
	 header, section {
	 	background-color: hotpink;
	 	color: white;
	 	padding: 20px;
	 	box-sizing: boder-box;
	 }
	 h1, h2, h3, h4, h5, h6 ul{
	 	margin-top: 0;
	 	margin-bottom: 0; 
	 }
	 a {
	 	text-decoration: none;
	 	color: inherit;
	 }
	 a:hover {
	 	text-decoration: underline;
	 }
	 h1 {
		text-align: center;
	 }
	 nav > ul {
	 	display: flex;
	 	justify-content: space-between;
	 	padding-left: 0;
	 	list-style: none;
	 	width: 500px;
	 	margin: 20px auto;
	 }
	 table {
	 	border: 2px solid white;
	 	border-collapse: collapse;
	 	margin: 20px auto;
	 }
	 td,th {
	 	padding: 10px
	 }
	 tr {
	 	border-bottom: 1px solid white;
	 }
	 div#loginInfo {
	 	height: 23px;
	 }
</style>

</head>

<body>


<header>
		<h1><a href="${cpath }/header.jsp">회원 가입 및 목록(로그인,아웃)</a></h1>
	
	<div id="loginInfo">
		<c:if test="${not empty login }">
			<h4 align="right">현재 접속자 : ${login.userName }</h4>
		</c:if>
	</div>
	
	<div>
		<form action="list.jsp">
			<p><input type="search" name="search" placeholder="검색어 입력" value="${param.search }" autofocus /></p>
			<p><input type="submit" value="검색" /></p>
		</form>
	</div>
	
	<nav>
		<ul>
			<li><a href="${cpath }/list.jsp">목록</a></li>
			<li><a href="${cpath }/join.jsp">추가(회원가입)</a></li>
		
			<c:if test="${empty login }">
				<li><a href="${cpath }/login.jsp">로그인</a></li>
			</c:if>
		
			<c:if test="${not empty login }">
				<li><a href="${cpath }/logout.jsp">로그아웃</a></li>
			</c:if>
		</ul>
	</nav>
</header>


</body>
</html>