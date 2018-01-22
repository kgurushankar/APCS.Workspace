import java.awt.Point;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private Two048 board;
	private int runCount;
	private int speed;
	private boolean gameRunning;

	public DrawingSurface() {
		board = new Two048();
		gameRunning = true;
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

		text("Enter: Run 1 step\nSpace: Start/Stop\nUp arrow: Increase speed\nDown arrow: Decrease speed\nc: Clear grid\n\nSpeed: "
				+ (60.0 / speed) + " per sec", height + 20, 30);

		if (runCount == 0) {
			// board.step();
			runCount = speed;
		} else if (runCount > 0) {
			runCount--;
		}

		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}

	}

	public void keyPressed() {
		// if (!board.lose() && !board.win()) {
		if (keyCode == KeyEvent.VK_UP) {
			board.step(0);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			board.step(2);
		} else if (keyCode == KeyEvent.VK_LEFT) {
			board.step(3);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			board.step(1);
		}
		// } else {
		// System.out.println("Clear");
		// if (keyCode == KeyEvent.VK_UP) {

		// }
		// }
	}

}