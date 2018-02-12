package kgurushankar.fractal.koch;

import java.awt.Point;

import processing.core.PApplet;

public class Flake {
	Curve[] kc;

	/** This is majorly messed up rn */
	Flake(Point start, int level, int number, int length) {
		double angle = Math.PI / number;
		Point[] p = new Point[number];
		p[0] = start;
		for (int i = 1; i < number; i++) {
			p[i] = new Point((int) (p[i - 1].x - length * Math.sin(angle)),
					(int) (p[i - 1].y - length * Math.cos(angle)));
		}
		kc = new Curve[number];
		for (int i = 0; i < number - 1; i++) {
			kc[i] = new Curve(level, p[i], p[i + 1]);
		}
		kc[number - 1] = new Curve(level, p[0], p[number - 1]);
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
