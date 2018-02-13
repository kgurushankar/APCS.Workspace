package kgurushankar.fractal;

import java.awt.Point;

public class Utils {
	public static Point midpt(Point a, Point b) {
		return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
	}
}
