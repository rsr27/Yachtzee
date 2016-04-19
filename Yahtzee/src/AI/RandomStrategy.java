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

		int randomChoice, randChoiceNext;
		
		randomChoice = rand.nextInt(13) + 1;
		randChoiceNext = randomChoice;
		AddToScoresheetAction.addScoretoSheet(player, randomChoice);
		
		while (!player.getPreviousSuccess())
		{
			// Cycle through available options.
			randChoiceNext++;
			
			// If we go over 13, go back to 1
			if (randChoiceNext >= 13)
				randChoiceNext -= 12;
			
			// If we reach our original value, we're done.
			if (randomChoice == randChoiceNext )
				break;
			
			// Attempt to add the score.
			player = AddToScoresheetAction.addScoretoSheet(player, randChoiceNext);
		}	
	}

	@Override
	public String getName() {
		return "Random Strategy";
	}


}
