package main;

import action.ActionType;
import ui.GamePanel;
import action.ActionManager;
import character.CharacterManager;
import ui.MainPanel;

import javax.swing.*;

/*
    - 전체 흐름을 제어하는 클래스
    - main 함수 포함
*/

public class GameManager {
    private GamePanel gamePanel;
    private MainPanel mainPanel; // 종료 메시지 위해 추가
    private ActionManager actionManager;
    private CharacterManager characterManager;

    // 생성자: 상태 매니저, 행동 매니저, UI 초기화
    public GameManager() {
        characterManager = new CharacterManager(this);
        actionManager = new ActionManager(characterManager);
        gamePanel = new GamePanel(this);
        mainPanel = new MainPanel(gamePanel); // 종료 메시지 위해 추가
        gamePanel.setMainPanel(mainPanel);

    }

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
    
    // shop 패키지


    // 종료 팝업 메시지를 위한 추가
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    // 메인
    public static void main(String[] args)
    {
        // GUI를 안전하게 실행하기 위한 쓰레드
        SwingUtilities.invokeLater(()-> {
            new GameManager(); // 게임 시작
        });
    }
}
