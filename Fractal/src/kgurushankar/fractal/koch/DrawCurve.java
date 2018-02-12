package kgurushankar.fractal.koch;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	@Override
	public kgurushankar.fractal.Curve setupCurve(int level, int length) {
		// TODO Auto-generated method stub
		return new Curve(level, 100, 500, length + 100, 500);

	}

}
