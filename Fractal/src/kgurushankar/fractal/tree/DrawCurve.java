package kgurushankar.fractal.tree;

public class DrawCurve extends kgurushankar.fractal.DrawCurve {

	@Override
	public Curve setupCurve(int level, int length) {
		// TODO Auto-generated method stub
		return new Curve(level, 1000, 1000, 1000, 1000 + length / 2);

	}

}
