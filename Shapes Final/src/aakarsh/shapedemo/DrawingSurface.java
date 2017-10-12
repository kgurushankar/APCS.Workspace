package aakarsh.shapedemo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import kgurushankar.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private PhysicsShape shapeA, shapeB;
	private Line lineTop, lineBot, lineRight, lineLeft;
	public static final float DRAWING_WIDTH = 400;
	public static final float DRAWING_HEIGHT = 300;

	public DrawingSurface() {
		shapeA = new PhysicsShape(new Circle(100, 100, 30));
		shapeB = new PhysicsShape(new Rectangle(200, 200, 30, 30));
		lineTop = new Line(0, 0, 400, 0);
		lineBot = new Line(0, 300, 400, 300);
		lineRight = new Line(0, 0, 0, 300);
		lineLeft = new Line(400, 0, 400, 300);
	}

	/**
	 * The statements in the setup() function execute once when the program begins.
	 */
	public void setup() {
		shapeA.setVelocity(0, 0);
		shapeB.setVelocity(0, 0);
		//frameRate(1);
	}

	/**
	 * Statements in draw() are executed until the program is stopped. Each
	 * statement is executed in sequence and after the last line is read, the first
	 * line is executed again.
	 */
	public void draw() {
		scale(width/DRAWING_WIDTH, height/DRAWING_HEIGHT);
		background(255);

		shapeA.draw(this);
		shapeB.draw(this);
		
		/*
		System.out.println(shapeA.getVx());
		System.out.println(shapeA.getVy());
		System.out.println(shapeB.getVx());
		System.out.println(shapeB.getVy());
		System.out.println();
		*/
		
		if(shapeA.getIsMoving()) {
			shapeA.accelerate();
			shapeA.act();
		}
		else {
			shapeA.setVelocity(20, 20);
			shapeA.stopMoving();
		}
		
		if(shapeB.getIsMoving()) {
			shapeB.accelerate();
			shapeB.act();
		}
		else {
			shapeB.setVelocity(20, 20);
			shapeB.stopMoving();
		}
		
		if (Math.abs(shapeA.getX() - shapeB.getX()) < 30 && Math.abs(shapeA.getY() - shapeB.getY()) < 30) {
			background((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
			shapeA.collide();
			shapeB.collide();
			
		}
		
	}
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			shapeA.startMoving();
		}
		else if (mouseButton == RIGHT) {
			shapeB.startMoving();
		}
	}
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_R) {
			shapeA = new PhysicsShape(new Circle(100, 100, 30));
			shapeB = new PhysicsShape(new Rectangle(200, 200, 30, 30));
		}
	}

}
