package collection.compare.test;

import java.util.*;

public class Deck {
    private static List<Card> cardList;
    private static Deque<Card> cardQue;
    public Deck() {
        cardList = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            cardList.add(new Card("\u2660", i));
            cardList.add(new Card("\u2665", i));
            cardList.add(new Card("\u2666", i));
            cardList.add(new Card("\u2663", i));
        }
        Collections.shuffle(cardList);
        cardQue = new ArrayDeque<>(cardList);
    }


    public Card pollCard(){
        return cardQue.poll();
    }
}