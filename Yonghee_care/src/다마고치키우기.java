
public class 다마고치키우기 implements idama{
  
   private int experience = 0;
   private int energy = 0;
   private int lv = 1;
   private int lvsum = 0;

   @Override
   public void roll() {
      if() {
         experience += 20;
         energy -=15;
         System.out.println("용히랑 놀아주어서 고마워요 꺄르르");
      }else {
         experience -= 10;
         System.out.println("용히는 띰띰한뎅,,,");
      }
      
   }

   @Override
   public void clean() {
      if() {
         energy -= 25;
         System.out.println("휴 깨끗해졌다!!");
      }else {
         experience -= 15;
         System.out.println("나 죽어....");
      }
      
   }

   @Override
   public void exer() {
      if() {
         experience += 20; 
         energy -= 15;
         System.out.println("용히는 건강해져따!!");
      }else {
         experience -= 10;
         System.out.println("고지혈증에 한 걸음 다가선 용히");
      }
      
   }

   @Override // 경험치가 100일 때 레벨업
   public void levelUp() {
         if(lv==15) { // 만렙은 15
        	 System.out.println("용히 키우기 끝!");
         }else if(experience >= 100) {
        	 lv ++;
        	 experience = 0;
        	 lvsum += 1;
        
        	 System.out.println("용희 레벨업!!"+"현재 레벨은"+lv);
         }
   }
   @Override // 경험치가 낮아졌을 때 레벨 다운
   public void levelDown() {
	   if(experience<0) {
		   System.out.println("용히 레벨 다운 ㅠㅠ");
		   experience = 0;
		   lv--;
		   lvsum -= lv;
	   }
   }

   @Override
   public boolean endGame() {
      //죽었을 때
	   if(lv<1) {
		   System.out.println("죽었다");
	   }
		   
      return false;
   }


@Override
   public void printInfo() {
      System.out.println("===용히 상태 확인===");
      System.out.println("experience: " + experience);
      System.out.println("energy: " + energy);
      System.out.println("lv: " + lvsum);
   }

   @Override
   public void eat() {
      if() {
         experience += 40;
         energy += 30;
         System.out.println("용히의 맘마타임~!");
      }else {
         energy -= 25;
         System.out.println("용히는 배가 고푼뎁,,,");
      }
      
   }

   @Override
   public void sleep() {
      if() {
         experience += 20;
         energy += 30;
         System.out.println("용희는 코~ 하고 올게요...");
      }else {;
         energy -= 30;
         System.out.println("용히는 조용희 혼자 있고 시푼뎁,,, ");
      }
      
   }
   
   

   
   
   
}
	


