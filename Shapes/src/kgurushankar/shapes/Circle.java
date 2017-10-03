package kgurushankar.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This class represents a circle
 * 
 * @author kgurushankar
 */
public class Circle extends Ellipse {
	/**
	 * Creates a default instance of a Circle object with all dimensions set to
	 * zero.
	 */
	public Circle() {
		super(0, 0, 0, 0, Color.BLACK, 2);
	}

	/**
	 * Creates a new instance of a circle object.
	 * 
	 * @param x
	 *            X coordinate of the center of the ellipse
	 * @param y
	 *            Y coordinate of the center of the ellipse
	 * @param r
	 *            Radius of the ellipse in pixels
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 * @param fillColor
	 *            color this shape will be filled with
	 */
	public Circle(double x, double y, double r, Color c, double strokeWidth, Color fillColor) {
		super(x, y, r, r, c, strokeWidth, fillColor);
	}

	/**
	 * Creates a new instance of a circle object.
	 * 
	 * @param x
	 *            X coordinate of the center of the ellipse
	 * @param y
	 *            Y coordinate of the center of the ellipse
	 * @param r
	 *            Radius of the ellipse in pixels
	 * @param c
	 *            Color of this shape
	 * @param strokeWidth
	 *            weight of the line this shape will be drawn with
	 */
	public Circle(double x, double y, double r, Color c, double strokeWidth) {
		super(x, y, r, r, c, strokeWidth);
	}

	/**
	 * Creates a new instance of a circle object that will be drawn in black with a
	 * stroke width of 2
	 * 
	 * @param x
	 *            X coordinate of the center of the ellipse
	 * @param y
	 *            Y coordinate of the center of the ellipse
	 * @param r
	 *            Radius of the ellipse in pixels
	 */
	public Circle(double x, double y, double r) {
		this(x, y, r, Color.black, 2);
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
		double r = (line[1][1] - line[0][1]) / 2;
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
	public boolean onellipse(Point2D point) {
		return onellipse(point.getX(), point.getY());
	}

}
