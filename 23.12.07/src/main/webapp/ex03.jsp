<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
<style>
	#root {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		display: flex;
		flex-flow: column;
		justify-content: center;
		align-items: center; 
		background-color: #f5f6f7;
	}
</style>
</head>
<body>

<%--
	request Method
	GET
	POST
	PUT
	PATCH
	DELETE
	HEAD
	OPTIONS
	
	
	response status code
	200(ok)
	301/302 (redirect) 				재요청
	4xx
	-401 (unauthorized)				권한이 없음
	-403 (forbidden)				접근 거부
	-404 (not found)				파일을 찾지 못함
	-405 (unsupported method)		HTTP 요청 메서드가 잘못된 경우
	5xx (server internal error)		서버 오류
	
	multi-user
	Account = 계정	
	*계정 구조의 3가지 요소
	- Identification	식별
	- Authentication	인증
	- Authorization		허가
	
	계정 -> 권한
	
	
	1) error-page(directive)
	2) response status code (web.xml)
	3) exception-type (web.xml)

 --%>



<div id="root">
<h1>Page Not Found</h1>
<img src="img/짱구.png">
<h3>잘못된 주소입니다</h3>
</div>

</body>
</html>