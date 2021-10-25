import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		DAO dao = new DAO();
		KVO kvo = new KVO();
		Regi regi = new Regi();
		PlayGame pg = new PlayGame();
		Login login = new Login();

		kvo.id = null;
		kvo.pw = null;
		kvo.nick = null;
		String id =null;
		String pw = null;

		// 寃뚯엫�뵆�젅�씠 媛앹껜�깮�꽦

		boolean result = false;

		while (true) {
			System.out.print("[1]로그인 [2]회원가입 [3]종료 >> ");

			int menu = sc.nextInt();

			if (menu == 1) {
				// 濡쒓렇�씤

				System.out.print("ID >> ");
				kvo.id = sc.next();
				System.out.print("PASSWORD >> ");
				kvo.pw = sc.next();

				int cnt = dao.select(kvo.id, kvo.pw);
				
				if (cnt == 1) {
					// 濡쒓렇�씤 �꽦怨� �썑 �떎留덇퀬移� �꽑�깮
					while (true) {

						System.out.print("[1]등록 [2]불러오기 >> ");

						int menu2 = sc.nextInt();

						if (menu2 == 1) {
							regi.register(kvo.id);
							continue;

						} else if (menu2 == 2) {
							// �꽑�깮�븳 罹먮┃�꽣 遺덈윭�삤湲�
							int cnt2 = dao.selectAll(kvo.id);
							if (cnt2 == 1) {
								System.out.print("캐릭터를 선택하세요 >> ");
								kvo.nick = sc.next();
								int cnt3 = dao.selectDama(kvo.nick);
								if (cnt3 == 1)
									break;
								else
									continue;
							} else {
								break;
							}
						}
					}
					System.out.println(kvo.nick + "이(가) 등장했습니다.");
					while (true) {
						System.out.print("[1]"+kvo.nick+" 키우기 [2]"+kvo.nick+" 상태확인 [3]랭킹확인 [4]종료 >> ");
						int menu3 = sc.nextInt();
						if (menu3 == 1) {
							pg.play();

							// 二쎌쑝硫� 罹먮┃�꽣 �궘�젣
							if (pg.endGame() == false) {
								dao.deletedama(kvo.nick);
								break;
							}

							pg.levelUp();
//							dao.lebupdate(kvo.nick, kvo.getLeb());

						} else if (menu3 == 2) {
							// �긽�깭�솗�씤
							dao.selectstate(kvo.nick);
						} else if (menu3 == 3) {
							// �옲�궧�솗�씤
					
							dao.selectRank();
						} else if (menu3 == 4) {
							break;
						} else {
							System.out.println("다시 입력 하세요");
						}
					}

				} else {
					continue;
				}
			} else if (menu == 2) {
				// �쉶�썝媛��엯
				login.join();

			} else if (menu == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("다시 입력 하세요");
			}

		}

	}
}
