package edu.cnm.deepdive;

/**
 * Instances of this class represent single cards in a deck of standard playing
 * cards.  tese intances are immutable: once initialized, the ranl and suit of
 * the a card cant be changed.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

import java.util.Random;

public class Card {

  private final Rank rank;
  private final Suit suit;

  /**
   * Initializes the <code>Card</code> instance with the specified {@link
   * Suit} and {@link Rank}.
   *
   * @param rank  card's rank (A, 2, &hellip; K).
   * @param suit  card's suit (Clubs, Diamonds, Hearts, Spades).
   */

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;

  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return String.format("%s%s", rank, suit);
  }
}
