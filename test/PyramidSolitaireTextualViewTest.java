import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for {@link PyramidSolitaireTextualView}.
 */
public class PyramidSolitaireTextualViewTest {
  private BasicPyramidSolitaire bps = new BasicPyramidSolitaire();

  private PyramidSolitaireTextualView bpsView = new PyramidSolitaireTextualView(bps);

  @Test
  public void testToString() {
    bps.startGame(bps.getDeck(), false, 7, 3);

    assertEquals("            A♣\n" +
            "          2♣  3♣\n" +
            "        4♣  5♣  6♣\n" +
            "      7♣  8♣  9♣  10♣\n" +
            "    J♣  Q♣  K♣  A♠  2♠\n" +
            "  3♠  4♠  5♠  6♠  7♠  8♠\n" +
            "9♠  10♠ J♠  Q♠  K♠  A♥  2♥\n" +
            "Draw: 3♥, 4♥, 5♥", bpsView.toString());
  }

  @Test
  public void testToStringGameNotStarted() {
    assertEquals("", bpsView.toString());
  }

}