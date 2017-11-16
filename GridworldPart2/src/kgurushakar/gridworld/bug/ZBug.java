package kgurushakar.gridworld.bug;

import info.gridworld.actor.Bug;

public class ZBug extends Bug {

	private int steps;
	private int sideLength;
	private int side;

	/**
	 * Constructs a z bug that traces a 'Z' of a given length
	 *
	 * @param length
	 *            the length
	 */
	public ZBug(int length) {
		steps = 0;
		sideLength = length;
		side = 0;
		turn();
		turn();
	}

	/**
	 * Moves to the next location of the 'Z'.
	 */
	public void act() {
		if (side > 2 || !canMove()) {
			return;
		} else if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else {
			steps = 0;
			if (side == 0) {
				turn();
				turn();
				turn();
			} else if (side == 1) {
				turn();
				turn();
				turn();
				turn();
				turn();
			}
			side++;
		}
	}
}
