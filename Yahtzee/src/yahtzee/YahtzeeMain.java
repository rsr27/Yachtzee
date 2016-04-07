package yahtzee;

import java.util.Scanner;

import Actions.HoldAction;
import Actions.Turn;
import Game.Player;

public class YahtzeeMain {

	public static void main(String[] args) {
		Player player = new Player(true);
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to Yahtzee!");
		System.out.println("Enter any letter to roll!");
		if(kb.next() != null || kb.next() == null) {
			player.rollUnheldDice();
		}
		
		Turn turn = new Turn(player);
		while(!player.calc.scores.mapIsFull()) {
			turn.turnRounds(player);
		}
	}
	
	public static void holdDice() {
		String whichDie = "";
		int dieIndex = -1;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the dumber of the die you would like to hold (just one): ");
		whichDie = kb.next();
		dieIndex = Integer.parseInt(whichDie);
	}
}
