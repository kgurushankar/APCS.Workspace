package kgurushakar.gridworld.bug;

import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
	private int steps;
	private int sideLength;

	/**
	 * Constructs a spiral bug that traces a spiral starting with the given side
	 * length
	 *
	 * @param length
	 *            the side length
	 */
	public SpiralBug(int length) {
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the spiral.
	 */
	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else {
			turn();
			turn();
			steps = 0;
			sideLength++;
		}
	}
}
