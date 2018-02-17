package kgurushankar.fractal.carpet;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	@Override
	public Curve setupCurve(int level, int length) {
		// TODO Auto-generated method stub
		return new Curve(level, 100, 1000, 100 + length, 1000);

	}

}
