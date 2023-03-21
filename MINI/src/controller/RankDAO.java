package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.RankDTO;

public class RankDAO {
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

	public int getTimer(RankDTO dto) {
		int row = 0;
		try {
			getConn();

			String sql = "insert into rank_table values ( ? , ? )";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getNickname());
			psmt.setInt(2, dto.getTime());
			
			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	
	}

	public ArrayList<RankDTO> Ranking() {
		RankDTO dto = null;
		ArrayList<RankDTO>list = new ArrayList<RankDTO>();
		
		try {
			getConn();

			String sql = "SELECT time, nickname, RANK() OVER (ORDER BY time) AS RANKING FROM rank_table ORDER BY time ";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int ranking = rs.getInt("ranking");
				int time = rs.getInt("time");
				String nickname = rs.getString("nickname");
				dto = new RankDTO(ranking, nickname, time);
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;
	}

	
}
