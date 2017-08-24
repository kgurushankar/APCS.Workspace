import processing.core.PApplet;

public interface Drawable {
	void draw(PApplet applet, int x, int y);

	void changeSize(float size);

	void incrementSize(float size);
}
