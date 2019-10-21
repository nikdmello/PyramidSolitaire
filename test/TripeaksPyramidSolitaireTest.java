import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;
import cs3500.pyramidsolitaire.model.hw04.TripeaksPyramidSolitaire;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for {@link TripeaksPyramidSolitaire}.
 */
public class TripeaksPyramidSolitaireTest {
  private TripeaksPyramidSolitaire tps = new TripeaksPyramidSolitaire();

  @Test
  public void testGetDeck() {
    List<Card> doubleDeck = new ArrayList<>();

    // Loops through each suit and rank and creates new cards to add to deck
    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        doubleDeck.add(new Card(rank, suit));
      }
    }
    for (Suit suit : Suit.values()) {
      for (Value rank : Value.values()) {
        doubleDeck.add(new Card(rank, suit));
      }
    }

    assertEquals(doubleDeck, tps.getDeck());
  }

  @Test
  public void testStartGame() {
    tps.startGame(tps.getDeck(), false, 8, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalNineRows() {
    tps.startGame(tps.getDeck(),false,9,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalZeroNumDraw() {
    tps.startGame(tps.getDeck(),false,9,0);
  }
}
