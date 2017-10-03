package kgurushankar.illusion.wavylines;

import processing.core.PApplet;

import java.awt.Color;

import kgurushankar.shapes.*;

public class DrawingSurface extends PApplet {
	Rectangle[][] boxes;
	Line[] verticals;
	public static final float WIDTH = 575;
	public static final float HEIGHT = 575;

	public void setup() {
		boxes = new Rectangle[11][11];
		verticals = new Line[6];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				int inc = ((i + 3) % 4);
				int xinc = 
				if (j % 2 == 0) {
					boxes[i][j] = new Rectangle(xinc);
				}
			}
		}
	}

	public void draw() {
		this.scale(this.width / WIDTH, this.height / HEIGHT);
		for (Line l : boxes) {
			if (l != null)
				l.draw(this);
		}
		for (Line l : verticals) {
			l.draw(this);
		}
	}

}
