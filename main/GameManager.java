package main;

import action.ActionType;
import ui.GamePanel;
import action.ActionManager;
import character.CharacterManager;

import javax.swing.*;

/*
    - 전체 흐름을 제어하는 클래스
    - main 함수 포함
*/

public class GameManager {
    private GamePanel gamePanel;
    private ActionManager actionManager;
    private CharacterManager characterManager;


    // action 패키지
    // -> 알바하기, 공부하기 버튼 연결 완료
    public ActionManager getActionManager(ActionType type) {
        return actionManager;
    }

    // character 패키지
    // -> createCharacter와 캐릭터 선택 버튼 연결
    public void createCharacter(int choice, String name){
        characterManager.createCharacter(choice, name);
    }

    // minigame 패키지
    public GameManager() {
        characterManager = new CharacterManager();
        actionManager = new ActionManager(characterManager);
        gamePanel = new GamePanel(this);

        //카드 게임 실행
        new MiniGame.CardMatchingGame(() -> {
            characterManager.addExp(100);
            System.out.println("카드 게임 완료 → 경험치 +100");
        });
    }
    public CharacterManager getCharacterManager() {
        return characterManager;
    }


    // shop 패키지


    // 메인
    public static void main(String[] args)
    {
        // GUI를 안전하게 실행하기 위한 쓰레드
        SwingUtilities.invokeLater(()-> {
            new GameManager(); // 게임 시작
        });
    }
}