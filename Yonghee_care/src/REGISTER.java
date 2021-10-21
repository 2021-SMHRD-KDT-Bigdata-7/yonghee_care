import java.util.Random;
import java.util.Scanner;

public class REGISTER{
	public void register() {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		while(true) {
			
			System.out.print("[1]다마고치등록 [2]다마고치키우기 [3]다마고치상태확인 [4]랭킹확인 [5]종료 >>");
			
			int menu = sc.nextInt();
			
			if(menu ==1) {
				System.out.println("다마고치등록");
				System.out.print("별명등록 >>");
				String nick = sc.next();
				
				while(true) {
					
					System.out.print("종류(용희 or 기현 or 형호 or 승지 or 혜인 or 태현)등록 >>");
					String type = sc.next();
					if(type == "용희") {
						//아이디 위치에 맞는 별명 등록, 종류 등록
						break;
					}else {
						System.out.println("용히가 키워지고 찌뿐뎅 ㅠㅠ");
					}
				}
			}else if(menu ==2) {
				System.out.println("용히 키우기!!");
				String[] Ycare = {"밥먹이기", "잠재우기", "놀아주기", "운동하기","방치우기"};
				String Ycare2 = Ycare[rd.nextInt(5)+1];
				
				//용희캐릭터
				while(true) {
					System.out.println("용히는 뭐하고시풀까용? 히~");
					System.out.println("[1]밥먹이기 [2]잠재우기 [3]놀아주기 [4]운동하기 [5]방치우기 >>" );					
					int menu2 = sc.nextInt();
					//하고싶은거 맞추기 if()문
					if( Ycare2 != "밥먹이기") {
						System.out.println("용히는 배가 고푼뎁,,, ");
						continue; //수민쌤이 맞다고 했음 틀리면 수민쌤책임
					}else {
						//정답- 경험치 40 에너지 ±30
						
					}
					
				}
				
				
			}else if(menu == 3) {
				//상태확인
			}else if(menu == 4) {
				//랭킹확인
			}else if(menu == 5) {
				break;
			}else {
				System.out.println("다시입력하세요");
			}
			
		}
	}
}
