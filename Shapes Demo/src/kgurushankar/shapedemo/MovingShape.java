package kgurushankar.shapedemo;

import java.awt.Color;

import devansh.shapes.Rectangle;
import devansh.shapes.Shape;
import processing.core.PApplet;

public class MovingShape {
	private Shape boundingShape;
	private double vx;
	private double vy;
	private Color fillColor;
	public static final double FRICTION = 0.5;

	public MovingShape(Shape s, Color fillColor) {
		this.boundingShape = s;
		this.fill(fillColor);
		vx = 0;
		vy = 0;
	}

	public void draw(PApplet applet) {
		boundingShape.draw(applet);
	}

	public void setVX(double vx) {
		this.vx = vx;
	}

	public void setVY(double vy) {
		this.vy = vy;
	}

	public void setV(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void act(Rectangle window) {
		boundingShape.setX(boundingShape.getX() + vx);
		if (!window.isPointInside(boundingShape.getX(), boundingShape.getY())) {
			this.vx = -this.vx;
			boundingShape.setX(boundingShape.getX() + vx);
		}
		boundingShape.setY(boundingShape.getY() + vy);
		if (!window.isPointInside(boundingShape.getX(), boundingShape.getY())) {
			this.vy = -this.vy;
			boundingShape.setY(boundingShape.getY() + vy);
		}

		double FRICTION_X = Math.cos(this.getAngle());
		double FRICTION_Y = Math.sin(this.getAngle());

		if (vx != 0) {
			if (Math.abs(vx) < FRICTION_X)
				vx = 0;
			vx -= (vx > 0) ? FRICTION_X : -FRICTION_X;
		}
		if (vy != 0) {
			if (Math.abs(vy) < FRICTION_Y)
				vy = 0;
			vy -= (vy > 0) ? FRICTION_Y : -FRICTION_Y;
		}
	}

	public double getX() {
		return boundingShape.getX();
	}

	public double getY() {
		return boundingShape.getY();
	}

	public Shape getShape() {
		return boundingShape;
	}

	public void moveTo(double x, double y) {
		moveX(x);
		moveY(y);
	}

	public void moveX(double x) {
		boundingShape.setX(x);
	}

	public void moveY(double y) {
		boundingShape.setY(y);
	}

	public double getAngle() {
		return Math.atan(vy / vx);
	}

	public void fill(Color c) {
		this.fillColor = c;
		this.boundingShape.fill(c.getRed(), c.getGreen(), c.getBlue());
	}

	public Color getFillColor() {
		return fillColor;
	}
}
