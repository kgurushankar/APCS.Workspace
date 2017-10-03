package kgurushankar.illusion.bentlines;

import processing.core.PApplet;

import java.awt.Color;

import kgurushankar.shapes.*;

public class DrawingSurface extends PApplet {
	Line[] lines;
	Line[] verticals;
	public static final float WIDTH = 800;
	public static final float HEIGHT = 800;

	public void setup() {
		lines = new Line[40];
		verticals = new Line[6];
		for (int i = 0; i < lines.length; i++) {
			double angle = (Math.PI * (double) i) / 20d;
			lines[i] = new Line(WIDTH / 2, HEIGHT / 2, angle, HEIGHT * 15 / 32);
		}
		for (int i = 0; i < verticals.length; i++) {
			verticals[i] = new Line(/* WIDTH * (3 / 16) */150 + i * WIDTH / 8, /* HEIGHT / 16 */50, Math.PI / 2,
					HEIGHT * 7 / 8, Color.RED, 10);
		}
	}

	public void draw() {
		this.scale(this.width / WIDTH, this.height / HEIGHT);
		for (Line l : lines) {
			if (l != null)
				l.draw(this);
		}
		for (Line l : verticals) {
			l.draw(this);
		}
	}

}
