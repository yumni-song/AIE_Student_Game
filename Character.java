package Character;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int exp;
    protected int grade;

    public Character(String name, int hp, int exp) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.grade = 1;
    }

    public abstract void study(); // 캐릭터 특성에 따라 다르게 동작

    public void rest() {
        hp += 5;
        System.out.println("\n[System] " + name + "이(가) 휴식을 취했습니다. 체력 +5");
    }

    public void printStatus() {
        System.out.println("\n이름: " + name + " | 체력: " + hp + " | 경험치: " + exp + " | 학년: " + grade);
    }

    protected void gainExp(int amount) {
        exp += amount;
        while (exp >= 100) {
            exp -= 100;
            grade++;
            if (grade >= 5) break;
            System.out.println("\n[System] 학년이 올랐습니다! 현재 학년: " + grade);
        }
    }

    public boolean isDroppedOut() {
        return hp <= 0;
    }

    public int getGrade() {
        return grade;
    }
}
