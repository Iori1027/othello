<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/othello.css">
<meta charset="UTF-8">
<title>オセロ</title>
</head>
<body>
	<h1>
	<c:if  test="${board.turn == 1}">
	<img src="${pageContext.request.contextPath}/images/game_reversi_black.png" style="width:20px"><c:out value="${player1.name}" />のターン<img src="${pageContext.request.contextPath}/images/game_reversi_black.png" style="width:20px">
	</c:if>
	<c:if  test="${board.turn == -1}">
	<img src="${pageContext.request.contextPath}/images/game_reversi_white.png" style="width:20px"><c:out value="${player2.name}" />のターン<img src="${pageContext.request.contextPath}/images/game_reversi_white.png" style="width:20px">
	</c:if>
	</h1>
	<jsp:include page="board.jsp"/>
	<form action="?" method="?">
	<button type="submit"  class="next" formmethod="post" formaction="Othello">送る</button>
	<button type="submit" formmethod="get" formaction="Main">メニューへ</button>
	</form>
</body>
</html>