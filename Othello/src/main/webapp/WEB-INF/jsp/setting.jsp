<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>設定</title>
</head>
<body>
<form action="Setting" method="post">
プレイヤー1名前<input type="text" name="firstPlayerName">
プレイヤー1COM Y<input type="radio" name="firstProperty" value="Computer">N<input type="radio" name="firstProperty" value="Person">
プレイヤー1名前<input type="text" name="SecondPlayerName">
プレイヤー1COM Y<input type="radio" name="SecondProperty" value="Computer">N<input type="radio" name="SecondProperty" value="Person">
<input type="submit" value="送信">
</form>
<a href="Main">
戻る
</a>
</body>
</html>