import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw02.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Represents tests for {@link BasicPyramidSolitaire}.
 */
public class BasicPyramidSolitaireTest {
  // Instantiates BasicPyramidSolitaire class
  private BasicPyramidSolitaire bps = new BasicPyramidSolitaire();

  private ArrayList<ArrayList<Card>> cardArray = new ArrayList<>();

  // Empty deck of cards
  private List<Card> emptyDeck = new ArrayList<>();

  // Clubs
  private Card aceClubs = new Card(Value.ACE, Suit.CLUBS);
  private Card twoClubs = new Card(Value.TWO, Suit.CLUBS);
  private Card threeClubs = new Card(Value.THREE, Suit.CLUBS);
  private Card fourClubs = new Card(Value.FOUR, Suit.CLUBS);
  private Card fiveClubs = new Card(Value.FIVE, Suit.CLUBS);
  private Card sixClubs = new Card(Value.SIX, Suit.CLUBS);
  private Card sevenClubs = new Card(Value.SEVEN, Suit.CLUBS);
  private Card eightClubs = new Card(Value.EIGHT, Suit.CLUBS);
  private Card nineClubs = new Card(Value.NINE, Suit.CLUBS);
  private Card tenClubs = new Card(Value.TEN, Suit.CLUBS);
  private Card jackClubs = new Card(Value.JACK, Suit.CLUBS);
  private Card queenClubs = new Card(Value.QUEEN, Suit.CLUBS);
  private Card kingClubs = new Card(Value.KING, Suit.CLUBS);

  // Spades
  private Card aceSpades = new Card(Value.ACE, Suit.SPADES);
  private Card twoSpades = new Card(Value.TWO, Suit.SPADES);
  private Card threeSpades = new Card(Value.THREE, Suit.SPADES);
  private Card fourSpades = new Card(Value.FOUR, Suit.SPADES);
  private Card fiveSpades = new Card(Value.FIVE, Suit.SPADES);
  private Card sixSpades = new Card(Value.SIX, Suit.SPADES);
  private Card sevenSpades = new Card(Value.SEVEN, Suit.SPADES);
  private Card eightSpades = new Card(Value.EIGHT, Suit.SPADES);
  private Card nineSpades = new Card(Value.NINE, Suit.SPADES);
  private Card tenSpades = new Card(Value.TEN, Suit.SPADES);
  private Card jackSpades = new Card(Value.JACK, Suit.SPADES);
  private Card queenSpades = new Card(Value.QUEEN, Suit.SPADES);
  private Card kingSpades = new Card(Value.KING, Suit.SPADES);

  // Hearts
  private Card aceHearts = new Card(Value.ACE, Suit.HEARTS);
  private Card twoHearts = new Card(Value.TWO, Suit.HEARTS);
  private Card threeHearts = new Card(Value.THREE, Suit.HEARTS);
  private Card fourHearts = new Card(Value.FOUR, Suit.HEARTS);
  private Card fiveHearts = new Card(Value.FIVE, Suit.HEARTS);
  private Card sixHearts = new Card(Value.SIX, Suit.HEARTS);
  private Card sevenHearts = new Card(Value.SEVEN, Suit.HEARTS);
  private Card eightHearts = new Card(Value.EIGHT, Suit.HEARTS);
  private Card nineHearts = new Card(Value.NINE, Suit.HEARTS);
  private Card tenHearts = new Card(Value.TEN, Suit.HEARTS);
  private Card jackHearts = new Card(Value.JACK, Suit.HEARTS);
  private Card queenHearts = new Card(Value.QUEEN, Suit.HEARTS);
  private Card kingHearts = new Card(Value.KING, Suit.HEARTS);

