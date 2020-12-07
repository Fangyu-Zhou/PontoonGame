package classes;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.reset();
    }

    public void reset() {
        ArrayList<Card> newCards = new ArrayList<>();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                newCards.add(new Card(suit, value));
            }
        }

        this.cards = newCards;
    }

    public void shuffle() {
        Random random = new Random();

        for(int i = 0; i < this.cards.size(); i++)
        {
            int p = random.nextInt(this.cards.size());
            Card temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(p));
            this.cards.set(p, temp);
        }
    }

    public Card getCard(int i) {
        try {
            return this.cards.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Card dealRandomCard() {
        Random random = new Random();
        int p = random.nextInt(this.cards.size());

        Card card = this.cards.get(p);
        this.cards.remove(p);

        return card;
    }

    public int size() {
        return this.cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
