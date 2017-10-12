package kgurushankar.testers.regularpolygon;

import kgurushankar.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private RegularPolygon p[];

	public DrawingSurface() {
		p = new RegularPolygon[4];
		p[0] = new RegularPolygon(width / 4, height / 4, 4, 10);
		p[1] = new RegularPolygon(width * 3 / 4, height / 4, 8, 5.75);
		p[2] = new RegularPolygon(width / 4, height * 3 / 4, 19, 2);
		p[3] = new RegularPolygon(width * 3 / 4, height * 3 / 4, 91, 0.5);
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		for (RegularPolygon r : p) {
			// r.draw(this);
			System.out.print("n:" + r.getNumSides());
			System.out.print(" s:" + r.getSideLength());
			System.out.print(" theta:" + r.calcVertexAngle());
			System.out.print(" r:" + r.getr());
			System.out.print(" R:" + r.getR());
			System.out.print(" P:" + r.calcPerimeter());
			System.out.print(" A:" + r.calcArea());
			System.out.println();
		}
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background
		p[0].draw(this);
		// for (RegularPolygon r : p) {
		// r.draw(this);
		// }
	}

}
