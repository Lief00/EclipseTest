<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<%String failureMessage = (String)request.getAttribute("loginFailure"); %>

<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>

<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<form action="Login">
	<p>ユーザーID</p>
	<input type="text" name="user_id">
	<p>パスワード</p>
	<input type="password" name="password">
	<p></p>
	<input type="submit" value="ログイン">
</form>
<form action="touroku2">
<input type="submit" value="登録">
</form>
</body>

</html>