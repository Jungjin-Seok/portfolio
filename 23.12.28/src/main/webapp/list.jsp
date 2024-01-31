<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 목록</title>
</head>
<body>

<section>
	<h3>list.jsp</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Email</th>
			</tr>		
		</thead>
		
		<tbody>
			<c:set var="list" value="${dao.selectAll(param.search) }"/>

			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.userId }</td>
					<td>${dto.userPw }</td>
					<td>${dto.userName }</td>
					<td>${dto.gender }</td>
					<td>${dto.email }</td>
					<td>
						<a href="${cpath }/modify.jsp?userId=${dto.userId}"><button>수정</button></a>
						<a class="deleteLink" href="${cpath }/delete.jsp?userId=${dto.userId}">
							<button>삭제</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</section>


<script>
		const deleteHandler = function(event) { // 발생한 행위가 event
		event.preventDefault()		// event의 기본작동을 막는다
									// a를 클릭했을 때 기본작동(페이지 이동)을 막아버린다
		const flag = confirm('정말 삭제 하시겠습니까')	// 삭제할지 물어보고 대답에 따라 ture/false저장
		if(flag) {									
			// 클릭당한 태그 요소가 event.target
			// 클릭당한 요소는 button이며, button의 상위요소는 a태그, 
			// parentNode : 상위 속성을 찾는것
			const a = event.target.parentNode
			//a의 href속성으로 이동시킨다
			location.href = a.href
		}	
	}
	
	// 문서 내부의 a태그 중에서 클래스가 deleteLink인 모든 요소를 불러와서
	const aList = document.querySelectorAll('a.deleteLink')
	
	//aList내부의 각 요소를 a라고 할 때, a를 클릭하면 실행되는 함수 자리에 deleteHandler를 할당한다
	aList.forEach(a => a.onclick = deleteHandler)
</script>




</body>
</html>