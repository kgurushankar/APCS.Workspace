package kgurushankar.netflixprize.ui;

import java.io.*;
import java.net.*;

import kgurushankar.netflixprize.data.Movie;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;

	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}

	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y, width, height);
			}
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}

	public void downloadArt(PApplet drawer) {

		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				BufferedReader in = null;
				String loc = "";
				try {
					URL target = new URL("http://www.imdb.com/title/tt" + movie.getImdb() + "/");
					URLConnection uc = target.openConnection();
					uc.setReadTimeout(15 * 1000);
					uc.connect();
					in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
					String line = null;
					while ((line = in.readLine()) != null) {
						if (line.contains(movie.getTitle() + "Poster")) {
							String url = in.readLine();
							loc = (url.substring(url.indexOf('"') + 1, url.lastIndexOf('"')));
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				coverArt = drawer.loadImage(loc, "jpg");
			}
		});

		downloader.start();

	}

}
