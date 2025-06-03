package demo2.ui;

import demo2.main.GameManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*; // panel 테두리 설정

/*
    - 메인 화면(게임 화면)을 구성하는 클래스
      -> 탭 패널, 메인 탭, 상점 탭, 사이드 패널, 캐릭터 패널, 게임 이름 패널
*/
public class MainPanel extends JPanel {
    private GamePanel gp;
    private MenuPanel menuPanel;
    protected JPanel mainTab, storeTab, sidePanel, characterPanel, titlePanel;
    private JTabbedPane tabPane;
    private JLabel title;
    //private ClockPanel clockPanel;

    public MainPanel(GamePanel gamePanel) {
        gp= gamePanel;

        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(30,10,30,10); // 여백

        // 시계 (ClockPanel 구현 예정)
        //clockPanel = new ClockPanel();
        //clockPanel.setLayout(new GridBagLayout());
        //clockPanel.setMinimumSize(new Dimension(0,0)); // 창 크기 반응해서 축소
        //clockPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // layout 테스트용
        //g.gridx = 0; g.gridy = 0; g.gridwidth = 1; g.gridheight = 5;
        //g.weightx = 0.1; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        //add(clockPanel, g);


        /* 탭 패널 -> 메인 탭, 상점 탭 */
        tabPane = new JTabbedPane();

        // 메인 탭
        mainTab = new JPanel();
        menuPanel = new MenuPanel(this);
        mainTab.setLayout(new BorderLayout(10,10));
        mainTab.add(menuPanel, BorderLayout.SOUTH);

        // 상점 탭
        storeTab = new JPanel();
        JLabel t2 = new JLabel("store"); // 임시 텍스트
        storeTab.add(t2);

        tabPane.addTab("메인",mainTab);
        tabPane.addTab("상점",storeTab);

        g.gridx = 1; g.gridy = 0; g.gridwidth = 3; g.gridheight = 5;
        g.weightx = 0.8; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        add(tabPane, g);


        /* 사이드 패널 -> 캐릭터 패널, 게임 제목 패널 */
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridBagLayout());
        sidePanel.setMinimumSize(new Dimension(0,0)); // 창 크기 반응해서 축소
        //sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // layout 테스트용
        GridBagConstraints g2 = new GridBagConstraints();
        g2.insets = new Insets(22,0,0,0);

        // 캐릭터 패널 (캐릭터 상태 표시)
        characterPanel = new JPanel();
        characterPanel.setLayout(new BorderLayout());
        characterPanel.setMinimumSize(new Dimension(0,0));
        characterPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 218, 247), 3));

        g2.gridx = 0; g2.gridy = 0; g2.weighty = 1.0; g2.fill = GridBagConstraints.BOTH;
        sidePanel.add(characterPanel, g2);

        // 게임 이름 패널
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setMinimumSize(new Dimension(0,0));
        title = new JLabel("<html><body><center>인공지능공학부생<br>키우기 게임</center></body></html>");
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        titlePanel.add(title, BorderLayout.CENTER);
        g2.insets = new Insets(30,0,10,0);

        g2.gridx = 0; g2.gridy = 1; g2.weighty = 0.2; g2.fill = GridBagConstraints.BOTH;
        sidePanel.add(titlePanel, g2);


        g.gridx = 4; g.gridy = 0; g.gridwidth = 1; g.gridheight = 4;
        g.weightx = 0.1; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        add(sidePanel, g);
        
    }

    // GamePanel의 gameManager를 전달
    public GameManager getGameManager() {
        return gp.getGameManager();
    }
}

