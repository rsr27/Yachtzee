package yahtzee;

import java.util.Scanner;

import Actions.HoldAction;
import Actions.Turn;
import Game.Player;

public class YahtzeeMain {

	public static void main(String[] args) {
		
		// This is just so I can commit... -Ryan
		
		// Setting the player to an AI now.
		// Here be dragons...
		Player player = new Player(false);
		
		float gamesTotal = 0;
		int numOfGames = 100;
		for(int i = 0; i < numOfGames; i++) {
			System.out.println("Welcome to Yahtzee!");
			
			// if the player is a computer player, then the game auto-plays with no interaction
			if(player.getHuman()) {
				Scanner kb = new Scanner(System.in);
				System.out.println("Enter any letter to roll!");
				if(kb.next() != null || kb.next() == null) {
					player.rollUnheldDice();
				}
			}
			
			Turn turn = new Turn(player);
			
			while(!player.calc.scores.mapIsFull()) {
				turn.turnRounds(player);
			}
			
			System.out.println();
			gamesTotal += player.calc.scores.getTotalScore();
			System.out.println("Your final score: " + player.calc.scores.getTotalScore());
			player.displayScoreSheet();
			
			player.calc.scores.resetScores();
		}
		System.out.println("Your average score is: " + (gamesTotal/numOfGames));
	}
	
	public static void holdDice() {
		String whichDie = "";
		int dieIndex = -1;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the number of the die you would like to hold (just one): ");
		whichDie = kb.next();
		dieIndex = Integer.parseInt(whichDie);
	}
}
