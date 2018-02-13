package kgurushankar.fractal.sierpinski;

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
		
	}

}
