package Actions;

import java.util.Scanner;

import Game.Hand;
import Game.Player;

public class ReleaseAction {

	// Takes a player object (for easy access to the dice)
		// Gets user input about which die they would like to release
		// Releases the specified die and returns the player object
		public static Player releaseDie(Player player) {
			Scanner kb = new Scanner(System.in);
			int dieIndex = -1;
			
			while(dieIndex!= 0) {
				// making sure the user enters something between 1 and 5
				while(!(dieIndex > 0 && dieIndex < 6)) {
					System.out.println();
					System.out.println("Enter the position of the die you would like to release (just one): ");
					System.out.print("Enter 0 to roll again: ");
					dieIndex = Integer.parseInt(kb.next());
				}
				// release the specified die
				if(player.releaseDie(dieIndex - 1)) {
					System.out.print("Die #" + dieIndex + " with value of ");
					System.out.println(Hand.getInstance().getDieValue(dieIndex - 1) + " successfully released.");
					
					// input loop
					System.out.println();
					System.out.println("Enter the position of the die you would like to release (just one): ");
					System.out.print("Enter 0 to roll again: ");
					dieIndex = Integer.parseInt(kb.next());
				}
			}
			return player;
		}
}
