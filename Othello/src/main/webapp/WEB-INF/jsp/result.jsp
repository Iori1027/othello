<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/othello.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<c:out value="白 = ${white}、黒 = ${black} で" />
<c:out value="${winner.name}の勝ち"/>
</h1>
<jsp:include page="board.jsp"/>
<a href="Main"> 戻る </a>
</body>
</html>