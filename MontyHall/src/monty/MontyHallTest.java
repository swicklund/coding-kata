package monty;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MontyHallTest {
	private static final int NUMBER_OF_PLAYS = 10000;
	private Game g;

	@Test
	public void doorLimits() throws Exception {
		for (int i = 0; i < NUMBER_OF_PLAYS; i++) {
			g = new Game();
			int door = g.getWinningDoor();
			assertTrue("Door is not thje right value: " + door, door > 0
					&& door < 4);
		}
	}

	@Test
	public void doorsDifferent() throws Exception {
		g = new Game();
		int lastDoor = g.getWinningDoor();
		boolean isDifferent = false;
		for (int i = 0; i < NUMBER_OF_PLAYS; i++) {
			g = new Game();
			int newDoor = g.getWinningDoor();
			if (newDoor != lastDoor) {
				isDifferent = true;
				break;
			}
		}
		assertTrue(isDifferent);
	}
	
	@Test
	public void doorCoverage() throws Exception {
		Set<Integer> doorSet = new HashSet<Integer>();
		for (int i = 0; i < NUMBER_OF_PLAYS; i++) {
			g = new Game();
			doorSet.add(g.getWinningDoor());
		}
		assertEquals(new HashSet<Integer>(Arrays.asList(1,2,3)), doorSet);
	}
	
	@Test
	public void gameNoSwitch() throws Exception {
		int choice = 1;
		int correctCount = 0;
		for (int i = 0; i < NUMBER_OF_PLAYS; i++) {
			g = new Game();
			g.setChoice(choice);
			int otherChoice = g.getOtherChoice();
			g.setChoice(choice);
			if (g.win()) {
				correctCount ++;
			}
		}
		assertEquals(.3333, (double)correctCount/NUMBER_OF_PLAYS, .05);
	}
	
	@Test
	public void GameWithSwitch() throws Exception {
		int choice = 1;
		int correctCount = 0;
		for (int i = 0; i < NUMBER_OF_PLAYS; i++) {
			g = new Game();
			g.setChoice(1);
			int otherChoice = g.getOtherChoice();
			g.setChoice(otherChoice);
			if (g.win()) {
				correctCount ++;
			}
		}
		assertEquals(.6666, (double)correctCount/NUMBER_OF_PLAYS, .05);
	}
}
