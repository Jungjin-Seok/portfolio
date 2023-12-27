<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 목록</title>
</head>
<body>
<c:set var="list" value="${dao.selectAll(param.search) }"/>

<c:forEach var="dto" items="${list }">
	<h4>${dto.userid }</h4>
	<h4>${dto.userName }</h4>
	<h4>${dto.email }</h4>
	<h4>${dto.gender }</h4>
	
	<p><a href="view.jsp?userid=${dto.userid }"><button>상세조회</button></a></p>
	<p><a href="modify.jsp?userid=${dto.userid }"><button>수정</button></a></p>
	<p><a href="delete.jsp?userid=${dto.userid }"><button>삭제</button></a></p>
</c:forEach>

</body>
</html>