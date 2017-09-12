import processing.core.PApplet;
import processing.core.PShape;

public class Person extends Drawable {
	private int headshape;
	private boolean newHead;
	private PShape head;
	private short wetness;
	private static final float a = 9.81f / 30;
	private float v = 0;

	public Person(PApplet applet, int x, int y, int headshape) {
		super(x, y, true);
		this.headshape = headshape;
		head = polygon(applet, 25, headshape);
		wetness = 0;
	}

	public Person(PApplet applet, int x, int y) {
		this(applet, x, y, 4);
	}

	@Override
	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(x, y);
		applet.scale(size);
		if (newHead) {
			head = polygon(applet, 25, headshape);
			newHead = false;
		}
		applet.scale(0.5f);
		applet.color(255 - wetness, 255 - wetness, 255);
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

	public void fall(PApplet applet, Ground ground) {
		//System.out.println(v);
		if (ground.getLocation(applet).doesIntersect(new Line(x, y, x + 25, y+75))) {
		} else {
			this.y += v;
			this.v += a;
		}

	}

	public void jump(DrawingSurface applet, Ground ground) {
		if (ground.getLocation(applet).doesIntersect(new Line(x, y, x + 25, y+75))) {
		this.v = -10;
		this.y -=10;}
	}
}