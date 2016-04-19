package Game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class ScoreCalculator {
	
	public Scoresheet scores;
//	private ArrayList<Die> dice = new ArrayList<Die>();
//	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	// Constructor takes an ArrayList of dice
	public ScoreCalculator() {
//		getDice(dice);
		scores = new Scoresheet();
	}

	// refreshes the dice and values lists with the passed list of dice
//	public void getDice(ArrayList<Die> dice) {
//		this.dice = dice;
//		for(Die d : dice) {
//			values.add(d.getRollValue());
//		}
//	}
	
	// ----- Here be Dragons - and boring math ----- //
	// Each "score" function calculates the score for the given hand
	// for the selected score slot and returns that score
	
	public boolean addToScoreSheet(String slot, int value) {
		return scores.addScore(slot, value);
	}
	
	public int getBestSlot() {
		
		ArrayList<Integer> localScores = new ArrayList<Integer>();
		
		if (scores.slotInSheet("ones")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreOnes());
		};

		if (scores.slotInSheet("twos")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreTwos());
		};

		if (scores.slotInSheet("threes")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreThrees());
		};

		if (scores.slotInSheet("fours")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFours());
		};

		if (scores.slotInSheet("fives")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFives());
		};

		if (scores.slotInSheet("sixes")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreSixes());
		};

		if (scores.slotInSheet("chance")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreChance());
		};

		if (scores.slotInSheet("smStr8")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreSmallStraight());
		};

		if (scores.slotInSheet("lgStr8")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreLargeStraight());
		};
		
		if (scores.slotInSheet("3ofaKind")) {
			localScores.add(-1);
		}
		else {
			localScores.add(score3ofaKind());
		};

		if (scores.slotInSheet("4ofaKind")) {
			localScores.add(-1);
		}
		else {
			localScores.add(score4ofaKind());
		};

		if (scores.slotInSheet("fullHouse")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFullHouse());
		};

		if (scores.slotInSheet("yahtzee")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreYahtzee());
		};
		
		int largest = 0;
		int currentIndex = 0;
		int largestIndex = 0;
		for(int i : localScores) {
			if (i >= largest) {
				largest = i;
				largestIndex = currentIndex;
			}
			
			currentIndex++;
		}
		
		System.out.println("Largest index: " + (largestIndex+1) );
		return largestIndex+1;
	}
	
	public int getBestLowerSection() {
		
		ArrayList<Integer> localScores = new ArrayList<Integer>();
		
		if (scores.slotInSheet("ones")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreOnes());
		};

		if (scores.slotInSheet("twos")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreTwos());
		};

		if (scores.slotInSheet("threes")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreThrees());
		};

		if (scores.slotInSheet("fours")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFours());
		};

		if (scores.slotInSheet("fives")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFives());
		};

		if (scores.slotInSheet("sixes")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreSixes());
		};
		
		int largest = 0;
		int currentIndex = 0;
		int largestIndex = 0;
		for(int i : localScores) {
			if (i > largest) {
				largest = i;
				largestIndex = currentIndex;
			}
			currentIndex++;
		}
		
		return largestIndex+1;
	}
	
	public int getBestUpperSection() {
		ArrayList<Integer> localScores = new ArrayList<Integer>();
		
		if (scores.slotInSheet("chance")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreChance());
		};

		if (scores.slotInSheet("smStr8")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreSmallStraight());
		};

		if (scores.slotInSheet("lgStr8")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreLargeStraight());
		};
		
		if (scores.slotInSheet("3ofaKind")) {
			localScores.add(-1);
		}
		else {
			localScores.add(score3ofaKind());
		};

		if (scores.slotInSheet("4ofaKind")) {
			localScores.add(-1);
		}
		else {
			localScores.add(score4ofaKind());
		};

		if (scores.slotInSheet("fullHouse")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreFullHouse());
		};

		if (scores.slotInSheet("yahtzee")) {
			localScores.add(-1);
		}
		else {
			localScores.add(scoreYahtzee());
		};
		
		int largest = 0;
		int currentIndex = 6;
		int largestIndex = 0;
		for(int i : localScores) {
			if (i > largest) {
				largest = i;
				largestIndex = currentIndex;
			}
			currentIndex++;
		}
		
		return largestIndex+1;
	}
	
	public int scoreOnes() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 1) {
				value += 1;
			}
		}
