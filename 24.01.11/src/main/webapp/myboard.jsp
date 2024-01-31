<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<main>
	<h3>내가 쓴 글</h3>
	<c:set var="list" value="${board2DAO.selectListByWriter(login.userid) }" />
	
	<table id="boardList">
		<thead>
			<tr>
			 	<th>번호</th>
			 	<th>제목</th>
			 	<th>작성자</th>
			 	<th>조회수</th>
			 	<th>날짜</th>
			 	<th>삭제 여부</th>
			</tr>
		</thead>

	<c:forEach var="dto" items="${list }">
	<tbody>
		<tr>
			<td>${dto.idx }</td>
			<td>
				<a href="${cpath }/view.jsp?idx=${dto.idx}">
					${dto.title }
					${not empty dto.image ? '📁' : '' }
				</a>
			</td>
			<td>${dto.writer }</td>
			<td>${dto.viewCount }</td>
			<td>${dto.writeDate }</td>
			<td>
				${dto.deleted == 1 ? '✖' : '✔' }
			</td>
		</tr>
		
	</tbody>	
	</c:forEach>
	</table>
	
</main>







</body>
</html>