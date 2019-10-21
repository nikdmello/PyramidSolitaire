package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents a relaxed version of the game that implements {@link PyramidSolitaireModel}.
 * The game relaxes the rules on removing cards as long as it is partially uncovered and is a pair.
 */
public class RelaxedPyramidSolitaire extends AbstractPyramidSolitaire {

  /**
   * Constructs a RelaxedPyramidSolitaire with no arguments.
   */
  public RelaxedPyramidSolitaire() {
    // Empty constructor
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

    if (isCardExposedRelaxed(row1, card1) && isCardExposedRelaxed(row2, card2)) {
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

  /**
   * Returns whether a card is covered by at most one card.
   *
   * @param row  the card row index.
   * @param card the card column index.
   * @return whether the card is exposed.
   */
  private boolean isCardExposedRelaxed(int row, int card) {
    if (row == numOfRows - 1) {
      return true;
    } else {
      return pyramid.get(row + 1).get(card) == null
             || pyramid.get(row + 1).get(card + 1) == null;
    }
  }
}
