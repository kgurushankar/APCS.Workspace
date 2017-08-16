
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
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Bee</code> is an actor that can move and turn. It only moves onto
 * tiles with flowers on them. <br />
 * Please note <code>./Bee.gif</code> is online clipart
 */
public class Bee extends Actor {

	private Color Original;
	private Actor lastLoc;

	/**
	 * Constructs a red bee.
	 */
	public Bee() {
		setColor(Original = Color.YELLOW);
	}

	/**
	 * Constructs a bee of a given color.
	 * 
	 * @param beeColor
	 *            the color for this bee
	 */
	public Bee(Color beeColor) {
		setColor(Original = beeColor);
	}

	/**
	 * Moves if it can move, turns otherwise.
	 */
	public void act() {
		if (canMove()) {
			move();
			if (!canMove()) {
				super.setColor(new Color(153, 50, 204));
			}
		} else {
			turn();
			if (canMove()) {
				super.setColor(Original);
			}
		}
	}

	/**
	 * Turns the bee 90 degrees to the right without changing its location.
	 */
	public void turn() {
		setDirection(getDirection() + Location.RIGHT);
	}

	/**
	 * Moves the bee forward
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (gr.isValid(next)) {
			Actor tmp = gr.get(next);
			gr.remove(next);
			moveTo(next);
			if (this.lastLoc != null)
				gr.put(loc, this.lastLoc);
			this.lastLoc = tmp;
		} else
			removeSelfFromGrid();
	}

	/**
	 * Tests whether this bee can move forward into a location that contains a
	 * flower.
	 * 
	 * @return true if this bee can move.
	 */
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		if (!(gr.get(next) instanceof Flower))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Flower);
		// ok to move into empty location or onto flower
		// not ok to move onto any other actor
	}

	public void setColor(Color newColor) {
		super.setColor(Original = newColor);
	}
}
