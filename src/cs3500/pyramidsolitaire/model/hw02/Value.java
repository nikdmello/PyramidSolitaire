package cs3500.pyramidsolitaire.model.hw02;

/**
 * Enumeration of playing card values.
 */
public enum Value {
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13);
  final public int value;

  /**
   * Constructs a Value with the given value, ranging from 2 to 10, A, J, Q, and K.
   *
   * @param value the value of the card
   */
  Value(int value) {
    this.value = value;
  }

  /**
   * Returns the value as a String.
   *
   * @return the String value of the suit
   */
  public String toString() {
    switch (this.value) {
      case 1:
        return "A";
      case 11:
        return "J";
      case 12:
        return "Q";
      case 13:
        return "K";
      default:
        return Integer.toString(this.value);
    }
  }
}
