package kgurushankar.fractal.dragon;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	public Curve setupCurve(int level, int length) {
		return new Curve(level, 100, 500, length + 100, 500);

	}

}
