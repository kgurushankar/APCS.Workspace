package kgurushankar.netflixprize.parse;

import java.util.HashMap;

import kgurushankar.netflixprize.data.*;

public class Main {
	public static void main(String args[]) {

		String baseFile = "testingDatasets" + FileIO.fileSeparator + "1Ratings.csv";

		String moviesFile = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";
		String linksFile = "ml-latest-small" + FileIO.fileSeparator + "links.csv";
		String tagsFile = "ml-latest-small" + FileIO.fileSeparator + "tags.csv";

		System.out.println("\n***Initializing Predictor***");

		HashMap<Integer, User> users = new HashMap<Integer, User>();
		HashMap<Integer, Movie> movies = new HashMap<Integer, Movie>();
		MLCSVTranslator.parse(users, movies, moviesFile, baseFile, tagsFile, linksFile);

		for (int i : users.keySet()) {
			users.get(i).computeAverages();
			System.out.println(users.get(i));
		}
	}

}