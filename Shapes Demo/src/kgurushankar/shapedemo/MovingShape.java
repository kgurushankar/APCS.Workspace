package kgurushankar.shapedemo;

import devansh.shapes.*;
import processing.core.PApplet;

public class MovingShape {
	private Shape boundingShape;
	private double vx;
	private double vy;
	public static final double friction = .1;

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
			vx -= (vx > 0) ? friction : -friction;
		if (vy != 0)
			vy -= (vy > 0) ? friction : -friction;
	}

	public void bounce() {
		vx = -vx;
		vy = -vy;
	}
	
	public void bounce(double theta){
		double vx = this.vx;
		double vy = this.vy;
		this.vx = -Math.cos(theta)*vx;
		this.vy = -Math.sin(theta)*vy;
	}
	
	public double getX() {
		return boundingShape.getX();
	}
	
	public double getY() {
		return boundingShape.getY();
	}

}
