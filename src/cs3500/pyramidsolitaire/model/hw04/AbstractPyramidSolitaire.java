package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

/**
 * Abstract base class for implementations of {@link PyramidSolitaireModel}.
 */
public class AbstractPyramidSolitaire implements PyramidSolitaireModel<Card> {
  private int numDrawCards;
  int numOfRows;
  ArrayList<ArrayList<Card>> pyramid;
  boolean started = false;
  /**
   * Represents the list of draw cards.
   */
  private List<Card> drawPile;
  /**
   * Represents the list of cards left after dealing the pyramid.
   */
  private List<Card> stock;

  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();

    // Loops through each suit and rank and creates new cards to add to deck
    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        deck.add(new Card(rank, suit));
      }
    }
    return deck;
  }

  @Override
  public void startGame(List<Card> deck, boolean shouldShuffle, int numRows, int numDraw) {
    ArrayList<Card> deckCopy = new ArrayList<>(deck);

    validateInputs(numRows, numDraw);
    validateDeck(deckCopy);

    numDrawCards = numDraw;
    numOfRows = numRows;
    started = true;

    // Shuffles the list of cards
    if (shouldShuffle) {
      Collections.shuffle(deckCopy);
    }

    this.getPyramid(deckCopy);
  }

  /**
   * Validates the deck by checking the size and for repeated cards.
   *
   * @param deck the deck of cards.
   */
  private void validateDeck(List<Card> deck) {
    if (deck == null) {
      throw new IllegalArgumentException("Deck is null.");
    }

    if (deck.size() != 52) {
      throw new IllegalArgumentException("Deck is of invalid size.");
    }

    for (int i = 0; i < deck.size(); i++) {
      for (int j = i + 1; j < deck.size(); j++) {
        if (deck.get(i).equals(deck.get(j))) {
          throw new IllegalArgumentException("Deck is invalid.");
        }
      }
    }
  }

  /**
   * Validates the inputs given when the game is started.
   *
   * @param numRows the number of rows given.
   * @param numDraw the number of draw cards given.
   */
  void validateInputs(int numRows, int numDraw) {
    if (numRows > 9 || numRows < 1) {
      throw new IllegalArgumentException("numRows input is invalid.");
    }

    if (numDraw < 1) {
      throw new IllegalArgumentException("numDraw input is invalid.");
    }
  }

  /**
   * Returns the representation of cards in an ArrayList of ArrayList of Cards.
   *
   * @param deck the deck of cards
   */
  private void getPyramid(List<Card> deck) {
    pyramid = new ArrayList<>();

    // Adds card arrays to arrayList
    for (int i = 0; i < getNumRows(); i++) {
      pyramid.add(new ArrayList<>());
    }

    // Gets the ith card array in the arrayList
    for (int i = 0; i < pyramid.size(); i++) {
      ArrayList<Card> row = pyramid.get(i);

      // Adds cards from deck to each card array
      for (int j = 0; j <= i; j++) {
        Card card = deck.remove(0);
        row.add(card);
      }

      pyramid.set(i, row);
      stock = new ArrayList<>(deck);
    }

    drawPile = new ArrayList<>();
    int cardIdx = 0;

    // Creates draw pile
    for (int i = 0; i < numDrawCards; i++) {
      if (!stock.isEmpty()) {
        Card card = stock.remove(0);
        drawPile.add(cardIdx, card);
        cardIdx++;
      } else {
        drawPile.add(cardIdx, null);
        cardIdx++;
      }
    }
  }

  /**
   * Returns whether a card is exposed in the pyramid.
   *
   * @param row the card row index.
   * @param card  the card column index.
   * @return whether the card is exposed.
   */
  private boolean isCardExposed(int row, int card) {
    if (row == numOfRows - 1) {
      return true;
    } else {
      return pyramid.get(row + 1).get(card) == null
             && pyramid.get(row + 1).get(card + 1) == null;
    }
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if ((row1 > pyramid.size() - 1) || (row2 > pyramid.size() - 1)
        || (card1 > row1) || (card2 > row2)) {
      throw new IllegalArgumentException("Coordinates are invalid.");
    }

    Card cardToRemove1 = getCardAt(row1, card1);
    Card cardToRemove2 = getCardAt(row2, card2);

    if (isCardExposed(row1, card1) && isCardExposed(row2, card2)) {
      if ((cardToRemove1.getValue().value + cardToRemove2.getValue().value) == 13) {
        pyramid.get(row1).set(card1, null);
        pyramid.get(row2).set(card2, null);
      } else {
        throw new IllegalArgumentException("Sum of card values is not 13.");
      }
    } else {
      throw new IllegalArgumentException("The card is not exposed.");
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if ((row > pyramid.size() - 1) || (card > row)) {
      throw new IllegalArgumentException("Coordinates are invalid.");
    }

    Card cardToRemove = getCardAt(row, card);

    if (isCardExposed(row, card)) {
      if (cardToRemove.getValue() == (Value.KING)) {
        pyramid.get(row).set(card, null);
      } else {
        throw new IllegalArgumentException("Card is not a King.");
      }
    } else {
      throw new IllegalArgumentException("The card is not exposed.");
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card) throws IllegalStateException {
    this.getDrawCards();

    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if ((row > pyramid.size() - 1) || (card > row)) {
      throw new IllegalArgumentException("Coordinates are invalid.");
    }

    if (drawIndex > drawPile.size() - 1) {
      throw new IllegalArgumentException("Draw index is invalid.");
    }

    Card cardToRemove = getCardAt(row, card);
    Card drawCardToRemove = drawPile.get(drawIndex);

    if (isCardExposed(row, card)) {
      if (cardToRemove.getValue().value + drawCardToRemove.getValue().value == 13) {
        pyramid.get(row).set(card, null);
        drawPile.set(drawIndex, null);
        replaceDrawCard(drawIndex);
      } else {
        throw new IllegalArgumentException("The move is invalid: the sum does not equal 13.");
      }
    } else {
      throw new IllegalArgumentException("The card is not exposed.");
    }
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if (drawIndex > drawPile.size() - 1) {
      throw new IllegalArgumentException("Draw index is invalid.");
    }

    Card drawCardToDiscard = drawPile.get(drawIndex);

    if (drawCardToDiscard == null) {
      throw new IllegalArgumentException("No card is present there.");
    } else {
      replaceDrawCard(drawIndex);
    }
  }

  /**
   * Replaces a draw card at a given index with a stock card, or null if there are no stock cards.
   *
   * @param drawIndex the draw card index.
   */
  private void replaceDrawCard(int drawIndex) {
    if (!stock.isEmpty()) {
      drawPile.set(drawIndex, stock.remove(0));
    } else {
      drawPile.set(drawIndex, null);
    }
  }

  @Override
  public int getNumRows() {
    if (!started) {
      return -1;
    }
    return numOfRows;
  }

  @Override
  public int getNumDraw() {
    if (!started) {
      return -1;
    }

    return numDrawCards;
  }

  @Override
  public int getRowWidth(int row) {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if (row > pyramid.size() - 1) {
      throw new IllegalArgumentException("Row is invalid.");
    }

    return pyramid.get(row).size();
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    // Creates a list of the exposed cards
    ArrayList<Card> exposedCards = new ArrayList<>();

    // Adds the draw cards
    for (Card drawCard : drawPile) {
      if (drawCard != null) {
        exposedCards.add(drawCard);
      }
    }

    // Adds the exposed cards from the pyramid
    for (int row = 0; row < pyramid.size(); row++) {
      ArrayList<Card> arr = pyramid.get(row);

      for (int col = 0; col < arr.size(); col++) {
        if (pyramid.get(row).get(col) != null) {
          if (row == numOfRows - 1) {
            exposedCards.add(pyramid.get(row).get(col));
          } else if ((pyramid.get(row + 1).get(col) == null)
                     && (pyramid.get(row + 1).get(col + 1) == null)) {
            exposedCards.add(pyramid.get(row).get(col));
          }
        }
      }
    }

    boolean over = true;

    // score = 0
    if (getScore() == 0) {
      return true;
    }

    // stock is empty
    if (!stock.isEmpty()) {
      return false;
    }

    // draw pile only contains nulls
    for (Card drawCard : drawPile) {
      if (drawCard != null) {
        over = false;
        break;
      }
    }

    // exposed king in pyramid or draw pile
    for (Card c : exposedCards) {
      if (c.getValue().value == 13) {
        over = false;
        break;
      }
    }

    // checks if any two exposed cards equal to 13
    for (Card c1 : exposedCards) {
      for (Card c2 : exposedCards) {
        if (c1.getValue().value + c2.getValue().value == 13) {
          over = false;
          break;
        }
      }
    }
    return over;
  }


  @Override
  public int getScore() throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }
    int sum = 0;

    for (ArrayList<Card> arr : pyramid) {
      for (Card card : arr) {
        if (card != null) {
          sum += card.getValue().value;
        }
      }
    }
    return sum;
  }

  @Override
  public Card getCardAt(int row, int card) throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    if ((row > pyramid.size() - 1) || (card > row)) {
      throw new IllegalArgumentException("Cannot get card(s). Coordinates are invalid.");
    }

    return pyramid.get(row).get(card);
  }

  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    if (!started) {
      throw new IllegalStateException("Game has not started.");
    }

    return new ArrayList<>(drawPile);
  }
}
