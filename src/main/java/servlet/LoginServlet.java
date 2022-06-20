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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public  class LoginServlet  {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	/**
	 * �����Ă������[�U�[ID�ƃp�X���[�h������DB�ɐڑ������O�C���F�؂��s��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ���[�U�[���瑗�M���ꂽ���[�U�[ID�ƃp�X���[�h���擾����B
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		// ���O�C���F�،�ɑJ�ڂ������i�[����
		String path = "";

		try {
			// PostgreSQL�ɐڑ����邽�߂�URL
			String url = "jdbc:postgresql://localhost:5432/test1";
			String user = "postgres";
			String pass = "pass";

			/*
			 * ���s����SQL
			 * id��password����v���郆�[�U�[��id���Ƃ��Ă���
			 */
			String sql = "SELECT id FROM users WHERE id=? AND password=?";

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
					request.setAttribute("user_id", res.getString("id"));

					// ���O�C��������ʂɑJ�ڂ���
					path = "irepon.jsp";
				} else {
					// ���O�C�����s�̕�����ǉ�����
					request.setAttribute("loginFailure", "���O�C���Ɏ��s���܂���");

					// ���O�C���Ɏ��s�����Ƃ��͂�����x���O�C����ʂ�\������
					path = "login.jsp";
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}