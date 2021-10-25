import java.util.Random;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();


		// 어떤 기능을 선택하더라도 dao에서 메소드를 호출하기 위함
		DAO2 dao = new DAO2();
		KVO kvo = new KVO();
		Regi regi = new Regi();
		PlayGame pg = new PlayGame();
		// 로그인 객체 생성
		Login login = new Login();

		
		kvo.id = null;;  //id가 업데이트가 안돼서 해줌
		kvo.pw = null;
		kvo.nick = null;

		// 게임플레이 객체생성

		boolean result = false;

		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >>");

			int menu = sc.nextInt();

			if (menu == 1) {
				// 로그인

				System.out.println("아이디를 입력하세요");
				kvo.id = sc.next();
				System.out.println("비밀번호를 입력하세요");
				kvo.pw = sc.next();

		
				if (dao.select(kvo.id, kvo.pw)) {
					// 로그인 성공 후 다마고치 선택
					while (true) {

						System.out.print("[1]다마고치등록 [2]기존 다마고치불러오기  >>");

						int menu2 = sc.nextInt();

						if (menu2 == 1) {
							regi.register();
							continue;

						} else if (menu2 == 2) {
							//선택한 캐릭터 불러오기
							if (dao.selectchar(kvo.id)) {
								System.out.println("선택할캐릭터의 닉네임을 입력해주세요 >>>");
								kvo.nick = sc.next();
								if(dao.selectnick(kvo.nick)) break;
								else continue;
							} else {
								break;
							}
						}
						while (true) {
							System.out.println(kvo.nick + "을/를 키워줄 메뉴를 골라주세요.");
							System.out.print("[1]다마고치키우기 [2]다마고치 상태확인 [3]랭킹확인 [4]종료 >>");
							int menu3 = sc.nextInt();
							if (menu3 == 1) {
								pg.play();
								
								//죽으면 캐릭터 삭제
								if (pg.endGame() == false) {
									dao.deletedama(kvo.nick);
									break;
								}
								
								pg.levelUp();
								dao.lebupdate(kvo.nick, kvo.getLeb());

							} else if (menu3 == 2) {
								// 상태확인
								dao.selectstate(kvo.nick);
							} else if (menu3 == 3) {
								// 랭킹확인
								dao.selectAll();
							} else if (menu3 == 4) {
								break;
							} else {
								System.out.println("다시입력하세요");
							}
						}

					}
				}else {
					continue;
				}
			} else if (menu == 2) {
				// 회원가입
				login.join();

			}else if (menu == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("다시입력하세요");
			} 

		}

	}
}
