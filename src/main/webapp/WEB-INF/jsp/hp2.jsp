<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホームページ</title>
<style>

</style>
</head>
<body style="background: #DDDDDD">
<h1  style="text-align: center;">サンプルページ</h1>
<div style="text-align: right;">
<%String failureMessage = (String)request.getAttribute("logined"); %>

<!-- エラーメッセージが存在するときだけ表示する -->
<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>
<a href="HPServlet">ログアウト</a>



</div>
</body>
</html>