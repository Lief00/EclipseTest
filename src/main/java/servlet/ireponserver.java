package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ireponserver")
public class ireponserver extends HttpServlet {
	


	private static final long serialVersionUID = 1L;

	public ireponserver() {
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try{
		    Class.forName("org.postgresql.Driver");
			    //
		}
		catch (ClassNotFoundException e) {
		    //
		}
		
		
		// 接続文字列の設定
		String url = "jdbc:postgresql://localhost:5432/testdb";
		String user = "postgres";
		String password = "pass";

		// SELECT文の作成・実行
		String sql = "SELECT * from test2";

		// PostgreSQLに接続
		String col1 = null;
		String col2 = null;
		String col3 = null;
		String col4 = "a";
		
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql);) {

			// 実行結果の取得
			while (result.next()) {
				col1 = result.getString(1);
				col2 = result.getString(2);
				col3 = result.getString(3);
				col4 = col4+ "   " +col1 + " " + col2 + " " + col3;
				
				System.out.println(col4);
			}
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("hoge", col4);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/irepon.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
