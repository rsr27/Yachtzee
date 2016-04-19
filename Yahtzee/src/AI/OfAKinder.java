package AI;

import java.lang.reflect.InvocationTargetException;

import Actions.AddToScoresheetAction;
import Game.Hand;
import Game.Player;

public class OfAKinder implements Strategy {

	Player player;
	
	public OfAKinder(Player player) {
		this.player = player;
	}
	
	@Override
	public void takeTurn() {
		int[] dice;
		while(player.getNumRolls() < 3) {
			player.rollUnheldDice();
			player.incrementNumRolls();
			
			// this block looks through the hand for duplicates and holds them
			player.releaseAllDice();
			dice = player.getDiceValues();
			for(int i = 0; i < 5; i++) {
				int compareDie = dice[i];
				for(int j = 0; j < 5; j++) {
					if(j != i) {
						if(dice[j] == compareDie) {
							player.holdDie(i);
							player.holdDie(j);
						}
					}
				}
			}
			
			if(player.calc.isYahtzee())
				AddToScoresheetAction.addScoretoSheet(player, 13);
		}
		
		AddToScoresheetAction.addScoretoSheet(player, player.calc.getBestSlot());
	}

	@Override
	public String getName() {
		return "Of a Kinder";
	}

}
