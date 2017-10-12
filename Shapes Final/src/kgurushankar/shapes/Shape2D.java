package kgurushankar.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * Defines a 2D shape that can be filled or unfilled
 * 
 * @author kgurushankar
 */
public abstract class Shape2D extends Shape1D {
	/**
	 * Color this shape will be filled with <br>
	 * For this shape to be filled, this object cannot be null
	 */
	protected Color fillColor;

	/**
	 * Create a Shape2D that has the given coordinates
	 * 
	 * @param x1
	 *            x coordinate of the starting point of the line
	 * @param y1
	 *            y coordinate of the starting point of the line
	 * @param x2
	 *            x coordinate of the ending point of the line
	 * @param y2
	 *            y coordinate of the ending point of the line
	 * @param edgeColor
	 *            Edge Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 * @param fillColor
	 *            color this shape will be filled with
	 */
	protected Shape2D(double x1, double y1, double x2, double y2, Color edgeColor, double strokeWidth,
			Color fillColor) {
		super(x1, y1, x2, y2, edgeColor, strokeWidth);
		this.fillColor = fillColor;
	};

	/**
	 * Create a Shape2D that has the given coordinates
	 * 
	 * @param x1
	 *            x coordinate of the starting point of the line
	 * @param y1
	 *            y coordinate of the starting point of the line
	 * @param x2
	 *            x coordinate of the ending point of the line
	 * @param y2
	 *            y coordinate of the ending point of the line
	 * @param c
	 *            Edge Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	protected Shape2D(double x1, double y1, double x2, double y2, Color c, double strokeWidth) {
		super(x1, y1, x2, y2, c, strokeWidth);
	}

	/**
	 * Create a Shape2D that has the given coordinates
	 * 
	 * @param start
	 *            starting point of the line
	 * @param end
	 *            ending point of the line
	 * @param c
	 *            Edge Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	protected Shape2D(Point2D start, Point2D end, Color c, double strokeWidth) {
		super(start, end, c, strokeWidth);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get a different shape with the same defining line<br>
	 * <i> note that this does not copy fillColor over<br>
	 * to do that use {@link Shape2D#Shape2D(Shape2D)} instead</i>
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	protected Shape2D(Shape1D shape) {
		super(shape);
	}

	/**
	 * Copy Constructor <br>
	 * Can be used to get a different shape with the same defining line and same
	 * fill settings
	 * 
	 * @param shape
	 *            shape to copy data from
	 */
	protected Shape2D(Shape2D shape) {
		super(shape);
		this.fillColor = shape.fillColor;
	}

	/** @return area of this shape */
	public abstract double getArea();

	/** @return perimeter of this shape */
	public abstract double getPerimeter();

	/**
	 * Draws this object (in Processing Graphics)
	 * 
	 * @param applet
	 *            the PApplet this is being drawn on
	 * @post this will be drawn on the PApplet object
	 */
	public void draw(PApplet applet) {
		super.draw(applet);
		if (fillColor != null)
			applet.fill(fillColor.getRGB());
	}

	public abstract Shape2D move(double x, double y);

	public abstract Shape2D moveTo(double x, double y);

	/** @return width of this shape */
	public double getWidth() {
		return (this.line[1][0] - this.line[0][0]);
	}

	/** @return height of this shape */
	public double getHeight() {
		return (this.line[1][1] - this.line[0][1]);
	}

}
