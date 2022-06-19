<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP inputForm</title>
    </head>
    <body>
        <p>ユーザー登録</p>
        
        <%
		String col = (String) request.getAttribute("non");
        out.println(col);
		%>

        <%-- GETメソッドでテキストを送信 --%>
        <form action="./FormServlet">
            <p>ユーザーネーム：<input type="text" name="text1"></p>
            <p>パスワード：<input type="text" name="text2"></p>
            <input type="submit" value="登録">
        </form>
        <p> </p>
            <form action="./FormServlet">
            <input type="submit" value="戻る">
        </form>



    </body>
</html>