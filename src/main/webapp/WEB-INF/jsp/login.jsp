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
<form action="Login" method="post">
	<input type="text" name="user_id">
	<input type="password" name="password">
	<input type="submit" value="ログイン">
</form>
</body>
</html>