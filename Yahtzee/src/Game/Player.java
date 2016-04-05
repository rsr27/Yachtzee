package Game;

import java.util.ArrayList;

public class Player {
	
	private final int numDice = 5;

	private Die[] diceHand;
	private ArrayList<Die> hand = new ArrayList<Die>();
	private boolean isHuman;
	
	public Player() {
//		diceHand = new Die[6];
		for(int i = 0; i < numDice; i++) {
			hand.add(new Die());
		}
		isHuman = true;
	}
	
	public Player(boolean isHuman) {
//		diceHand = new Die[6];
		for(int i = 0; i < numDice; i++) {
			hand.add(new Die());
		}
		
		setHuman(isHuman);
	}
	
	public void rollUnheldDice() {
		for (Die d : hand) {
			if(!d.getHeldState()) {
				d.roll();
			}
			System.out.println(d.getRollValue());
		}
	}
	
	public void holdDie(int die) {
//		diceHand[die].hold();
		hand.get(die).hold();
	}
	
	public void releaseDie(int die) {
//		diceHand[die].release();
		hand.get(die).release();
	}
	
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
}
