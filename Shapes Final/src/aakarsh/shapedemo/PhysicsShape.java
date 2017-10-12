package aakarsh.shapedemo;

import kgurushankar.shapes.*;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape2D boundingShape;
	private boolean isMoving;

	private double vx, vy;
	private double acceleration;

	public PhysicsShape(Shape2D s) {
		this.boundingShape = s;
		vx = 0;
		vy = 0;
		acceleration = 0.1;
		isMoving = false;
	}

	public void draw(PApplet drawer) {
		boundingShape.draw(drawer);
	}

	public Shape2D getBoundingShape() {
		return boundingShape;
	}

	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void act() {
		if (boundingShape.getX() > 370 || boundingShape.getX() < 0) {
			vx = -vx;
		}
		if (boundingShape.getY() > 270 || boundingShape.getY() < 0) {
			vy = -vy;
		}
		boundingShape = boundingShape.moveTo(boundingShape.getX() + vx, boundingShape.getY() + vy);
	}
	
	public void accelerate() {
		if (vx > 0) {
			vx -= acceleration;
		}
		else if (vx < 0) {
			vx += acceleration;
		}
		if (vy > 0) {
			vy -= acceleration;
		}
		else if (vy < 0) {
			vy += acceleration;
		}
		if (Math.abs(vx) < 0.00000000001 || Math.abs(vy) < 0.00000000001) {
			isMoving = false;
		}
	}
	
	public double getVx() {
		return vx;
	}
	
	public double getVy() {
		return vy;
	}
	
	
	public boolean getIsMoving() {
		return isMoving;
	}
	
	public void startMoving() {
		isMoving = true;
	}
	
	public void stopMoving() {
		isMoving = false;
	}
	
	public void collide() {
		vx = -vx;
		vy = -vy;
	}
	
	public double getX() {
		return boundingShape.getX();
	}
	
	public double getY() {
		return boundingShape.getY();
	}

}
