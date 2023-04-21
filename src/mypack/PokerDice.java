package mypack;

import java.util.*;

public class PokerDice {
	
	/******** PHASE 1 ********/
	
    /*** INSTANCE VARIABLES  ***/

    // General
    private ArrayList<GVdie> dice;
    private int score;
    private int rolls;
    private int rounds;
    private HashMap<Integer, Integer> tally;

    // Constants for scoring categories
    private final static int FIVE_OF_A_KIND = 50;
    private final static int FOUR_OF_A_KIND = 40;
    private final static int THREE_OF_A_KIND = 30;
    private final static int FULL_HOUSE = 35;
    private final static int SMALL_STRAIGHT = 30;
    private final static int LARGE_STRAIGHT = 45;
    private int chance;

    /*** CONSTRUCTOR ***/
    public PokerDice() {
        // Instantiate an populate the ArrayList of GVdie objects
        dice = new ArrayList<GVdie>();
        for (int i = 0; i < 5; i++) {
            dice.add(new GVdie(1));
        }
        // Instantiate HashMap
        tally = new HashMap<Integer, Integer>();
        // Invoke resetGame() method to initialize instance variables
        resetGame();
    }

    /*** ACCESSOR METHODS ***/
    public int getScore() {
        return score;
    }

    public int getNumRolls() {
        return rolls;
    }

    public int getNumRounds() {
        return rounds;
    }

    public boolean okToRoll() {
        if (rounds < 3) {
            return true;
        }
        return false;
    }

    public boolean gameOver() {
        if (rounds == 7) {
            return true;
        }
        return false;
    }

    public ArrayList<GVdie> getDice() {
        return dice;
    }

    /*** MUTATOR METHODS ***/
    public void resetGame() {
        // Set variables to 0
        score = 0;
        rolls = 0;
        rounds = 0;

        // Set all dice to blank and make sure all dice are not held
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).setHeld(false); 
            dice.get(i).setBlank();
        }
    }
    
    /******** PHASE 2 ********/
    
    public String diceToString() {
    	String diceString = "[";
    	for (int i = 0; i < dice.size(); i++) {
    		if (i != 4) {
    			diceString += dice.get(i).getValue() + ",";
    		}
    		else {
    			diceString += dice.get(i).getValue();
    		}
    	}
    	diceString += "]";
    	return diceString;
    }
    
    // Helper Methods
    private void tallyDice() {
    	
    	// Clear the HashMap
    	tally.clear();
    	
    	// Variables
    	int numOnes = 0;
    	int numTwos = 0; 
    	int numThrees = 0;
    	int numFours = 0;
    	int numFives = 0; 
    	int numSixes = 0;
    	
    	// Check values of GVdie
    	for (int i = 0; i < dice.size(); i++) {
    		if (dice.get(i).getValue() == 1) {
    			numOnes++;
    		}
    		else if (dice.get(i).getValue() == 2) {
    			numTwos++;
    		}
    		else if (dice.get(i).getValue() == 3) {
    			numThrees++;
    		}
    		else if (dice.get(i).getValue() == 4) {
    			numFours++;
    		}
    		else if (dice.get(i).getValue() == 5) {
    			numFives++;
    		}
    		else if (dice.get(i).getValue() == 6) {
    			numSixes++;
    		}
    	}
    	
    	// Update HashMap
    	tally.put(1, numOnes);
    	tally.put(2, numTwos);
    	tally.put(3, numThrees);
    	tally.put(4, numFours);
    	tally.put(5, numFives);
    	tally.put(6, numSixes);
    }
    
    private boolean hasStraight(int length) {
    	// Invoke tallyDice() method
    	tallyDice();
    	
    	// Check for straights
    	for (int i = 0; i < tally.size(); i++) {
    		if (tally.get(i) == length) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean hasMultiples(int count) {
    	// Invoke tallyDice() method
    	tallyDice();
    	
    	// Return true if there are count or more identical values
    	for (int i = 0; i < tally.size(); i++) {
    		if (tally.get(i) >= count) {
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    private boolean hasStrictPair() {
    	// Invoke tallyDice() method
    	tallyDice();
    	
    	// Return true if pair is found
    	for (int i = 0; i < tally.size(); i++) {
    		if (tally.get(i) == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private void nextRound() {
    	rounds++;
    	rolls = 0;
    	
    	// Set all dice to blank and make sure all dice are not held
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).setHeld(false); 
            dice.get(i).setBlank();
        }
    }
    
    public void setDice(int [] values) {
    	for (int i = 0; i < dice.size(); i++) {
    		// Check to see values are between 1 and 6
    		if (values[i] < 1 || values[i] > 6) {
    			values[i] = 1;
    		}
    		// Roll the dice
    		while (dice.get(i).getValue() != values[i]) {
    			dice.get(i).roll();
    		}
    	}
    }
    
    /******** PHASE 3 ********/
    
    public void rollDice() {
    	for (int i = 0; i < dice.size(); i++) {
    		if (dice.get(i).isHeld() == false) {
    			dice.get(i).roll();
    		}
    	}
    	rolls++;
    }
    
    public void checkFullHouse() {
    	if ((hasMultiples(3) == true) && hasStrictPair() == true) {
    		score += FULL_HOUSE;
    	}
    	else if (hasMultiples(5) == true) {
    		score += FULL_HOUSE;
    	}
    	nextRound();
    }
    
    public void checkSmallStraight() {
    	if (hasStraight(4) == true) {
    		score += SMALL_STRAIGHT;
    	}
    	nextRound();
    }
    
    public void checkLargeStraight() {
    	if (hasStraight(5) == true) {
    		score += LARGE_STRAIGHT;
    	}
    	nextRound();
    }
    
    public void checkFiveOfAKind() {
    	if (hasMultiples(5) == true) {
    		score += FIVE_OF_A_KIND;
    	}
    	nextRound();
    }
    
    public void checkFourOfAKind() {
    	if (hasMultiples(4) == true) {
    		score += FOUR_OF_A_KIND;
    	}
    	nextRound();
    }
    
    public void checkThreeOfAKind() {
    	if (hasMultiples(3) == true) {
    		score += THREE_OF_A_KIND;
    	}
    	nextRound();
    }
    
    public void checkChance() {
    	for (int i = 0; i < dice.size(); i++) {
    		score += dice.get(i).getValue();
    	}
    	nextRound();
    }
}

