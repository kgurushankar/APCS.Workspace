package kgurushakar.gridworld.bug;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {

	private int[] steps;
	private int number;

	/**
	 * Constructs a Dancing bug that dances using the turns in the array
	 *
	 * @param steps
	 *            the array of turns to make
	 */
	public DancingBug(int[] steps) {
		number = 0;
		this.steps = steps;
	}

	/**
	 * Turns and moves to the next location
	 */
	public void act() {
		turn(steps[number % steps.length]);
		number++;
		super.act();
	}

	/**
	 * Turn num times 45 degrees
	 *
	 * @param num
	 *            number of times to turn
	 */
	public void turn(int num) {
		for (int i = 0; i < num % 8; i++) {
			turn();
		}
	}
}
