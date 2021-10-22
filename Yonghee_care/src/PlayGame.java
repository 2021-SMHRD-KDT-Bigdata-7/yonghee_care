import java.util.Random;
import java.util.Scanner;

public class PlayGame extends damaMethod {

//   private static idama idama;
   Scanner sc = new Scanner(System.in);
   Random rd = new Random();

   damaMethod dm = new damaMethod();

   // 다마고치 등록

   
   public void printInfo() {
      dm.printInfo();
   }
   
   // 다마고치 키우기
   public void play() {

      System.out.println("용히 키우기!!");
      String[] Ycare = { "밥먹이기", "잠재우기", "놀아주기", "운동하기", "방치우기" };
      int num = rd.nextInt(5);
//      String Ycare2 = Ycare[rd.nextInt(5)];
      boolean flag = true; // 와일문 빠져나오기 위한 불리언 값
      int stack = 0; // 두번째 틀렸을 시 에어지 깍기 위한 스택 (노형호가 a 라고 함)

      // 용희캐릭터
      while (flag) {
         System.out.println("용히는 뭐하고시풀까용? 히~");
         System.out.println("[1]밥먹이기 [2]잠재우기 [3]놀아주기 [4]운동하기 [5]방치우기 >>");
         int menu2 = sc.nextInt();

         // 하고싶은거 맞추기 if()문

         // 밥먹이기
         if (Ycare[num] == ("밥먹이기")) {
            if (Ycare[num] == Ycare[menu2 - 1]) {
               // 정답- 경험치 40 에너지 ±30
               dm.eat();
               flag = false; // while문 빠져나가기
            } else {
               System.out.println("용히는 배가 고푼뎁,,, ");
               if (stack == 1) {
                  // 에너지 깍기
//                  idama.energyDown();
                  flag = false;
               }
               stack++;
               continue; // 수민쌤이 맞다고 했음 틀리면 수민쌤책임
            }
         } else if (Ycare[num] == ("잠재우기")) {
            // 잠재우기
            if (Ycare[num] == (Ycare[menu2 - 1])) {
               // 정답- 경험치 40 에너지 ±30
               dm.sleep();
               flag = false;

            } else {
               System.out.println("용히는 조용희있고 시푼뎁,,,");
               if (stack == 1) {
                  // 에너지 깍기
                  dm.energyDown();
                  flag = false;
               }
               stack++;
               continue; // 수민쌤이 맞다고 했음 틀리면 수민쌤책임
            }
         } else if (Ycare[num] == ("놀아주기")) {
            // 놀아주기
            if (Ycare[num] == (Ycare[menu2 - 1])) {
               // 정답- 경험치 40 에너지 ±30
               dm.roll();
               flag = false;
            } else {
               System.out.println("용히는 띰띰해욤,,,");
               if (stack == 1) {
                  // 에너지 깍기
                  dm.energyDown();
                  flag = false;
               }
               stack++;
               continue; // 수민쌤이 맞다고 했음 틀리면 수민쌤책임

            }
         } else if (Ycare[num] == ("운동하기")) {
            if (Ycare[num] == (Ycare[menu2 - 1])) {
               // 정답- 경험치 40 에너지 ±30
               dm.exer();
               flag = false;
            } else {
               System.out.println("용히는 씩씩!! 건강!! ");
               if (stack == 1) {
                  // 에너지 깍기
                  dm.energyDown();
                  flag = false;
               }
               stack++;
               continue; // 수민쌤이 맞다고 했음 틀리면 수민쌤책임

            }
         } else if (Ycare[num] == ("방치우기")) {
            if (Ycare[num] == (Ycare[menu2 - 1])) {
               // 정답- 경험치 40 에너지 ±30
               dm.clean();
               flag = false;
            } else {
               System.out.println("용히 똥 쌌어요 ㅠㅠ 치워쥬쎄욤 ");
               if (stack == 1) {
                  // 에너지 깍기
                  dm.energyDown();
                  flag = false;
               }
               stack++;
               continue; // 수민쌤이 맞다고 했음 틀리면 수민쌤책임

            }
         } else {
            System.out.println("다시입력하세요");
         }

      }

   }

}