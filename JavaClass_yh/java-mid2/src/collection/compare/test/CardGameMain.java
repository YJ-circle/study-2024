package collection.compare.test;

public class CardGameMain {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("플레이어1");
        Player player2 = new Player("플레이어2");
        for(int i = 1; i<=5; i++){
            player1.pollCard(deck);
            player2.pollCard(deck);
        }
        player1.printCard();
        player2.printCard();
        System.out.println(
                player1.cardSum() < player2.cardSum() ? "player2 승리!" : player1.cardSum() == player2.cardSum() ? "무승부" : "player1 승리!"
        );

    }
}
