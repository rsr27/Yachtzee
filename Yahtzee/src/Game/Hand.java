package Game;

import java.util.Observable;
import java.util.Random;

import Game.HandStatus.HandState;

/*
 * The Hand class contains the dice
 * And implements the SINGLETON design pattern
 */

public class Hand {
	private final int numDice = 5;
	private static Hand instance = null;
	private Random rand;
	private HandState status;
	private int[] dice;
	private boolean[] holds;
	private int numRolls;
	
	private Hand() {
		dice = new int[numDice];
		status = HandState.READY;
		holds = new boolean[numDice];
		rand = new Random();
		numRolls = 1;
		
		for(boolean b : holds)
			b = false;
		
		for (int i: dice)
			i = 1;
	}
	
	// Gets Singleton instance
	public static Hand getInstance() {
		if (instance == null)
			instance = new Hand();
		return instance;
	}
	
	public void resetHand() {
		numRolls = 1;
		for(boolean b : holds)
			b = false;
	}

	public void setNumRolls(int rolls) {
		numRolls = rolls;
	}
	
	public int getNumRolls() {
		return numRolls;
	}
	
	public void incrementNumRolls() {
		numRolls++;
	}
	
	public void rollUnheldDice() {
		for(int i = 0; i < 5; i++) {
			if(holds[i] == false) {
				dice[i] = rand.nextInt(6) + 1;
			}
		}
	}
	
	// returns the holds array
	public boolean[] getHeldStatus() {
		return holds;
	}
	
	// returns the holds status of a specific die
	public boolean getHeldStatus(int whichDie) {
		if(whichDie > 0)
			return holds[whichDie - 1];
		else
			return false;
	}
	
	public boolean holdDie(int dieToHold) {
		if(dieToHold >= 0)
		{
			holds[dieToHold] = true;
			return true;
		}
		
		return false;
	}
	
	public boolean releaseDie(int dieToRelease) {
		if(dieToRelease >= 0) {
			holds[dieToRelease] = false;
			return true;
		}
		
		return false;
	}
	
	public int[] getDiceValues() {
		return dice;
	}

	public int getDieValue(int whichDie) {
			return dice[whichDie];
	}
	
	public HandState getHandState(){
		return status;
	}
	
}
