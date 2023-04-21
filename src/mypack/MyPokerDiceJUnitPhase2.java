package mypack;


import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Random;
/*******************************************
 * The test class for PokerDice - phase 2
 *
 ******************************************/
public class MyPokerDiceJUnitPhase2{
    /** object of the PokerDice class */
    private PokerDice game;

    private static final int NUM_DICE = 5;

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

    /******************************************************
     * Test setDice - valid values
     *****************************************************/
    @Test
    public void testSetDiceOKValues()
    {
        game.resetGame();
        int [] vals = generateRandomVals();
        game.setDice(vals);

        for (int i = 0; i < vals.length ; i++) {
            assertEquals("gvdie value should be", vals[i], dice.get(i).getValue() );
        }
    }


    /******************************************************
     * Test diceToString
     *****************************************************/
    @Test
    public void testDiceToString()
    {
        game.resetGame();
        int [] vals = generateRandomVals();
        game.setDice(vals);
        assertEquals("Dice to String should be", valuesToString(vals), game.diceToString());

    }

    /******************************************************
     * generate an array of NUM-DICE random numbers
     * between 1 - 6 (inclusive)
     * @return int [] - array of NUM_DICE random numbers
     *****************************************************/
    private int[] generateRandomVals() {
        Random rand = new Random ();
        int [] values = new int [NUM_DICE];
        for (int i = 0; i < values.length; i++)
            values[i] = rand.nextInt(6) + 1;
        return values;
    }

    /******************************************************
     * Converts an array to a String
     * @return String -
     *****************************************************/
    private String valuesToString (int [] values){
        String s = "[";
        s += values [0];
        for (int i = 1 ; i <= values.length - 1 ; i++)
            s += "," + values [i];
        s += "]";
        return s;
    }
}