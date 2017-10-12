package kgurushankar.illusion.wavylines;

import processing.core.PApplet;

import java.awt.Color;

import kgurushankar.shapes.*;

public class DrawingSurface extends PApplet {
	// 50 by 50
	Rectangle[][] boxes;
	public static final float WIDTH = 575;
	public static final float HEIGHT = 550;
	private static final Color green = Color.GREEN.darker().darker();

	public void setup() {
		boxes = new Rectangle[11][11];
		for (int i = 0; i < 11; i++) { // y
			for (int j = 0; j < 11; j++) {// x
				int inc = (i % 4);
				int xinc = (inc == 0) ? 25 : (inc == 1) ? 12 : (inc == 2) ? 0 : 12;
				if (j % 2 == 0) {
					boxes[i][j] = new Rectangle(xinc + j * 50, 1 + i * 50, 49, 47, Color.BLACK, 1, green);
				} else {
					boxes[i][j] = new Rectangle(xinc + j * 50, i * 50, 49, 50, Color.GRAY, 1, Color.WHITE);
				}
			}
		}
	}

	public void draw() {
		this.scale(this.width / WIDTH, this.height / HEIGHT);
		for (Rectangle b[] : boxes) {
			for (Rectangle r : b) {
				r.draw(this);
			}
		}
	}

}
