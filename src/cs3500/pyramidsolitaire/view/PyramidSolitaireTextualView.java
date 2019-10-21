package cs3500.pyramidsolitaire.view;

import java.io.IOException;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents the textual view of the basic pyramid solitaire model.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {
  private final PyramidSolitaireModel<?> model;
  private Appendable out;

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
  }

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable out) {
    this.model = model;
    this.out = out;
  }

  @Override
  public void render() throws IOException {
    out.append(toString()).append("\n");
  }

  @Override
  public String toString() {
    String result = "";

    // Game is not started
    if (model.getNumDraw() == -1) {
      return result;
    }

    // Game is won
    if (model.getScore() == 0) {
      result = "You win!";
      return result;
    }

    // Game is over
    if (model.isGameOver()) {
      result = "Game over. Score: " + model.getScore();
      return result;
    }

    // Renders pyramid
    for (int i = 0; i < model.getNumRows(); i++) {
      for (int k = 1; k < model.getNumRows() - i; k++) {
        result = result.concat("  ");
      }
      for (int j = 0; j < i + 1; j++) {
        if (model.getCardAt(i, j) == null) {
          result = result.concat("    ");
        } else if (model.getCardAt(i, j).toString().length() == 3) {
          result = result.concat(model.getCardAt(i, j).toString()).concat(" ");
        } else {
          result = result.concat(model.getCardAt(i, j).toString()).concat("  ");
        }
      }
      result = result.stripTrailing();
      result = result.concat("\n");
    }

    // Renders draw string
    if (model.getNumDraw() == 0) {
      result = result.concat("Draw:");
    } else {
      result = result.concat("Draw: ");
    }

    // Renders the draw cards
    for (int i = 0; i < model.getNumDraw(); i++) {
      if (model.getDrawCards().get(i) != null) {
        result = result.concat(model.getDrawCards().get(i).toString());
      }
      else {
        result = result.concat("  ").replaceFirst(",", "");
      }
      if (i < model.getNumDraw() - 1) {
        result = result.concat(", ");
      }
    }

    return result;
  }
}
