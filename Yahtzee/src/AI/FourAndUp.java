package AI;

import Actions.AddToScoresheetAction;
import Game.Player;

public class FourAndUp implements Strategy {

	Player player;
	
	public FourAndUp(Player player) {
		this.player = player;
	}
	
	@Override
	public void takeTurn() {
		int[] dice;
		while(player.getNumRolls() < 3) {
			player.rollUnheldDice();
			player.incrementNumRolls();
			
			// this block looks through the hand for values >= 4
			dice = player.getDiceValues();
			for(int i = 0; i < 5; i++) {
				if(dice[i] >= 4) {
					player.holdDie(i);
				}
			}
			
			if(player.calc.isYahtzee())
			{
				AddToScoresheetAction.addScoretoSheet(player, 13);
				
				if (player.getPreviousSuccess())
				{
					player.setNumRolls(0);
					break;
				}
			}
		}
		
		AddToScoresheetAction.addScoretoSheet(player, player.calc.getBestSlot());
	}

	@Override
	public String getName() {
		return "4 and Up";
	}

}
