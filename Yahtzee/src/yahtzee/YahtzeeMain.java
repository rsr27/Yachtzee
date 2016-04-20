package yahtzee;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
		
		int highestScore = 0, lowestScore = 50000;
		
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
			else
			{
				player.rollUnheldDice();
			}
			
			Turn turn = new Turn(player);
			
			while(!player.calc.scores.mapIsFull()) {
				turn.turnRounds(player);
				
				/*try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			
			System.out.println();
			
			int newScore = player.calc.scores.getTotalScore();
			
			if (newScore > highestScore)
				highestScore = player.calc.scores.getTotalScore();
		
			if (newScore < lowestScore)
				lowestScore = newScore;
			
			gamesTotal += newScore;
			player.displayScoreSheet();
			System.out.println("Your final score: " + newScore);
			
			player.calc.scores.resetScores();
		}
		System.out.println("Your average score is: " + (gamesTotal/numOfGames));
		System.out.println("Your highest score is: " + highestScore);
		System.out.println("Your lowest score is: " + lowestScore);
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
