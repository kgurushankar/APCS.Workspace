package kgurushankar.netflixprize.parse;

import java.util.ArrayList;
import java.util.HashMap;

import kgurushankar.netflixprize.data.*;

public class MLCSVTranslator {
	public static void parse(HashMap<Integer, User> users, HashMap<Integer, Movie> movies, String movieFilePath,
			String ratingFilePath, String tagFilePath, String linkFilePath) {
		MLCSVTranslator tl = new MLCSVTranslator();

		// MOVIES
		ArrayList<String> mM = FileIO.readFile(movieFilePath);
		mM.remove(0);
		for (String s : mM) {
			Movie m = tl.parseMovie(s);
			movies.put(m.getId(), m);
		}
		mM = null;

		// LINKS
		ArrayList<String> mL = FileIO.readFile(linkFilePath);
		mL.remove(0);

		for (String s : mL) {
			String[] a = CSVUtils.parseLine(s);
			int id = Integer.parseInt(a[0]);
			String imdb = (a[1].equals("")) ?"" : a[1];
			String tmdb = (a[2].equals("")) ? "" : a[2];
			movies.get(id).setLinks(imdb, tmdb);
		}
		mL = null;

		// RATINGS
		ArrayList<String> mR = FileIO.readFile(ratingFilePath);
		mR.remove(0);
		for (String a : mR) {
			String s[] = CSVUtils.parseLine(a);
			int user = Integer.parseInt(s[0]);
			int movie = Integer.parseInt(s[1]);
			float rating = Float.parseFloat(s[2]);
			Movie m = movies.get(movie);
			if (!users.containsKey(user)) {
				users.put(user, new User(user));
			}
			users.get(user).addRating(m, rating);
			m.addRating(users.get(user), rating);
		}
		mR = null;

		// Tags
		ArrayList<String> mT = FileIO.readFile(tagFilePath);
		mT.remove(0);
		for (String a : mT) {
			String s[] = CSVUtils.parseLine(a);
			int movie = Integer.parseInt(s[1]);
			String tag = s[3];
			movies.get(movie).addTag(tag);
		}

		// Final Initializations
	}

	private Movie parseMovie(String[] movie) {
		int id = Integer.parseInt(movie[0]);

		String title;
		short year;
		if (movie[1].indexOf('(') == -1) { // no year
			year = -1;
			title = movie[1];
		} else {
			// Find last set of parentheses to skip over title translations
			int start = movie[1].lastIndexOf('(') + 1;
			int end = movie[1].lastIndexOf(')');

			String y = (movie[1].substring(start, end));
			int loc = y.indexOf('-'); // find the - if the year is a range

			if (loc != -1) { // the year is a range
				short begin = Short.parseShort(y.substring(0, loc));
				if (y.length() - 1 > loc) {// an ending year is specified
					short complete = Short.parseShort(y.substring(loc + 1));
					year = complete;
				} else {
					year = begin;
				}
			} else {
				try {
					year = Short.parseShort(y);
				} catch (NumberFormatException e) {
					year = -1;
				}
			}
			title = movie[1].substring(0, movie[1].indexOf('('));
		}

		boolean[] genres = new boolean[Movie.GENRES.length];
		for (int i = 0; i < genres.length; i++) {
			genres[i] = movie[2].contains(Movie.GENRES[i]);
		}
		return new Movie(title, id, year, genres);

	}

	public Movie parseMovie(String s) {
		return parseMovie(CSVUtils.parseLine(s));
	}

}
