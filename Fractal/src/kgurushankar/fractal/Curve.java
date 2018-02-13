package kgurushankar.fractal;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

public abstract class Curve {

	private Line[] p;

	public Curve(int level, Point start, Point end) {
		ArrayList<Line> AL = new ArrayList<Line>();
		setupCurve(AL, level, start, end);
		p = new Line[AL.size()];
		AL.toArray(p);
	}

	public Curve(int level, int x, int y, int x2, int y2) {
		this(level, new Point(x, y), new Point(x2, y2));
	}

	public void draw(PApplet marker) {
		for (Line l : p) {
			l.draw(marker);
		}
	}

	protected abstract void setupCurve(ArrayList<Line> AL, int level, Point one, Point two);
}
