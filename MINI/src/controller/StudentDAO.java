package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.StudentDTO;

public class StudentDAO {

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
      }

   }

   // 회원가입 메소드
   public int join(StudentDTO dto) {

      int row = 0;

      try {
         getConn();

         String sql = "INSERT INTO STUDENT_TABLE VALUES (?, ?)";

         psmt = conn.prepareStatement(sql);

         psmt.setString(1, dto.getId());
         psmt.setString(2, dto.getPw());

         row = psmt.executeUpdate();

      } catch (Exception e) {
      } finally {
         getClose();
      }

      return row;
   }

   // 로그인 메소드

   public String login(StudentDTO dto) {

      String uName = null;

      try {
         getConn();

         String sql = "SELECT * FROM STUDENT_TABLE WHERE STUDENT_ID = ? AND STUDENT_PW = ?";

         psmt = conn.prepareStatement(sql);

         psmt.setString(1, dto.getId());
         psmt.setString(2, dto.getPw());

         rs = psmt.executeQuery();
         if (rs.next() == true) {
            uName = rs.getString("STUDENT_ID");
         }

      } catch (Exception e) {
      } finally {
         getClose();
      }
      return uName;

   }

}