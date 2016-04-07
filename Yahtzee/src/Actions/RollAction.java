package Actions;

import Game.Die;
import Game.Player;

public class RollAction {
	
	public RollAction(Player player) {
		
	}
	
	public static Player roll(Player player) {
		player.rollUnheldDice();
		return player;
	}

}
