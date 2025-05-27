package main;

import action.ActionType;
import ui.GamePanel;
import action.ActionManager;
import character.DemoStatusManager;

/*
    - 전체 흐름을 제어하는 클래스
    - main 함수 포함
*/

public class GameManager {
    private GamePanel gamePanel;
    private ActionManager actionManager;
    private DemoStatusManager statusManager;
    private CharacterSelected characterSelected;  // 캐릭터 선택 테스트용

    // 생성자: 상태 매니저, 행동 매니저, UI 초기화
    public GameManager() {
        statusManager = new DemoStatusManager();
        actionManager = new ActionManager(statusManager);
        characterSelected = new CharacterSelected(); // 캐릭터 선택 테스트용
        gamePanel = new GamePanel(this);
    }

    // action 패키지
    // -> 알바하기, 공부하기 버튼 연결 완료
    public ActionManager getActionManager(ActionType type) {
        return actionManager;
    }

    // character 패키지
    /* 캐릭터 선택 이벤트 처리 테스트
    -> Character 패키지와 연결하는 부분을 콘솔에 출력해서 확인했습니다. */
    public class CharacterSelected {
        public void buttonClicked(String c) {
            System.out.println("Character : " + c);
        }
    }
    public void getCharacter(String c) {
        CharacterSelected cs = new CharacterSelected();
        cs.buttonClicked(c);
    }

    // minigame 패키지
    
    // shop 패키지


    // 메인
    public static void main(String[] args)
    {
        new GameManager(); // 게임 시작
    }
}
