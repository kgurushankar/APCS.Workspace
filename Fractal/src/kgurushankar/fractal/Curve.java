package kgurushankar.fractal;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Curve {

	protected Line[] p;

	public void draw(PApplet marker) {
		for (Line l : p) {
			l.draw(marker);
		}
	}

	protected abstract void setupCurve(ArrayList<Line> AL, int level, Point one, Point two);
}
