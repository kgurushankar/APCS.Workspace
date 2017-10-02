package kgurushankar.illusion.linesize;

import processing.core.PApplet;

import java.awt.Color;

import kgurushankar.shapes.*;

public class DrawingSurface extends PApplet {
	Line[] lines;
	Line[] vertical;
	public static final float WIDTH = 800;
	public static final float HEIGHT = 600;

	public void setup() {
		lines = new Line[11];
		vertical = new Line[2];
		for (int i = -5; i < lines.length - 5; i++) {
			lines[i + 5] = new Line(0, (HEIGHT / 2) + HEIGHT / 28 * i, WIDTH, (HEIGHT / 2) + HEIGHT / 7 * i);
		}
		vertical[0] = new Line(WIDTH / 2, HEIGHT / 6, WIDTH / 2, HEIGHT * 5 / 6);
		vertical[1] = new Line(WIDTH * 3 / 4, HEIGHT / 6, WIDTH * 3 / 4, HEIGHT * 5 / 6);
	}

	public void draw() {
		this.scale(this.width / WIDTH, this.height / HEIGHT);
		this.stroke(Color.BLACK.getRGB());
		for (Line line : lines) {
			line.draw(this);
		}
		this.strokeWeight(10);
		this.stroke(Color.BLUE.getRGB());
		for (Line line : vertical) {
			line.draw(this);
		}
		this.strokeWeight(1);
	}

}
