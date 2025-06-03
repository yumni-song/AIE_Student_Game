package ui;

import javax.swing.*;
import java.awt.*;
import character.*;

/*
    - 캐릭터 상태를 표시하는 패널의 클래스
      -> character 패키지와 연결 예정
*/
public class StatePanel extends JPanel {
    private JLabel title, name, grade, energy, exp;
    private CharacterManager characterManager;

    public StatePanel() {
        setLayout(new GridLayout(5,1));

        // 패널 제목
        title = new JLabel("캐릭터 상태");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBackground(new Color(200, 218, 247));

        // 이름
        name = new JLabel("이름: ");
        
        // 학년
        grade = new JLabel("학년 : ");
        
        // 체력
        energy = new JLabel("체력: ");
        
        // 경험치
        exp = new JLabel("경험치: ");

        add(title);
        add(name);
        add(grade);
        add(energy);
        add(exp);
    }
}
