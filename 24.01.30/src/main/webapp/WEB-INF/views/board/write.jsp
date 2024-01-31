<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
	form, h3 {
		display: flex;
		justify-content: center;
	}
	input[type=submit] {
		border-radius: 50px;
		background-color: black;
		color: white;
	}
	input[type=submit]:hover{
		cursor: pointer;
	}
</style>

<h3>게시글 작성</h3>

<form method="POST">
	<table>
		<tr>
			<td><input type="text" name="title" placeholder="제목" required ></td>
		</tr>
		<tr>
			<td><input type="text" name="writer" placeholder="${login.userid }" readonly></td>
		</tr>
		<tr>
			<td><textarea name="content" placeholder="내용을 작성하세요" 
							style="resize:none; width: 600px; height: 200px;"></textarea></td>
		</tr>
		
		<c:if test="${login.userid == 'admin' }">
			<tr>
				<td>
					<label>
						<input type="checkbox" name="isNotice" value="1" 
								${login.userid != 'admin' ? 'disabled' : '' }>
								공지로 등록하기
					</label>
				</td>
			</tr>
		</c:if>
	</table>
	
	
	<input type="submit" value="작성완료">
</form>

</body>
</html>