package cs3500.pyramidsolitaire.model.hw02;

/**
 * Enumeration of playing card suits.
 */
public enum Suit {
  CLUBS('♣'),
  SPADES('♠'),
  HEARTS('♥'),
  DIAMONDS('♦');
  final char suit;


  /**
   * Constructs a Suit with the given suit, ranging from clubs, spades, hearts, and diamonds.
   *
   * @param suit the suit of the card
   */
  Suit(char suit) {
    this.suit = suit;
  }

  /**
   * Returns the suit as a String.
   *
   * @return the String value of the suit
   */
  public String toString() {
    return String.valueOf(this.suit);
  }
}

