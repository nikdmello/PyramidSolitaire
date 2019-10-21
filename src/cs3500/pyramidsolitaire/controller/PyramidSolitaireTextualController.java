package cs3500.pyramidsolitaire.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;

/**
 * Represents the textual controller of the basic pyramid solitaire game.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {
  private Readable rd;
  private Appendable ap;

  /**
   * Constructs the pyramid solitaire textual controller.
   *
   * @param rd Readable.
   * @param ap Appendable
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("The input or output is null.");
    }
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public <Card> void playGame(PyramidSolitaireModel<Card> model, List<Card> deck, boolean shuffle,
                              int numRows, int numDraw) {
    if (model == null) {
      throw new IllegalArgumentException("The model is null.");
    }

    if (numRows < 1 || numRows > 9 || numDraw < 1) {
      throw new IllegalStateException("Invalid input(s). Game cannot start.");
    }

    if (deck == null) {
      throw new IllegalStateException("The deck is null.");
    }

    model.startGame(deck, shuffle, numRows, numDraw);

    PyramidSolitaireView view = new PyramidSolitaireTextualView(model, ap);
    Scanner scan = new Scanner(rd);
    boolean gameNotOver = true;

    while (gameNotOver) {
      // Renders pyramid and score
      if (model.isGameOver()) {
        if (model.getScore() == 0) {
          try {
            ap.append("You win!");
            break;
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          try {
            ap.append("Game over. Score: ").append(String.valueOf(model.getScore()));
            break;
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      } else {
        try {
          view.render();
          ap.append("Score: ").append(String.valueOf(model.getScore())).append("\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      // Handles commands
      if (scan.hasNext()) {
        String command = scan.next();
        int num1;
        int num2;
        int num3;
        int num4;

        switch (command) {
          case "rm1":
            num1 = handleInput(scan);
            num2 = handleInput(scan);

            try {
              model.remove(num1 - 1, num2 - 1);
            } catch (Exception err) {
              try {
                ap.append("Invalid move. Play again. ").append(err.getMessage()).append("\n");
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            break;
          case "rm2":
            num1 = handleInput(scan);
            num2 = handleInput(scan);
            num3 = handleInput(scan);
            num4 = handleInput(scan);

            try {
              model.remove(num1 - 1, num2 - 1, num3 - 1, num4 - 1);
            } catch (Exception err) {
              try {
                ap.append("Invalid move. Play again. ").append(err.getMessage()).append("\n");
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            break;
          case "rmwd":
            num1 = handleInput(scan);
            num2 = handleInput(scan);
            num3 = handleInput(scan);

            try {
              model.removeUsingDraw(num1 - 1, num2 - 1, num3 - 1);
            } catch (Exception err) {
              try {
                ap.append("Invalid move. Play again. ").append(err.getMessage()).append("\n");
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            break;
          case "dd":
            num1 = handleInput(scan);

            try {
              model.discardDraw(num1 - 1);
            } catch (Exception err) {
              try {
                ap.append("Invalid move. Play again. ").append(err.getMessage()).append("\n");
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            break;
          case "q":
          case "Q":
            try {
              ap.append("Game quit!\nState of game when quit:\n");
            } catch (IOException e) {
              e.printStackTrace();
            }
            break;
          default:
            try {
              ap.append("Invalid move. Play again. Command is invalid.\n");
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
      } else {
        gameNotOver = false;
      }
    }
  }

  private int handleInput(Scanner scan) {
    while (true) {
      if (scan.hasNextInt()) {
        return scan.nextInt();
      }

      if (scan.hasNext()) {
        if (scan.hasNext("q") || (scan.hasNext("Q"))) {
          return -1;
        }
        try {
          ap.append("Invalid input. Play again. Replace typo with desired input.\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
        scan.next();
      }
    }
  }

}
