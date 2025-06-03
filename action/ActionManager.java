package demo2.action;

import demo2.character.CharacterManager;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 캐릭터가 수행할 수 있는 행동을 관리하는 클래스
 * 행동 유형에 따른 경험치 및 에너지 변화를 정의하고,
 * 행동 실행 시 해당 효과를 상태에 반영함
 */
public class ActionManager {
    private CharacterManager characterManager; // 캐릭터 상태 관리 객체
    private Map<ActionType, ActionEffect> effects; // 행동별 효과 맵

    // 생성자: 행동별 효과 등록
    public ActionManager(CharacterManager characterManager) {
        this.characterManager = characterManager;
        effects = new HashMap<>();

        // 행동별 효과 설정 (CLASS: 경험치↑↑, HOMEWORK: 경험치↑)
        effects.put(ActionType.CLASS, new ActionEffect(40, -40));     // 경험치 +40, 에너지 -40
        effects.put(ActionType.HOMEWORK, new ActionEffect(10, -10));  // 경험치 +10, 에너지 -10
        effects.put(ActionType.PARTTIME, new ActionEffect(30, -20));  // PARTTIME 추가 (예시)
    }

    /**
     * CLASS 수행 시 호출됨
     * - 효과 반영은 15초 후에 지연 처리됨 (팝업 닫힌 이후)
     */
    public void performAction(ActionType type) {
        // 15초 후 효과 적용
        Timer timer = new Timer(15000, e -> {
            characterManager.applyEffect(type);
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * HOMEWORK 수행 시 즉시 상태 반영
     */
    public void performActionImmediately(ActionType type) {
        characterManager.applyEffect(type);
    }
}

