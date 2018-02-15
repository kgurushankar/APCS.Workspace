package kgurushankar.fractal;

import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public abstract class DrawCurve extends PApplet {

	private Curve curve;
	private int level, length;

	protected abstract Curve setupCurve(int level, int length);

	public DrawCurve() {
		level = 10;
		length = 500;
		curve = setupCurve();

	}

	protected Curve setupCurve() {
		return setupCurve(level, length);
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

		stroke(0);
		curve.draw(this);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num * 10;
		curve = setupCurve();
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			curve = setupCurve();
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			curve = setupCurve();
		}
	}

}
