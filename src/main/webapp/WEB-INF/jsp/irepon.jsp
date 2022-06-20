<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>46</title>
</head>

<body>
<p>入力確認テスト</p>
<input type="date">


	<%
	
        String col = (String) request.getAttribute("hoge");
        out.println(col);
		

	
	%>
	

    <p></p>
	
	<form action="./ireponadd" method="post">
 	<input type="text" value="ID"> <input type="text" value="name"> <input type="text" value="romaji">
　　<input type="submit" value="追加"><br>
    </form>
    
    <form action="./ireponupdate" method="post">
 	<input type="text" value="変更前ID"> <input type="text" value="ID"> <input type="text" value="name"> <input type="text" value="romaji">
　　<input type="submit" value="更新"><br>
    </form>


	
	


</body>

</html>