package Actions;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import AI.*;
import Game.Hand;
import Game.Player;

public class Turn {

	// The player that this turn cooresponds to.
	private Player player;
	
	// Keyboard input object
	Scanner kb = new Scanner(System.in);
	
	// Constructor
	public Turn(Player player) {
		this.player = player; // set our player
		Hand.getInstance().setNumRolls(1); // start roll counts as 1
	}
	
	// This is the main function that handles playing the game. It emulates
	// the behavior of taking a turn.
	public Player turnRounds(Player turnPlayer) {
		
		// If the player is a human, allow the user to make his
		// own decisions.
		if (turnPlayer.getHuman()) {
			
			// Variables to hold player decisions
			String decision = "";
			boolean scored = false;
			
			// Loop until you've rolled 3 times.
			while(Hand.getInstance().getNumRolls() < 3 && scored == false) {
				decision = "";
				while(!decision.equals("h") && !decision.equals("r") && !decision.equals("0") && !decision.equals("s")) {
					System.out.println();
					System.out.println("If you wish to hold any dice,          enter \"h\".");
					System.out.println("If you wish to release any dice,       enter \"r\".");
					System.out.println("When you are ready to roll,            enter \"0\" (zero).");
					System.out.println("If you wish to enter your score now,   enter \"s\".");
					System.out.println();
					System.out.print("Your decision: ");
					decision = kb.next();
				}
				
				switch (decision) {
				case "h":
					if(Hand.getInstance().getNumRolls() < 3) {
						player = HoldAction.holdDie(player);
					}
					break;
				case "r":
					if(Hand.getInstance().getNumRolls() < 3) {
						player = ReleaseAction.releaseDie(player);
					}
					break;
				case "0":
					player.rollUnheldDice();
					break;
				case "s":
					Hand.getInstance().setNumRolls(2);
					break;
				default:
					break;				
				}
				
				Hand.getInstance().incrementNumRolls();
				if(Hand.getInstance().getNumRolls() == 3)
					scored = true;
			}

			scored = true;
		
			do {
				player = AddToScoresheetAction.addScoretoSheet(player);
			} while (!player.getPreviousSuccess());
			
			player.releaseAllDice();
			Hand.getInstance().setNumRolls(1);
			player.rollUnheldDice();
			
		}
		else
		{
			// AI
			Strategy strats = null;
			
			int strategyId = AIPicker.pickAI(player);
			
			if(strategyId == AIPicker.STRATEGY_UPPERSECTION)
				strats = new UpperSectioner(player);
			else if (strategyId == AIPicker.STRATEGY_4UP)
				strats = new FourAndUp(player);
			else if (strategyId == AIPicker.STRATEGY_OFAKINDER)
				strats = new OfAKinder(player);
			else
				strats = new RandomStrategy(player);

			//strats = new FourAndUp(player);
			System.out.println("Decided to use \"" + strats.getName() + "\" strategy!\n");
			strats.takeTurn();
			
			// Release the Kraken!
			player.releaseAllDice();
			Hand.getInstance().setNumRolls(1);
			player.rollUnheldDice();
			
			// Delay to let us see output
//			try {
//				TimeUnit.SECONDS.sleep(6);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		return player;
	}
	
	
}
