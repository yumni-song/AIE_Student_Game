package ui;

import main.GameManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*; // panel 테두리 설정

/*
    - 메인 화면(게임 화면)을 구성하는 클래스
      -> 탭 패널, 메인 탭, 상점 탭, 사이드 패널, 캐릭터 상태 패널, 게임 이름 패널, 시계 패널
*/
public class MainPanel extends JPanel {
    private GamePanel gp;
    private MenuPanel menuPanel;
    protected JPanel mainTab, storeTab, sidePanel, titlePanel;
    private JTabbedPane tabPane;
    private JLabel title;
    private ClockPanel clockPanel;
    private StatePanel statePanel;

    public MainPanel(GamePanel gamePanel) {
        gp= gamePanel;

        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(30,10,30,10); // 여백

        // 시계 패널
        clockPanel = new ClockPanel();
        clockPanel.setBorder(BorderFactory.createEmptyBorder(200,0,180,0));
        clockPanel.setMinimumSize(new Dimension(0,0)); // 창 크기 반응해서 축소
        //clockPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // layout 테스트용
        g.gridx = 0; g.gridy = 0; g.gridwidth = 1; g.gridheight = 5;
        g.weightx = 0.2; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        add(clockPanel, g);


        /* 탭 패널 -> 메인 탭, 상점 탭 */
        tabPane = new JTabbedPane();

        // 메인 탭
        mainTab = new JPanel();
        menuPanel = new MenuPanel(this);
        mainTab.setLayout(new BorderLayout(10,10));
        mainTab.add(menuPanel, BorderLayout.SOUTH);

        // 상점 탭 (shop 패키지와 연결 예정)
        storeTab = new JPanel();
        JLabel t2 = new JLabel("store"); // 임시 텍스트
        storeTab.add(t2);

        tabPane.addTab("메인",mainTab);
        tabPane.addTab("상점",storeTab);

        g.gridx = 1; g.gridy = 0; g.gridwidth = 3; g.gridheight = 5;
        g.weightx = 0.6; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        add(tabPane, g);


        /* 사이드 패널 -> 캐릭터 패널, 게임 제목 패널 */
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridBagLayout());
        sidePanel.setMinimumSize(new Dimension(100,150)); // 창 크기 반응해서 축소
        //sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // layout 테스트용
        GridBagConstraints g2 = new GridBagConstraints();
        g2.insets = new Insets(22,0,0,0);

        // 캐릭터 상태 표시 패널(틀)
        statePanel = new StatePanel(); // 내용은 StatePanel에서 구현
        statePanel.setMinimumSize(new Dimension(100,150));
        statePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 218, 247), 3),
                new EmptyBorder(30,15,30,15)));

        g2.gridx = 0; g2.gridy = 0; g2.weighty = 1.0; g2.fill = GridBagConstraints.BOTH;
        sidePanel.add(statePanel, g2);

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
        g.weightx = 0.2; g.weighty = 1.0; g.fill = GridBagConstraints.BOTH;
        add(sidePanel, g);
        
    }

    // GamePanel의 gameManager를 전달
    public GameManager getGameManager() {
        return gp.getGameManager();
    }

    // 퇴학 팝업 메시지
    public void droppedOutPopup() {
        JDialog dialog = new JDialog((Frame) null, "퇴학", false); // 비모달
        dialog.setUndecorated(true);
        dialog.setAlwaysOnTop(true); // 실행되는 동안 모든 창 위에 위치
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(gp);
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(Color.RED);

        JLabel label = new JLabel("퇴학입니다.",SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);
        dialog.setVisible(true);

        // 프로그램 종료
        Timer timer = new Timer(5000, e->{ // 5초 뒤에
            dialog.dispose();                              // 팝업 닫고
            System.exit(0);                          // 프로그램 종료
        });
        timer.start(); // 타이머 시작
    }

    // 졸업 팝업 메시지
    public void graduatedPopup() {
        JDialog dialog = new JDialog((Frame) null, "졸업", false); // 비모달
        dialog.setUndecorated(true);
        dialog.setAlwaysOnTop(true); // 실행되는 동안 모든 창 위에 위치
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(gp);
        dialog.setLayout(new BorderLayout());
        dialog.getContentPane().setBackground(Color.GREEN);

        JLabel label = new JLabel("졸업입니다.",SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);
        dialog.setVisible(true);

        // 프로그램 종료
        Timer timer = new Timer(5000, e->{ // 5초 뒤에
            dialog.dispose();                              // 팝업 닫고
            System.exit(0);                          // 프로그램 종료
        });
        timer.start(); // 타이머 시작
    }
}
