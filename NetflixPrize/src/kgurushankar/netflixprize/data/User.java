package kgurushankar.netflixprize.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class User {
	private int ID;
	private double[] genreRatings;
	private double[] genreSoD;
	private HashMap<Movie, Float> ratings;

	public User(int Id) {
		this.ratings = new HashMap<Movie, Float>();
		this.ID = Id;
		genreRatings = new double[Movie.GENRES.length];
		genreSoD = new double[Movie.GENRES.length];
	}

	public void addRating(Movie m, float stars) {
		ratings.put(m, stars);
	}

	public float getRating(Movie m) {
		return (ratings.containsKey(m)) ? ratings.get(m) : -1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ID + "=[Ratings:[");
		for (Movie m : ratings.keySet()) {
			sb.append(m.getTitle() + ":" + ratings.get(m) + ",");
		}
		sb.append("],avg= " + Arrays.toString(genreRatings) + ",sod=" + Arrays.toString(genreSoD) + "]");
		return sb.toString();
	}

	public void computeAverages() {
		ArrayList<ArrayList<Float>> values = new ArrayList<ArrayList<Float>>();
		for (int i = 0; i < Movie.GENRES.length; i++) {
			values.add(new ArrayList<Float>());
		}
		for (Movie m : ratings.keySet()) {
			float rating = ratings.get(m);
			boolean b = false;
			boolean[] a = m.getGenres();
			for (int i = 0; i < values.size(); i++) {
				b = a[i];
				if (b) {
					values.get(i).add(rating);
				}
			}
		}
		for (int i = 0; i < genreRatings.length; i++) {
			genreRatings[i] = average(values.get(i));
			genreSoD[i] = (genreRatings[i] != -1) ? (standardOfDeviation(values.get(i), genreRatings[i])) : -1;
		}

	}

	private double average(ArrayList<Float> arr) {
		double out = 0;
		for (float x : arr) {
			out += x;
		}
		return (arr.size() != 0) ? ((out) / (arr.size())) : -1;
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

	public double[] getAverageRating() {
		return this.genreRatings;
	}

	public double[] getSoD() {
		return this.genreSoD;
	}
}
