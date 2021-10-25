import java.util.Random;
import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	
	int cnt = 0;
	
	DAO dao = new DAO();

	//�븘�슂�뾾�쓬
	public int login(String id, String pw) {

		/// 濡쒓렇�씤

//		System.out.println("�븘�씠�뵒瑜� �엯�젰�븯�꽭�슂");
//		String id = sc.next();
//		System.out.println("鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂");
//		String pw = sc.next();

		cnt = dao.select(id, pw);
		
		dao.close();
		return cnt;
	}
	

	public boolean join() {
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.print("비번을 입력하세요 : ");
		String pw = sc.next();

		// DAO�겢�옒�뒪�쓽 insert()�뿉 �젒洹쇳븯湲곗쐞�빐 媛앹껜 �깮�꽦
		int cnt = dao.insert(id, pw);

		if (cnt > 0) {
			System.out.println("가입완료");
			return true;

		} else {
			System.out.println("가입실패");
			return false;
		}
	}
}