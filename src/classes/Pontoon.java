package classes;

import java.util.ArrayList;

public class Pontoon extends CardGame {


    public Pontoon(int nplayers) {
        super(nplayers);
    }

    @Override
    public void dealInitialCars() {
        for (Player player : this.getPlayers()) {
            //get card from random index
            Card one = this.getDeck().dealRandomCard();
            Card two = this.getDeck().dealRandomCard();

            player.getCards().add(one);
            player.getCards().add(two);
        }
    }

    @Override
    public int compareHands(Player hand1, Player hand2) {
        int level1 = this.getRankLevel(hand1);
        int level2 = this.getRankLevel(hand2);

        int levelDiff = level1 - level2;

        if (levelDiff == 0 && level1 == 1) {
            int hand1Val = hand1.getBestNumericalHandValue();
            int hand2Val = hand2.getBestNumericalHandValue();

            return Integer.compare(0, hand1Val - hand2Val);
        } else {
            return Integer.compare(0, levelDiff);
        }
    }

    private int getRankLevel(Player player) {
        ArrayList<Card> cards = player.getCards();
        if (this.isPontoon(cards)) {
            return 4;
        } else if (this.isFiveCardTrick(player)){
            return 3;
        } else if (player.getBestNumericalHandValue() == 21) {
            return 2;
        } else if (player.getBestNumericalHandValue() != -1) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean isPontoon(ArrayList<Card> cards) {
        if (cards.size() != 2) return false;

        Card another = null;

        if (cards.get(0).getNumericalValue().size() == 2) {
            another = cards.get(1);

        } else if (cards.get(1).getNumericalValue().size() == 2) {
            another = cards.get(0);
        } else {
            return false;
        }

        return another.getNumericalValue().get(0) == 10;
    }

    private boolean isFiveCardTrick(Player player) {
        return player.getCards().size() == 5 && player.getBestNumericalHandValue() == 21;
    }
}
