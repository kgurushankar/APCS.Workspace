package kgurushankar.fractal.carpet;

import java.awt.Point;
import java.util.ArrayList;

import kgurushankar.fractal.Line;
import kgurushankar.fractal.Utils;

public class Curve extends kgurushankar.fractal.Curve {
	public Curve(int level, int x, int y, int x2, int y2) {
		super(level, x, y, x2, y2);
	}

	public Curve(int level, Point start, Point end) {
		super(level, start, end);
	}

	@Override
	protected void setupCurve(ArrayList<Line> AL, int level, Point one, Point two) {
		if (level > 1) {
			int sl = Math.abs(one.x - two.x);
			Point left = new Point(one.x, one.y - sl);
			Point right = new Point(two.x, two.y - sl);
			AL.add(new Line(one, two));
			AL.add(new Line(one, left));
			AL.add(new Line(left, right));
			AL.add(new Line(right, two));
			int d = sl / 3;
			// Bottom row
			setupCurve(AL, level - 1, one, new Point(one.x + 1 * d, one.y));
			setupCurve(AL, level - 1, new Point(one.x + 1 * d, one.y), new Point(one.x + 2 * d, one.y));
			setupCurve(AL, level - 1, new Point(one.x + 2 * d, one.y), new Point(one.x + 3 * d, one.y));
			// Middle
			setupCurve(AL, level - 1, new Point(one.x, one.y - 1 * d), new Point(one.x + 1 * d, one.y - 1 * d));
			setupCurve(AL, level - 1, new Point(one.x + 2 * d, one.y - 1 * d), new Point(one.x + 3 * d, one.y - 1 * d));
			// Top row
			setupCurve(AL, level - 1, new Point(one.x + 0 * d, one.y - 2 * d), new Point(one.x + 1 * d, one.y - 2 * d));
			setupCurve(AL, level - 1, new Point(one.x + 1 * d, one.y - 2 * d), new Point(one.x + 2 * d, one.y - 2 * d));
			setupCurve(AL, level - 1, new Point(one.x + 2 * d, one.y - 2 * d), new Point(one.x + 3 * d, one.y - 2 * d));
		}
	}

}
