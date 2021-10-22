import java.sql.Date;
import java.util.Scanner;

public class Regi {
   Scanner sc = new Scanner(System.in);
   DAO dao = new DAO();
   KVO kvo = new KVO();
   String nick;
   String xkdlq;

   int cnt=0;
   
   public void register() {

      System.out.println("다마고치등록");
      System.out.print("별명등록 >>");
      nick = sc.next();

      while (true) {

         System.out.print("종류(용희 or 기현 or 형호 or 승지 or 혜인 or 태현)등록 >>");
         xkdlq = sc.next();
         
         if (xkdlq.equals("용희")) {
            // 아이디 위치에 맞는 별명 등록, 종류 등록
            break;
         } else {
            System.out.println("용히가 키워지고 찌뿐뎅 ㅠㅠ");
         }

      }
      cnt = dao.insertreg(nick,xkdlq);
      
      if (cnt > 0) {
         System.out.println("저장 완료");
      } else {
         System.out.println("저장 실패");
      }

   }

}