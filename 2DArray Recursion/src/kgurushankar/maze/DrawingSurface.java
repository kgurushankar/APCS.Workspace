package kgurushankar.maze;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	Finder maze;
	int dim;

	public DrawingSurface() {
		maze = new Finder("data/maze/test5.txt", 12, 12);
		dim = 100;
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		// size(0,0,PApplet.P3D);
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background
		fill(0);
		textAlign(LEFT);
		textSize(12);
		maze.draw(this, 50, 50, this.width - 50, this.height - 50);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		dim -= num * 10;
	}

}
