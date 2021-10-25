import java.util.Random;
import java.util.Scanner;

public class Login {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();

	
	int cnt = 0;
	
	DAO2 dao = new DAO2();

	//필요없음
	public int login(String id, String pw) {

		/// 로그인

//		System.out.println("아이디를 입력하세요");
//		String id = sc.next();
//		System.out.println("비밀번호를 입력하세요");
//		String pw = sc.next();

		cnt = dao.select(id, pw);
		
		dao.close();
		return cnt;
	}
	

	public boolean join() {
		System.out.println("가입 아이디 : ");
		String id = sc.next();
		System.out.println("가입 비밀번호 : ");
		String pw = sc.next();

		// DAO클래스의 insert()에 접근하기위해 객체 생성
		int cnt = dao.insert(id, pw);

		if (cnt > 0) {
			System.out.println("가입완료! 어서와요");
			return true;

		} else {
			System.out.println("가입실패,,저리가요");
			return false;
		}
	}
}