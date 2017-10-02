package kgurushankar.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class Shape2D extends Shape1D {
	/**
	 * Create a Shape1D that has the given coordinates
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
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	protected Shape2D(double x1, double y1, double x2, double y2, Color c, double strokeWidth) {
		super(x1, y1, x2, y2, c, strokeWidth);
	}

	protected Shape2D(Point2D.Double start, Point2D.Double end, Color c, double strokeWidth) {
		super(start, end, c, strokeWidth);
	}

	protected Shape2D(Shape1D shape) {
		super(shape);
	}

	/** @return area of this shape */
	public abstract double getArea();

	/** @return perimeter of this shape */
	public abstract double getPerimeter();
}
