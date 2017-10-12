package kgurushankar.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Regular polygon is a polygon which has congruent angles and sides
 * 
 * @author kgurushankar
 */
public class RegularPolygon {
	private int numSides;
	private double sideLength;
	private Circle out, in;
	private Line[] sides;
	private double x;
	private double y;

	/**
	 * Constructs a new regular Triangle with side length 100 at 0,0
	 */
	public RegularPolygon() {
		this(0, 0, 3, 100);
	}

	/**
	 * Constructs a new regular Polygon with numSides sides, side length sideLength,
	 * at x, y
	 * 
	 * @param x
	 *            x coordinate of the center of this regular polygon
	 * @param y
	 *            y coordinate of the center of this regular polygon
	 * @param numSides
	 *            number of sides of this regular polygon
	 * @param sideLength
	 *            length of each side of this regular polygon
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		this.x = x;
		this.y = y;
		this.numSides = numSides;
		this.sideLength = sideLength;
		calcR();
		calcr();
		setupLines();
	}

	/** @return internal angle of each vertex */
	public double calcVertexAngle() {
		return ((numSides - 2d) / numSides) * Math.PI;
	}

	/** @return perimeter of this regular polygon */
	public double calcPerimeter() {
		return numSides * sideLength;
	}

	/** @return area of this regular polygon */
	public double calcArea() {
		return (numSides * getR() * getR() * Math.sin(Math.PI * 2 / numSides)) / 2;
	}

	/** @return number of sies of this regular polygon */
	public int getNumSides() {
		return numSides;
	}

	/** @return length of each of the sides of this regular polygon */
	public double getSideLength() {
		return sideLength;
	}

	/** @return radius of the circle that circumscribes this regular polygon */
	public double getR() {
		return out.getWidth() / 2;
	}

	/** @return radius of the circle that is inscribed in this regular polygon */
	public double getr() {
		return in.getWidth() / 2;
	}

	/**
	 * Draw this polygon
	 * 
	 * @param applet
	 *            PApplet for this to be drawn on
	 * @post draws this regular polygon on applet
	 */
	public void draw(PApplet applet) {
		for (Line l : sides) {
			l.draw(applet);
		}
	}

	/**
	 * Draw the circles that can be inscribed in and circumscribed about this
	 * polygon
	 * 
	 * @param applet
	 *            PApplet for the circles to be drawn on
	 * @post draws the circles that can be inscribed in and circumscribed about this
	 *       polygon on applet
	 */
	public void drawBoundingCircles(PApplet applet) {
		in.draw(applet);
		out.draw(applet);
	}

	/**
	 * @param radians
	 *            a radian measure
	 * @return equivalent angle in degrees
	 */
	public static double toDegrees(double radians) {
		return radians * 180 / Math.PI;
	}

	// figure this out!!
	private void setupLines() {
		double radius = getR() * 10;
		double angle = Math.PI * 2 / numSides;
		double x1 = Math.cos(0) * radius, x2, y1 = Math.sin(0) * radius, y2;
		sides = new Line[numSides];
		int n = 0;
		for (double a = angle; a < PApplet.TWO_PI; a += angle) {
			x2 = x1;
			y2 = x2;
			x1 = Math.cos(a) * radius;
			y1 = Math.sin(a) * radius;
			sides[n] = new Line((float) (x1 + x), (float) (y1 + y), (float) (x2 + x), (float) (y2 + y), randomColor(),
					2);
			n++;
		}
	}

	private void calcr() {
		double r = sideLength / (Math.tan(Math.PI / numSides) * 2);
		in = new Circle(x, y, r);
	}

	private void calcR() {
		double R = sideLength / (Math.sin(Math.PI / numSides) * 2);
		out = new Circle(x, y, R);
	}

	private static Color randomColor() {
		return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}
}
