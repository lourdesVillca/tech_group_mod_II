package week2.homework5;
/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;
import java.util.stream.Collectors;


public class MovieRatingsProcessor {
    /**
     * Method that get a list of movies sorted alphabetically.
     *
     * @param movieRatings TeeMap with the movie rating information.
     * @return sorted movie list.
     */
    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        if (movieRatings == null || movieRatings.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(movieRatings.keySet());
    }

    /**
     * Method that get movies above a rating and sort alphabetically.
     *
     * @param movieRatings TreeMap with the movie ratings information.
     * @param rating       Represents the rating to make the comparisson.
     * @return List of movies.
     */
    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        if (movieRatings == null || movieRatings.isEmpty()) return new ArrayList<>();
        return movieRatings.entrySet().stream()
                .filter(e -> e.getValue().peek() > rating)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Method that remove all movie ratings bellow the given rating.
     *
     * @param movieRatings Map with the movie ratings.
     * @param rating       Represents the rating.
     * @return TreeMap with the mapped movies.
     */
    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> result = new TreeMap<>();
        if (movieRatings == null) return result;
        for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
            PriorityQueue<Integer> ratingQueue = movie.getValue();
            int ratingQueueSize = ratingQueue.size();
            ratingQueue.removeIf(x -> x < rating);
            if (ratingQueue.size() < ratingQueueSize) {
                result.put(movie.getKey(), ratingQueueSize - ratingQueue.size());
            }
        }
        result.keySet().forEach(key -> {
            if (movieRatings.get(key).size() == 0) movieRatings.remove(key);
        });
        return result;
    }
}
