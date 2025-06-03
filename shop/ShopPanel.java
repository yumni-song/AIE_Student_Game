package demo2.shop;

import demo2.character.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ShopPanel extends JPanel {
    private Character character;

    public ShopPanel(Character character){
        this.character = character;
        setLayout(null);

        JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/images/background.png")));

        bg.setBounds(0,0,1400,1000);
        add(bg);

        List<Item> items = ItemData.getShopItems();

        String[] imagePaths = {
            "/images/water.png", "/images/sundubu.png", "/images/ashatchu.png",
            "/images/jacket.png", "/images/hoodie.png"
        };

        int[][] pos = {
            {350, 350}, {500, 350}, {650, 350}, {330, 480}, {580, 480}
        };

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            JButton btn = new JButton(new ImageIcon(getClass().getResource(imagePaths[i])));
            btn.setBounds(pos[i][0], pos[i][1], 100, 100);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);

            btn.addActionListener((ActionEvent e) -> {
                boolean result = ShopEffect.applyItemEffect(character, item);
                System.out.println("현재 경험치 : " + character.getExp() + ", 체력 : " + character.getEnergy());
                character.printStatus();
            });
            bg.add(btn);
        }
    }
}


