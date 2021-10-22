import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		// 어떤 기능을 선택하더라도 dao에서 메소드를 호출하기 위함
		DAO dao = new DAO();
		
		//로그인 객체 생성
		Login login = new Login();
		
		//상태확인을 위한 인터페이스 접근
//		idama id = null;
		damaMethod dm = new damaMethod();
		
		//게임플레이 객체생성
		
		
		boolean result = false;

		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >>");

			int menu = sc.nextInt();

			if (menu == 1) {
				//로그인
				if(login.login() == 1) {   //여기
					//로그인 성공 후 다마고치 키우기
					while(true) {
						PlayGame pg = new PlayGame();
						System.out.print("[1]다마고치등록 [2]다마고치키우기 [3]다마고치상태확인 [4]랭킹확인 [5]종료 >>");
						
						int menu2 = sc.nextInt();
						
						if(menu2 ==1) {
							pg.register();
						}else if(menu2 ==2) {
							pg.play();
						}else if(menu2 == 3) {
							//상태확인
							dm.printInfo();
						}else if(menu2 == 4) {
							//랭킹확인
							
						}else if(menu2 == 5) {
							break;
						}else {
							System.out.println("다시입력하세요");
						}
					}
			
				}else {
					continue;
				}
				break;
			} else if (menu == 2) {
				//회원가입
				login.join();
				
			} else {
				System.out.println("프로그램 종료");
				break;

			}
		}	
		
		

	}

}
