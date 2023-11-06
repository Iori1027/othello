<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/othello.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="area">
		<div class="boad">
			<img
				src="${pageContext.request.contextPath}/images/game_reversi_board.png"
				alt="オセロボード" class="board">
			<form action="Othello" method="post">
				<div class="stones">
					<c:forEach var="x" begin="1" end="8" step="1">
						<c:forEach var="y" begin="1" end="8" step="1">
							<c:choose>
								<c:when test="${board.stones[x][y].color == 1}">
									<img
										src="${pageContext.request.contextPath}/images/game_reversi_black.png"
										style="--x:${x};--y:${y}" class="grid">
								</c:when>
								<c:when test="${board.stones[x][y].color == -1}">
									<img
										src="${pageContext.request.contextPath}/images/game_reversi_white.png"
										style="--x:${x};--y:${y}" class="grid">
								</c:when>
								<c:when test="${board.stones[x][y].color == 10}">
									<button type="submit" name="position" value="${x}${y}"
										style="--x:${x};--y:${y}" class="grid"></button>
								</c:when>

							</c:choose>
						</c:forEach>
					</c:forEach>
					<c:if test="${next.equals('com')}">
						<button type="submit" class="next" formmethod="post"
							formaction="Othello">次へ</button>
					</c:if>
				</div>
			</form>

		</div>
	</div>
</body>
</html>