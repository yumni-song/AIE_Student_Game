package Character;

public abstract class Character {
    // 변수 선언
    protected String name;
    protected int hp;
    protected int exp;
    protected int grade;

    public Character(String name, int hp, int exp) {    // 캐릭터 정보 구조
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.grade = 1;
    }

    public abstract void study();       // 과제 하기 / 캐릭터 특성에 따라 다르게 동작
    public abstract void lecture();     // 수업 듣기
    public abstract void work();        // 알바 하기

    public void printStatus() {     // 현재 캐릭터 정보 출력
        System.out.println("\n이름: " + name + " | 체력: " + hp + " | 경험치: " + exp + " | 학년: " + grade);
    }

    protected void gainExp(int amount) {    // 경험치 증가
        exp += amount;
        while (exp >= 100) {                // 경험치가 100이 되면 0으로 되돌리고, 학년 증가
            exp -= 100;
            grade++;
            if (grade >= 5) break;
            System.out.println("\n[System] 학년이 올랐습니다! 현재 학년: " + grade);
        }
    }

    public boolean isDroppedOut() {     // 체력이 0인지?
        return hp <= 0;
    }

    public int getGrade() {     // 현재 학년 정보 불러오기
        return grade;
    }
}
