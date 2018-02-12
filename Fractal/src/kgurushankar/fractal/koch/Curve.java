package kgurushankar.kochcurve;

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 *
 *
 * @author kgurushankar
 * @version
 */
public class KochCurve {

	// TO DO
	Line[] p;

	public KochCurve(int level, Point start, Point end) {
		this(level, start.x, start.y, end.x, end.y);
	}

	public KochCurve(int level, int x, int y, int x2, int y2) {
		ArrayList<Line> AL = new ArrayList<Line>();
		setupKochCurve(AL, level, new Point(x, y), new Point(x2, y2));
		p = new Line[AL.size()];
		AL.toArray(p);
	}

	public KochCurve(int level, int length) {
		this(level, 100, 500, length + 100, 500);
	}

	public void draw(PApplet marker) {
		for (Line l : p) {
			l.draw(marker);
		}
	}

	private void setupKochCurve(ArrayList<Line> AL, int level, Point one, Point two) {
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
			setupKochCurve(AL, level - 1, one, a);
			setupKochCurve(AL, level - 1, a, tip);
			setupKochCurve(AL, level - 1, tip, b);
			setupKochCurve(AL, level - 1, b, two);
		}
	}
}
