import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO2 {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	

	//DB연결
	public void getConn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_2_4_1022";
			String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("연결 오류발생!!!!");
			e.printStackTrace();
		}
	}

	//DB연결 종료
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

	//회원정보 입력
	public int insert(String id, String pw) {

		getConn();
		int result = 0;
		
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
		int result = 0;
		
		try {

			String sql = "select * from user_info where id=? and pw=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			while(rs.next()) {
				
				if (rs != null) {
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
	
	//상태확인
	public int selectstate(String nick) {
		
		getConn();
		int result = 0;
		try {
			
			String sql = "select * from dama where nick=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nick);
			
			rs = psmt.executeQuery();
			System.out.println("\n====(*용희*) 상태확인=====\n");
			
			while(rs.next()) {
				
				String getNick = rs.getString(1);
				int getLeb = rs.getInt(4);
				int getEnergy = rs.getInt(5);
				int getRudgjacl = rs.getInt(3);
				String getDama_date = rs.getString(7);

				System.out.println("NICK : " + getNick );
				System.out.println("LEVEL : "+ getLeb);
				System.out.println("ENERGY : " + getEnergy);
				System.out.println("EXP : " + getRudgjacl);
				System.out.println("Date : " + getDama_date);
				
				System.out.println();
				
				if (rs != null) {
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
	

 
	//어따썼는지를 모르겠어요
	public int selectnick(String nick) {
		
		getConn();
		int result = 0;
		
		try {
			
			String sql = "select * from dama where nick=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nick);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getNick = rs.getString(1); // 숫자는 컬럼의 순서
				
				System.out.println(getNick);
				
				if (rs != null) {
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

	
	//나의 모든 캐릭터 출력
	public int selectchar(String id) {
		
		getConn();
		int result = 0;
		try {
			// 실행할 sql문 작성
			
			String sql = "select * from dama where id=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String getId = rs.getString(6); // 숫자는 컬럼의 순서\
				String getNick = rs.getString(1);
				int getLeb = rs.getInt(4);
				int getEnergy = rs.getInt(5);
				String getDama_date = rs.getString(7);
				
				
				System.out.println("ID : " + getId + "\t" + "NICK : " + getNick + "\t" + "LEVEL : "
						+ getLeb + "\t" + "date : " + getDama_date);
				
				if (rs != null) {
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

	
	// 순위 메소드
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
//            String getNeeds = rs.getString(8);

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

	// 다마고치 등록 메소드
	public int insertreg(String id, String nick, String xkdlq) {

		getConn();
		int result = 0;
		String sql = "insert into dama(nick,xkdlq,rudgjacl,leb,energy, id) values(?,?,0,1,100,?)";

		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, nick);
			psmt.setString(2, xkdlq);
			psmt.setString(3, id);

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결 종료
			close();
		}

		return result;
	}

	// 다마 죽었을 때 캐릭 삭제
	public void deletedama(String nick) {
		getConn();

		try {
			String sql = "delete from dama where nick=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();

		}
	}
	
	//level update
	//다시
	public int lebupdate(String nick , int leb, int rudgjacl) {

		getConn();
		int result = 0;
		try {
			String sql = "update dama set leb=?, rudgjacl=? where nick=?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1,leb);
			psmt.setInt(2,rudgjacl);
			psmt.setString(3, nick);

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close();
		}

		return result;
	}
	
	//energy update
	//다시
	public int energyupdate(String nick , int energy) {

		getConn();
		int result = 0;
		try {
			String sql = "update dama set energy=? where nick=?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1,energy);
			psmt.setString(2, nick);

			result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close();
		}

		return result;
	}
}
