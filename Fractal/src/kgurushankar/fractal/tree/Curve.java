package kgurushankar.fractal.tree;

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
		if (level > 0) {
			double angle = -Math.acos((two.x - one.x) / (one.distance(two)));
			AL.add(new Line(one, two));
			double l = -Math.toRadians(20);
			double r = Math.toRadians(20);
			double pangle = angle + r;
			double mangle = angle + l;
			int length = (int) ((level - 1) * one.distance(two) / level);
			Point p = new Point((int) (two.x + Math.cos(pangle) * length), (int) (two.y + Math.sin(pangle) * length));
			Point m = new Point((int) (two.x + Math.cos(mangle) * length), (int) (two.y + Math.sin(mangle) * length));
			setupCurve(AL, level - 1, two, p);
			setupCurve(AL, level - 1, two, m);
		}
	}

}
