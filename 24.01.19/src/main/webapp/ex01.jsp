<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>ex01.jsp</h1>
<hr>

<h3>jsp (model 1)의 장단점</h3>

<ul>
	<li>HTML 과 JAVA 코드를 함께 사용할 수 있다</li>
	<li>JAVA코드를 편리하게 사용하기 위한 라이브러리가 있다 (EL/JSTL)</li>
	<li>개발 로직과 화면 구성을 동시에 수행할 수 있다 (개발이 빠르다)</li>
</ul>

<ul>
	<li>사이트 규모가 커지면, 파일 관리가 어려워진다</li>
	<li>개발 로직과 화면 구성을 동시에 수행할 수 있다 (유지보수가 까다롭다)</li>
	<li>HTML과 JAVA코드를 분리하여 처리 및 표현을 별도로 개발하는 편이 더 좋다</li>
</ul>
<hr>

<style>
	#wrap{
		width: 500px;
		height: 500px;
		top: 50px;
		color: white;
		margin:auto;
		background-color: black;
		position: relative;
		font-size: 50px;
		border-radius: 50px;
	}
	.item1, .item2, .item3 {
		position: absolute;
		top: 80px;;
		left: 70px;
		width: 300px;
		height: 300px;
		background-color: red;
		color: white;
		font-size: 20px;
		z-index: 2;
		padding: 23px;
		box-sizing: border-box;
		border-radius: 20px 120px 20px 120px;
	}
	.item2 {
		top: 130px;
		left: 120px;
		z-index: 3;
		background-color: pink;
	}
	.item3 {
		top: 180px;
		left: 180px;
		z-index: 4;
		background-color: blue;
	}
</style>


<div id="wrap">
	JSP
	<div class="item1">Model(Database)</div>
	<div class="item2">View(HTML)</div>
	<div class="item3">Controller(Java)</div>
</div>

</body>
</html>