import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private Two048 board;

	public DrawingSurface() {
		board = new Two048();
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
		String s = "";
		if (board.lose()) {
			s = "You lose! \n Press r to play again";
		} else if (board.win()) {
			s = "You win! \n Press r to play again";
		}
		text(s, height + 20, 30);

		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}

	}

	public void keyPressed() {
		if (board.lose()) {
			if (keyCode == KeyEvent.VK_R) {
				board = new Two048();
			}
		} else if (board.win()) {
			if (keyCode == KeyEvent.VK_R) {
				board = new Two048();
			}
		} else {
			if (keyCode == KeyEvent.VK_UP) {
				board.step(0);
			} else if (keyCode == KeyEvent.VK_DOWN) {
				board.step(2);
			} else if (keyCode == KeyEvent.VK_LEFT) {
				board.step(3);
			} else if (keyCode == KeyEvent.VK_RIGHT) {
				board.step(1);
			} else if (keyCode == KeyEvent.VK_SPACE) {
				board.spawnNew();
			}
		}
	}

}