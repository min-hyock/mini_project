package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.QuizDTO;

public class QuizDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// 데이터베이스 연결
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_0306_5";
			String password = "smhrd5";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public QuizDTO getJava() {
		QuizDTO dto = null;
		Random ran = new Random();
		Set<Integer> set = new HashSet<>();

		try {
			getConn();

			String sql = "SELECT question, answer FROM quiz_table where n_question = ?";
			psmt = conn.prepareStatement(sql);

			while (set.size() < 78) {
				int n = ran.nextInt(1, 79);
				if (!set.contains(n)) {
					set.add(n);
					psmt.setInt(1, n);
					rs = psmt.executeQuery();
					while (rs.next()) {
						String question = rs.getString("question");
						String answer = rs.getString("answer");
						dto = new QuizDTO(question, answer);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}

	public QuizDTO getDB() {
		QuizDTO dto = null;
		Random ran = new Random();
		Set<Integer> set = new HashSet<>();

		try {
			getConn();

			String sql = "SELECT question, answer FROM quiz_table where n_question = ?";
			psmt = conn.prepareStatement(sql);

			while (set.size() < 55) {
				int n;
				do {
					n = ran.nextInt(79, 135);
				} while (set.contains(n));
				set.add(n);
				psmt.setInt(1, n);
				rs = psmt.executeQuery();
				while (rs.next()) {
					String question = rs.getString("question");
					String answer = rs.getString("answer");
					dto = new QuizDTO(question, answer);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}

	public QuizDTO getNun() {
		QuizDTO dto = null;
		Random ran = new Random();
		Set<Integer> set = new HashSet<>();
		int rangeMin = 135;
		int rangeMax = 170;

		try {
			getConn();

			String sql = "SELECT question, answer FROM quiz_table where n_question = ?";
			psmt = conn.prepareStatement(sql);

			while (set.size() < 36) {
				int n = ran.nextInt(rangeMax - rangeMin + 1) + rangeMin;
				if (!set.contains(n)) {
					set.add(n);
					psmt.setInt(1, n);
					rs = psmt.executeQuery();
					while (rs.next()) {
						String question = rs.getString("question");
						String answer = rs.getString("answer");
						dto = new QuizDTO(question, answer);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}
}
