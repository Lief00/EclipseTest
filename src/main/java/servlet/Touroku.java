package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class Touroku extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public Touroku() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        
		
		String text1 = "";	// テキスト1格納用変数
		String text2 = "";	// テキスト2格納用変数
		
		// JSPの画面から値を取得
        /*
        指定のnameから値取得
        */
		text1 = request.getParameter("text1");
		text2 = request.getParameter("text2");
		
		// 取得した値をコンソールに出力
		System.out.println(text1);
		System.out.println(text2);
		

		
		
		try{
		    Class.forName("org.postgresql.Driver");
			    //
		}
		catch (ClassNotFoundException e) {
		    //
		}
		
		
		// 接続文字列の設定
		String URL = "jdbc:postgresql://localhost:5432/test1";
		String USER = "postgres";
		String PASS = "pass";
		final String SQL = "insert into user4(name,pass) VALUES(?,?)";
		
        try(Connection conn = 
                DriverManager.getConnection(URL, USER, PASS)){

            conn.setAutoCommit(false);
    		if((text1 == "")||(text2 == "")){
    			request.setAttribute("non", "ユーザーネームかパスワードが入力されていません");
    			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/UserTourokuE.jsp");
    			dispatcher.forward(request, response);
    		}else {
            
            try(PreparedStatement ps = conn.prepareStatement(SQL)){
                ps.setString(1,text1);
                ps.setString(2,text2);
                
                ps.executeUpdate();
                conn.commit();
            
            } catch (Exception e) {
                conn.rollback();
                System.out.println("rollback");
                throw e;
            }
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		
		


		// SELECT文の作成・実行
		String sql = "SELECT * from user4";

		// PostgreSQLに接続
		String col1 = null;
		String col2 = null;
		String col3 = null;
		String col4 = "a";
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql);) {

			// 実行結果の取得
			while (result.next()) {
				col1 = result.getString(1);
				col2 = result.getString(2);
				col3 = result.getString(3);
				col4 = col4+ "   " +col1 + " " + col2 + " " + col3+"</p>";
				
				System.out.println(col4);
			}
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("hoge", col4);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



    @Override
    public String getServletInfo() {
        return "Short description";
    }
}