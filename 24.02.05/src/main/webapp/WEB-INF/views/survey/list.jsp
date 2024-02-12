<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>

<section>
	<h3>설문 목록</h3>
	
	<c:if test="${not empty login }">
		<div>
			<p><a href="${cpath }/survey/insert"><button>설문 추가 하기</button></a></p>
		</div>
	</c:if>
	
	<table>
		<c:forEach var="dto" items="${list }" >
			<tr>
				<td>${idx }</td>
				<td><a href="${cpath }/survey/info/{idx}">${title }</a></td>
				<c:if test="${idx == userid || userid == 'admin' }">
					<td><a hreabbr="${cpath }/survey/delete"><button>삭제</button></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</section>

</body>
</html>