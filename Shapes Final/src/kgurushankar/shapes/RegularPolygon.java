package kgurushankar.shapes;

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
	private double[][] points;
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
		setupSides();
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
		for (int i = 0; i < numSides - 1; i++) {
			new Line((float) points[i][0], (float) points[i][1], (float) points[i + 1][0], (float) points[i + 1][1])
					.draw(applet);
		}
		new Line((float) points[0][0], (float) points[0][1], (float) points[numSides - 1][0],
				(float) points[numSides - 1][1]).draw(applet);
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
	private void setupSides() {
		double radius = getR();
		double angle = Math.PI * 2 / numSides;
		points = new double[numSides][2];
		for (int i = 0; i < numSides; i++) {
			points[i][0] = radius * Math.cos(angle * i + Math.PI / 4) + x;
			points[i][1] = radius * Math.sin(angle * i + Math.PI / 4) + y;
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

}
