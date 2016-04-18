package Game;

import java.util.ArrayList;

import AI.RandomStrategy;
import AI.Strategy;

public class Player {
	
	//private ArrayList<Die> hand = new ArrayList<Die>();
	private boolean isHuman;
	public static ScoreCalculator calc;
	private ArrayList<Strategy> strategies;
	
	// Default constructor sets the Player as human
	public Player() {
		isHuman = true;
		calc = new ScoreCalculator();
		strategies.add(new RandomStrategy());
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
		
		
//		for (Die d : hand) {
//			if(!d.getHeldState()) {
//				d.roll();
//			}
//			System.out.print(d.getRollValue() + " ");
//		}
		
		System.out.println();
//		calc.getDice(hand);
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
	
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
}
