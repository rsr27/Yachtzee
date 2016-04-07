package Actions;

import java.util.Scanner;

import Game.Player;

public class HoldAction {
	
	// Takes a player object (for easy access to the dice)
	// Gets user input about which die they would like to hold
	// Holds the specified die and returns the player object
	public static Player holdDie(Player player) {
		Scanner kb = new Scanner(System.in);
		int dieIndex = -1;
		
		while(dieIndex != 0) {
			// making sure the user enters something between 1 and 5
			while(!(dieIndex >= 0 && dieIndex < 6)) {
				System.out.println();
				System.out.println("Enter the position of the die you would like to hold (just one): ");
				System.out.print("Enter 0 to roll again: ");
				dieIndex = kb.nextInt();
			}
			// hold the specified die
			if(dieIndex == 0)
				break;
			if(player.holdDie(dieIndex - 1)) {
				System.out.print("Die #" + dieIndex + " with value of ");
				System.out.println(player.getDice().get(dieIndex - 1).getRollValue() + " successfully held.");
				
				// input loop
				System.out.println();
				System.out.println("Enter the position of the die you would like to hold (just one): ");
				System.out.print("Enter 0 to roll again: ");
				dieIndex = kb.nextInt();
			}
		}
		
		player.rollUnheldDice();
		return player;
	}
}
