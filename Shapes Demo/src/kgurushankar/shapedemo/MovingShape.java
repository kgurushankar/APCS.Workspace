package kgurushankar.shapedemo;

import devansh.shapes.Shape;
import processing.core.PApplet;

public class MovingShape {
	private Shape boundingShape;
	private double vx;
	private double vy;
	public static final double FRICTION_X = .1;
	public static final double FRICTION_Y = .1;

	public MovingShape(Shape s) {
		this.boundingShape = s;
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

	public void act() {
		boundingShape.setX(boundingShape.getX() + vx);
		boundingShape.setY(boundingShape.getY() + vy);
		if (vx != 0)
			vx -= (vx > 0) ? FRICTION_X : -FRICTION_X;
		if (vy != 0)
			vy -= (vy > 0) ? FRICTION_Y : -FRICTION_Y;
	}

	public void bounce() {
		vx = -vx;
		vy = -vy;
	}

	public void bounce(double theta) {
		double vx = this.vx;
		double vy = this.vy;
		// Need to resolve vectors
		this.vx = -Math.cos(theta) * vx;
		this.vy = -Math.sin(theta) * vy;
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

}
