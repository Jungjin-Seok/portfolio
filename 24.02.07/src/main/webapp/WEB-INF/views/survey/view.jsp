<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>

	<h3>벨런스</h3>
	<br>
	
	<table>
		<tr>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<td>
				<a href="${cpath }/survey/result"><img src="${cpath }/upload/${dto.image1}"></a>
			</td>
			<td>${dto.question1 }</td>
		</tr>			
		<tr>
			<td>VS<td>
		</tr>
		<tr>
			<td>
				<a href="${cpath }/survey/result"><img src="${cpath }/upload/${dto.image2}"></a>
			</td>
			<td>${dto.question2 }</td>
		</tr>		
	</table>
</section>

</body>
</html>