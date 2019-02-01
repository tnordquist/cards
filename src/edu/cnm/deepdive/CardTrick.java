package edu.cnm.deepdive;

import edu.cnm.deepdive.Deck.DeckEmptyException;
import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CardTrick {

  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng;

  public CardTrick() {
    rng = new Random();
    redPile = new ArrayList<>();
    blackPile = new ArrayList<>();
  }

  public Deck prepareDeck() {
    Deck deck = new Deck();
    deck.shuffle(rng);
    return deck;
  }

  public void splitDeck(Deck deck) {
    try {
      while (true) {
        Card card1 = deck.deal();
        Card card2 = deck.deal();
        switch (card1.getSuit().getColor()) {
          case RED:
            redPile.add(card2);
            break;
          case BLACK:
            blackPile.add(card2);
            break;
        }
      }
    } catch (DeckEmptyException e) {
      // Does Nothing.
    }
  }

  public void swapCards() {
    int count = rng.nextInt(Math.min(redPile.size(), blackPile.size()) + 1);
//    int count = rng.nextInt(1 + ((redPile.size() > blackPile.size()) ? blackPile.size() : redPile.size()));
    List<Card> redExtract = new LinkedList<>();
    List<Card> blackExtract = new LinkedList<>();
    System.out.printf("Swapping %d cards between red and black piles.%n", count);
    for (int i = 0; i < count; i++) {
      redExtract.add(redPile.remove(0));
      blackExtract.add(blackPile.remove(0));
    }
    System.out.printf("Black extract: %s%n", blackExtract);
    System.out.printf("Red extract: %s%n", redExtract);
    redPile.addAll(blackExtract);
    blackPile.addAll(redExtract);
  }

  public void countAndReport() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().getColor() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().getColor() == Color.BLACK) {
        blackCount++;
      }
    }
    Collections.sort(redPile);
    Collections.sort(blackPile);
    System.out.printf("Black pile: %s%n", blackPile);
    System.out.printf("Red pile: %s%n", redPile);

    System.out.printf("Black: %d. Red: %d.%n", blackCount, redCount);
  }  // end countAndReport()

  public static void main(String[] args) {
    CardTrick trick = new CardTrick();
    Deck deck = trick.prepareDeck();
    trick.splitDeck(deck);
    trick.swapCards();
    trick.countAndReport();
  }

}
