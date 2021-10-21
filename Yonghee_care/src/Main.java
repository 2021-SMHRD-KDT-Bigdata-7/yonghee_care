import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
	}


	public static boolean login() {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		// 어떤 기능을 선택하더라도 dao에서 메소드를 호출하기 위함
		DAO dao = new DAO();
		boolean result = false;

		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >>");

			int menu = sc.nextInt();

			if (menu == 1) { /// 로그인
				while (true) {

					System.out.println("아이디를 입력하세요");
					String id = sc.next();
					System.out.println("비밀번호를 입력하세요");
					String pw = sc.next();

					String[] getidpw = dao.select(id, pw);
					if (getidpw[0] == id && getidpw[1] == pw) {
						result = true;
						break;
					}
				}

			} else if (menu == 2) {

				System.out.println("가입 아이디 : ");
				String id = sc.next();
				System.out.println("가입 비밀번호 : ");
				String pw = sc.next();

				// DAO클래스의 insert()에 접근하기위해 객체 생성
				int cnt = dao.insert(id, pw);

				if (cnt > 0) {
					System.out.println("가입완료! 어서와요");
				} else {
					System.out.println("가입실패,,저리가요");
				}
				continue;

			} else {
				System.out.println("프로그램 종료");
				break;

			}
		}
		return result;
	}
}