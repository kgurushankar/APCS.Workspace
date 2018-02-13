package kgurushankar.fractal.sierpinski;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	@Override
	public Curve setupCurve(int level, int length) {
		// TODO Auto-generated method stub
		return new Curve(level, 500, 100, 500, 100 + length / 2);

	}

}
