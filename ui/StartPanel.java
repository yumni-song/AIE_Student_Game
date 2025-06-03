package demo2.ui;

import java.awt.*;
import javax.swing.*;

/*
    - 시작 화면을 구성하는 클래스
      -> 게임 이름, 시작하기 버튼
*/
public class StartPanel extends JPanel {
    private JLabel startLabel, label1, label2, label3, label4, label5, label6;
    private JButton startButton, guideButton;
    private JPanel guidePanel, labelPanel;
    private JFrame guideFrame;

    public StartPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 게임 이름
        startLabel = new JLabel("인공지능공학부생 키우기 GAME");
        startLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
        startLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬

        // 시작하기 버튼
        startButton = new JButton("시작하기");
        startButton.setFont(new Font("SanSerif", Font.BOLD, 20));
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(500,50));
        startButton.setMaximumSize(new Dimension(300,50));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 게임 설명 버튼
        guidePanel = new JPanel(); // layout을 위한 패널
        guidePanel.setMaximumSize(new Dimension(1300,40));
        guidePanel.setLayout(new BorderLayout());

        guideButton = new JButton("게임 설명");
        guideButton.setFont(new Font("SanSerif", Font.BOLD, 15));
        guideButton.setFocusPainted(false);
        guideButton.setPreferredSize(new Dimension(120,40));
        guideButton.setMaximumSize(new Dimension(120,40));
        guideButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        guidePanel.add(guideButton, BorderLayout.EAST);
        guideButton.addActionListener(e -> { // 버튼 이벤트 처리
            openGuideFrame();
        });

        add(Box.createVerticalStrut(50)); // 수직 여백
        add(guidePanel);
        add(Box.createVerticalGlue()); // 위쪽 여백
        add(startLabel);
        add(Box.createVerticalStrut(50)); // 수직 여백
        add(startButton);
        add(Box.createVerticalGlue()); // 아래쪽 여백
    }

    // 게임 방법 설명창
    private void openGuideFrame() {
        guideFrame = new JFrame("게임 방법");
        guideFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        labelPanel = new JPanel(); // 설명 label을 담을 패널
        labelPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30)); // 여백 설정
        labelPanel.setLayout(new GridLayout(6,1));

        label1 = new JLabel("게임 목표");
        label1.setFont(new Font("SanSerif", Font.BOLD, 25));
        label2 = new JLabel("<html>인공지능공학부생 캐릭터를 키워 경험치를 쌓고, 체력을 관리하며<br>" +
                "졸업 퀘스트를 통과해 4학년까지 진급<br>-> 졸업 엔딩 도달<html>");
        label2.setFont(new Font("SanSerif", Font.PLAIN, 15));

        label3 = new JLabel("진행 방식");
        label3.setFont(new Font("SanSerif", Font.BOLD, 25));
        label4 = new JLabel("<html>1. 수업듣기 - 소량의 경험치 획득, 체력 소모 적음<br>" +
                "2. 공부하기 - 경험치 많이 획득, 체력 많이 소모<br> 3. 알바하기 - 미니게임 수행 -> 결과에 따라 경험치/체력 변동<br>" +
                "4. 상점 - 음식으로 체력 회복 / 옷으로 캐릭터 커스터마이징<br>5. 종료 - 4학년 완료 시 졸업 / 체력 0이면 퇴학<html>");
        label4.setFont(new Font("SanSerif", Font.PLAIN, 15));

        label5 = new JLabel("진급 / 졸업 시스템");
        label5.setFont(new Font("SanSerif", Font.BOLD, 25));
        label6 = new JLabel("<html>학년 종료 시 경험치 확인 후 진급 여부 결정<br>-> 최종 졸업 때는 일정 경험치 이상이면 졸업 가능<html>");
        label6.setFont(new Font("SanSerif", Font.PLAIN, 15));

        labelPanel.add(label1); labelPanel.add(label2); labelPanel.add(label3);
        labelPanel.add(label4); labelPanel.add(label5); labelPanel.add(label6);
        guideFrame.add(new JScrollPane(labelPanel)); // 스크롤 가능
        guideFrame.setSize(800,600);
        guideFrame.setLocationRelativeTo(null); // 화면 가운데 배치
        guideFrame.setVisible(true);
    }

    /* GamePanel에서 버튼을 사용하기 위해 전달 */
    public JButton getSButton() {
        return startButton;
    }
}