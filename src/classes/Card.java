package classes;

import java.util.ArrayList;
import java.util.Objects;

public class Card {

    public static enum Suit {
        CLUBS,
        HEARTS,
        DIAMONDS,
        SPADES
    }

    public static enum Value {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public ArrayList<Integer> getNumericalValue() {
        ArrayList<Integer> cardValue = new ArrayList<>();
        switch (this.value) {
            case ACE:
                cardValue.add(1);
                cardValue.add(11);
                break;
            case TWO:
                cardValue.add(2);
                break;
            case THREE:
                cardValue.add(3);
                break;
            case FOUR:
                cardValue.add(4);
                break;
            case FIVE:
                cardValue.add(5);
            case SIX:
                cardValue.add(6);
                break;
            case SEVEN:
                cardValue.add(7);
                break;
            case EIGHT:
                cardValue.add(8);
                break;
            case NINE:
                cardValue.add(9);
                break;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                cardValue.add(10);
                break;
        }

        return cardValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }
}
