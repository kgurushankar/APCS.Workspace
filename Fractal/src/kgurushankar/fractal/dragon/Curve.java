package kgurushankar.fractal.dragon;

import java.awt.Point;
import java.util.ArrayList;

import kgurushankar.fractal.Line;

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
			AL.add(new Line(one, two));
		} else {
			int xn = (one.x + two.x) / 2 + (two.y - one.y) / 2;
			int yn = (one.y + two.y) / 2 - (two.x - one.x) / 2;
			Point tip = new Point(xn, yn);
			setupCurve(AL, level - 1, one, tip);
			setupCurve(AL, level - 1, two, tip);
		}

	}

}
