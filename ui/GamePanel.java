package demo2.ui;

import demo2.main.GameManager;

import java.awt.*;
import javax.swing.*;

/*
    - 전체 UI 프레임과 패널을 구성하고 관리하는 클래스
      -> 전체 프레임, 전체 패널, 카드 레이아웃 패널들(시작 화면, 캐릭터 선택 화면, 메인 화면)
    - 카드 레이아웃을 이용하여 시작 화면, 캐릭터 선택 화면, 메인 화면을 전환함
*/
public class GamePanel extends JPanel{
    private GameManager gameManager;
    private StartPanel startPanel;
    private CharacterPanel characterPanel;
    private MainPanel mainPanel;

    private JFrame jf;
    private JPanel panel;
    private JButton startButton, c1Button, c2Button;

    public GamePanel(GameManager gm) {
        gameManager = gm;

        // 전체 프레임
        jf = new JFrame();
        jf.setTitle("인공지능공학부생 키우기 게임");
        jf.setSize(1100,700);
        jf.setLocation(200,100);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* 카드 레이아웃
           시작 화면 -> 캐릭터 선택 화면 -> 메인 화면(게임 화면) */

        CardLayout cl = new CardLayout();
        panel = new JPanel(cl); // 전체 패널
        
        // 1. 시작 화면
        startPanel = new StartPanel();
        startButton = startPanel.getSButton();

        // 2. 캐릭터 선택 화면
        characterPanel = new CharacterPanel(this);
        c1Button = characterPanel.getC1button();
        c2Button = characterPanel.getC2Button();

        // 3. 메인 화면(게임 환경)
        mainPanel = new MainPanel(this);

        // 카드를 전체 패널에 추가
        panel.add(startPanel, "start");
        panel.add(characterPanel, "character");
        panel.add(mainPanel, "main");

        jf.setLayout(new BorderLayout());
        jf.add(panel, BorderLayout.CENTER);

        // 버튼으로 카드 전환
        startButton.addActionListener(e -> cl.show(panel, "character")); // 시작 화면 -> 캐릭터 선택 화면
        c1Button.addActionListener(e -> cl.show(panel, "main"));         // 캐릭터 선택 -> 메인 게임 화면
        c2Button.addActionListener(e -> cl.show(panel, "main"));         // 캐릭터 선택 -> 메인 게임 화면

        // 화면 표시
        jf.add(panel);
        jf.setVisible(true); // 전체 프레임

    }

    // gameManager 전달
    public GameManager getGameManager() {
        return gameManager;
    }
}

