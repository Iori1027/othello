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
プレイヤー1 名前<input type="text" name="firstPlayerName">
 <input type="radio" name="firstProperty" value="Computer" id="select_radio1"><label for="select_radio1">コンピュータ</label>
 <input type="radio" name="firstProperty" value="Person" id="select_radio2"><label for="select_radio2">プレイヤー</label></p>
プレイヤー2 名前<input type="text" name="SecondPlayerName">
 <input type="radio" name="SecondProperty" value="Computer" id="select_radio3"><label for="select_radio3">コンピュータ</label>
 <input type="radio" name="SecondProperty" value="Person" id="select_radio4"><label for="select_radio4">プレイヤー</label>
<input type="submit" value="送信">
</form>
<a href="Main">
戻る
</a>
</body>
</html>