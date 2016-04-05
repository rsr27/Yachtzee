package Yahtzee;

import java.util.Scanner;

import Game.Player;

public class YahtzeeMain {

	public static void main(String[] args) {
		Player player = new Player(true);
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to Yahtzee!");
		System.out.println("Enter any letter to roll!");
		if(kb.next() != null) {
			player.rollUnheldDice();
			
		}
		

	}

}
