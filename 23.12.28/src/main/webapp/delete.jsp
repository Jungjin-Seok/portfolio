<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="row" value="${dao.delete(param.userId) }" />
${row }

<c:if test="${row != 0 }">
	<c:redirect url="/list.jsp" />
</c:if>

<script>
	alert('삭제 실패')
	history.go(-1)
</script>


</body>
</html>