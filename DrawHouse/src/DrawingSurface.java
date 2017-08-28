import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private Drawable house, person;
	public int[][] coord; // 0 - house, 1 - person
	private final boolean maintainAspectRatio = true;

	public void setup() {
		house = new House(this);
		person = new Person(this);
		coord = new int[2][2];
	}

	public void draw() {
		float scalex = (float) (width / 500.);
		float scaley = (float) (height / 500.);
		float scalef = Math.min(scalex, scaley);

		scale((maintainAspectRatio) ? scalef : scalex, (maintainAspectRatio) ? scalef : scaley);
		background(204);

		house.draw(this, coord[0][0], coord[0][1]);
		person.draw(this, coord[1][0], coord[1][1]);

	}

	public void keyPressed() {
		//If numpad is off, then movement is for the person only mouse also works for 
		if (keyCode == UP) {
			coord[1][1] -= 10;
		} else if (keyCode == DOWN) {
			coord[1][1] += 10;
		} else if (keyCode == LEFT) {
			coord[1][0] -= 10;
		} else if (keyCode == RIGHT) {
			coord[1][0] += 10;
		} else if (keyCode == KeyEvent.VK_PAGE_UP) {
			house.incrementSize(.1f);
		} else if (keyCode == KeyEvent.VK_PAGE_DOWN) {
			house.incrementSize(-0.1f);
		} else if (keyCode == KeyEvent.VK_NUMPAD8) { // up
			coord[0][1] -= 10;
		} else if (keyCode == KeyEvent.VK_NUMPAD2) {// down
			coord[0][1] += 10;
		} else if (keyCode == KeyEvent.VK_NUMPAD4) {// left
			coord[0][0] -= 10;
		} else if (keyCode == KeyEvent.VK_NUMPAD6) {// right
			coord[0][0] += 10;
		}
	}
 
	public void mouseClicked() {
		coord[0][0] = ((mouseX + 5) / 10) * 10;
		coord[0][1] = ((mouseY + 5) / 10) * 10;
	}
}
