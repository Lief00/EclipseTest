<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー追加</title>
</head>

<body>
	<form action="/irepon/ireponserver" method="Post">
		<p>ID：<input type="number" name="ID"></p>
		<p>姓名：<input type="text" name="Surname"></p>
		<p>名前：<input type="text" name="name"></p>
		<p>誕生日：<input type="text" name="birthday"></p>
		<p>出身地：<input type="text" name="birthplace"></p>
		<button type="submit">送信</button>
	</form>
</body>
</html>