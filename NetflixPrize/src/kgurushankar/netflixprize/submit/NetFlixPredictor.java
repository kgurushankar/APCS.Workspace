package kgurushankar.netflixprize.submit;

import java.util.HashMap;

import kgurushankar.netflixprize.data.Movie;
import kgurushankar.netflixprize.data.User;
import kgurushankar.netflixprize.parse.MLCSVTranslator;

public class NetFlixPredictor {

	private HashMap<Integer, User> users;
	private HashMap<Integer, Movie> movies;

	/**
	 * 
	 * Use the file names to read all data into some local structures.
	 * 
	 * @param movieFilePath
	 *            The full path to the movies database.
	 * @param ratingFilePath
	 *            The full path to the ratings database.
	 * @param tagFilePath
	 *            The full path to the tags database.
	 * @param linkFilePath
	 *            The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		users = new HashMap<Integer, User>();
		movies = new HashMap<Integer, Movie>();
		MLCSVTranslator.parse(users, movies, movieFilePath, ratingFilePath, tagFilePath, linkFilePath);
		for (int i : users.keySet()) {
			users.get(i).computeAverages();
		}
		for (int i : movies.keySet()) {
			movies.get(i).computeAverages();
		}
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @param movieNumber
	 *            The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does
	 *         not exist in the database, the movie does not exist, or the movie has
	 *         not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		if (users.containsKey(userID)) {
			User u = users.get(userID);
			return u.getRating(movies.get(movieID));
		} else {
			return -1;
		}

	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other
	 * available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @param movieNumber
	 *            The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the
	 *         movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {
		User u = users.get(userID);
		Movie m = movies.get(movieID);
		if (u.getRating(m) != -1) {
			return u.getRating(m);
		} else {
			byte genres = 0;
			double total = 0;
			boolean[] g = m.getGenres();
			double[] r = u.getAverageRating();
			double[] sod = u.getSoD();
			double wr = 0;
			for (int i = 0; i < Movie.GENRES.length; i++) {
				if (g[i]) {
					total += weight(sod[i]) * ((r[i] == -1) ? 3.711 : r[i]);
					genres++;
					wr += weight(sod[i]);
				}
			}
			if (!Double.isFinite(total) || total == 0) {
				return 3.711;
			}
			double avg = (total) / genres;
			double wt = wr / genres;
			double out = avg / wt;
			if (Double.isFinite(out)) {
				return out;
			} else {
				System.out.println();
				return out;
			}
		}
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not
	 * currently rated it).
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but
	 *         they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		return 0;
	}

	private double weight(double val) {
		return 1 / (Math.log(val) * Math.log(val));
	}
}
