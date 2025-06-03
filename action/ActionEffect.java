package demo2.action;

/**
 * 행동의 효과를 나타내는 클래스
 * 경험치 변화량과 에너지 변화량을 저장함
 */
public class ActionEffect {
    private int expChange;      // 행동 시 변화되는 경험치
    private int energyChange;   // 행동 시 변화되는 에너지

    // 생성자: 경험치와 에너지 변화량을 초기화
    public ActionEffect(int expChange, int energyChange) {
        this.expChange = expChange;
        this.energyChange = energyChange;
    }

    // 경험치 변화량 반환
    public int getExpChange() {
        return expChange;
    }

    // 에너지 변화량 반환
    public int getEnergyChange() {
        return energyChange;
    }
}

