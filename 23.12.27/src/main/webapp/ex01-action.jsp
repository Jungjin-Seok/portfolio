<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-action.jsp</title>
</head>
<body>

<%
	// 파라미터를 받아오기 전에 GET은 주소창을 통해서 전달하기 때문에 인코딩을 별도로 설정하지 않아도 글자깨짐 현상이 없다
	// POST는 주소창을 통하지 않아서, 별도의 인코딩 형식을 지정해야 글자를 정상적으로 받을 수 있다
	// 파라미터는 request객체에 담겨서 넘어오기 때문에 request의 인코딩규칙을 지정한 후 파라미터를 꺼낸다
	// GET,POST는 request.getParameter로 처리가능 처리가 가능하다는건 EL TAG : ${param.userid},useBean Tag : <jsp:useBean/>도 처리 가능
	// POST 일 때, 파라미터를 꺼내기 전에 인코딩을 먼저 맨 위에 설정 한다
	
	request.setCharacterEncoding("UTF-8");
	
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	String encoding = request.getCharacterEncoding();
	
	
%>

<h3>userid : <%=userid %></h3>
<h3>userpw : <%=userpw %></h3>
<h3>encoding : <%=encoding %></h3>

<table border="1" cellpadding="10" cellspacing="0">
	<thead>
		<tr>
			<th>request method</th>
			<th>parameter</th>
			<th>SQL</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>GET</td>
			<td>-</td>
			<td>select * from ...</td>
		</tr>
		<tr>
			<td>GET</td>
			<td>query String</td>
			<td>
				select * from ... where id = {query String } <br>
				delete from ... where id = {query String} <br>
			</td>
		</tr>
		<tr>
			<td>POST</td>
			<td>from-data</td>
			<td>
				insert into ... values({form-data}) <br>
				update ... set column = {form-data} <br>
			</td>
		</tr>
	</tbody>
</table>

</body>
</html>