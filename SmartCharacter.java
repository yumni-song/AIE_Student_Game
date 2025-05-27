package Character;

public class SmartCharacter extends Character {
    public SmartCharacter(String name) {
        super(name, 10, 0);
    }

    @Override
    public void study() {
        hp -= 5;
        gainExp(20);
        System.out.println("\n[System] " + name + "이(가) 공부했습니다! 체력 -5, 경험치 +20");
    }
}

