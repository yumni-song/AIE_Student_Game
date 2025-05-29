package Character;

public class StrongCharacter extends Character {
    public StrongCharacter(String name) {
        super(name, 20, 0);     // 시작 스테이터스 설정
    }

    @Override
    public void study() {       // 체력 유리 캐릭터의 과제하기
        hp -= 2;
        gainExp(10);
        System.out.println("\n[System] " + name + "이(가) 과제를 했습니다! 체력 -2, 경험치 +10");
    }

    @Override
    public void lecture() {     // 수업듣기
        hp -= 1;
        gainExp(18);
        System.out.println("\n[System] " + name + "이(가) 수업을 들었습니다! 체력 -1, 경험치 +18");
    }

    @Override
    public void work() {        // 알바하기
        hp -= 5;
        gainExp(40);
        System.out.println("\n[System] " + name + "이(가) 퇴근했습니다! 체력 -10, 경험치 +40");
    }
}
