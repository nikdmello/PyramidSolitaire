import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Represents tests for {@link PyramidSolitaireTextualController}.
 */
public class PyramidSolitaireTextualControllerTest {
  private PyramidSolitaireModel<Card> model = new BasicPyramidSolitaire();
  private PyramidSolitaireModel<Card> model2 = new BasicPyramidSolitaire();

  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(null, null);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() {

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(null, null);

  }

  @Test
  public void testRemoveOneCard() {

    Interaction[] interactionsRemoveOne = new Interaction[]{
        new InputInteraction("rm1 5 3\n"),
        new PrintInteraction("        A♣\n" +
                             "      2♣  3♣\n" +
                             "    4♣  5♣  6♣\n" +
                             "  7♣  8♣  9♣  10♣\n" +
                             "J♣  Q♣  K♣  A♠  2♠\n" +
                             "Draw: 3♠, 4♠, 5♠\n" +
                             "Score: 94\n" +
                             "        A♣\n" +
                             "      2♣  3♣\n" +
                             "    4♣  5♣  6♣\n" +
                             "  7♣  8♣  9♣  10♣\n" +
                             "J♣  Q♣      A♠  2♠\n" +
                             "Draw: 3♠, 4♠, 5♠\n" +
                             "Score: 81"),
        };

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (Interaction i : interactionsRemoveOne) {
      i.apply(sb1, sb2);
    }

    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactionsRemoveOne) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 5, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testRemoveTwoCards() {

    Interaction[] interactionsRemoveTwo = new Interaction[]{
        new InputInteraction("rm2 6 3 6 6\n"),
        new PrintInteraction("          A♣\n" +
                             "        2♣  3♣\n" +
                             "      4♣  5♣  6♣\n" +
                             "    7♣  8♣  9♣  10♣\n" +
                             "  J♣  Q♣  K♣  A♠  2♠\n" +
                             "3♠  4♠  5♠  6♠  7♠  8♠\n" +
                             "Draw: 9♠, 10♠, J♠\n" +
                             "Score: 127\n" +
                             "          A♣\n" +
                             "        2♣  3♣\n" +
                             "      4♣  5♣  6♣\n" +
                             "    7♣  8♣  9♣  10♣\n" +
                             "  J♣  Q♣  K♣  A♠  2♠\n" +
                             "3♠  4♠      6♠  7♠\n" +
                             "Draw: 9♠, 10♠, J♠\n" +
                             "Score: 114"),
        };

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (Interaction i : interactionsRemoveTwo) {
      i.apply(sb1, sb2);
    }

    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactionsRemoveTwo) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 6, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testGameWon() {

    Interaction[] interactionsWin = new Interaction[]{
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("dd 1\n"),
        new InputInteraction("rmwd 1 1 1\n"),
        new PrintInteraction("A♣\n"
                             + "Draw: 2♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 5♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 6♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 7♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 8♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 9♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: 10♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: J♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "A♣\n"
                             + "Draw: Q♣, 3♣, 4♣\n"
                             + "Score: 1\n"
                             + "You win!"),
        };

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (Interaction i : interactionsWin) {
      i.apply(sb1, sb2);
    }

    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactionsWin) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 1, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testQuit() {

    Interaction[] interactionsRemoveOne = new Interaction[]{
        new InputInteraction("q\n"),
        new PrintInteraction("    A♣\n" +
                             "  2♣  3♣\n" +
                             "4♣  5♣  6♣\n" +
                             "Draw: 7♣, 8♣, 9♣\n" +
                             "Score: 21\n" +
                             "Game quit!\n" +
                             "State of game when quit:\n" +
                             "    A♣\n" +
                             "  2♣  3♣\n" +
                             "4♣  5♣  6♣\n" +
                             "Draw: 7♣, 8♣, 9♣\n" +
                             "Score: 21"),
        };

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (Interaction i : interactionsRemoveOne) {
      i.apply(sb1, sb2);
    }

    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactionsRemoveOne) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 3, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }


  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(null, model.getDeck(), false, 5, 3);
  }

  @Test(expected = IllegalStateException.class)
  public void testNullDeck() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, null, false, 5, 3);
  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalNumRows() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 0, 3);
  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalNumDraw() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 1, 0);
  }

  @Test
  public void testInvalidDiscardDraw() {
    Interaction[] interactionsInvalid = new Interaction[]{
        new InputInteraction("dd 4\n"),
        new PrintInteraction("      A♣\n"
                             + "    2♣  3♣\n"
                             + "  4♣  5♣  6♣\n"
                             + "7♣  8♣  9♣  10♣\n"
                             + "Draw: J♣, Q♣, K♣\n"
                             + "Score: 55\n"
                             + "Invalid move. Play again. Draw index is invalid.\n"
                             + "      A♣\n"
                             + "    2♣  3♣\n"
                             + "  4♣  5♣  6♣\n"
                             + "7♣  8♣  9♣  10♣\n"
                             + "Draw: J♣, Q♣, K♣\n"
                             + "Score: 55"),
        };

    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (Interaction i : interactionsInvalid) {
      i.apply(sb1, sb2);
    }

    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactionsInvalid) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 4, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test
  public void testShuffleDeck() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);

    controller.playGame(model, model.getDeck(), true, 4, 3);
    controller.playGame(model2, model2.getDeck(), false, 4, 3);

    assertNotEquals(model.getCardAt(1,1), model2.getCardAt(1,1));
  }

  @Test
  public void testSupplyDeck() {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireTextualController controller =
            new PyramidSolitaireTextualController(input, actualOutput);

    controller.playGame(model, model.getDeck(), false, 4, 3);

    List<Card> deck = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        deck.add(new Card(rank, suit));
      }
    }

    assertEquals(model.getDeck(), deck);
  }



  //  @Test
  //  public void testInvalidInput() {
  //    Interaction[] interactionsInvalid = new Interaction[]{
  //            new InputInteraction("rm1 9 a\n"),
  //            new PrintInteraction("Invalid input. Play again. "
  //                                 + "Replace typo with desired input."),
  //            };
  //
  //    StringBuilder sb1 = new StringBuilder();
  //    StringBuilder sb2 = new StringBuilder();
  //    for (Interaction i : interactionsInvalid) {
  //      i.apply(sb1, sb2);
  //    }
  //
  //    StringBuilder fakeUserInput = new StringBuilder();
  //    StringBuilder expectedOutput = new StringBuilder();
  //
  //    for (Interaction interaction : interactionsInvalid) {
  //      interaction.apply(fakeUserInput, expectedOutput);
  //    }
  //
  //    StringReader input = new StringReader(fakeUserInput.toString());
  //    StringBuilder actualOutput = new StringBuilder();
  //
  //    PyramidSolitaireTextualController controller =
  //            new PyramidSolitaireTextualController(input, actualOutput);
  //    controller.playGame(model, model.getDeck(), false, 4, 3);
  //
  //    assertEquals(expectedOutput.toString(), actualOutput.toString());
  //
  //  }


}