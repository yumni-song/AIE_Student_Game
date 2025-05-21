package demo1.ui;

import javax.swing.*;
import java.awt.*;

import demo1.action.ActionManager;
import demo1.action.ActionType;

/**
 * - action 패키지에서 만든 동작이 버튼 클릭으로 잘 연결되는지 확인하는 참고용 UI입니다.
 * - 실제 UI는 GamePanel 등에서 구현하실 테니, 구조나 버튼 처리 방식만 참고로 봐주시면 됩니다!
 * - 수업은 15초 딜레이 후 효과 적용 / 과제는 즉시 반영되도록 구성돼 있습니다.
 */

public class ActionDemoPanel extends JPanel {
    private JButton classButton;
    private JButton homeworkButton;

    public ActionDemoPanel(ActionManager actionManager) {
        setLayout(new FlowLayout());

        classButton = new JButton("수업 듣기");
        homeworkButton = new JButton("과제 하기");

        // 수업: 팝업 띄우고 15초 후 효과 적용
        classButton.addActionListener(e -> {
            showPopup("수업을 듣는 중입니다...", 15000);
            actionManager.performAction(ActionType.CLASS);  // 15초 후 상태 반영됨
        });

        // 과제: 팝업 없이 즉시 수행
        homeworkButton.addActionListener(e -> {
            actionManager.performActionImmediately(ActionType.HOMEWORK); // 즉시 상태 반영
        });

        add(classButton);
        add(homeworkButton);
    }

    /**
     * 15초 동안 표시되는 팝업 생성
     */
    private void showPopup(String message, int durationMs) {
        JDialog dialog = new JDialog((Frame) null, "진행 중", false); // 비모달
        dialog.setUndecorated(true);
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);
        dialog.setVisible(true);

        // 지정된 시간 후 팝업 닫기
        Timer timer = new Timer(durationMs, e -> {
            dialog.setVisible(false);
            dialog.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }
}

