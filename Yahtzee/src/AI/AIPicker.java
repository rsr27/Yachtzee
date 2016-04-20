package AI;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Game.Hand;
import Game.Player;

/*
 * This class selects one of the AI Strategies
 * This class is IMMUTABLE
 */

public final class AIPicker {

	public final static int STRATEGY_4UP = 0;
	public final static int STRATEGY_UPPERSECTION = 1;
	public final static int STRATEGY_OFAKINDER = 2;
	public final static int STRATEGY_RANDOM = 3;
	
	public static int pickAI(Player player) {
		
		// Examine the dice, and choose an appropriate strategy
		int[] diceValues = player.getDiceValues();
		int[] counts = new int[6];
		boolean anyTwoOrMore = false;
		boolean anyThreeOrMore = false;
		
		// Find the number of x dice.
		for (int i = 0; i < 5; i++)
		{
			counts[diceValues[i]-1]++;
			if (counts[diceValues[i]-1] >= 2)
				anyTwoOrMore = true;
			if (counts[diceValues[i]-1] >= 3)
				anyThreeOrMore = true;
		}
		
		//if we have a 2, 3, 4 then use the upper section strategy (looking for straights, or of a kind)
		if ( (counts[1] == 1 && counts[2] == 1 && counts[3] == 1) || anyThreeOrMore)
		{
			return STRATEGY_UPPERSECTION;
		}
		else if (anyTwoOrMore)
		{
			return STRATEGY_OFAKINDER;
		}
		// Else, try to find the most valuable dice.
		else 
		{
			return STRATEGY_4UP;
		}
	}
}
