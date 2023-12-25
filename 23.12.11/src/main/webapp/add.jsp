<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>추가</h3>
<form action="add-action.jsp">
	<p><input type="text" name="name" placeHolder="이름"></p>
	<p><input type="text" name="pnum" placeHolder="전화번호"></p>
	<p><input type="text" name="age" placeHolder="나이" min="0" max="100" required></p>

	<p>
	 <label><input type="radio" name="favorite" value="Y">Y</label>
	 <label><input type="radio" name="favorite" value="N" checked>N</label>
	</p>
	<p><input type="submit"></p>
</form>


</body>
</html>