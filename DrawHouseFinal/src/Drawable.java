
import processing.core.PApplet;

public abstract class Drawable {
	public static int GRAVITY = -1;
	protected int x, y;
	protected float size;

	public Drawable(int x, int y, boolean gravity) {
		this.x = x;
		this.y = y;
		this.size = 1f;
	}

	public abstract void draw(PApplet applet);

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
		System.out.println(this.x+" " +this.y);
	}

	public void moveTo(int x, int y) {
		System.out.println(x+" " +y);
		this.x = x;
		this.y = y;
	}
}
