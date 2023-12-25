<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="ex03.UpdownGame"%>
<%@ page import="java.net.URLEncoder"%>

<h1>업다운 게임 처리</h1>
<hr>

<%! // 선언부 (미리 준비되어 있는 변수와 함수, 값이 유지된다)
	UpdownGame game = new UpdownGame();
%>

<%	// service()
	// 웹 프로그램으로써 수행해야할 전제적인 로직만 나타내고 있다(request, response)
	// 상세한 기능의 내용은 game 객체 내부에 메서드로 존재한다
	if(request.getParameter("reset") != null){
		game.reset();
		response.sendRedirect("ex03-form.jsp?msg="); // 302
		return;
		// 이후 코드를 수행하지 않는다
	}

	String user = request.getParameter("user");
	String msg = game.handle(user);

	String location = "ex03-form.jsp?msg=" + URLEncoder.encode(msg, "UTF-8");

	response.sendRedirect(location);

%>
