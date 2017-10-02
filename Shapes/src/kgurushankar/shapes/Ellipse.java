package kgurushankar.shapes;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * This class represents a ellipse
 * 
 * @author kgurushankar
 */
public class Ellipse extends Shape2D {
	// Line defines a line that:
	// Is the diagonal of the rectangle that this ellipse can be inscribed in

	/**
	 * Creates a default instance of a Ellipse object with all dimensions set to
	 * zero.
	 */
	public Ellipse() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new instance of a ellipse object.
	 * 
	 * @param x
	 *            X coordinate of the center of the ellipse
	 * @param y
	 *            Y coordinate of the center of the ellipse
	 * @param width
	 *            Width of the ellipse in pixels
	 * @param height
	 *            Height of the ellipse in pixels
	 */
	public Ellipse(double x, double y, double width, double height) {
		super(x - width, y - width, x + width, y + width);
	}

	/** @return perimeter of the ellipse */
	public double getPerimeter() {
		return Math.PI * super.getLength();
	}

	/** @return area of the ellipse */
	public double getArea() {
		return Math.PI * this.r * this.r;
	}

	/**
	 * Determines whether the point is contained inside this ellipse
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * 
	 * @return if the point is inside
	 */
	public boolean isPointInside(double x, double y) {
		return (Math.sqrt(Math.pow(this.getX() - x, 2) + Math.pow(this.getY() - y, 2)) <= this.r);
	}

	/**
	 * Determines whether the point is contained inside this ellipse
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
	 * Draws this ellipse object (in Processing)
	 * 
	 * @param applet
	 *            The PApplet the ellipse is being drawn on
	 */
	public void draw(PApplet applet) {
		applet.ellipseMode(PApplet.RADIUS);
		applet.ellipse((float) this.getX(), (float) this.getY(), (float) this.r, (float) this.r);
	}

	/**
	 * Draws this ellipse object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object the ellipse is being drawn on
	 */
	public void draw(Graphics g) {
		g.drawOval((int) (getX() - r), (int) (getY() - r), (int) (2 * r), (int) (2 * r));

	}

	/**
	 * Checks if a point is on the ellipse (if a point was drawn and the ellipse was
	 * as well, the point would be on the unfilled edge)
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * @return if a point is on the edge of the ellipse (the line drawn)
	 */
	public boolean onellipse(double x, double y) {
		double out = ((this.getX() - x) * (this.getX() - x) + (this.getY() - y) * (this.getY() - y) - r * r);
		return out <= 0.001 && out >= -0.001;
	}

	/**
	 * Checks if a point is on the ellipse (if a point was drawn and the ellipse was
	 * as well, the point would be on the unfilled edge)
	 * 
	 * @param point
	 *            the point being checked
	 * @return if a point is on the edge of the ellipse (the line drawn)
	 */
	public boolean onellipse(Point2D.Double point) {
		return onellipse(point.getX(), point.getY());
	}

	/**
	 * @param applet
	 *            the PApplet this ellipse will be drawn on
	 * @return this ellipse as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		PShape p = applet.createShape(PApplet.ELLIPSE, (float) getX(), (float) getY(), (float) r, (float) r);
		return p;
	}

}
