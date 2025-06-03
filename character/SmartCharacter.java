package demo2.character;

import demo2.action.ActionType;
import demo2.action.ActionEffect;

public class SmartCharacter extends Character {
    // 시작 스테이터스 설정
    public SmartCharacter(String name) {
        this.energy = 100;
        this.exp = 0;
        this.grade = 1;
    }

    // 수업, 과제, 알바 / 선택지별 동작
    @Override
    public ActionEffect getEffect(ActionType type) {
        switch (type) {
            case CLASS:
                return new ActionEffect(30, -15);
            case HOMEWORK:
                return new ActionEffect(20, -10);
            case PARTTIME:
                return new ActionEffect(30, -20);
            default:
                return new ActionEffect(0, 0);
        }
    }
}


