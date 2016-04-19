package Actions;

import java.util.Scanner;

import Game.Player;

public class AddToScoresheetAction {
	
	public static Player addScoretoSheet(Player player) {
		
		Scanner kb = new Scanner(System.in);
		int decision = 0;
		
		if (player.getHuman())
		{
			// Human decisions
			System.out.println("Enter the number of the slot you would like to put the score in:");
			displayScoreSheet(player);
			decision = kb.nextInt();
		}
		else
		{
			// AI decisions
		}
		
		//player.calc.getDice(player.getDice());
		
		switch(decision) {
		case 1:
			player.calc.scoreOnes();
			break;
		case 2:
			player.calc.scoreTwos();
			break;
		case 3:
			player.calc.scoreThrees();
			break;
		case 4:
			player.calc.scoreFours();
			break;
		case 5:
			player.calc.scoreFives();
			break;
		case 6:
			player.calc.scoreSixes();
			break;
		case 7:
			player.calc.scoreChance();
			break;
		case 8:
			player.calc.scoreSmallStraight();
			break;
		case 9:
			player.calc.scoreLargeStraight();
			break;
		case 10:
			player.calc.score3ofaKind();
			break;
		case 11:
			player.calc.score4ofaKind();
			break;
		case 12:
			player.calc.scoreFullHouse();
			break;
		case 13:
			player.calc.scoreYahtzee();
			break;
		default:
			break;
		}
		
		displayScoreSheet(player);
		
		return player;
	}
	
	public static Player addScoretoSheet(Player player, int slot) {		
		switch(slot) {
		case 1:
			player.calc.addToScoreSheet("ones", player.calc.scoreOnes());
			break;
		case 2:
			player.calc.addToScoreSheet("twos", player.calc.scoreTwos());
			break;
		case 3:
			player.calc.addToScoreSheet("threes", player.calc.scoreThrees());
			break;
		case 4:
			player.calc.addToScoreSheet("fours", player.calc.scoreFours());
			break;
		case 5:
			player.calc.addToScoreSheet("fives", player.calc.scoreFives());
			break;
		case 6:
			player.calc.addToScoreSheet("sixes", player.calc.scoreSixes());
			break;
		case 7:
			player.calc.addToScoreSheet("chance", player.calc.scoreChance());
			break;
		case 8:
			player.calc.addToScoreSheet("smStr8", player.calc.scoreSmallStraight());
			break;
		case 9:
			player.calc.addToScoreSheet("lgStr8", player.calc.scoreLargeStraight());
			break;
		case 10:
			player.calc.addToScoreSheet("3ofaKind", player.calc.score3ofaKind());
			break;
		case 11:
			player.calc.addToScoreSheet("4ofaKind", player.calc.score4ofaKind());
			break;
		case 12:
			player.calc.addToScoreSheet("fullHouse", player.calc.scoreFullHouse());
			break;
		case 13:
			player.calc.addToScoreSheet("yahtzee", player.calc.scoreYahtzee());
			break;
		default:
			break;
		}
		
		player.displayScoreSheet();
		return player;
	}
	//*/
	
	public static void displayScoreSheet(Player player) {
		System.out.println();
		System.out.println("Ones:            1    " + getScoreInSheet(player, "ones"));
		System.out.println("Twos:            2    " + getScoreInSheet(player, "twos"));
		System.out.println("Threes:          3    " + getScoreInSheet(player, "threes"));
		System.out.println("Fours:           4    " + getScoreInSheet(player, "fours"));
		System.out.println("Fives:           5    " + getScoreInSheet(player, "fives"));
		System.out.println("Sixes:           6    " + getScoreInSheet(player, "sixes"));
		System.out.println("Chance:          7    " + getScoreInSheet(player, "chance"));
		System.out.println("Small Straight:  8    " + getScoreInSheet(player, "smStr8"));
		System.out.println("Large Straight:  9    " + getScoreInSheet(player, "lgStr8"));
		System.out.println("3 of a Kind:     10   " + getScoreInSheet(player, "3ofaKind"));
		System.out.println("4 of a Kind:     11   " + getScoreInSheet(player, "4ofaKind"));
		System.out.println("Full House:      12   " + getScoreInSheet(player, "fullHouse"));
		System.out.println("Yahtzee:         13   " + getScoreInSheet(player, "yahtzee"));
		System.out.println();
	}
	
	public static String getScoreInSheet(Player player, String slot) {
		String returnString = "Slot holds: ";
		if(player.calc.scores.scoreHash.get(slot) == -1)
			returnString += "empty";
		else
			returnString += player.calc.scores.scoreHash.get(slot).toString();
		return returnString;
	}
}
;