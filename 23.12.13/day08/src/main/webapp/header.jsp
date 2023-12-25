<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
	a	{
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: none;
	}
	.frame {
		width: 900px;
		margin: 0 auto;
		border: 1px dashed pink;
	}
	header {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	nav > ul {
		display: flex;
		width: 300px;
		list-style: none;
		padding: 0;
	}
	nav > ul > li {
		display: flex;
	}
	div.box {
		display: flex;
		flex-flow: wrap;
		margin: auto;
	}
	div.item {
		box-sizing: border-box;
		width: 200px;
		margin: 10px;
		padding: 10px;
		text-align: center;
	}
	div.detail {
		display: flex;
		flex-flow: column;
		justify-content: center;
		align-items: center;
		text-align: center;
	}
	div.sb {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
</style>
</head>
<body>

<header class="frame">
	<h3><a href="#">≡</a></h3>
	<a>
		<img src="logo.png">
	</a>
	<div>검색</div>
	<nav>
		<ul>
			<li><a href="${cpath }/list.jsp">전체</a></li>
			<li><a href="${cpath }/list.jsp?category=음악">음악</a></li>
			<li><a href="${cpath }/list.jsp?category=뉴스">뉴스</a></li>
			<li><a href="${cpath }/list.jsp?category=일상">일상</a></li>
			<li><a href="${cpath }/list.jsp?category=게임">게임</a></li>
		</ul>
	</nav>
</header>


</body>
</html>