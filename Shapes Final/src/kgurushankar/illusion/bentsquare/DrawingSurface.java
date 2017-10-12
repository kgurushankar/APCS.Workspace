package kgurushankar.illusion.bentsquare;

import processing.core.PApplet;

import java.awt.Color;

import kgurushankar.shapes.*;

public class DrawingSurface extends PApplet {
	Circle[] circles;
	Rectangle square;
	public static final float WIDTH = 800;
	public static final float HEIGHT = 800;

	public void setup() {
		circles = new Circle[16];
		for (int i = 0; i < circles.length; i++) {
			circles[i] = new Circle(WIDTH / 2, HEIGHT / 2, i * 25, Color.black, 5);
		}
		int margin = 125; // 130 is closer to image in ppt but 125 looks better
		square = new Rectangle(margin, margin, WIDTH - 2 * margin, HEIGHT - 2 * margin, Color.MAGENTA, 5);
	}

	public void draw() {
		this.scale(this.width / WIDTH, this.height / HEIGHT);
		for (Circle c : circles) {
			c.draw(this);
		}
		square.draw(this);
	}

}
