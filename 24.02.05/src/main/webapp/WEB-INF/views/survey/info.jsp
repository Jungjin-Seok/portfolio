<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h3>벨런스 : ${dto.idx }</h3>
	<br>
	
	<table id="info">
		<tr>${dto.title }</tr>
		<tr>
			<td>${dto.image1 }</td>
			<td>${dto.question1 }</td>
			<td><a><button>선택</button></a></td>
		</tr>
		
		<h2>VS</h2>
		
		<tr>
			<td>${dto.image2 }</td>
			<td>${dto.question2 }</td>
			<td><a><button>선택</button></a></td>
		</tr>
	</table>
</section>

</body>
</html>