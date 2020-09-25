package week2.homework5;
/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {
    /**
     * Method that create a TreeMap with the information of the movie Rating.
     *
     * @param allUsersRatings User Rating list
     * @return TreeMap with the movie rating.
     */
    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> movieRatingMap = new TreeMap<>();
        if (allUsersRatings == null || allUsersRatings.isEmpty()) return movieRatingMap;
        for (UserMovieRating userMovieRating : allUsersRatings) {
            if (userMovieRating == null || userMovieRating.movie == null || userMovieRating.movie.isEmpty() || userMovieRating.userRating < 0)
                continue;
            String key = userMovieRating.getMovie().toLowerCase();
            PriorityQueue<Integer> userRating = movieRatingMap.get(key);
            if (userRating == null) {
                userRating = new PriorityQueue<>();
                userRating.add(userMovieRating.userRating);
                movieRatingMap.put(userMovieRating.getMovie().toLowerCase(), userRating);
            } else {
                userRating.add(userMovieRating.userRating);
            }
        }
        return movieRatingMap;
    }
}
