<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p>
		<select name="searchType" required>
			<option value="">== 검색 유형을 선택하세요 ==</option>
			<option ${param.searchType == 'category' ? 'selected' : ''} value="category">버거</option>
			<option ${param.searchType == 'category' ? 'selected' : ''} value="category">음료</option>
		</select>
		<input type="search" name="searchKeyword"
		 placeholder="검색어를 입력합니다"
		 value="${param.searchKeyword }">
		<input type="submit" value="검색">
	</p>
</form>

<section class="frame">
	<div>
		<a href="${cpath }/add"><button>추가</button></a>
	</div>	
	
	
	<div class="box">
		<c:forEach var="dto" items="${list }">
		<div class="item">
			<div class="img">
				<a href="${cpath }/view/${dto.idx}">
				<img src="${cpath }/resources/image/${dto.imgname}" height="120"></a>
			</div>
			<div class="name">${dto.name }</div>
			<div class="price">${dto.price } 원</div>
		</div>	
	</c:forEach>
	</div>		
	
</section>

</body>
</html>