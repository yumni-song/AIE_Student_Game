package demo2.character;


import demo2.action.ActionType;
import demo2.action.ActionEffect;

public abstract class Character {
    // 변수 선언
    protected int energy;
    protected int exp;
    protected int grade;

    // 현재 캐릭터 정보 출력
    public void printStatus() {
        System.out.println("체력: " + energy + " | 경험치: " + exp + " | 학년: " + grade);
    }

    // 경험치 증가
    public void gainExp(int amount) {
        exp += amount;
        if (exp >= 100) {
            exp -= 100;
            grade++;
        }
    }

    // 체력 변화
    public void changeEnergy(int amount) {
        energy += amount;
        if (energy >= 100) energy = 100;
        if (energy <= 0) energy = 0;
    }

    // 체력이 0인지?
    public boolean isDroppedOut() {
        return energy <= 0;
    }

    // 현재 학년 정보 불러오기
    public int getGrade() {
        return grade;
    }

    // 캐릭터마다 행동별 효과 다르게 계산
    public abstract ActionEffect getEffect(ActionType type);

    // 추가: getter/setter
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = Math.max(exp, 0);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 100) this.energy = 100;
        else if (energy < 0) this.energy = 0;
        else this.energy = energy;
    }
}
