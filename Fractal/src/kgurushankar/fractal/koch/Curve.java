package kgurushankar.fractal.koch;

import java.awt.Point;
import java.util.ArrayList;

import kgurushankar.fractal.Line;
import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 *
 *
 * @author kgurushankar
 * @version
 */
public class Curve extends kgurushankar.fractal.Curve {

	// TO DO
	Line[] p;

	public Curve(int level, int x, int y, int x2, int y2) {
		super(level, x, y, x2, y2);
	}

	public Curve(int level, Point start, Point end) {
		super(level, start, end);
	}

	public void draw(PApplet marker) {
		for (Line l : p) {
			l.draw(marker);
		}
	}

	protected void setupCurve(ArrayList<Line> AL, int level, Point one, Point two) {
		if (level == 1) {
			AL.add(new Line(one, two));
		}
		if (level >= 0) {
			int dx = (two.x - one.x) / 3;
			int dy = (two.y - one.y) / 3;
			Point a = new Point(one.x + dx, one.y + dy);
			Point b = new Point(two.x - dx, two.y - dy);
			double sin120 = -0.866025403784438646763723170752936183471402626905190;
			Point tip = new Point(a.x + (int) (dx * 0.5 + dy * sin120), a.y + (int) (dy * 0.5 - dx * sin120));
			setupCurve(AL, level - 1, one, a);
			setupCurve(AL, level - 1, a, tip);
			setupCurve(AL, level - 1, tip, b);
			setupCurve(AL, level - 1, b, two);
		}
	}
}
