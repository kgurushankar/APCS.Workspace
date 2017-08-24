import processing.core.PApplet;
import processing.core.PShape;

public class Person implements Drawable {
	private int headshape;
	private boolean newHead;
	private PShape head;
	private float size;

	public Person(PApplet applet, int headshape) {
		this.headshape = headshape;
		head = polygon(applet, 25, headshape);
		size = 1f;
	}

	public Person(PApplet applet) {
		this(applet, 4);
	}

	@Override
	public void draw(PApplet applet, int x, int y) {
		if (newHead) {
			head = polygon(applet, 25, headshape);
			newHead = false;
		}
		applet.pushMatrix();

		applet.translate(x, y);
		applet.scale(size * 0.5f);

		applet.shape(head, 25, 25);
		applet.line(25, 50, 25, 125);
		applet.line(25, 125, 50, 150);
		applet.line(25, 125, 0, 150);
		applet.line(25, 75, 50, 100);
		applet.line(25, 75, 0, 100);

		applet.popMatrix();

	}

	private PShape polygon(PApplet applet, float radius, int npoints) {
		float angle = PApplet.TWO_PI / npoints;
		PShape polygon = applet.createShape();
		polygon.beginShape();
		for (float a = 0; a < PApplet.TWO_PI; a += angle) {
			float sx = PApplet.cos(a) * radius;
			float sy = PApplet.sin(a) * radius;
			polygon.vertex(sx, sy);
		}
		polygon.endShape(PApplet.CLOSE);
		return polygon;
	}

	public void changeHeadshape(int headshape) {
		this.headshape = headshape;
		newHead = true;
	}

	@Override
	public void changeSize(float size) {
		this.size = size;

	}

	@Override
	public void incrementSize(float size) {
		if (this.size + size > 0f) {
			this.size += size;
		}

	}
}
