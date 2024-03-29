import processing.core.PApplet;

public abstract class Drawable {
	private int x, y;
	private float size;

	public Drawable(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = 1f;
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
}