package kgurushakar.gridworld.bug;

/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BoxBug extends Bug {
	/** How many steps of a side of the square have been taken */
	private int steps;
	/** Length of each side of the square */
	private int sideLength;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 *
	 * @param length
	 *            the side length
	 */
	public BoxBug(int length) {
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		// If it has taken less steps than the side length and it can move forward
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		} else {// if it has reached the end of a side or cannot continue forward, turn right
				// and reset the step count
			turn();
			turn();
			steps = 0;
		}
	}
}
