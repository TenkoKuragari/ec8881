package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a pile of cards. The behavior of a pile is that it holds a collection of
 * cards that can be added to the bottom that are either face up or face down. The cards
 * can be shuffled randomly into a face down position. When a card is removed (drawn), if
 * the top card is face up, it means the pile need to be shuffled before the card is removed
 * from the top.
 *
 * @author Ethan Chen
 */
public class Pile {
    private final ArrayList<Card> cards;
    private final String name;
    private static Random rng;

    /**
     * Create the pile of cards for a given seed.
     *
     * @param name name of the pile
     */
    public Pile(String name) {
        this.cards = new ArrayList<>();
        this.name = name;
    }

    /**
     *Add a card to the bottom of the pile (leave the face setting as is).
     *
     * @param card an instance of a class card
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     *Remove all cards from the pile by clearing it out.
     */
    public void clear() {
        this.cards.clear();
    }

    /**
     *Get the next top card from the pile.
     *
     * @param faceUp sets whether the drawn card will be face up or not
     * @return drawn card
     */
    public Card drawCard(boolean faceUp) {
        Card firstcard = cards.getFirst();
        if (firstcard.isFaceUp()) {
            this.shuffle();
            System.out.println(this);
        }
        Card card = cards.removeFirst();
        if (faceUp) {
            card.setFaceUp();
        } else {
            card.setFaceDown();
            }
        return card;
    }

    /**
     *Returns the collection of cards in the pile's current state.
     *
     * @return the pile of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     *Is there at least one card in the pile
     *
     * @return whether there is a card in the pile or none.
     */
    public boolean hasCard() {
        return !cards.isEmpty();
    }

    /**
     *Create and set the seed for the random number generator
     *
     * @param seed seed value
     */
    public static void setSeed(long seed) {
        Pile.rng = new Random();
        rng.setSeed(seed);
    }

    /**
     *Shuffle the cards and set them all to face down.
     * It displays the following to standard output: "Shuffling {name} pile".
     */
    public void shuffle() {
        Collections.shuffle(cards, rng);
        System.out.println( "Shuffling " + this.name + " pile");
        for (Card card : cards) {
            card.setFaceDown();
        }
    }

    /**
     *Returns a string representation of the pile in the format:
     *"{name} pile: first-card second-card ..."
     *
     * @return pile of cards in string output
     */
    public String toString() {
        String cards = this.name + " pile: ";
        for (Card card : this.cards) {
            cards += card.toString() + " ";
        }
        return cards;
    }
}
