package ui;

import java.awt.*;
import javax.swing.*;

/*
    - 시작 화면을 구성하는 클래스
      -> 게임 이름, 시작하기 버튼
*/
public class StartPanel extends JPanel {
    private JLabel startLabel;
    private JButton startButton;

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


        add(Box.createVerticalGlue()); // 위쪽 여백
        add(startLabel);
        add(Box.createVerticalStrut(50)); // 수직 여백
        add(startButton);
        add(Box.createVerticalGlue()); // 아래쪽 여백
    }

    /* GamePanel에서 버튼을 사용하기 위해 전달 */
    public JButton getSButton() {
        return startButton;
    }
}
