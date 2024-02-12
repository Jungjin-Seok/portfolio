<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>결과</h1>
<hr>

<h3>${name } 님은  ${age } 살이고  ${adult } 입니다</h3>
<a href="${cpath }/ex02"><button>다시</button></a>
	
</body>
</html>