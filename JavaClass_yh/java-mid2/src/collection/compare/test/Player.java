package collection.compare.test;

import java.util.ArrayList;
import java.util.List;
public class Player {
    private String name;
    private List<Card> card = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void pollCard(Deck deck){
        card.add(deck.pollCard());
    }

    public void printCard(){
        System.out.println(name + "의 카드: " + card +
                           ", 합계: " + cardSum());
    }

    public int cardSum(){
        card.sort(null);
        int sum = 0;
        for (Card c : card) {
            sum += c.getNum();
        }
        return sum;
    }
}
