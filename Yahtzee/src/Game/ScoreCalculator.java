package Game;

import java.util.ArrayList;

public class ScoreCalculator {
	
	public Scoresheet scores;
	private ArrayList<Die> dice = new ArrayList<Die>();
	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	// Constructor takes an ArrayList of dice
	public ScoreCalculator(ArrayList<Die> dice) {
		getDice(dice);
		scores = new Scoresheet();
	}

	// refreshes the dice and values lists with the passed list of dice
	public void getDice(ArrayList<Die> dice) {
		this.dice = dice;
		for(Die d : dice) {
			values.add(d.getRollValue());
		}
	}
	
	// ----- Here be Dragons - and boring math ----- //
	// Each "score" function calculates the score for the given hand
	// for the selected score slot
	// Each returns true if successfully called
	
	public boolean scoreOnes() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 1) {
				value += 1;
			}
		}
		return scores.addScore("ones", value);
	}
	
	public boolean scoreTwos() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 2) {
				value += 2;
			}
		}
		return scores.addScore("twos", value);
	}
	
	public boolean scoreThrees() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 3) {
				value += 3;
			}
		}
		return scores.addScore("threes", value);
	}
	
	public boolean scoreFours() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 4) {
				value += 4;
			}
		}
		return scores.addScore("fours", value);
	}
	
	public boolean scoreFives() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 5) {
				value += 5;
			}
		}
		return scores.addScore("fives", value);
	}
	
	public boolean scoreSixes() {
		int value = 0;
		for(Die d : dice) {
			if(d.getRollValue() == 6) {
				value += 6;
			}
		}
		return scores.addScore("sixes", value);
	}
	
	public boolean scoreChance() {
		int value = 0;
		for(Die d : dice) {
			value += d.getRollValue();
		}
		return scores.addScore("chance", value);
	}
	
	public boolean scoreSmallStraight() {
		int value = 0;
		
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
		return scores.addScore("smStr8", value);
	}
	
	public boolean scoreLargeStraight() {
		int value = 0;
		
		// calculates whether or not the dice contain a large straight
		// and adds 40 to the score if so
		if(values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) {
			if(values.contains(1) || values.contains(6))
				value = 40;
		}
		return scores.addScore("lgStr8", value);
	}
	
	public boolean score3ofaKind() {
		int value = 0;
		int duplicates = 0;
		int sumOfDice = 0;
		
		// keep track of the total value of the dice
		for(int i : values) {
			sumOfDice += i;
		}
		
		// loop through the values twice to check for duplicates
		for(int i : values) {
			duplicates = 0;
			for(int j : values) {
				if(j == i) {
					duplicates++;
				}
			}
			if(duplicates >= 3) {
				value = sumOfDice;
				break;
			}
		}
		
		return scores.addScore("3ofaKind", value);
	}
	
	public boolean score4ofaKind() {
		int value = 0;
		int duplicates = 0;
		int sumOfDice = 0;
		
		// keep track of the total value of the dice
		for(int i : values) {
			sumOfDice += i;
		}
		
		// loop through the values twice to check for duplicates
		for(int i : values) {
			duplicates = 0;
			for(int j : values) {
				if(j == i) {
					duplicates++;
				}
			}
			if(duplicates >= 4) {
				value = sumOfDice;
				break;
			}
		}
		
		return scores.addScore("4ofaKind", value);
	}
	
	public boolean scoreFullHouse() {
		int value = 0;
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
			value = 25;
		}
		
		return scores.addScore("fullHouse", value);
	}
	
	public boolean scoreYahtzee() {
		int value = 0;
		int dieValue = dice.get(0).getRollValue();
		for(Die d : dice) {
			if(d.getRollValue() != dieValue) {
				break;
			}
		}
		return scores.addScore("ones", value);
	}
}
