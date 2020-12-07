package classes;

import java.util.ArrayList;

public abstract class CardGame {

    private int numPlayers;
    private Deck deck;
    private ArrayList<Player> players;

    public CardGame(int nplayers) {
        this.numPlayers = nplayers;
        this.deck = new Deck();
        this.players = new ArrayList<>();
    }

    public abstract void dealInitialCars();

    public abstract int compareHands(Player hand1, Player hand2);

    public Player getPlayer(int i ) {
        try {
            return this.players.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
