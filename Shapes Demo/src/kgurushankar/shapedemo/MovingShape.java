package kgurushankar.shapedemo;

import devansh.shapes.*;
import processing.core.PApplet;

public class MovingShape {
	private Shape boundingShape;
	private double vx;
	private double vy;
	public static final double friction = 0;

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
		this.vy = vy;
	}

	public void setV() {
		this.vx = vx;
	}

	public void act() {
		boundingShape.setX(boundingShape.getX() + vx);
		boundingShape.setY(boundingShape.getY() + vy);
		vx -= friction;
		vy -= friction;
	}

}
