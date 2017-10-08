package kgurushankar.shapedemo;

import devansh.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private MovingShape shape;
	public static final float WIDTH = 800;
	public static final float HEIGHT = 800;

	public DrawingSurface() {
		shape = new MovingShape(new Circle(100, 100, 30));
		shape.setV(5, 5);
	}

	public void setup() {
	}

	public void draw() {
		background(255);
		shape.draw(this);
		shape.act();
	}

}
