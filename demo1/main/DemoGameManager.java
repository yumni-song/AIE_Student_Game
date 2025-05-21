package demo1.main;

import javax.swing.*;
import demo1.action.ActionManager;
import demo1.character.DemoStatusManager;
import demo1.ui.ActionDemoPanel;

/**
 * - action 패키지가 다른 코드들과 어떻게 연결되는지를 보여주기 위한 메인 실행용 클래스로, 참고용으로 봐주시면 됩니다!
 * - 테스트 용도라 패널에 수업하기, 과제하기 두 버튼이 작동하도록 만들었습니다.
 * - ActionManager, ActionDemoPanel, DemoStatusManager과 연결돼 있어 버튼 클릭 시 콘솔에 상태 변화가 출력됩니다.
 */
public class DemoGameManager {
	private ActionManager actionManager;
    private DemoStatusManager statusManager;

    // 생성자: 상태/행동 매니저 초기화
    public DemoGameManager() {
        statusManager = new DemoStatusManager();
        actionManager = new ActionManager(statusManager);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    
    public static void main(String[] args) {
    	// Swing을 안전하게 실행하기 위한 쓰레드
        SwingUtilities.invokeLater(() -> {
            DemoGameManager manager = new DemoGameManager();

            JFrame frame = new JFrame("대학생 키우기 (action 데모용)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            ActionDemoPanel panel = new ActionDemoPanel(manager.getActionManager());
            frame.add(panel);

            frame.setVisible(true);
        });
    }

}
