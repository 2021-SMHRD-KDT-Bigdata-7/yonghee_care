import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;

   int result = 0;

   // DB연결

   public void getConn() {

      try {

         Class.forName("oracle.jdbc.driver.OracleDriver");

         String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
         String user = "cgi_2_4_1022";
         String password = "smhrd4";
         conn = DriverManager.getConnection(url, user, password);

      } catch (Exception e) { // Exception클래스 : 어떠한 오류라도 발생했을 때 catch!

         System.out.println("연결 오류발생!!!!");

         e.printStackTrace();

      }
   }

   // DB종료

   public void close() {
      try {

         if (rs != null) {
            rs.close();
         }
         if (psmt != null) {
            psmt.close();
         }
         if (conn != null) {
            conn.close();
         }
      } catch (SQLException e) {

         e.printStackTrace();
      }
   }

   // 회원가입 아이디 비밀번호 입력

   // 회원 정보 Insert 메소드

   public int insert(String id, String pw) {

      // insert를 하기위해서는 데이터베이스 연결이 필요 -> 연결메소드 호출(getConn())
      getConn();

      // try~catch로 오류를 잡아 줘야함
      String sql = "insert into user_info values(?,?)";

      try {

         psmt = conn.prepareStatement(sql);

         psmt.setString(1, id);
         psmt.setString(2, pw);

         result = psmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         // 데이터베이스 연결 종료
         close();
      }

      return result;
   }

   // 로그인
   // 회원 정보 Select 메소드

   public int select(String id, String pw) {

      getConn();

      try {
         // 실행할 sql문 작성

         String sql = "select * from user_info where id=? and pw=?";

         psmt = conn.prepareStatement(sql);

         psmt.setString(1, id);
         psmt.setString(2, pw);

         rs = psmt.executeQuery();

         
         while (rs.next()) {
            String getId = rs.getString(1); // 숫자는 컬럼의 순서
            String getPw = rs.getString(2);

            System.out.println(getId + "/" + getPw);
            
            
            if(rs != null) {
               result = 1; 
            }
         }
      } catch (Exception e) {

         e.printStackTrace();

      } finally {
         close();
      }
      return result;
   }
   

   public void selectAll() {

      getConn();

      try {
         String sql = "Select * from DAMA order by leb desc";

         psmt = conn.prepareStatement(sql);

         rs = psmt.executeQuery();
         int num = 1;

         while (rs.next()) {
            String getNick = rs.getString(1);
            String getxkdlq = rs.getString(2);
            int getrudgjacl = rs.getInt(3);
            int getLeb = rs.getInt(4);
            int getEnergy = rs.getInt(5);
            String getId = rs.getString(6);
            String getDama_date = rs.getString(7);
            String getNeeds = rs.getString(8);

            System.out.println(num + "등" + "\t" + "ID : " + getId + "\t" + "NICK : " + getNick + "\t" + "LEVEL : "
                  + getLeb + "\t" + "EXP : " + getrudgjacl + "\t");
            num++;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         // 3.데이터베이스 닫아주기
         close();
      }

   }
   

//   public int insertreg(String nick, String xkdlq, int rudgjacl, int leb, int energy) {
   public int insertreg(String nick, String xkdlq) {
      // insert를 하기위해서는 데이터베이스 연결이 필요 -> 연결메소드 호출(getConn())
            getConn();

            // try~catch로 오류를 잡아 줘야함
            String sql = "insert into dama(nick,xkdlq,rudgjacl,leb,energy) values(?,?,0,1,100)";

            try {

               psmt = conn.prepareStatement(sql);

               psmt.setString(1, nick);
               psmt.setString(2, xkdlq);
               
               result = psmt.executeUpdate();

            } catch (Exception e) {
               e.printStackTrace();
            } finally {
               // 데이터베이스 연결 종료
               close();
            }

            return result;
   }

}