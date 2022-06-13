<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欅坂46</title>
</head>

<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>氏名</th>
			<th>生年月日</th>
			<th>出身地</th>
		</tr>
		<tr>
			<% 
			 // 接続文字列の設定
	        String url = "jdbc:postgresql://localhost:5432/testdb" ;
	        String user = "postgres" ;
	        String password = "pass" ;

	        // SELECT文の作成・実行
	        String sql = "SELECT * from public.keyakizaka" ;

	        // PostgreSQLに接続
	        try (Connection con = DriverManager.getConnection ( url, user, password );
	                Statement stmt = con.createStatement();
	                ResultSet result = stmt.executeQuery ( sql ); ) {

	            // 実行結果の取得
	            while ( result.next() ) {
	            	String col1 = result.getString ( 1 ) ;
	                String col2 = result.getString ( 2 ) ;
	                String col3 = result.getString ( 3 ) ;
	                String col4 = result.getString ( 4 ) ;
	                String col5 = result.getString ( 5 ) ;
			%>
			<th><%=col1 %></th>
			<th><%=col2 %></th>
			<th><%=col3 %></th>
			<th><%=col4 %></th>
			<th><%=col5 %></th>
			<%  }
	        } catch ( SQLException e ) {
	          e.printStackTrace() ;
	      }%>
		</tr>
	</table>
</body>

</html>