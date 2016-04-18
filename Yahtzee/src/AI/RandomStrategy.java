package AI;

import java.util.Random;

import Actions.AddToScoresheetAction;
import Game.Hand;

public class RandomStrategy implements Strategy {

	Random rand;
	
	public RandomStrategy() {
		rand = new Random();
	}
	
	@Override
	public void takeTurn() {
		while(Hand.getInstance().getNumRolls() < 3) {
			Hand.getInstance().rollUnheldDice();
			for(int i = 0; i < 5; i++) {
				if(rand.nextBoolean())
					Hand.getInstance().holdDie(i);
				else
					Hand.getInstance().releaseDie(i);
			}
			Hand.getInstance().incrementNumRolls();
		}
		
		AddToScoresheetAction.addScoretoSheet(rand.nextInt() + 1);
	}

	@Override
	public String getName() {
		return "Random Strategy";
	}

}
