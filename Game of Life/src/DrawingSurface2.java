import java.awt.Point;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class DrawingSurface2 extends PApplet {
	Life l;
	private boolean pause;

	public void setup() {
		l = new Life("life100.txt");
	}

	public void draw() {
		l.draw(this, 0, 0, width, height);
		if (pause) {
			this.fill(255, 0, 0);
			this.textSize(32);
			this.text("PAUSED", 10, 30);
		} else {
			if (frameCount % 60 == 0) {
				l.step();
			}
		}
	}

	public void mousePressed() {
		Point p = l.clickToIndex(new Point(mouseX, mouseY), 0, 0, width, height);
		if (last == null || (p.x != last.x || p.y != last.y)) {
			l.toggleCell(p.x, p.y);
			last = p;
		}
	}

	private Point last;

	public void mouseDragged() {
		mousePressed();
	}

	public void mouseReleased() {
		last = null;
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_P) {
			pause = !pause;
		} else if (keyCode == KeyEvent.VK_SPACE) {
			l = new Life();
		}
	}
}
