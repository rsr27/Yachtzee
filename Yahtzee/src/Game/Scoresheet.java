package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Scoresheet {
	private int totalScore;
	private int numSlotsFilled;
	
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
			return true;
		} else {
			System.out.println("This slot already filled!");
			return false;
		}
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
	
	public boolean mapIsFull() {
		if(numSlotsFilled < 13)
			return false;
		return true;
	}

}
