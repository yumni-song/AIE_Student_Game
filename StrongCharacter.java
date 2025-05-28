package Character;

public class StrongCharacter extends Character {
    public StrongCharacter(String name) {
        super(name, 20, 0);     // 시작 스테이터스 설정
    }

    @Override
    public void study() {   // 체력 유리 캐릭터의 공부하기
        hp -= 3;
        gainExp(10);
        System.out.println("\n[System] " + name + "이(가) 공부했습니다! 체력 -3, 경험치 +10");
    }
}
