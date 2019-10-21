package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents a playing card that includes a value from 1 to 13 and its suit.
 */
final public class Card {
  final private Value value;
  final private Suit suit;

  /**
   * Constructs a playing card with the given value and suit.
   *
   * @param value the value of the card
   * @param suit  the suit of the card
   */
  public Card(Value value, Suit suit) {
    if (value == null || suit == null) {
      throw new IllegalArgumentException("Value and/or suit cannot be null.");
    }
    this.value = value;
    this.suit = suit;
  }

  @Override
  public String toString() {
    return this.value.toString() + this.suit.toString();
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    if (!(that instanceof Card)) {
      return false;
    }

    return ((Card) that).value == (this.value)
            && ((Card) that).suit == this.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, suit);
  }

  public Value getValue() {
    return this.value;
  }
}