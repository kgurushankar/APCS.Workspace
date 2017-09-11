
import processing.core.PApplet;

public abstract class Drawable {
	public static int GRAVITY = -1;
	private int x, y;
	private float size;
	private boolean gravity;
	private float v;
	private Line contact;

	public Drawable(int x, int y, boolean gravity, Line contact) {
		this.x = x;
		this.y = y;
		this.size = 1f;
		this.contact = contact;
	}

	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(x, y);
		applet.scale(size);
	}

	public void changeSize(float size) {
		if (size > 0f) {
			this.size = size;
		} else {
			throw new IllegalArgumentException("Scaling size must be > 0");
		}
	}

	public void incrementSize(float size) {
		if (this.size + size > 0f) {
			this.size += size;
		} else {
			throw new IllegalArgumentException("Final size must be > 0");
		}
	}

	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void fall() {
		if (gravity) {
			v += GRAVITY;
			y += v;
		}
	}

	public void setLine(Line l) {
		this.contact = l;
	}

	public boolean touching(Drawable other) {
		return this.contact.doesIntersect(other.contact);
	}
}
