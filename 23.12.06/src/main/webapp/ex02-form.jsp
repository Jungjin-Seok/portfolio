<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-form.jsp</title>
</head>
<body>

<h1>업다운 게임 입력 / 출력</h1>
<hr>

<form action="ex02-action.jsp">
	<input type="number" name="user" min="1" max="100" required autofocus>
	<input type="submit">
	<a href="ex02-action.jsp?reset=true"><input type="button" value="재시작"></a>
</form>

<%--출력할 메시지 공간 --%>
<h3><%=request.getParameter("msg") %></h3>

</body>
</html>