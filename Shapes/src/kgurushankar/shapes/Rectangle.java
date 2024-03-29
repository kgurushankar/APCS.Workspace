package kgurushankar.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * This class represents a rectangle
 * 
 * @author kgurushankar
 */
public class Rectangle extends Shape2D {

	/**
	 * Creates a default instance of a Rectangle object with all dimensions set to
	 * zero.
	 */
	public Rectangle() {
		super(0, 0, 0, 0, Color.BLACK, 2);
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
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 * @param fillColor
	 *            color this shape will be filled with
	 */
	public Rectangle(double x, double y, double width, double height, Color c, double strokeWidth, Color fillColor) {
		super(x, y, x + width, y + height, c, strokeWidth, fillColor);
	}

	/**
	 * Creates a new instance of a Rectangle object. It will have a black color and
	 * will have a strokewidth of 2
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
		this(x, y, width, height, Color.BLACK, 2);
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
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	public Rectangle(double x, double y, double width, double height, Color c, double strokeWidth) {
		super(x, y, x + width, y + height, c, strokeWidth);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get a rectangle with the same defining line and same fill
	 * settings as the shape given
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	public Rectangle(Shape2D shape) {
		super(shape);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get a rectangle with the same defining line as the shape
	 * given<br>
	 * <i> note that this does not copy fillColor over<br>
	 * to do that use {@link Rectangle#Rectangle(Shape2D)} instead</i>
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	public Rectangle(Shape1D shape) {
		super(shape);
	}

	/** @return perimeter of the rectangle */
	public double getPerimeter() {
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
		return 2 * (width + height);
	}

	/** @return area of the rectangle */
	public double getArea() {
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
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
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
		double xc = line[0][0];
		double yc = line[0][1];
		return (x >= xc && x <= (xc + width)) && (y >= yc && y <= (yc + height));
	}

	/**
	 * Determines whether the point is contained inside this rectangle
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
	 * Draws this Rectangle object (in Processing)
	 * 
	 * @param applet
	 *            The PApplet the rectangle is being drawn on
	 * @post this rectangle will be drawn on the PApplet
	 * 
	 */
	public void draw(PApplet applet) {
		super.draw(applet);
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
		double x = line[0][0];
		double y = line[0][1];
		applet.rect((float) x, (float) y, (float) width, (float) height);
	}

	/**
	 * Draws this Rectangle object (in Swing Graphics)
	 * 
	 * @param g
	 *            The Graphics object the rectangle is being drawn on
	 * @post this rectangle will be drawn on the Graphics object
	 */
	public void draw(Graphics g) {
		super.draw(g);
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
		double x = line[0][0];
		double y = line[0][1];
		if (fillColor == null) {
			g.drawRect((int) x, (int) y, (int) width, (int) height);
		} else {
			g.setColor(fillColor);
			g.fillRect((int) x, (int) y, (int) width, (int) height);
		}

	}

	/**
	 * @param applet
	 *            the PApplet this rectangle will be used in
	 * @return this rectangle as a PShape
	 */
	public PShape getPShape(PApplet applet) {
		double width = line[1][0] - line[0][0];
		double height = line[1][1] - line[0][1];
		double x = line[0][0];
		double y = line[0][1];
		PShape p = applet.createShape(PApplet.RECT, (float) x, (float) y, (float) width, (float) height);
		return p;
	}

	/** @return the length of the diagonal of this rectangle */
	public double getDiagonalLength() {
		return super.getLength();
	}

	@Override
	public Shape2D move(double x, double y) {
		return new Rectangle(getX() + x, getY() + y, getWidth(), getHeight(), super.color, super.weight,
				super.fillColor);
	}

	@Override
	public Shape2D moveTo(double x, double y) {
		return new Rectangle(x, y, getWidth(), getHeight(), super.color, super.weight, super.fillColor);
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return line[0][0];
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return line[0][1];
	}

}
