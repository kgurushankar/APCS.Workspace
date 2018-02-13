package kgurushankar.fractal.koch;

import java.awt.Point;

import processing.core.PApplet;

public class Flake {
	Curve[] kc;

	Flake(Point start, int level, int length) {
		kc = new Curve[3];
		double base = length / 2.;
		Point right = new Point((int) (start.x + base), (int) (start.y + base * Math.sqrt(3)));
		Point left = new Point((int) (start.x - base), (int) (start.y + base * Math.sqrt(3)));
		kc[0] = new Curve(level, start, left);
		kc[1] = new Curve(level, left, right);
		kc[2] = new Curve(level, right, start);
	}

	public void draw(PApplet applet) {
		for (Curve k : kc) {
			k.draw(applet);
		}
	}

	public Flake() {
		Point a = new Point(500, 100);
		Point b = new Point(900, 500);
		Point c = new Point(500, 900);
		Point d = new Point(100, 500);
		kc = new Curve[4];
		kc[0] = new Curve(5, b, a);
		kc[1] = new Curve(5, c, b);
		kc[2] = new Curve(5, d, c);
		kc[3] = new Curve(5, a, d);
	}
}
