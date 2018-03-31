package kgurushankar.netflixprize.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Movie implements Comparable<Movie> {
	public static final String[] GENRES = { "Action", "Adventure", "Animation", "Children's", "Comedy", "Crime",
			"Documentary", "Drama", "Fantasy", "Film-Noir", "Horror", "Musical", "Mystery", "Romance", "Sci-Fi",
			"Thriller", "War", "Western", "(no genres listed)" };

	private boolean[] genres;
	private int id;
	private String title;
	private short year;
	private String imdb;
	private String tmdb;
	private HashMap<User, Float> ratings;
	private ArrayList<String> tags;
	private double avg;
	private double sod;

	public Movie(String title, int id, short year2, boolean[] genres) {
		this.title = title;
		this.id = id;
		this.year = year2;
		this.genres = genres;
		this.imdb = "";
		this.tmdb = "";
		ratings = new HashMap<User, Float>();
		tags = new ArrayList<String>();
	}

	public String toString() {
		return title + " =[ id:" + id + ", year: " + year + "]";
	}

	public boolean hasGenre(String genre) {
		for (int i = 0; i < GENRES.length; i++) {
			if (GENRES[i].equals(genre)) {
				return genres[i];
			}
		}
		throw new IllegalArgumentException("Genre does not exist");
	}

	public boolean hasYear() {
		return year != -1;
	}

	public int getId() {
		return id;
	}

	public String getImdb() {
		return imdb;
	}

	public String getTmdb() {
		return tmdb;
	}

	public void setLinks(String imdb, String tmdb) {
		this.imdb = imdb;
		this.tmdb = tmdb;

	}

	public String getTitle() {
		return this.title;
	}

	public byte numberOfGenres() {
		byte count = 0;
		for (boolean b : genres) {
			count += (b) ? 1 : 0;
		}
		return count;
	}

	public boolean[] getGenres() {
		return genres;
	}

	@Override
	public int compareTo(Movie o) {
		return this.id - o.id;
	}

	public void addRating(User u, float f) {
		ratings.put(u, f);
	}

	public void computeAverages() {
		ArrayList<Float> values = new ArrayList<Float>();
		for (User u : ratings.keySet()) {
			values.add(ratings.get(u));
		}
		avg = average(values);
		sod = standardOfDeviation(values, avg);

	}

	private double average(ArrayList<Float> arr) {
		double out = 0;
		for (float x : arr) {
			out += x;
		}
		return (arr.size() != 0) ? ((out) / (arr.size())) : Double.NaN;
	}

	private double standardOfDeviation(ArrayList<Float> arr, double avg) {
		double sq = 0;
		double dif;
		for (float x : arr) {
			dif = (avg - x);
			sq += dif * dif;
		}
		double x = sq / (arr.size() - 1);
		return Math.sqrt(x);
	}

	public void addTag(String tag) {
		tags.add(tag);
	}
}
