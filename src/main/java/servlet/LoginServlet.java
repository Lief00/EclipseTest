package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public  class LoginServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    

    public LoginServlet() {
        super();
    }


    @Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user_id");
		String password =request.getParameter("password");
		
		try{
		    Class.forName("org.postgresql.Driver");
			    //
		}
		catch (ClassNotFoundException e) {
		    //
		}
		

		// ���[�U�[���瑗�M���ꂽ���[�U�[ID�ƃp�X���[�h���擾����B

		// ���O�C���F�،�ɑJ�ڂ������i�[����
		String path = "";

		try {
			// PostgreSQL�ɐڑ����邽�߂�URL
			String url = "jdbc:postgresql://localhost:5432/test1";
			String user = "postgres";
			String pass = "pass";
			String id = null;

			/*
			 * ���s����SQL
			 * id��password����v���郆�[�U�[��id���Ƃ��Ă���
			 */
			String sql = "SELECT * FROM user4 WHERE name = ? AND pass =?";

			// PostgreSQL�ɐڑ�����
			//Class.forName("org.postgresql.Driver");
			try (Connection con = DriverManager.getConnection(url,user, pass);
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				



				// ���͂��ꂽ���[�U�[ID�ƃp�X���[�h��SQL�̏����ɂ���
				pstmt.setString(1, userId);
				pstmt.setString(2, password);

				// SQL�̎��s
				ResultSet res = pstmt.executeQuery();
				
	

				// ���[�U�[ID�ƃp�X���[�h����v���郆�[�U�[�����݂�����
				if (res.next()) {
					// user_id�����N�G�X�g�X�R�[�v�ɐݒ肷��
					String name = res.getString("name");
					request.setAttribute("logined", "ログインしています"+"</p>"+"こんにちは！"+name+"さん！"+"</p>");
					// ログイン成功時
					path = "WEB-INF/jsp/hp2.jsp";
				} else {
					// ���O�C�����s�̕�����ǉ�����
					request.setAttribute("loginFailure", "ユーザーネームかパスワードが間違っています");

					// ログイン失敗時
					path = "WEB-INF/jsp/login.jsp";
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}