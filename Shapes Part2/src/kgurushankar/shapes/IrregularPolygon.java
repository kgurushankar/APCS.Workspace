/*
 * + I like that you have 3 constructors and you can use color in them, the code is very organized and clear to understand 
 * -
 * 
 * 
 * 
 */

package kgurushankar.shapes;

import java.awt.Color;
import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import processing.core.PApplet; // for Processing
import processing.core.PShape;

public class IrregularPolygon extends Shape2D {
	private ArrayList<Point2D.Double> points;

	// constructors
	public IrregularPolygon() {
		this(Color.BLACK, 2);
	}

	public IrregularPolygon(Color border, int strokeWidth) {
		this(border, strokeWidth, null);
	}

	public IrregularPolygon(Color border, int strokeWidth, Color fill) {
		super(0, 0, 0, 0, border, strokeWidth, fill);
		points = new ArrayList<Point2D.Double>();
	}

	// public methods
	public void add(Point2D.Double aPoint) {
		points.add(aPoint);
	}

	public void draw(PApplet applet) {
		super.draw(applet);
		PShape shape;
		shape = applet.createShape();
		shape.beginShape();
		shape.fill(applet.g.fillColor);
		shape.stroke(applet.g.strokeColor);
		shape.strokeWeight(applet.g.strokeWeight);
		for (Point2D.Double p : points) {
			shape.vertex((float) p.getX(), (float) p.getY());
		}
		shape.endShape(PApplet.CLOSE);
		applet.shape(shape);
	}

	public double getArea() {
		if (points.size() == 0) {
			return 0;
		}
		double a = 0;
		int n = points.size();
		for (int i = 0; i < points.size() - 1; i++) {
			a += points.get(i).getX() * points.get(i + 1).getY();
			a -= points.get(i).getY() * points.get(i + 1).getX();
		}
		a += points.get(n - 1).getX() * points.get(0).getY();
		a -= points.get(n - 1).getY() * points.get(0).getX();
		return Math.abs(a / 2);
	}

	public double getPerimeter() {
		if (points.size() == 0) {
			return 0;
		}
		double d = 0;
		for (int i = 0; i < points.size() - 1; i++) {
			d += points.get(i).distance(points.get(i + 1));
		}
		d += points.get(0).distance(points.get(points.size() - 1));
		return d;
	}

	public boolean isPolygon() {
		Line[] l = new Line[points.size()];
		for (int i = 0; i < points.size() - 1; i++) {
			l[i] = new Line((float) points.get(i).getX(), (float) points.get(i).getY(),
					(float) points.get(i + 1).getX(), (float) points.get(i + 1).getY());
		}
		l[l.length - 1] = new Line((float) points.get(0).getX(), (float) points.get(0).getY(),
				(float) points.get(points.size() - 1).getX(), (float) points.get(points.size() - 1).getY());

		for (int i = 0; i < l.length - 1; i++) {
			if (l[i].doesIntersect(l[i + 1])) {
				return false;
			}
		}
		if (l[0].doesIntersect(l[l.length - 1])) {
			return false;
		}
		return true;

	}

	@Override
	public double getX() {
		double x = 0;
		for (Point2D.Double p : points) {
			x += p.getX();
		}
		return x / points.size();
	}

	@Override
	public double getY() {
		double y = 0;
		for (Point2D.Double p : points) {
			y += p.getY();
		}
		return y / points.size();
	}

	@Override
	public Shape2D move(double x, double y) {
		IrregularPolygon ip = new IrregularPolygon();
		for (Point2D.Double p : points) {
			ip.add(new Point2D.Double(p.getX() + x, p.getY() + y));
		}
		return ip;
	}

	@Override
	public Shape2D moveTo(double x, double y) {
		double dx = x - getX();
		double dy = y - getY();
		return move(dx, dy);
	}
}
