package Game;

import java.util.ArrayList;

import AI.RandomStrategy;
import AI.Strategy;
/*
 * This class acts as a FACADE
 */
public class Player {
	
	//private ArrayList<Die> hand = new ArrayList<Die>();
	private boolean isHuman;
	public static ScoreCalculator calc;
	
	// Default constructor sets the Player as human
	public Player() {
		isHuman = true;
		calc = new ScoreCalculator();
	}
	
	// Constructor that takes a boolean isHuman defining the Player as human or AI
	public Player(boolean isHuman) {
		setHuman(isHuman);
		calc = new ScoreCalculator();
	}
	
	// Loops through the dice hand and rolls any unheld dice
	// Then updates the dice in the score calculator
	public void rollUnheldDice() {
		Hand.getInstance().rollUnheldDice();
		
		// Ryan: Added an * after the dice that are held to help 
		// the player see which dice they've held.
		
		for (int i = 0; i < 5; i++)
		{
			if (Hand.getInstance().getHeldStatus(i + 1))
			{
				System.out.print(Hand.getInstance().getDieValue(i) + "* ");
			}
			else
			{
				System.out.print(Hand.getInstance().getDieValue(i) + " ");
			}
		}
		
		System.out.println();
	}
	
	// holds the die at the given index
	// returns true if called successfully
	public boolean holdDie(int die) {
		Hand.getInstance().holdDie(die);
		return true;
	}
	
	// releases the die at the given index
	// returns true if called successfully
	public boolean releaseDie(int die) {
		Hand.getInstance().releaseDie(die);
		return true;
	}
	
	public static void displayScoreSheet() {
		calc.scores.displayScoreSheet();
	}
	
//	public ArrayList<Die> getDice() {
//		return hand;
//	}
	public void releaseAllDice() {
		for (int i = 0; i < 5; i++)
			releaseDie(i);
	}
	
	public int[] getDiceValues() {
		return Hand.getInstance().getDiceValues();
	}
	
	// Sets the player as human or AI
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
	
	// Returns whether or nout our player is human or AI.
	public boolean getHuman() {
		return this.isHuman;
	}
	
	public void setNumRolls(int rolls) {
		Hand.getInstance().setNumRolls(rolls);
	}
	
	public int getNumRolls() {
		return Hand.getInstance().getNumRolls();
	}
	
	public void incrementNumRolls() {
		Hand.getInstance().incrementNumRolls();
	}
	
	public boolean getPreviousSuccess()
	{
		return calc.scores.getPreviousSuccess();
	}
	
}
