package kgurushankar.fractal.box;

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
		if (level <= 1) {

		} else {
			int dx = -(one.x - two.x) / 3;
			int dy = -(one.y - two.y) / 3;
			AL.add(new Line(one, two));
			AL.add(new Line(new Point(one.x, two.y), new Point(two.x, one.y)));
			setupCurve(AL, level - 1, one, new Point(one.x + dx, one.y + dy));
			setupCurve(AL, level - 1, new Point(one.x + 2 * dx, one.y + 2 * dy), two);
			setupCurve(AL, level - 1, new Point(one.x, two.y), new Point(one.x + dx, one.y + 2 * dy));
			setupCurve(AL, level - 1, new Point(one.x + 2 * dx, one.y + dy), new Point(two.x, one.y));

		}
	}
}
