package kgurushankar.testers;

import java.awt.Color;

import kgurushankar.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private Rectangle r;
	private Circle c;
	private Ellipse e;

	public DrawingSurface() {
		r = new Rectangle(100, 100, 20, 300);
		c = new Circle(100, 100, 50);
		e = new Ellipse(r);
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background
		r.draw(this);
		c.draw(this);
		e.draw(this);
	}

}
