package classes;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    public void dealToPlayer(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public ArrayList<Integer> getNumericalHandValue() {
        ArrayList<Integer> handValues = new ArrayList<>();
        handValues.add(0);

        for (Card card : this.cards) {
            ArrayList<Integer> cur = card.getNumericalValue();
            ArrayList<Integer> next = new ArrayList<>();

            //TODO: can make more concise
            if (cur.size() == 1) {
                int curCardValue = cur.get(0);

                for (int num : handValues) {
                    next.add(num + curCardValue);
                }

                handValues = next;
            } else {
                int curCardValue1 = cur.get(0);
                int curCardValue2 = cur.get(1);

                for (int num : handValues) {
                    next.add(num + curCardValue1);
                    next.add(num + curCardValue2);
                }

                handValues = next;
            }
        }

        Collections.sort(handValues);
        return handValues;
    }

    public int getBestNumericalHandValue() {
        ArrayList<Integer> potentialValue = this.getNumericalHandValue();

        for (int i = potentialValue.size() - 1; i >= 0; i--) {
            int curVal = potentialValue.get(i);

            if (curVal <= 21) {
                return curVal;
            }
        }

        //if no value under 21 available
        return -1;
    }

    public int getHandSize() {
        return this.cards.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
