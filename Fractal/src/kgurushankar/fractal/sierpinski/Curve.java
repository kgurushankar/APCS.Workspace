package kgurushankar.fractal.sierpinski;

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
		Point midbase = Utils.midpt(one, two);
		Point tip = new Point(midbase.x, (int) (-Math.sqrt(3) * midbase.distance(one) + one.y));
		if (level > 1) {
			Point midleft = Utils.midpt(one, tip);
			Point midright = Utils.midpt(tip, two);
			setupCurve(AL, level - 1, one, midbase);
			setupCurve(AL, level - 1, midbase, two);
			setupCurve(AL, level - 1, midleft, midright);
		} else {
			AL.add(new Line(one, two));
			AL.add(new Line(one, tip));
			AL.add(new Line(tip, two));
		}
	}

}
