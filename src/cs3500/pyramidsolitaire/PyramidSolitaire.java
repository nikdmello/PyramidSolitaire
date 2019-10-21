package cs3500.pyramidsolitaire;

import java.io.InputStreamReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;

/**
 * The main class from where the basic pyramid solitaire game can be run.
 */
public final class PyramidSolitaire {

  /**
   * The method that starts the game.
   */
  public static void main(String[] args) {
    PyramidSolitaireModel<Card> model;

    //    if (args.length > 0) {
    //
    //    }

    Readable r = new InputStreamReader(System.in);
    PyramidSolitaireTextualController controller = new PyramidSolitaireTextualController(r,
            System.out);

    switch (args[0]) {
      case "relaxed":
        model = PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.RELAXED);
        break;
      case "basic":
        model = PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.BASIC);
        break;
      case "tripeaks":
        model = PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.TRIPEAKS);
        break;
      default:
        throw new IllegalStateException("Unexpected value");
    }

    controller.playGame(model, model.getDeck(), true, 7, 3);
  }

}

