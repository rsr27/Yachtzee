package Game;

import java.util.ArrayList;

public class Player {
	
	private final int numDice = 5;
	private ArrayList<Die> hand = new ArrayList<Die>();
	private boolean isHuman;
	public ScoreCalculator calc;
	
	// Default constructor sets the Player as human
	public Player() {
		for(int i = 0; i < numDice; i++) {
			hand.add(new Die());
		}
		isHuman = true;
		calc = new ScoreCalculator(hand);
		
	}
	
	// Constructor that takes a boolean isHuman defining the Player as human or AI
	public Player(boolean isHuman) {
		for(int i = 0; i < numDice; i++) {
			hand.add(new Die());
		}
		
		setHuman(isHuman);
		calc = new ScoreCalculator(hand);
	}
	
	// Loops through the dice hand and rolls any unheld dice
	// Then updates the dice in the score calculator
	public void rollUnheldDice() {
		for (Die d : hand) {
			if(!d.getHeldState()) {
				d.roll();
			}
			System.out.print(d.getRollValue() + " ");
		}
		System.out.println();
		calc.getDice(hand);
	}
	
	// holds the die at the given index
	// returns true if called successfully
	public boolean holdDie(int die) {
		hand.get(die).hold();
		return true;
	}
	
	// releases the die at the given index
	// returns true if called successfully
	public boolean releaseDie(int die) {
		hand.get(die).release();
		return true;
	}
	
	public ArrayList<Die> getDice() {
		return hand;
	}
	
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
}
