package AI;

import java.util.Random;

import Actions.AddToScoresheetAction;
import Game.Hand;
import Game.Player;

public class RandomStrategy implements Strategy {

	Player player;
	Random rand;
	
	public RandomStrategy(Player player) {
		this.player = player;
		rand = new Random();
	}
	
	@Override
	public void takeTurn() {
		
		while(player.getNumRolls() < 3) {
			player.rollUnheldDice();
			for(int i = 0; i < 5; i++) {
				if(rand.nextBoolean())
					player.holdDie(i);
				else
					player.releaseDie(i);
			}
			
			player.incrementNumRolls();
		}
		
		AddToScoresheetAction.addScoretoSheet(player, rand.nextInt(13) + 1);
	}

	@Override
	public String getName() {
		return "Random Strategy";
	}


}
