<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<h3>게시판</h3>
<hr>

<table border="1" cellpadding="10" cellspacing="0">
	<c:set var="list" value="${boardDAO.selectList() }" />
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.title }</td>
			<td>${dto.writer }</td>
			<td>${dto.writeDate }</td>
		</tr>
	</c:forEach>
</table>



<div style="display: flex; width: 800px; margin: auto; justify-content: space-between; ">
	<div>
	
	</div>	
	<div>
		<a href="${cpath }/write.jsp"><button>작성</button></a>
	</div>
</div>

</body>
</html>