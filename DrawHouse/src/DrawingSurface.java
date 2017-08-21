import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PShape;

public class DrawingSurface extends PApplet {
	PShape base, roof, window, door;

	public void setup() {
		frameRate(30);
		base = createShape();
		base.beginShape();
		base.fill(204);
		base.vertex(0, 0);
		base.vertex(0, 150);
		base.vertex(300, 150);
		base.vertex(300, 0);
		base.endShape(CLOSE);

		roof = createShape();
		roof.beginShape();
		roof.fill(204);
		roof.vertex(0, 0); // point
		roof.vertex(150, 100);
		roof.vertex(-150, 100);
		roof.endShape(CLOSE);

		window = createShape();
		window.beginShape();
		window.vertex(0, 0);
		window.vertex(50, 0);
		window.vertex(50, 50);
		window.vertex(0, 50);
		window.endShape(CLOSE);

		door = createShape();
		door.beginShape();
		door.vertex(0, 0);
		door.vertex(0, 75);
		door.vertex(50, 75);
		door.vertex(50, 0);
		door.endShape(CLOSE);
	}

	public void draw() {
		scale((float) (width / 500), (float)(height/500));
		background(204);

		shape(base, 100, 200);
		shape(roof, 250, 100);
		shape(window, 150, 225);
		shape(window, 300, 225);
		shape(door, 225, 275);

		line(100, 350, 400, 350);
	}

	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(500, 500);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}

}
