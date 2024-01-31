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
			<c:if test="${dto.writer == login.userid }">
				<a href="${cpath }/modify.jsp?idx=${dto.idx}"><button>수 정</button></a>
			
				<a class="deleteBtn"
				   idx="${dto.idx }" 
			   	   href="${cpath }/delete.jsp?idx=${dto.idx}"><button>삭 제</button></a>
			</c:if>
		
		</div>
	</div>
</main>



<script>
	// const = 상수(값을 바꿀 수 없다)
	// let = (값을 바꿀 수 있다)
	// 문서 전체에서 a태그 중에서 클래스가 deleteBtn인 모든 요소를 nodeList 형태로 불러온다
	const deleteBtnList = document.querySelectorAll('a.deleteBtn')
	
	// 이벤트 함수를 정의한다
	const deleteHandler = function(event) {
		event.preventDefault()		// 이벤트 기본 작동을 막는다 (a의 기본 작동: 링크 페이지 이동)
		let target = event.target	// 이벤트 대상을 target에 저장한다
		
		// 클릭된 요소의 클래스에 deleteBtn이 포함되어 있지 않다면 반복을 수행한다
		while(target.classList.contains('deleteBtn') == false){
			target = target.parentNode	// 현재 target의 상위 요소 (부모 노드)를 target에 저장한다
		}
		
		
		const idx = target.getAttribute('idx')					//	target의 idx를 저장한다, 문자열 형식으로 들고온다
		const url = target.href									//	target의 href를 저장한다
		const flag = confirm(idx + '번 게시글을 삭제하시겠습니까?')		//	사용자에게 확인/취소 묻기
		if(flag){												//	만약, 확인을 클릭했으면
			location.href = url									//	브라우저의 주소창을 < a href="">의 값으로 변경한다 (페이지 이동)
		}
	}
	
	// 3) deleteBtnList의 모든 요소를 element라고 할때, element를 클릭하면 deleteHandler가 실행되도록 연결한다
	deleteBtnList.forEach(element => element.onclick = deleteHandler)
</script>







</body>
</html>