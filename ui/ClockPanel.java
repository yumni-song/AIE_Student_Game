package ui;

import java.awt.*;
import javax.swing.*;
import java.time.LocalDateTime; // 날짜, 시간 관련

/*
    - 시간을 표시하는 패널의 클래스
      -> Clock과 연결
*/
public class ClockPanel extends JPanel {
    private JLabel year, hour, minute, date;
    private Thread ht, mt;

    public ClockPanel() {
        setLayout(new GridLayout(5,1,0,10));

        LocalDateTime n = LocalDateTime.now(); // 현재 시간 불러오기
        
        // 날짜
        year = new JLabel(String.format("%d",n.getYear()));
        year.setHorizontalAlignment(JLabel.CENTER);
        year.setFont(new Font("SansSerif", Font.BOLD, 40));
        
        date = new JLabel(String.format("%s %d", n.getMonth(), n.getDayOfMonth()));
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setFont(new Font("SansSerif", Font.BOLD, 30));
        
        add(year); 
        add(date);

        // 시간
        hour = new JLabel(String.format("%02d", n.getHour()));
        hour.setHorizontalAlignment(JLabel.CENTER);
        hour.setFont(new Font("SansSerif", Font.BOLD, 80));
        
        minute = new JLabel(String.format("%02d", n.getMinute()));
        minute.setHorizontalAlignment(JLabel.CENTER);
        minute.setFont(new Font("SansSerif", Font.BOLD, 80));
        
        add(hour);
        add(minute);


        // 시간 스레드(Clock과 연결)
        ht = new Thread(new Clock(hour, LocalDateTime::getHour));
        mt = new Thread(new Clock(minute, LocalDateTime::getMinute));
        ht.start(); // hour 쓰레드 시작
        mt.start(); // minute 쓰레드 시작
    }
}
