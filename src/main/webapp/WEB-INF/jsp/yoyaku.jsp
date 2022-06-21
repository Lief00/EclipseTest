<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP inputForm</title>
    </head>
    <body>
        


        <%-- GETメソッドでテキストを送信 --%>
        <form action="./yoyaku">
            <p>ユーザーID：<input type="text" name="text1"></p>
            <p>車種：<input type="text" name="text2"></p>
            <p>貸出日：<input type="date" name="text3"></p>
            <p>返却日：<input type="date" name="text4"></p>

            <input type="submit" value="予約">
        </form>
        



    </body>
</html>