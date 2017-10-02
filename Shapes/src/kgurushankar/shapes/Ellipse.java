package kgurushankar.shapes;

import java.awt.Color;
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
		this(0, 0, 0, 0, Color.black, 0);
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
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	public Ellipse(double x, double y, double width, double height, Color c, double strokeWidth) {
		super(x - width, y - width, x + width, y + width, c, strokeWidth);
	}

	public Ellipse(Shape1D shape) {
		super(shape);
	}

	/** @return perimeter of the ellipse */
	public double getPerimeter() {
		return Math.PI * super.getLength();
	}

	/** @return area of the ellipse */
	public double getArea() {
		double width = (line[1][0] - line[0][0]) / 2;
		double height = (line[1][1] - line[0][1]) / 2;
		return Math.PI * width * height;
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
		double xc = (this.line[0][0] + this.line[1][0]) / 2;
		double yc = (this.line[0][0] + this.line[1][0]) / 2;
		double width = this.line[0][0] - xc;
		double height = this.line[0][1] - yc;
		return (Math.pow((x - xc), 2) / (height * height) + Math.pow(y - yc, 2) / (width * width) <= 1);
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
		super.draw(applet);
		double xc = (this.line[0][0] + this.line[1][0]) / 2;
		double yc = (this.line[0][0] + this.line[1][0]) / 2;
		double width = this.line[0][0] - xc;
		double height = this.line[0][1] - yc;
		applet.ellipseMode(PApplet.RADIUS);
		applet.ellipse((float) xc, (float) yc, (float) width, (float) height);
	}

	/**
	 * Draws this ellipse object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object the ellipse is being drawn on
	 */
	public void draw(Graphics g) {
		super.draw(g);
		double xc = (this.line[0][0] + this.line[1][0]) / 2;
		double yc = (this.line[0][0] + this.line[1][0]) / 2;
		double width = this.line[0][0] - xc;
		double height = this.line[0][1] - yc;
		g.drawOval((int) (xc - width), (int) (yc - height), (int) (2 * width), (int) (2 * height));

	}

	/**
	 * @param applet
	 *            the PApplet this ellipse will be drawn on
	 * @return this ellipse as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		PShape p = applet.createShape(PApplet.ELLIPSE, (float) getX(), (float) getY(),
				(float) (line[1][0] - line[0][0]), (float) (line[1][1] - line[0][1]));
		return p;
	}

	protected double getX() {
		return (this.line[0][0] + this.line[1][0]) / 2;
	}

	protected double getY() {
		return (this.line[0][0] + this.line[1][0]) / 2;
	}

}
