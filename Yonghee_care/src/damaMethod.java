
public class damaMethod extends Acc implements idama {
 
	int lv = 1;
	Acc acc = new Acc();
	
//	public damaMethod() {
//		
//	}
//
//	public damaMethod(int experience, int energy, int lv) {
//		super();
//		this.experience = experience;
//		this.energy = energy;
//		this.lv = lv;
//	}

	@Override
	// 놀기 선택 했을 때 경험치 +20 , 에너지-15
	public void roll() {
		acc.exp += 20;
		acc.energy -= 15;
		System.out.println("용히랑 놀아주어서 고마워요 꺄르르");

	}

	// 청소 선택 했을 때 경험치 +30, 에너지-40
	@Override
	public void clean() {
		acc.exp += 30;
		acc.energy -= 40;
		System.out.println("휴 깨끗해졌다!!");
	}

	// 운동 선택 했을 때 경험치 +40, 에너지 -30
	@Override
	public void exer() {
		acc.energy -= 30;
		System.out.println("용히는 건강해져따!!");

	}

	// 밥 먹이기 선택 했을 떄 경험치+40, 에너지-30;
	@Override
	public void eat() {

		acc.exp += 40;
		energy += 30;
		System.out.println("용히의 맘마타임~!");
	}

	// 잠자기 선택 했을 때 경험치+40, 에너지-30;
	@Override
	public void sleep() {
		acc.exp += 40;
		energy += 30;
		System.out.println("용희는 코~ 하고 올게요...");
	}

// 경험치가 100일 때 레벨업 / 경험치 초기화
	@Override
	public void levelUp() {
		if (lv == 15) { // 만렙은 15
			System.out.println("용히 키우기 끝!");
		} else if (acc.exp >= 100) {
			lv++;
			acc.exp = 0;

			System.out.println("용희 레벨업!!" + "현재 레벨은" + lv);
		}
	}

	// 에너지가 0이 되면 죽음
	@Override
	public boolean endGame() {

		if (energy <= 0) {
			System.out.println("죽었다");
		}
		return false;
	}

	// 한번 틀렸을 때 에너지를 깎게 하는 메소드
	@Override
	public void energyDown() {
		System.out.println("틀렸어!!");
		energy -= 10;
	}

// 현재 상태 확인
	@Override
	public void printInfo() {
		System.out.println();
		System.out.println("===용히 상태 확인===");
		System.out.println("experience: " + acc.exp);
		System.out.println("energy: " + energy);
		System.out.println("lv: " + lv);
	}

}
