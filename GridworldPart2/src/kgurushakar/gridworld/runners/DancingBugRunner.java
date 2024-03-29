package kgurushakar.gridworld.runners;

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

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import kgurushakar.gridworld.bug.DancingBug;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner {
	public static void main(String[] args) {
		// int[] a = new int[] { 9, 20, 12, 16, 10, 18, 14, 12, 16, 10, 9, 17, 5, 2, 4,
		// 16, 20, 20, 15, 8 };
		int[] s = new int[] { 1, 2, 2, 3, 3, 2, 2, 1 };
		ActorWorld world = new ActorWorld();
		DancingBug alice = new DancingBug(s);
		alice.setColor(Color.ORANGE);
		world.add(new Location(7, 8), alice);
		world.show();
	}
}