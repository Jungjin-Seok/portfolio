<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>

<h1>회원 가입 및 목록(로그인,아웃)</h1>
<hr>

<section>
	<div>
		<form action="list.jsp">
			<p><input type="search" name="search" placeholder="검색어 입력" value="${param.search }" autofocus /></p>
			<p><input type="submit" value="검색" /></p>
		</form>
	</div>
	
	<div>
		<a href="login.jsp"><button>로그인</button></a>
	</div>
	
	<div>
		<a href="join.jsp"><button>회원가입</button></a>
	</div>
	
	
</section>


</body>
</html>