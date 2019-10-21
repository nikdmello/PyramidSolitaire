package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * The factory class that allows different versions of the game to be played.
 */
public class PyramidSolitaireCreator {
  /**
   * Enumeration of game types.
   */
  public enum GameType {
    BASIC, RELAXED, TRIPEAKS;
  }

  /**
   * Instantiates an implementation of {@link PyramidSolitaireModel}.
   *
   * @param type  the game type enum.
   * @return PyramidSolitaireModel.
   */
  public static PyramidSolitaireModel<Card> create(GameType type) {
    if (type == GameType.BASIC) {
      return new BasicPyramidSolitaire();
    }
    else if (type == GameType.RELAXED) {
      return new RelaxedPyramidSolitaire();
    }
    else {
      return new TripeaksPyramidSolitaire();
    }
  }
}
