package kgurushankar.fractal.koch;

import java.awt.Point;
import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawFlake extends PApplet {

	private Flake curve;
	private int level, length;

	public DrawFlake() {
		level = 5;
		length = 1000;
		curve = new Flake(new Point(500, 100), level, length);
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

		textSize(12);
		fill(0);
		// text("Use the mouse wheel to change length, use UP/DOWN keys to change
		// level.",0,15);

		stroke(0);
		curve.draw(this);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num * 10;
		curve = new Flake(new Point(500, 100), level, length);
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			curve = new Flake(new Point(500, 100), level, length);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			curve = new Flake(new Point(500, 100), level, length);
		}
	}

}
