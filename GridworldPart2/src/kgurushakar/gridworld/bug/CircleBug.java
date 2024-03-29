package kgurushakar.gridworld.bug;

import info.gridworld.actor.Bug;

public class CircleBug extends Bug {
	private int steps;
	private int sideLength;

	/**
	 * Constructs a circle bug that traces a octagon of a given side length
	 *
	 * @param length
	 *            the side length
	 */
	public CircleBug(int length) {
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the octagon.
	 */
	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else {
			turn();
			steps = 0;
		}
	}

}
