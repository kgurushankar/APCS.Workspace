package kgurushankar.shapes;

import java.awt.geom.Point2D;

public abstract class Shape2D extends Shape1D {

	protected Shape2D(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);
	}

	protected Shape2D(Point2D.Double start, Point2D.Double end) {
		super(start, end);
	}

	protected Shape2D(Shape1D shape) {
		super(shape);
	}

	/** @return area of this shape */
	public abstract double getArea();

	/** @return perimeter of this shape */
	public abstract double getPerimeter();
}
