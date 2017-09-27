package kgurushankar.shapes;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * This class represents a rectangle
 * 
 * @author kgurushankar
 */
public class Rectangle extends Shape {
	private double width, height;

	/**
	 * Creates a default instance of a Rectangle object with all dimensions set to
	 * zero.
	 */
	public Rectangle() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new instance of a Rectangle object.
	 * 
	 * @param x
	 *            X coordinate of the top left corner of the rectangle
	 * @param y
	 *            Y coordinate of the top left corner of the rectangle
	 * @param width
	 *            Width of the rectangle in pixels
	 * @param height
	 *            Height of the rectangle in pixels
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		if (width < 0) {
			this.width = -width;
			this.setX(this.getX() + width);
		} else {
			this.width = width;
		}
		if (height < 0) {
			this.height = -height;
			this.setY(this.getY() + height);
		} else {
			this.height = height;
		}
	}

	/** @return perimeter of the rectangle */
	public double getPerimeter() {
		return 2 * (width + height);
	}

	/** @return area of the rectangle */
	public double getArea() {
		return width * height;
	}

	/**
	 * Determines whether the point is contained inside this rectangle
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * @return if the point is inside
	 */
	public boolean isPointInside(double x, double y) {
		return (x >= this.getX() && x <= (this.getX() + this.width))
				&& (y >= this.getY() && y <= (this.getY() + this.height));
	}

	/**
	 * Determines whether the point is contained inside this rectangle
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
	 * Draws this Rectangle object (in Processing)
	 * 
	 * @param applet
	 *            The PApplet the rectangle is being drawn on
	 * @post this rectangle will be drawn on the PApplet
	 * 
	 */
	public void draw(PApplet applet) {
		applet.rect((float) this.getX(), (float) this.getY(), (float) this.width, (float) this.height);
	}

	/**
	 * Draws this Rectangle object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object the rectangle is being drawn on
	 * @post this rectangle will be drawn on the Graphics object
	 */
	public void draw(Graphics g) {
		g.drawRect((int) getX(), (int) getY(), (int) width, (int) height);
	}

	/**
	 * @param applet
	 *            the PApplet this rectangle will be used in
	 * @return this rectangle as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		PShape p = applet.createShape(PApplet.RECT, (float) getX(), (float) getY(), (float) width, (float) height);
		return p;
	}

	/** @return the length of the diagonal of this rectangle */
	public double getDiagonalLength() {
		return Math.sqrt(width * width + height * height);
	}

}
