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
	 * @param fillColor
	 *            color this shape will be filled with
	 */
	public Ellipse(double x, double y, double width, double height, Color c, double strokeWidth, Color fillColor) {
		super(x - width, y - height, x + width, y + height, c, strokeWidth, fillColor);
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
		super(x - width, y - height, x + width, y + height, c, strokeWidth);
	}

	/**
	 * Creates a new instance of a ellipse object that is black with a stroke width
	 * of 2
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
		this(x, y, width, height, Color.BLACK, 2);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get an ellipse with the same defining line and same fill
	 * settings as the shape given
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	public Ellipse(Shape2D shape) {
		super(shape);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get an ellipse with the same defining line as the shape
	 * given<br>
	 * <i> note that this does not copy fillColor over<br>
	 * to do that use {@link Ellipse#Ellipse(Shape2D)} instead</i>
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	public Ellipse(Shape1D shape) {
		super(shape);
	}

	/** @return perimeter of the ellipse */
	public double getPerimeter() {
		return Math.PI * super.getLength();
	}

	/** @return area of the ellipse */
	public double getArea() {
		double width = getWidth() / 2;
		double height = getHeight() / 2;
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
		double xc = getX();
		double yc = getY();
		double width = getWidth() / 2;
		double height = getWidth() / 2;
		return (Math.pow((x - xc), 2) / (height * height) + Math.pow(y - yc, 2) / (width * width) <= 1);
	}

	/**
	 * Determines whether the point is contained inside this ellipse
	 * 
	 * @param point
	 *            the point being checked
	 * @return if the point is inside
	 */
	public boolean isPointInside(Point2D point) {
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
		double xc = getX();
		double yc = getY();
		double width = getWidth() / 2;
		double height = getHeight() / 2;
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
		double xc = getX();
		double yc = getY();
		double width = getWidth() / 2;
		double height = getHeight() / 2;
		if (fillColor == null) {
			g.drawOval((int) (xc - width), (int) (yc - height), (int) (width), (int) (height));
		} else {
			g.setColor(fillColor);
			g.fillOval((int) (xc - width), (int) (yc - height), (int) (width), (int) (height));
		}
	}

	/**
	 * @param applet
	 *            the PApplet this ellipse will be drawn on
	 * @return this ellipse as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		PShape p = applet.createShape(PApplet.ELLIPSE, (float) getX(), (float) getY(), (float) getWidth(),
				(float) getHeight());
		return p;
	}

	/** @return x coordinate of the center of this ellipse */
	public double getX() {
		return (this.line[1][0] + this.line[0][0]) / 2;
	}

	/** @return y coordinate of the center of this ellipse */
	public double getY() {
		return (this.line[1][1] + this.line[0][1]) / 2;
	}

	/**
	 * @param x
	 *            the change in this shape's x coordinate
	 * @param y
	 *            the change in this shape's y coordinate
	 * @return a new shape with shifted coordinates and otherwise same attributes as
	 *         this one
	 */
	public Shape2D move(double x, double y) {
		return moveTo(getX() + x, getY() + y);
	}

	/**
	 * @param x
	 *            the new shape's x coordinate
	 * @param x
	 *            the new shape's y coordinate
	 * @return a new shape with different coordinates and otherwise same attributes
	 *         as this one
	 */
	public Shape2D moveTo(double x, double y) {
		return new Ellipse(x, y, getWidth() / 2, getHeight() / 2, super.color, super.weight, super.fillColor);
	}

}