  // Diamonds
  private Card aceDiamonds = new Card(Value.ACE, Suit.DIAMONDS);
  private Card twoDiamonds = new Card(Value.TWO, Suit.DIAMONDS);
  private Card threeDiamonds = new Card(Value.THREE, Suit.DIAMONDS);
  private Card fourDiamonds = new Card(Value.FOUR, Suit.DIAMONDS);
  private Card fiveDiamonds = new Card(Value.FIVE, Suit.DIAMONDS);
  private Card sixDiamonds = new Card(Value.SIX, Suit.DIAMONDS);
  private Card sevenDiamonds = new Card(Value.SEVEN, Suit.DIAMONDS);
  private Card eightDiamonds = new Card(Value.EIGHT, Suit.DIAMONDS);
  private Card nineDiamonds = new Card(Value.NINE, Suit.DIAMONDS);
  private Card tenDiamonds = new Card(Value.TEN, Suit.DIAMONDS);
  private Card jackDiamonds = new Card(Value.JACK, Suit.DIAMONDS);
  private Card queenDiamonds = new Card(Value.QUEEN, Suit.DIAMONDS);
  private Card kingDiamonds = new Card(Value.KING, Suit.DIAMONDS);

  private void init() {
    // CLUBS
    emptyDeck.add(aceClubs);
    emptyDeck.add(twoClubs);
    emptyDeck.add(threeClubs);
    emptyDeck.add(fourClubs);
    emptyDeck.add(fiveClubs);
    emptyDeck.add(sixClubs);
    emptyDeck.add(sevenClubs);
    emptyDeck.add(eightClubs);
    emptyDeck.add(nineClubs);
    emptyDeck.add(tenClubs);
    emptyDeck.add(jackClubs);
    emptyDeck.add(queenClubs);
    emptyDeck.add(kingClubs);
    // SPADES
    emptyDeck.add(aceSpades);
    emptyDeck.add(twoSpades);
    emptyDeck.add(threeSpades);
    emptyDeck.add(fourSpades);
    emptyDeck.add(fiveSpades);
    emptyDeck.add(sixSpades);
    emptyDeck.add(sevenSpades);
    emptyDeck.add(eightSpades);
    emptyDeck.add(nineSpades);
    emptyDeck.add(tenSpades);
    emptyDeck.add(jackSpades);
    emptyDeck.add(queenSpades);
    emptyDeck.add(kingSpades);
    // HEARTS
    emptyDeck.add(aceHearts);
    emptyDeck.add(twoHearts);
    emptyDeck.add(threeHearts);
    emptyDeck.add(fourHearts);
    emptyDeck.add(fiveHearts);
    emptyDeck.add(sixHearts);
    emptyDeck.add(sevenHearts);
    emptyDeck.add(eightHearts);
    emptyDeck.add(nineHearts);
    emptyDeck.add(tenHearts);
    emptyDeck.add(jackHearts);
    emptyDeck.add(queenHearts);
    emptyDeck.add(kingHearts);
    // DIAMONDS
    emptyDeck.add(aceDiamonds);
    emptyDeck.add(twoDiamonds);
    emptyDeck.add(threeDiamonds);
    emptyDeck.add(fourDiamonds);
    emptyDeck.add(fiveDiamonds);
    emptyDeck.add(sixDiamonds);
    emptyDeck.add(sevenDiamonds);
    emptyDeck.add(eightDiamonds);
    emptyDeck.add(nineDiamonds);
    emptyDeck.add(tenDiamonds);
    emptyDeck.add(jackDiamonds);
    emptyDeck.add(queenDiamonds);
    emptyDeck.add(kingDiamonds);
  }

  @Test
  public void testGetDeck() {
    init();
    assertEquals(emptyDeck, bps.getDeck());
  }

  @Test
  public void testGetDeckEmptyDeck() {
    assertNotEquals(emptyDeck, bps.getDeck());
  }

  @Test
  public void testGetDeckShuffle() {
    init();
    Collections.shuffle(emptyDeck);

    assertNotEquals(emptyDeck, bps.getDeck());
  }

  @Test
  public void testGetDeckShuffle2() {
    bps.startGame(bps.getDeck(), true, 9, 3);

    assertNotEquals(emptyDeck, bps.getDeck());
  }

