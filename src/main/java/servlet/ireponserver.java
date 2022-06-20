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
		
		
	       final String URL = "jdbc:postgresql://127.0.0.1:5432/testdb10";
	        final String USER = "postgres";
	        final String PASS = "pass";
	        final String SQL = "insert into syain(id,name,romaji) VALUES(?,?,?)";
	        
	        
	
        

		// SELECT文の作成・実行
		String sql = "SELECT * from syain";
		

		// PostgreSQLに接続
		String col1 = null;
		String col2 = null;
		String col3 = null;
		String col4 = "ID name romaji";
		
   

		
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery(sql);) {
			
	

			// 実行結果の取得
			while (result.next()) {
				col1 = result.getString(1);
				col2 = result.getString(2);
				col3 = result.getString(3);
				col4 = col4+ "</p>" +col1 + " " + col2 + " " + col3+"	<form action=\"./ireponsearch\" method=\"post\">\r\n"
						+ "　　<input type=\"submit\" value=\"詳細検索\"><br>\r\n"
						+ "	</form>\r\n"
						+ "	<p></p>\r\n"
						+ "	\r\n"
						+ "	<form action=\"./irepondeleat\" method=\"post\">\r\n"
						+ "　　<input type=\"submit\" value=\"削除\"><br>\r\n"
						+ "    </form>";
				
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
