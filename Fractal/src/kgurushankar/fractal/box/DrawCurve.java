package kgurushankar.fractal.box;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	public Curve setupCurve(int level, int length) {
		return new Curve(level, 100, 100, length + 100, length + 100);

	}

}