  @Test
  public void testGetDrawCardsDrawThreeCards() {
    bps.startGame(bps.getDeck(), false, 9, 3);

    ArrayList<Card> drawPileCards = new ArrayList<>();
    drawPileCards.add(sevenDiamonds);
    drawPileCards.add(eightDiamonds);
    drawPileCards.add(nineDiamonds);

    assertEquals(drawPileCards, bps.getDrawCards());
  }

  @Test
  public void testGetDrawCardsDrawTwoCards() {
    bps.startGame(bps.getDeck(), false, 7, 2);

    ArrayList<Card> drawPileCards = new ArrayList<>();
    drawPileCards.add(threeHearts);
    drawPileCards.add(fourHearts);
    bps.getDrawCards();
    bps.getDrawCards();

    assertEquals(drawPileCards, bps.getDrawCards());
  }

  @Test
  public void testGetCardAtExposedCard() {
    bps.startGame(bps.getDeck(), false, 9, 3);

    assertEquals(jackHearts, bps.getCardAt(8,0));
  }

  @Test
  public void testGetCardAtFourClubs() {
    bps.startGame(bps.getDeck(), false, 3, 3);

    assertEquals(fourClubs, bps.getCardAt(2,0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIllegalCard() {
    bps.startGame(bps.getDeck(), false, 9, 3);
    bps.getCardAt(0,2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtIllegalRow() {
    bps.startGame(bps.getDeck(), false, 7, 3);
    bps.getCardAt(7,0);
  }

  @Test
  public void testStartGame() {
    bps.startGame(bps.getDeck(), false, 7, 3);

    assertTrue(bps.getDeck() != null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveTwoCardsIllegal() {
    bps.startGame(bps.getDeck(), false, 4, 3);
    bps.remove(2, 2, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawIllegal() {
    bps.startGame(bps.getDeck(), false, 4, 3);
    bps.removeUsingDraw(1,2,1);
  }

  @Test
  public void testDiscardDraw() {
    bps.startGame(bps.getDeck(), false, 2, 3);
    bps.getDrawCards();
    bps.discardDraw(0);

    ArrayList<Card> drawPile = new ArrayList<>();
    drawPile.add(sevenClubs);
    drawPile.add(fiveClubs);
    drawPile.add(sixClubs);

    assertEquals(drawPile, bps.getDrawCards());
  }

  @Test
  public void testGetNumRowsSixRows() {
    bps.startGame(bps.getDeck(), false, 6, 3);

    assertEquals(6, bps.getNumRows());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetNumRowsIllegalCardNumber() {
    bps.startGame(bps.getDeck(), false, 10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetNumRowsIllegalZeroRows() {
    bps.startGame(bps.getDeck(), false, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetNumRowsIllegalTenRows() {
    bps.startGame(bps.getDeck(), false, 10, 3);
  }

  @Test
  public void testGetNumDraw() {
    bps.startGame(bps.getDeck(), false, 5, 3);

    assertEquals(3, bps.getNumDraw());
  }

  @Test
  public void testGetRowWidthFiveRows() {
    bps.startGame(bps.getDeck(), false, 6, 3);

    assertEquals(5, bps.getRowWidth(4));
  }

  @Test
  public void testGetRowWidthOneRow() {
    bps.startGame(bps.getDeck(), false, 5, 3);

    assertEquals(1, bps.getRowWidth(0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthIllegal() {
    bps.startGame(bps.getDeck(), false, 6, 3);
    bps.getRowWidth(6);
  }

  @Test
  public void testGetScoreTwoRows() {
    bps.startGame(bps.getDeck(), false, 2, 3);
    bps.isGameOver();

    assertEquals(6, bps.getScore());
  }

  @Test
  public void testGetScoreFourRows() {
    bps.startGame(bps.getDeck(), false, 4, 3);

    assertEquals(55, bps.getScore());
  }

  //TODO: test game has not started
}