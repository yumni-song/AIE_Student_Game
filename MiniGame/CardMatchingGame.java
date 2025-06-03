package MiniGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CardMatchingGame extends JPanel {
    private final List<Card> cards = new ArrayList<>();
    private Card firstSelected = null;
    private Card secondSelected = null;
    private int matchedPairs = 0;
    private Runnable onGameComplete;

    public CardMatchingGame(Runnable onGameComplete) {
        this.onGameComplete = onGameComplete;
        setLayout(new GridLayout(2, 3));
        setBackground(Color.WHITE);

        initCards();
    }

    private void initCards() {
        String[] frontImages = { "card1.png", "card2.png", "card3.png" };
        List<String> allImages = new ArrayList<>();
        for (String img : frontImages) {
            allImages.add(img);
            allImages.add(img);
        }
        Collections.shuffle(allImages);

        for (String img : allImages) {
            Card card = new Card(img);
            card.addActionListener(e -> handleCardClick(card));
            cards.add(card);
            add(card);
        }
    }


    private void handleCardClick(Card card) {
        if (card.isMatched() || card.isFlipped() || secondSelected != null) return;

        card.flip();

        if (firstSelected == null) {
            firstSelected = card;
        } else {
            secondSelected = card;

            Timer timer = new Timer(800, e -> checkMatch());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void checkMatch() {
        if (firstSelected.getImageName().equals(secondSelected.getImageName())) {
            firstSelected.setMatched(true);
            secondSelected.setMatched(true);
            matchedPairs++;
            if (matchedPairs == 3) {
                JOptionPane.showMessageDialog(this, "성공! 경험치 +100");
                if (onGameComplete != null) onGameComplete.run();
                // 부모 창 닫기
                SwingUtilities.getWindowAncestor(this).dispose();
            }
        } else {
            firstSelected.flipBack();
            secondSelected.flipBack();
        }

        firstSelected = null;
        secondSelected = null;
    }

    class Card extends JButton {
        private final String imageName;
        private final ImageIcon frontIcon;
        private final ImageIcon backIcon;
        private boolean flipped = false;
        private boolean matched = false;

        public Card(String imageName) {
            this.imageName = imageName;
            this.frontIcon = new ImageIcon(getClass().getResource(imageName));
            this.backIcon = new ImageIcon(getClass().getResource("card_back.png"));
            setIcon(backIcon);
        }

        public void flip() {
            setIcon(frontIcon);
            flipped = true;
        }

        public void flipBack() {
            setIcon(backIcon);
            flipped = false;
        }

        public String getImageName() {
            return imageName;
        }

        public boolean isFlipped() {
            return flipped;
        }

        public void setMatched(boolean matched) {
            this.matched = matched;
        }

        public boolean isMatched() {
            return matched;
        }
    }
}
