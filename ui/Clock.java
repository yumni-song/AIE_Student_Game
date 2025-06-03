package ui;

import javax.swing.*;
import java.time.LocalDateTime; // 날짜, 시간 관련
import java.util.function.*; // 함수형 인터페이스

/*
    - 시간 스레드를 구현한 클래스
      -> ClockPanel과 연결
*/
public class Clock implements Runnable{
    private JLabel tl;
    private int next, current;
    private Function<LocalDateTime,Integer> unit;

    public Clock(JLabel timeLabel, Function<LocalDateTime,Integer> timeUnit){
        tl = timeLabel;
        unit = timeUnit;
    }

    // 시간 업데이트
    public void run(){ 
        current = -1; // 첫 루프에서 current 초기화

        while(true){
            next = unit.apply(LocalDateTime.now());

            // 시간이 변화되었으면 업데이트
            if (next != current) {
                current = next;
                // UI 업데이트
                SwingUtilities.invokeLater(()->{
                    tl.setText(String.format("%02d", next));
                });
            }

            try{
                Thread.sleep(1000); // 1초 휴식
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
