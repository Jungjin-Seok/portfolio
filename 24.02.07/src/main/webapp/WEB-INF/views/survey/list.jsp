<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h3>설문 목록</h3>
	<nav>
		<ul>
			<li><a href="${cpath }/answer/list">설문결과목록</a></li>
		</ul>
	</nav>
	<c:if test="${not empty login }">
		<div>
			<p><a href="${cpath }/survey/insert"><button>설문 추가 하기</button></a></p>
		</div>
	</c:if>
	<table style="border: 1px solid white;">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
			</tr>	
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list }" >
			
			<tr>
				<td>${dto.idx }</td>
				<td><a href="${cpath }/survey/view/${dto.idx}">${dto.title }</a></td>
				<c:if test="${login.userid == 'admin' }">
					<td><a href="${cpath }/survey/delete"><button>삭제</button></a></td>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>


</body>
</html>