//		return scores.addScore("ones", value);
		return value;
	}
	
	public int scoreTwos() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 2) {
				value += 2;
			}
		}
		return value;
	}
	
	public int scoreThrees() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 3) {
				value += 3;
			}
		}
		return value;
	}
	
	public int scoreFours() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 4) {
				value += 4;
			}
		}
		return value;
	}
	
	public int scoreFives() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 5) {
				value += 5;
			}
		}
		return value;
	}
	
	public int scoreSixes() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			if(i == 6) {
				value += 6;
			}
		}
		return value;
	}
	
	public int scoreChance() {
		int value = 0;
		for(int i : Hand.getInstance().getDiceValues()) {
			value += i;
		}
		return value;
	}
	
	public int scoreSmallStraight() {
		int value = 0;
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		
		// calculates whether or not the dice contain a small straight
		// and adds 30 to the score if so
		if(values.contains(3) && values.contains(4)) {
			if(values.contains(1) && values.contains(2))
				value = 30;
			else if(values.contains(2) && values.contains(5))
				value = 30;
			else if(values.contains(5) && values.contains(6))
				value = 30;
		}
		return value;
	}
	
	public int scoreLargeStraight() {
		int value = 0;
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		
		// calculates whether or not the dice contain a large straight
		// and adds 40 to the score if so
		if(values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) {
			if(values.contains(1) || values.contains(6))
				value = 40;
		}
		return value;
	}
	
	public int score3ofaKind() {
//		int value = 0;
//		ArrayList<Integer> values = new ArrayList<Integer>();
//		int[] valuesArray = Hand.getInstance().getDiceValues();
//		for(int i : valuesArray) {
//			values.add(i);
//		}
//		int duplicates = 0;
//		int sumOfDice = 0;
//		
//		// keep track of the total value of the dice
//		for(int i : values) {
//			sumOfDice += i;
//		}
//		
//		// loop through the values twice to check for duplicates
//		for(int i : values) {
//			duplicates = 0;
//			for(int j : values) {
//				if(j == i) {
//					duplicates++;
//				}
//			}
//			if(duplicates >= 3) {
//				value = sumOfDice;
//				break;
//			}
//		}
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		// keep track of the total value of the dice
		int sumOfDice = 0;
		for(int i : values) {
			sumOfDice += i;
		}
		if(is3ofaKind())
			return sumOfDice;
		else
			return 0;
	}
	
	public boolean is3ofaKind() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		int duplicates = 0;
		
		// loop through the values twice to check for duplicates
		for(int i : values) {
			duplicates = 0;
			for(int j : values) {
				if(j == i) {
					duplicates++;
				}
			}
			if(duplicates >= 3) {
				return true;
			}
		}
		return false;
		
	}
	
	public int score4ofaKind() {
//		int value = 0;
//		ArrayList<Integer> values = new ArrayList<Integer>();
//		int[] valuesArray = Hand.getInstance().getDiceValues();
//		for(int i : valuesArray) {
//			values.add(i);
//		}
//		int duplicates = 0;
//		int sumOfDice = 0;
//		
//		// keep track of the total value of the dice
//		for(int i : values) {
//			sumOfDice += i;
//		}
//		
//		// loop through the values twice to check for duplicates
//		for(int i : values) {
//			duplicates = 0;
//			for(int j : values) {
//				if(j == i) {
//					duplicates++;
//				}
//			}
//			if(duplicates >= 4) {
//				value = sumOfDice;
//				break;
//			}
//		}		
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		// keep track of the total value of the dice
		int sumOfDice = 0;
		for(int i : values) {
			sumOfDice += i;
		}
		if(is4ofaKind())
			return sumOfDice;
		else
			return 0;
	}
	
	public boolean is4ofaKind() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		int duplicates = 0;
		
		// loop through the values twice to check for duplicates
		for(int i : values) {
			duplicates = 0;
			for(int j : values) {
				if(j == i) {
					duplicates++;
				}
			}
			if(duplicates >= 4) {
				return true;
			}
		}
		return false;
	}
	
	public int scoreFullHouse() {
//		int value = 0;
//		ArrayList<Integer> values = new ArrayList<Integer>();
//		int[] valuesArray = Hand.getInstance().getDiceValues();
//		for(int i : valuesArray) {
//			values.add(i);
//		}
//		int dieValue1 = values.get(0);
//		int dieValue1Count = 0;
//		int dieValue2 = 0;
//		int dieValue2Count = 0;
//		
//		for(int i : values) {
//			if(i != dieValue1) {
//				dieValue2 = i;
//				break;
//			}
//		}
//		
//		for(int i : values) {
//			if(i == dieValue1) {
//				dieValue1Count++;
//			}
//			if(i == dieValue2) {
//				dieValue2Count++;
//			}
//		}
//		
//		if((dieValue1Count == 2 && dieValue2Count == 3) || (dieValue1Count == 3 && dieValue2Count == 2)) {
//			value = 25;
//		}
		
		if(isFullHouse())
			return 25;
		else
			return 0;
	}
	
	public boolean isFullHouse() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		int dieValue1 = values.get(0);
		int dieValue1Count = 0;
		int dieValue2 = 0;
		int dieValue2Count = 0;
		
		for(int i : values) {
			if(i != dieValue1) {
				dieValue2 = i;
				break;
			}
		}
		
		for(int i : values) {
			if(i == dieValue1) {
				dieValue1Count++;
			}
			if(i == dieValue2) {
				dieValue2Count++;
			}
		}
		
		if((dieValue1Count == 2 && dieValue2Count == 3) || (dieValue1Count == 3 && dieValue2Count == 2)) {
			return true;
		}
		return false;
	}
	
	public int scoreYahtzee() {
//		int value = 50;
//		ArrayList<Integer> values = new ArrayList<Integer>();
//		int[] valuesArray = Hand.getInstance().getDiceValues();
//		for(int i : valuesArray) {
//			values.add(i);
//		}
//		int dieValue = valuesArray[0];
//		for(int i : valuesArray) {
//			if(i != dieValue) {
//				value = 0;
//				break;
//			}
//		}
		if(isYahtzee())
			return 50;
		else
			return 0;
	}
	
	public boolean isYahtzee() {
		ArrayList<Integer> values = new ArrayList<Integer>();
		int[] valuesArray = Hand.getInstance().getDiceValues();
		for(int i : valuesArray) {
			values.add(i);
		}
		int dieValue = valuesArray[0];
		for(int i : valuesArray) {
			if(i != dieValue) {
				return false;
			}
		}
		return true;
	}
}
