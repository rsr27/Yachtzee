package Actions;

import java.util.Scanner;

import Game.Hand;
import Game.Player;

public class Turn {

	private Player player;
	Scanner kb = new Scanner(System.in);
	
	public Turn(Player player) {
		this.player = player;
		Hand.getInstance().setNumRolls(1); // start roll counts as 1
	}
	
	public Player turnRounds(Player turnPlayer) {
		
		if (turnPlayer.getHuman()) {
			String decision = "";
			boolean scored = false;
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
			
			player = AddToScoresheetAction.addScoretoSheet(player);
			
			while (!player.getPreviousSuccess())
			{
				player = AddToScoresheetAction.addScoretoSheet(player);
			}

			player.releaseAllDice();
			Hand.getInstance().setNumRolls(1);
			player.rollUnheldDice();
			
		}
		else
		{
			// AI
			
			
		}
		
		return player;
	}
	
	
}
