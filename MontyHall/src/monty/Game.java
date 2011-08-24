package monty;

import java.util.Random;

public class Game {

	private int choice;
	private int winningDoor;
	
	public Game() {
		this.winningDoor = new Random().nextInt(3)+1;
	}
	
	public int getWinningDoor() {
		return winningDoor;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getOtherChoice() {
		int otherChoice;
		if (choice == winningDoor) {
			otherChoice = (winningDoor+1)%3;
			if (otherChoice == 0)
				otherChoice++;
		} else {
			otherChoice = winningDoor;
		}
		return otherChoice;
	}

	public boolean win() {
		return choice == winningDoor;
	}

}
