package Game;

import java.util.ArrayList;

public class Scoresheet {
	private int totalScore;
	private int ones, twos, threes, fours, fives, sixes;
	private int threeOfaKind, fourOfaKind, yahtzee;
	private int chance, fullHouse, smStr8, lgStr8;
	
	private ArrayList<Integer> nums = new ArrayList<Integer>(6);
	private ArrayList<Integer> ofaKind = new ArrayList<Integer>(3);
	private ArrayList<Integer> otherSlots = new ArrayList<Integer>(4);
	
	public Scoresheet() {
		// populating the list for slots 1 - 6
		for(int i = 0; i < 6; i++) {
			nums.add(-1);
		}
		// populating the list for slots 3ofaKind, 4ofaKind, and 5ofaKind (Yahtzee)
		for(int i = 0; i < 3; i++) {
			ofaKind.add(-1);
		}
		// populating the list for other slots
		for(int i = 0; i < 4; i++) {
			otherSlots.add(-1);
		}
		
		totalScore = 0;
	}
	
	// getters and setters
	public int getOnes() {
		return ones;
	}
	public void setOnes(int ones) {
		this.ones = ones;
	}
	public int getTwos() {
		return twos;
	}
	public void setTwos(int twos) {
		this.twos = twos;
	}
	public int getThrees() {
		return threes;
	}
	public void setThrees(int threes) {
		this.threes = threes;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getFives() {
		return fives;
	}
	public void setFives(int fives) {
		this.fives = fives;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getThreeOfaKind() {
		return threeOfaKind;
	}
	public void setThreeOfaKind(int threeOfaKind) {
		this.threeOfaKind = threeOfaKind;
	}
	public int getFourOfaKind() {
		return fourOfaKind;
	}
	public void setFourOfaKind(int fourOfaKind) {
		this.fourOfaKind = fourOfaKind;
	}
	public int getYahtzee() {
		return yahtzee;
	}
	public void setYahtzee(int yahtzee) {
		this.yahtzee = yahtzee;
	}
	public int getChance() {
		return chance;
	}
	public void setChance(int chance) {
		this.chance = chance;
	}
	public int getFullHouse() {
		return fullHouse;
	}
	public void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}
	public int getSmStr8() {
		return smStr8;
	}
	public void setSmStr8(int smStr8) {
		this.smStr8 = smStr8;
	}
	public int getLgStr8() {
		return lgStr8;
	}
	public void setLgStr8(int lgStr8) {
		this.lgStr8 = lgStr8;
	}
	
	public int getTotalScore() {
		for(int i : nums) {
			if(i > -1)
				totalScore += 1;
		}
		for(int i : ofaKind) {
			if(i > -1)
				totalScore += 1;
		}for(int i : otherSlots) {
			if(i > -1)
				totalScore += 1;
		}
		return totalScore;
	}
	
	

}
