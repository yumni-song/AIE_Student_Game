package character;

import action.ActionEffect;

/**
 * - action 패키지에서 수행된 효과를 적용하는 테스트용 상태 관리자입니다.
 * - action 부분이 잘 실행되는지 보는 용도이기 때문에 그냥 콘솔에 결과가 출력되도록 했습니다.
 * - 'action 의 변수는 이렇고 변화하면 이런식으로 적용되는 구나' 하는 참고용으로 봐주시면 됩니다!
 */
public class DemoStatusManager {
	 private int exp = 200;        // 경험치
	    private int energy = 100;   // 에너지 (최대 100)

	    /**
	     * 행동 효과를 적용하여 상태를 업데이트함
	     * 경험치, 에너지 변화 포함
	     */
	    public void applyEffect(ActionEffect effect) {
	        exp += effect.getExpChange();
	        energy += effect.getEnergyChange();


	        printStatus(); // 현재 상태 출력
	    }

	    // 콘솔에 현재 상태 출력
	    private void printStatus() {
	        System.out.println("경험치: " + exp);
	        System.out.println("에너지: " + energy);
	        System.out.println("-----------");
	    }

	public int getExp(){
		return this.exp;
	}

	public int getHp(){
		return this.energy;
	}

	public void updateStatus(int newExp, int newHp){
		this.exp = newExp;
		this.energy = newHp;
	}


}


