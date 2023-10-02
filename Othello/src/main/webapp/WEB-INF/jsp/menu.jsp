<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/othello.css">
<meta charset="UTF-8">
<title>オセロ</title>
</head>
<body style="margin:0px">
<h1>オセロゲーム<h1>
	<div class="area">
		<div class="boad">
			<img
				src="${pageContext.request.contextPath}/images/game_reversi_board.png"
				alt="オセロボード" class="board">
			<div class="stones">
				<img
				src="${pageContext.request.contextPath}/images/game_reversi_black.png"
				style="--x:4;--y:4" class="grid">
				<img
				src="${pageContext.request.contextPath}/images/game_reversi_black.png"
				style="--x:5;--y:5" class="grid">
				<img
				src="${pageContext.request.contextPath}/images/game_reversi_white.png"
				style="--x:4;--y:5" class="grid">
				<img
				src="${pageContext.request.contextPath}/images/game_reversi_white.png"
				style="--x:5;--y:4" class="grid">
			</div>
		</div>
		</div>
		</p>
		<form method="get" action="?">
		<button type="submit" value="post" formaction="Setting">設定</button>
		<button type="submit" value="post" formaction="Othello">ゲーム開始</button>
		</a>
		</form>
</body>
</html>