//package mypack;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//
//public class PokerDiceGUI extends JFrame implements ActionListener{
//
//    // The game that keeps track of everything 
//    PokerDice theGame;
//
//    // Score of the game 
//    JLabel scoreLabel;
//
//    // A button for each scoring category 
//    JButton rollButton;
//    JButton smallStraightButton;
//    JButton largeStraightButton;
//    
//    // TO DO 
//    // Declare five buttons: threeKindButton, fourKindButton,
//    // fiveKindButton, fullHouseButton, chanceButton;
//
//    // Menu items 
//    JMenuBar menus;
//    JMenu fileMenu;
//    JMenuItem quitItem;
//    JMenuItem newGameItem;
//
//    
//    // Main method - starts the game
//    public static void main(String [] args){
//        PokerDiceGUI gui = new PokerDiceGUI();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setTitle("Poker Dice Game");
//        gui.pack();
//        gui.setVisible(true);
//    }
//
//    // Position the five dice and buttons on the screen
//    public PokerDiceGUI(){
//        // instantiate the game
//        theGame = new PokerDice();
//        setupGUI();
//        setupMenu ();
//        resetGame();
//    }
//
//    // Setup all the GUI components
//    private void setupGUI(){
//
//        // set layout manager
//        setLayout(new GridBagLayout());
//        GridBagConstraints position = new GridBagConstraints();
//
//        // instantiate all buttons and JLabel
//        rollButton = new JButton("roll");
//        scoreLabel = new JLabel();
//        smallStraightButton = new JButton("Small Straight");
//        largeStraightButton = new JButton("Large Straight");
//        
//        // TO DO 
//        // Initialize five buttons for 3-4-5 of kind,
//        // fullhouse, and chance button
//    
//
//        // Add all dice to the JFrame
//        ArrayList<GVdie> dice = theGame.getDice();
//        position.gridy = 1;
//        position.gridx = 2;
//        position.insets = new Insets(2,2,2,2);
//
//        // Positions the dice
//        for (GVdie d : dice) {
//            add(d, position);
//            position.gridx++;
//        }
//
//        // Add all buttons
//        position.insets = new Insets(4,4,4,4);
//        position.gridx = 2;
//        position.gridy = 2;
//        position.gridwidth = 2;
//        add(smallStraightButton, position);
//
//        position.gridy++;
//        add(largeStraightButton, position);
//
//        
//        // TO DO 
//        // Add the Five buttons you created to the GUI
//        // The location should be gridy++, basically one down
//
//
//        // Add the roll button and the score
//        position.gridwidth = 1;
//        position.gridx = 4;
//        position.gridy++;
//        add(rollButton, position);
//
//        position.gridx++;
//        add(scoreLabel, position);
//
//        // Register all buttons with the Action Listener
//        smallStraightButton.addActionListener(this);
//        largeStraightButton.addActionListener(this);
//        rollButton.addActionListener(this);
//
//        // TO DO 
//        // Add action listeners to the FIVE buttons you put in the GUI
//        
//
//    }
//
//    // Setup Menu
//    private void setupMenu () {
//        fileMenu = new JMenu("File");
//        quitItem = new JMenuItem("Quit");
//        newGameItem = new JMenuItem("New Game");
//        fileMenu.add(newGameItem);
//        fileMenu.add(quitItem);
//        menus = new JMenuBar();
//        setJMenuBar(menus);
//        menus.add(fileMenu);
//
//        // Register the menu items with this action listener
//        quitItem.addActionListener(this);
//        newGameItem.addActionListener(this);
//    }
//
//     // Handles all button and menu selection
//     // @param e the component that was pressed
//    public void actionPerformed (ActionEvent e){
//        // determine which button or menu was selected
//        JComponent buttonPressed = (JComponent) e.getSource();
//
//        if (buttonPressed == quitItem){
//            System.exit(1);
//        }
//
//        if (buttonPressed == newGameItem){
//            resetGame();
//        }
//
//        // For each of the scoring categories
//        // If the button is selected
//        //     Ask the game to check the category
//        //     Disable button
//        if (buttonPressed == largeStraightButton)
//        {
//            theGame.checkLargeStraight();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == smallStraightButton)
//        {
//            theGame.checkSmallStraight();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == threeKindButton)
//        {
//            theGame.checkThreeOfAKind();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == fourKindButton)
//        {
//            theGame.checkFourOfAKind();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == fiveKindButton)
//        {
//            theGame.checkFiveOfAKind();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == fullHouseButton)
//        {
//            theGame.checkFullHouse();
//            buttonPressed.setEnabled(false);
//        }
//        if (buttonPressed == chanceButton)
//        {
//            theGame.checkChance();
//            buttonPressed.setEnabled(false);
//        }
//
//        // Roll each dice that is not held
//        if (buttonPressed == rollButton)
//            theGame.rollDice();
//
//        // If OK to roll then enable the button
//        if (theGame.okToRoll())
//            rollButton.setEnabled(true);
//        else
//            rollButton.setEnabled(false);
//
//        scoreLabel.setText("Score: " + theGame.getScore());
//        if (theGame.gameOver())
//        {
//            // Display message
//            JOptionPane.showMessageDialog (null, "Game ended");
//            rollButton.setEnabled(false);
//        }
//    }
//
//    // Reset the game, the score, and enable all buttons
//    public void resetGame(){
//        theGame.resetGame();
//        scoreLabel.setText("Score: " + theGame.getScore());
//
//        // Enable all buttons
//        smallStraightButton.setEnabled(true);
//        largeStraightButton.setEnabled(true);
//        threeKindButton.setEnabled(true);
//        fourKindButton.setEnabled(true);
//        fiveKindButton.setEnabled(true);
//        fullHouseButton.setEnabled(true);
//        chanceButton.setEnabled(true);
//
//    }
//}
