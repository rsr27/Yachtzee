package AI;

import java.util.Random;

import Game.Player;

/*
 * This class selects one of the AI Strategies
 * This class is IMMUTABLE
 */
public final class AIPicker {
	
	public static String pickAI() {
		Random rand = new Random();
		String strategy = "";
		int stratSelector = rand.nextInt(100);
		if(stratSelector < 75)
			strategy = "4 and Up";
		if(stratSelector >= 75 && stratSelector < 88)
			strategy = "Upper Sectioner";
		if(stratSelector >= 88)
			strategy = "Of a Kinder";
		return strategy;
	}
}
