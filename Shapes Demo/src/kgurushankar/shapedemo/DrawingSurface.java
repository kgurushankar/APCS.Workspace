package kgurushankar.shapedemo;

import java.util.ArrayList;

import devansh.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private ArrayList<MovingShape> shapes = new ArrayList<MovingShape>();

	public static final float WIDTH = 800;
	public static final float HEIGHT = 800;
	private int mousexold, mouseyold;

	public DrawingSurface() {

		shapes.add(new MovingShape(new Circle(100, 100, 30)));
		shapes.get(0).setV(10, 10);
	}

	public void setup() {
	}

	public void draw() {
		// this.scale(height / HEIGHT, width / WIDTH);
		background(255);
		for (MovingShape s : shapes) {
			s.draw(this);
			s.act();
		}
		System.out.println(shapes.get(0).getX()+ "  "+shapes.get(0).getY());
	}

	private MovingShape activeShape;

	public void mouseClicked() {
		for (MovingShape s : shapes) {
			if (s.getShape().isPointInside(mouseX, mouseY)) {
				activeShape = s;
				System.out.println("shape set");
			}
		}

	}

	public void mouseDragged() {
		float scalex = (float) (width / WIDTH);
		float scaley = (float) (height / HEIGHT);
		int x = (int) (mouseX / scalex);
		int y = (int) (mouseY / scaley);
		mousexold = mouseX;
		mouseyold = mouseY;

	}

	public void mouseReleased() {
		if (activeShape != null) {
			activeShape.setV(mouseX - mousexold, mouseY - mouseyold);
		}
	}
}
