package demo2.ui;

import java.awt.*;
import javax.swing.*;

/*
    - 캐릭터 선택 화면을 구성하는 클래스
      -> 안내 텍스트, 캐릭터 선택 버튼(Strong / Smart)
    - 사용자가 버튼을 클릭하면 캐릭터 패키지의 메서드를 호출하여 정보 전달
*/
public class CharacterPanel extends JPanel {
    private GamePanel gp;

    private JButton c1Button, c2Button;
    private JLabel text;
    private JPanel textPanel, buttonPanel;

    public CharacterPanel(GamePanel gamePanel) {
        gp = gamePanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 캐릭터 선택 안내 텍스트
        textPanel = new JPanel();
        text = new JLabel("캐릭터 선택");
        text.setFont(new Font("SansSerif", Font.BOLD, 40));
        textPanel.add(text);

        // 캐릭터 선택 버튼 패널
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));

        // 1. Strong 캐릭터 버튼 (체력 유리)
        c1Button = new JButton("Strong Character");
        c1Button.setFont(new Font("SansSerif", Font.BOLD, 30));
        c1Button.setPreferredSize(new Dimension(400,500));
        c1Button.setMaximumSize(new Dimension(400,500));
        c1Button.addActionListener(e -> {
            gp.getGameManager().createCharacter(1,"Strong Character");
        });

        // 2. Smart 캐릭터 버튼 (경험치 유리)
        c2Button = new JButton("Smart Character");
        c2Button.setFont(new Font("SansSerif", Font.BOLD, 30));
        c2Button.setPreferredSize(new Dimension(400,500));
        c2Button.setMaximumSize(new Dimension(400,500));
        c2Button.addActionListener(e -> {
            gp.getGameManager().createCharacter(0,"Smart Character");
        });


        buttonPanel.add(c1Button);
        buttonPanel.add(Box.createHorizontalStrut(80)); // 버튼 사이 여백 설정
        buttonPanel.add(c2Button);

        add(Box.createVerticalGlue()); // 위쪽 여백
        add(textPanel);
        add(buttonPanel);
        add(Box.createVerticalGlue()); // 아래쪽 여백
    }

    /* GamePanel에서 버튼을 사용하기 위해 전달 */
    public JButton getC1button() {
        return c1Button;
    }

    public JButton getC2Button() {
        return c2Button;
    }
}