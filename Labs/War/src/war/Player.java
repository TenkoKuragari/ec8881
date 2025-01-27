package war;

/**
 *Represents a single player in the game.
 *
 * @author Ethan Chen
 */

public class Player {
    private final Pile pile;
    private boolean winner;

    /**
     * Create the player with their id.
     *
     * @param id the players id number
     */
    public Player (int id) {
        this.pile = new Pile("P" + id);
        this.winner = false;
    }

    /**
     * Add the collection of cards from the incoming pile to the bottom of player's pile, in order.
     *
     * @param card the incoming pile of cards to add to this player's pile
     */
    public void addCard(Card card) {
        this.pile.addCard(card);
    }

    /**
     *Add the collection of cards from the incoming pile to the bottom of player's pile, in order.
     *
     * @param cards the incoming pile of cards to add to this player's pile
     */
    public void addCards(Pile cards) {
        for (Card c : cards.getCards()) {
            this.pile.addCard(c);
        }
    }

    /**
     * Remove a card from the top of the pile.
     *
     * @return the newly removed card from the top of the pile
     */
    public Card drawCard() {
        return this.pile.drawCard(true);
    }

    /**
     * Checks whether there are cards in the player's pile or not.
     *
     * @return whether there are cards in the player's pile or not.
     */
    public boolean hasCard() {
        return this.pile.hasCard();
    }

    /**
     * Checks whether this player is the winner or not
     *
     * @return whether this player was the winner or not
     */
    public boolean isWinner() {
        return this.winner;
    }

    /**
     * Declare this player to be the winner.
     */
    public void setWinner() {
        this.winner = true;
    }

    /**
     * Returns a string representation of this player's pile
     *
     * @return string of players pile
     */
    @Override
    public String toString() {
        return this.pile.toString();
    }
}
