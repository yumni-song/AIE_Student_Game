package shop;

import character.DemoStatusManager;
import shop.ItemData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ShopPanel extends JPanel {
    private DemoStatusManager character;

    public ShopPanel(DemoStatusManager character){
        this.character = character;
        setLayout(null);
        
        //배경이미지
        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/images/background.png")));
        bg.setBounds(0,0,1400,1000); //크기 지정 (600*400)
        add(bg);
        
        //아이템리스트
        List<Item> items = ItemData.getShopItems();

        //이미지 파일 경로
        String[] imagePaths = {"/images/water.png", "/images/sundubu.png", "/images/ashatchu.png",
                "/images/jacket.png", "/images/hoodie.png"
    };
        //각 이미지가 배치될 위치
        int[][] pos = {
                {350, 350}, {500, 350}, {650, 350}, {330, 480}, {580, 480}
        };

        for (int i =0; i<items.size();i++){
            Item item = items.get(i);
            JButton btn = new JButton(new ImageIcon(getClass().getResource(imagePaths[i])));
            btn.setBounds(pos[i][0],pos[i][1],100,100);
            //버튼배경 제거
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);

            //버튼 클릭 이벤트
            btn.addActionListener((ActionEvent e)-> {
                boolean result = ShopEffect.applyItemEffect(character,item);
                System.out.println("현재 경험치 : "+character.getExp()+", 체력 : "+character.getHp());
            });
            bg.add(btn);

        }
        }

    
    
    
}
