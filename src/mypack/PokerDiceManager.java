package mypack;

public class PokerDiceManager {
	
	public static void main(String[] args) {
        
		int oldScore;
        System.out.println ("Testing begins"); 
        PokerDice game = new PokerDice();
    
        /*** PHASE 1 TESTING ***/

        // Testing the Constructor
        assert game.getDice().size() == 5 : "dice should be an ArrayList of five"; 
        assert game.getScore() == 0 : "score should be 0";
        assert game.getNumRolls() == 0 : "rolls should be 0";
        assert game.getNumRounds() == 0 : "rounds should be 0";
        
        // Testing resetGame() and setHeld
        for (int i = 0; i < game.getDice().size(); i++) {
        	assert game.getDice().get(i).isHeld() == false : "dice should not be held";
        }

        System.out.println ("Testing ends");
        
        /*** PHASE 2 TESTING ***/
        
        // Testing the diceToString method
        System.out.println(game.diceToString());
        
    }   
}
