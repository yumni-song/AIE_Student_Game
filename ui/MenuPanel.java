package demo2.ui;

import demo2.action.ActionType;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*; // panel 테두리 설정
import javax.swing.BorderFactory; // border 설정 합치기

/*
    - 메인 화면(게임 화면)의 버튼 메뉴를 구성하는 클래스
      -> 수업듣기, 과제하기, 알바하기 버튼
    - 사용자가 버튼 클릭하면 이벤트 처리
      -> 팝업, action 패키지의 메서드 호출
*/
public class MenuPanel extends JPanel {
    private MainPanel mp;
    private JButton classButton, homeworkButton, workButton;
    Border color, space;
    private JFrame miniGameFrame;

    public MenuPanel(MainPanel mainPanel) {
        mp = mainPanel;

        // 수업듣기 버튼
        classButton = new JButton("수업듣기");
        classButton.setFont(new Font("SanSerif", Font.BOLD, 20));

        classButton.addActionListener(e -> {         // 수업: 팝업 띄우고 15초 후 효과 적용
            showPopup("수업을 듣는 중입니다...", 15000);
            mp.getGameManager().getActionManager(ActionType.CLASS)
                    .performAction(ActionType.CLASS);  // 15초 후 상태 반영됨
        });

        // 과제하기 버튼
        homeworkButton = new JButton("과제하기");
        homeworkButton.setFont(new Font("SanSerif", Font.BOLD, 20));

        homeworkButton.addActionListener(e -> {      // 과제: 팝업 없이 즉시 수행
            mp.getGameManager().getActionManager(ActionType.HOMEWORK)
                    .performActionImmediately(ActionType.HOMEWORK); // 즉시 상태 반영
        });

        // 알바하기 버튼
        workButton = new JButton("알바하기");
        workButton.setFont(new Font("SanSerif", Font.BOLD, 20));

        workButton.addActionListener(e -> { // 알바: 게임 화면 팝업
            OpenMiniGameFrame();
        });


        add(classButton);
        add(homeworkButton);
        add(workButton);

        // 메뉴 panel 테두리, 여백 설정
        color = BorderFactory.createLineBorder(new Color(200, 218, 247), 3);
        space = new EmptyBorder(40,10,40,10);
        setBorder(BorderFactory.createCompoundBorder(color, space));
    }

    // 수업듣기 버튼 클릭하면 팝업
    private void showPopup(String message, int durationMs) {
        JDialog dialog = new JDialog((Frame) null, "진행 중", false); // 비모달
        dialog.setUndecorated(true);
        dialog.setAlwaysOnTop(true); // 실행되는 동안 모든 창 위에 위치
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(mp.mainTab);
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(new Color(115, 160, 235));

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
    
    // 알바하기 버튼 클릭하면 나타나는 게임 화면
    private void OpenMiniGameFrame() {
        miniGameFrame = new JFrame("알바하기");
        miniGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        miniGameFrame.getContentPane().setBackground(Color.BLACK);
        miniGameFrame.setSize(mp.mainTab.getSize());
        miniGameFrame.setLocationRelativeTo(mp.mainTab); // 화면 가운데 배치
        miniGameFrame.setVisible(true);
    }
}


