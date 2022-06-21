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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/yoyaku")
public class yoyaku extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    public yoyaku() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        
		
		String text1 = "";	// テキスト1格納用変数
		String text2 = "";
		String text3 = "";
		String text4 = "";// テキスト2格納用変数
		
		// JSPの画面から値を取得
        /*
        指定のnameから値取得
        */
		text1 = request.getParameter("text1");
		text2 = request.getParameter("text2");
		text3 = request.getParameter("text3");
		text4 = request.getParameter("text4");
		

		
		
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
		final String SQL = "insert into yoyaku2(userid,syasyu,kasidasi,henkyaku) VALUES(?,?,?,?)";
		
        try(Connection conn = 
                DriverManager.getConnection(URL, USER, PASS)){

            conn.setAutoCommit(false);
    
            try(PreparedStatement ps = conn.prepareStatement(SQL)){
                ps.setString(1,text1);
                ps.setString(2,text2);
                ps.setString(3,text3);
                ps.setString(4,text4);
                
                ps.executeUpdate();
                conn.commit();
            
            } catch (Exception e) {
                conn.rollback();
                System.out.println("rollback");
                throw e;
            
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		
		


	

	}



}