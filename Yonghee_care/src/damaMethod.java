
public class damaMethod extends KVO implements idama {
	
	DAO2 dao = new DAO2();
	
	

   @Override
   // 놀기 선택 했을 때 경험치 +20 , 에너지-15
   public void roll() {
      setRudgjacl(rudgjacl + 20);
      setEnergy(energy - 15);
      System.out.println("용히랑 놀아주어서 고마워요 꺄르르");

   }

   // 청소 선택 했을 때 경험치 +30, 에너지-40
   @Override
   public void clean() {
      setRudgjacl(rudgjacl + 30);
      setEnergy(energy - 40);
      System.out.println("휴 깨끗해졌다!!");
   }

   // 운동 선택 했을 때 경험치 +40, 에너지 -30
   @Override
   public void exer() {
	   setRudgjacl(rudgjacl + 40);
      setEnergy(energy - 30);
      System.out.println("용히는 건강해져따!!");

   }

   // 밥 먹이기 선택 했을 떄 경험치+40, 에너지-30;
   @Override
   public void eat() {

      setRudgjacl(rudgjacl + 40);
      setEnergy(energy + 30);
      System.out.println("용히의 맘마타임~!");
   }

   // 잠자기 선택 했을 때 경험치+40, 에너지-30;
   @Override
   public void sleep() {
      setRudgjacl(rudgjacl + 40);
      setEnergy(energy + 30);
      System.out.println("용희는 코~ 하고 올게요...");
   }

// 경험치가 100일 때 레벨업 / 경험치 초기화
   @Override
   public void levelUp() {
      if (leb == 15) { // 만렙은 15
    	  System.out.println("용히 키우기 끝!");
      } else if (rudgjacl >= 100) {
         setLeb(leb + 1);
         
         setRudgjacl(rudgjacl - 100);

         System.out.println("용희 레벨업!!" + "현재 레벨은 " + leb);
         System.out.println();
      }
   }

   @Override
   public void energyDown() {
	     setEnergy(energy - 10);
   }

   // 에너지가 0이 되면 죽음
   @Override
   public boolean endGame() {

      if (getEnergy() <= -1000) {
         System.out.println("죽었다");
         return false;
      }else {
         return true;
      }
   }

// 현재 상태 확인
   @Override
   public void printInfo() {
      System.out.println("===용히 상태 확인===");
      System.out.println("experience: " + getRudgjacl());
      System.out.println("energy: "+ getEnergy() );
      System.out.println("leb: " + getLeb());
   }



}