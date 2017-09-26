package kgurushankar.shapes;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * This class represents a circle
 * 
 * @author kgurushankar
 */
public class Circle {
	// x & y are center points
	private double x, y, r;

	/**
	 * Creates a default instance of a Circle object with all dimensions set to
	 * zero.
	 */
	public Circle() {
		this(0, 0, 0);
	}

	/**
	 * Creates a new instance of a Circle object.
	 * 
	 * @param x
	 *            X coordinate of the center of the circle
	 * @param y
	 *            Y coordinate of the center of the circle
	 * @param radius
	 *            Radius of the circle in pixels
	 */
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.r = (r < 0) ? -r : r;
	}

	/** @return perimeter of the circle */
	public double getPerimeter() {
		return 2 * Math.PI * this.r;
	}

	/** @return area of the circle */
	public double getArea() {
		return Math.PI * this.r * this.r;
	}

	/**
	 * Determines whether the point is contained inside this circle
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * 
	 * @return if the point is inside
	 */
	public boolean isPointInside(double x, double y) {
		return (Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= this.r);
	}

	/**
	 * Determines whether the point is contained inside this circle
	 * 
	 * @param point
	 *            the point being checked
	 * @return if the point is inside
	 */
	public boolean isPointInside(Point2D.Double point) {
		double x = point.getX();
		double y = point.getY();
		return isPointInside(x, y);
	}

	/**
	 * Draws this Circle object (in Processing)
	 * 
	 * @param applet
	 *            The PApplet the circle is being drawn on
	 */
	public void draw(PApplet applet) {
		applet.ellipseMode(PApplet.RADIUS);
		applet.ellipse((float) this.x, (float) this.y, (float) this.r, (float) this.r);
	}

	/**
	 * Draws this circle object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object the circle is being drawn on
	 */
	public void draw(Graphics g) {
		g.drawOval((int) (x - r), (int) (y - r), (int) (2 * r), (int) (2 * r));

	}

	/**
	 * Checks if a point is on the circle (if a point was drawn and the circle was
	 * as well, the point would be on the unfilled edge)
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * @return if a point is on the edge of the circle (the line drawn)
	 */
	public boolean onCircle(double x, double y) {
		double out = ((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) - r * r);
		return out <= 0.001 && out >= -0.001;
	}

	/**
	 * Checks if a point is on the circle (if a point was drawn and the circle was
	 * as well, the point would be on the unfilled edge)
	 * 
	 * @param point
	 *            the point being checked
	 * @return if a point is on the edge of the circle (the line drawn)
	 */
	public boolean onCircle(Point2D.Double point) {
		return onCircle(point.getX(), point.getY());
	}

	/**
	 * @param applet
	 *            the PApplet this circle will be drawn on
	 * @return this circle as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		PShape p = applet.createShape(PApplet.ELLIPSE, (float) x, (float) y, (float) r, (float) r);
		return p;
	}

}
