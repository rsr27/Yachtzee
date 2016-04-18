package Actions;

import java.util.Scanner;

import Game.Player;

public class Turn {

	private int rollCount;
	private Player player;
	Scanner kb = new Scanner(System.in);
	
	public Turn(Player player) {
		this.player = player;
		rollCount = 1; // start roll counts as 1
	}
	
	public Player turnRounds(Player turnPlayer) {
		String decision = "";
		boolean scored = false;
		while(rollCount < 3 && scored == false) {
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
				if(rollCount < 3) {
					player = HoldAction.holdDie(player);
				}
				break;
			case "r":
				if(rollCount < 3) {
					player = ReleaseAction.releaseDie(player);
				}
				break;
			case "0":
				player.rollUnheldDice();
				break;
			case "s":
				rollCount = 2;
				break;
			default:
				break;				
			}
			
			rollCount++;
			if(rollCount == 3)
				scored = true;
		}
		
		scored = true;
		player = AddToScoresheetAction.addScoretoSheet(player);
		player.releaseAllDice();
		rollCount = 1;

		player.rollUnheldDice();
		
		return player;
	}
	
	
}
