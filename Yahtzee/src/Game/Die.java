package Game;

import java.util.Random;

public class Die {

	private int rollValue;
	private boolean isHeld;
	Random rand;
	
	public Die() {
		rand = new Random();
		isHeld = false;
	}
	
	// rolls the die, stores the value in rollValue and returns the value
	public int roll() {
		rollValue =  rand.nextInt(6) + 1;
		return rollValue;
	}
	
	public int getRollValue() {
		return rollValue;
	}
	
	public void hold() {
		isHeld = true;
	}
	
	public void release() {
		isHeld = false;
	}
	
	public boolean getHeldState() {
		return isHeld;
	}
}
