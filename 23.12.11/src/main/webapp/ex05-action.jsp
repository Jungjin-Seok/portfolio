<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex05-action.jsp</title>
</head>
<body>

<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String adult = age >= 20 ? "성인" : "미성년자";
	
	String msg = String.format("%s님은 %d살이고, %s 입니다", name, age, adult);
	
	request.setAttribute("msg", msg);
//  	requst.getRequestDispatcher("ex05-result.jsp").forward(request, response);
%>

<jsp:forward page="05-result.jsp"/> --%>

</body>
</html>