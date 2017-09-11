import java.awt.event.KeyEvent;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private Drawable house, person, ground;
	private ArrayList<Rain> rain = new ArrayList<Rain>();
	private final boolean maintainAspectRatio = true;

	public void setup() {
		house = new House(this, 0, 0);
		person = new Person(this, 0, 0);
	}

	public void draw() {
		float scalex = (float) (width / 500.);
		float scaley = (float) (height / 500.);
		float scalef = Math.min(scalex, scaley);

		scale((maintainAspectRatio) ? scalef : scalex, (maintainAspectRatio) ? scalef : scaley);
		background(204);

		house.draw(this);
		person.draw(this);

	}

	public void keyPressed() {
		// If numpad is off, then movement is for the person only mouse also works for
		if (keyCode == UP) {
			person.move(0, -10);
		} else if (keyCode == DOWN) {
			person.move(0, 10);
		} else if (keyCode == LEFT) {
			person.move(-10, 0);
		} else if (keyCode == RIGHT) {
			person.move(10, 0);
		} else if (keyCode == KeyEvent.VK_PAGE_UP) {
			house.incrementSize(.1f);
		} else if (keyCode == KeyEvent.VK_PAGE_DOWN) {
			house.incrementSize(-0.1f);
		} else if (keyCode == KeyEvent.VK_NUMPAD8) { // up
			house.move(0, -10);
		} else if (keyCode == KeyEvent.VK_NUMPAD2) {// down
			house.move(0, 10);
		} else if (keyCode == KeyEvent.VK_NUMPAD4) {// left
			house.move(-10, 0);
		} else if (keyCode == KeyEvent.VK_NUMPAD6) {// right
			house.move(10, 0);
		}
	}

	public void mouseClicked() {
		float scalex = (float) (width / 500.);
		float scaley = (float) (height / 500.);
		int x = (int) (mouseX / scalex);
		int y = (int) (mouseY / scaley);
		house.moveTo(((x + 5) / 10) * 10, ((y + 5) / 10) * 10);
	}
}
