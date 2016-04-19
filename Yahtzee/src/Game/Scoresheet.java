package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Scoresheet {
	private int totalScore;
	private int numSlotsFilled;
	private boolean previousSuccess = true;
	
	public HashMap<String, Integer> scoreHash = new HashMap<>();
	
	public Scoresheet() {
		scoreHash.put("ones", -1);
		scoreHash.put("twos", -1);
		scoreHash.put("threes", -1);
		scoreHash.put("fours", -1);
		scoreHash.put("fives", -1);
		scoreHash.put("sixes", -1);
		scoreHash.put("chance", -1);
		scoreHash.put("smStr8", -1);
		scoreHash.put("lgStr8", -1);
		scoreHash.put("3ofaKind", -1);
		scoreHash.put("4ofaKind", -1);
		scoreHash.put("yahtzee", -1);
		scoreHash.put("fullHouse", -1);

		numSlotsFilled = 0;
		totalScore = 0;
	}
	
	public boolean addScore(String slot, int score) {
		if(scoreHash.get(slot) == -1){
			scoreHash.put(slot, 0);
			scoreHash.put(slot, score);
			numSlotsFilled++;
			previousSuccess = true;
		} else {
			System.out.println("This slot is already filled!");
			previousSuccess = false;
		}
		
		return previousSuccess;
	}
	
	public int getTotalScore() {
		int scoreInSlot = 0;
		Iterator it = scoreHash.entrySet().iterator();
		while(it.hasNext()) {
			scoreInSlot = (int) it.next();
			if (scoreInSlot != -1) {
				totalScore += scoreInSlot;
			}
		}
		return totalScore;
	}

	public boolean getPreviousSuccess()
	{
		return previousSuccess;
	}
	
	public boolean upperSectionIsFull() {
		if(scoreHash.get("chance") == -1)
			return false;
		if(scoreHash.get("smStr8") == -1)
			return false;
		if(scoreHash.get("lgStr8") == -1)
			return false;
		if(scoreHash.get("3ofaKind") == -1)
			return false;
		if(scoreHash.get("4ofaKind") == -1)
			return false;
		if(scoreHash.get("fullHouse") == -1)
			return false;
		if(scoreHash.get("yahtzee") == -1)
			return false;
		return true;
	}
	
	public boolean mapIsFull() {
		if(numSlotsFilled < 13)
			return false;
		return true;
	}
	
	public void displayScoreSheet() {
		System.out.println();
		System.out.println("Ones:            1    " + getScoreInSheet("ones"));
		System.out.println("Twos:            2    " + getScoreInSheet("twos"));
		System.out.println("Threes:          3    " + getScoreInSheet("threes"));
		System.out.println("Fours:           4    " + getScoreInSheet("fours"));
		System.out.println("Fives:           5    " + getScoreInSheet("fives"));
		System.out.println("Sixes:           6    " + getScoreInSheet("sixes"));
		System.out.println("Chance:          7    " + getScoreInSheet("chance"));
		System.out.println("Small Straight:  8    " + getScoreInSheet("smStr8"));
		System.out.println("Large Straight:  9    " + getScoreInSheet("lgStr8"));
		System.out.println("3 of a Kind:     10   " + getScoreInSheet("3ofaKind"));
		System.out.println("4 of a Kind:     11   " + getScoreInSheet("4ofaKind"));
		System.out.println("Full House:      12   " + getScoreInSheet("fullHouse"));
		System.out.println("Yahtzee:         13   " + getScoreInSheet("yahtzee"));
		System.out.println();
	}
	
	public String getScoreInSheet(String slot) {
		String returnString = "Slot holds: ";
		if(scoreHash.get(slot) == -1)
			returnString += "empty";
		else
			returnString += scoreHash.get(slot).toString();
		return returnString;
	}

}
