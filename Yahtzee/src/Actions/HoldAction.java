package Actions;

import java.util.Scanner;

import Game.Hand;
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
			if(Hand.getInstance().holdDie(dieIndex - 1)) {
				System.out.print("Die #" + dieIndex + " with value of ");
				System.out.println(Hand.getInstance().getDieValue(dieIndex - 1) + " successfully held.");
				
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
