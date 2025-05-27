package Character;

public class StrongCharacter extends Character {
    public StrongCharacter(String name) {
        super(name, 20, 0);
    }

    @Override
    public void study() {
        hp -= 3;
        gainExp(10);
        System.out.println("\n[System] " + name + "이(가) 공부했습니다! 체력 -3, 경험치 +10");
    }
}
