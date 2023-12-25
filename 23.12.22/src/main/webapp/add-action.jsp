<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<jsp:useBean id="dto" class="bugs.BugsDTO" />
<jsp:setProperty property="*" name="dto"/>

<jsp:useBean id="dao" class="bugs.BugsDAO"/>
<!-- value 값을 저장하고 row에 담는다  -->
<c:set var="row" value="${dao.insert(dto) }" />

<c:if test="${row != 0 }">
	<c:redirect url="list.jsp" />
</c:if>

<!-- <p>
	<a href="add.jsp"><button>추가 실패</button></a>
</p> -->
<script> /* '추가'가 되지 않을시 그것을 보여주기 위해서 */
	alert('추가 실패')
	history.back();
</script>

</body>
</html>