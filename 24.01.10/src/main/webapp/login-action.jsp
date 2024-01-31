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

<jsp:useBean id="dto" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="login" value="${memberDAO.login(dto) }" scope="session" />
<c:if test="${not empty login }">
	<c:redirect url="/" />
</c:if>

<script>
	alert('로그인실패')
	history.go(-1)
</script>
</body>
</html>