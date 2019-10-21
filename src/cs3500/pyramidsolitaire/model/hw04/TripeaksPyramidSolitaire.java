package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

/**
 * Represents a TriPeaks version of the game that implements {@link PyramidSolitaireModel}.
 * The game has 3 overlapping pyramids instead of just one pyramid.
 */
public class TripeaksPyramidSolitaire extends AbstractPyramidSolitaire {
  private ArrayList<ArrayList<Card>> triPyramid;

  /**
   * Constructs a TripeaksPyramidSolitaire with no arguments.
   */
  public TripeaksPyramidSolitaire() {
    // Empty constructor
  }

  @Override
  public List<Card> getDeck() {
    List<Card> doubleDeck = new ArrayList<>();

    // Loops through each suit and rank and creates new cards to add to deck
    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        doubleDeck.add(new Card(rank, suit));
      }
    }

    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        doubleDeck.add(new Card(rank, suit));
      }
    }
    return doubleDeck;
  }

  @Override
  public void startGame(List<Card> deck, boolean shouldShuffle, int numRows, int numDraw) {
    ArrayList<Card> deckCopy = new ArrayList<>(deck);

    validateInputs(numRows, numDraw);
    validateDoubleDeck(deck);

    numOfRows = numRows;
    started = true;

    // Shuffles the list of cards
    if (shouldShuffle) {
      Collections.shuffle(deckCopy);
    }

    this.getTriPyramid(deckCopy);
  }

  /**
   * Validates the inputs given when the game is started.
   *
   * @param numRows the number of rows given.
   * @param numDraw the number of draw cards given.
   */
  void validateInputs(int numRows, int numDraw) {
    if (numRows > 8 || numRows < 1) {
      throw new IllegalArgumentException("numRows input is invalid.");
    }

    if (numDraw < 1) {
      throw new IllegalArgumentException("numDraw input is invalid.");
    }
  }

  /**
   * Validates the deck by checking the size and for repeated cards.
   *
   * @param deck the deck of cards.
   */
  private void validateDoubleDeck(List<Card> deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck is null.");
    }

    if (deck.size() != 104) {
      throw new IllegalArgumentException("Deck is of invalid size.");
    }
  }

  /**
   * Returns the representation of cards in an ArrayList of ArrayList of Cards.
   *
   * @param deck the deck of cards
   */
  private void getTriPyramid(List<Card> deck) {
    triPyramid = new ArrayList<>();

    // Adds card arrays to arrayList
    for (int i = 0; i < getNumRows(); i++) {
      triPyramid.add(new ArrayList<>());
    }

    int rowWidth;
    if (numOfRows % 2 == 0) {
      rowWidth = numOfRows + 1;
    } else {
      rowWidth = numOfRows;
    }

    int cardsPerRow = 3;
    int nullsPerRow = rowWidth - cardsPerRow;
    int nullsPerGroup = nullsPerRow / 2;
    int cardsPerGroup = cardsPerRow / 3;

    // Gets the ith card array in the arrayList
    for (int i = 0; i < (triPyramid.size() / 2); i++) {
      ArrayList<Card> row = triPyramid.get(i);

      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < cardsPerGroup; k++) {
          Card card = deck.remove(0);
          row.add(card);
        }
        if (j != 2) {
          for (int l = 0; l < nullsPerGroup; l++) {
            row.add(null);
          }
        }
      }
      cardsPerGroup++;
      nullsPerGroup--;

      triPyramid.set(i, row);
      List<Card> doubleDeckStock = new ArrayList<>(deck);
      System.out.println(row);
    }

    //    for (int i = (triPyramid.size() / 2); i < numOfRows; i++) {
    //      ArrayList<Card> row = triPyramid.get(i);
    //
    //        for (int j = (3 * triPyramid.size()/2); j < i; j++) {
    //        Card card = deck.remove(0);
    //        row.add(card);
    //      }
    //      for (int j = triPyramid.size(); j <= numOfRows*2; j++) {
    //        Card card = deck.remove(0);
    //        row.add(card);
    //      }
    //      System.out.println(row);
    //    }

    for (int i = (triPyramid.size() / 2); i < numOfRows; i++) {
      ArrayList<Card> row = triPyramid.get(i);
    }


    //    // Gets the ith card array in the arrayList
    //    for (int i = (triPyramid.size() / 2) - 1; i < triPyramid.size(); i++) {
    //      ArrayList<Card> row = triPyramid.get(i);
    //
    //      // Adds cards from deck to each card array
    //      for (int j = 0; j <= 3 * i; j++) {
    //        Card card = deck.remove(0);
    //        row.add(card);
    //      }
    //      System.out.println(row);
    //    }
  }

  @Override
  public int getRowWidth(int row) {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if (row > triPyramid.size() - 1) {
      throw new IllegalArgumentException("Row is invalid.");
    }

    return triPyramid.get(row).size();
  }


}
