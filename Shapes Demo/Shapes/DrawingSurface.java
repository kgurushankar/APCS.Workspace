import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	private double width = 400.0;
	private double height = 300.0;
	private House house;
	private Person person;
	private Projectile projectile;

	public DrawingSurface() {
		projectile = new Projectile();
		house = new House();
		person = new Person();
		
	}

	public void draw() {

		clear();
		background(135, 206, 235);
		fill(0, 255, 0);
		rect(0, (float)(this.height/2.0), (float) this.width, (float)(this.height/2.0));
		
		
		System.out.println("check");
		house.draw(this, width, height);
		person.draw(this, width, height);
		projectile.draw(this, width, height);
		
		if(person.l1.intersects(projectile.pl)) {
			System.out.println("yay");
		}
		

	}

	public void mouseClicked() {
		house.changeCoordinates(mouseX, mouseY);
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				house.changeSize(0.01);
			} else if (keyCode == DOWN) {
				house.changeSize(-0.01);
				
			} else if (keyCode == LEFT) {
				person.move(-5);
			} else if (keyCode == RIGHT) {
				person.move(5);
			}
		} else if (keyCode == KeyEvent.VK_SPACE) {
			person.jump(-10);
		} else if (keyCode == KeyEvent.VK_C) {
			person.crouch();
		}
	}

	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		person.changeColor();
		person.rotate = true;

	}

}
