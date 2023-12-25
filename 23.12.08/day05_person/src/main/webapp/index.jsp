<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style>
 	div. nav {
 		width:100%;
 	}
 	div.nav > ul{
 		width: 900px;
 		margin: auto;
 		display: flex;
 		justify-content: center;
 		list-style: none;
 		padding: 0;
 	}
 	div.nav > ul > li {
 		text-align: center;
 		flex: 1;
 	}
 	a {
 		text-decoration: none;
 		color: grey;
 	}
 	a > button:hover {
 	 color: pink;
 	}
 	div.nav a {
 		display: block;
 	}
 	h1 {
 		text-align: center;
 	}
</style>
</head>

<body>
<h1>대문페이지</h1>
<hr>

<div class="nav">
	<ul>
		<li><a href="list.jsp"><button>인원관리</button></a></li>
	</ul>
</div>



</body>
</html>