package mypack;

import static org.junit.Assert.*;
import org.junit.*;
//import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.Random;

/*******************************************
 * The test class for PokerDice - phase1
 *
 ******************************************/
public class MyPokerDiceJUnitPhase1{
    /** object of the PokerDice class */
    private PokerDice game;

    /** the game dice */
    private ArrayList<GVdie> dice;

    /******************************************************
     * Instantiate - PokerGame
     * Called before every test case method.
     *****************************************************/
    @Before
    public void setUp()
    {
        game = new PokerDice();
        dice = game.getDice();
    }

    /******************************************************
     * Test initial values of the constructor
     *****************************************************/
    @Test
    public void testConstructor()
    {
        assertEquals("Constructor: rounds should be zero",
                0, game.getNumRounds());

        assertEquals("Constructor: rolls should be zero",
                0, game.getNumRolls());

        assertEquals("Constructor: score should be zero",
                0, game.getScore());

        assertEquals("Constructor: dice array should have 5 GVdie",
                5, game.getDice().size());

        for (GVdie d : dice) {
            assertFalse("resetGame(): the dice should not be held", d.isHeld());
        }
    }

    /******************************************************
     * Test resetGame
     *****************************************************/
    @Test
    public void testResetGame()
    {
        game.resetGame();
        assertEquals("Instance variables should be reset to zero in resetGame()",
                0, game.getScore());
        assertTrue ("resetGame(): did you reset number of rolls?", game.okToRoll());
        assertFalse ("resetGame(): did you reset number of rounds?", game.gameOver());

        for (GVdie d : dice) {
            assertFalse("resetGame(): the dice should not be held", d.isHeld());
        }
    }

}
