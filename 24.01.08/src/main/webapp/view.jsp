<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<main>
	<c:set var="dto" value="${board2DAO.selectOne(param.idx) }" />
	<table id="boardview">
		<tr>
			<td>${dto.idx }. ${dto.title } (${dto.writer })</td>
		</tr>
		<tr>
			<td>조회수 : ${dto.viewCount }</td>
		</tr>
		<tr>
			<td>
				<c:if test="${not empty dto.image }">
					<img src="${cpath }/reviewImage/${dto.image}">
				</c:if>
				<pre>${dto.content }</pre>
			</td>
		</tr>
		<tr>
			<td>${dto.ipaddr} 에서  ${dto.writeDate }에 작성함</td>
		</tr>
	</table>
	
	<div class="sb">
		<div>
			<a href="${cpath }"><button>목 록</button></a>
		</div>
		<div>
			<a href="${cpath }/modify.jsp?idx=${dto.idx}"><button>수 정</button></a>
			<a href="${cpath }/delete.jsp?idx=${dto.idx}"><button>삭 제</button></a>
		</div>
	</div>

</main>









</body>
</html>