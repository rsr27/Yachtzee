package AI;

import Actions.AddToScoresheetAction;
import Game.Player;

public class UpperSectioner implements Strategy {

	Player player;
	
	public UpperSectioner(Player player) {
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
		if(player.calc.scores.upperSectionIsFull())
			AddToScoresheetAction.addScoretoSheet(player, player.calc.getBestLowerSection());
		else
			AddToScoresheetAction.addScoretoSheet(player, player.calc.getBestUpperSection());		
	}

	@Override
	public String getName() {
		return "Upper Sectioner";
	}

}
