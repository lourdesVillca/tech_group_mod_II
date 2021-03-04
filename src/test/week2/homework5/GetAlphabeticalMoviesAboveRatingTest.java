package week2.homework5;
import org.junit.Test;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 
// Decompiled by Procyon v0.5.36
// 

public class GetAlphabeticalMoviesAboveRatingTest
{
    TreeMap<String, PriorityQueue<Integer>> map;
    
    @Before
    public void setUp() {
        this.map = new TreeMap<String, PriorityQueue<Integer>>();
        final PriorityQueue<Integer> value = new PriorityQueue<Integer>();
        value.add(3);
        value.add(5);
        this.map.put("sabrina", value);
        final PriorityQueue<Integer> value2 = new PriorityQueue<Integer>();
        value2.add(4);
        value2.add(1);
        this.map.put("inception", value2);
        final PriorityQueue<Integer> value3 = new PriorityQueue<Integer>();
        value3.add(4);
        value3.add(5);
        value3.add(1);
        value3.add(3);
        value3.add(5);
        this.map.put("ratatouille", value3);
        final PriorityQueue<Integer> value4 = new PriorityQueue<Integer>();
        value4.add(4);
        value4.add(3);
        this.map.put("grease", value4);
    }
    
    @Test
    public void testNull() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)null, 2);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is null");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is null", alphabeticalMoviesAboveRating.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testEmpty() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(new TreeMap(), 2);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is empty");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is empty", alphabeticalMoviesAboveRating.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " when input is empty");
        }
    }
    
    @Test
    public void testReturnMoviesAbove() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)this.map, 2);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies are above threshold", 2L, (long)alphabeticalMoviesAboveRating.size());
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", alphabeticalMoviesAboveRating.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", alphabeticalMoviesAboveRating.contains("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", alphabeticalMoviesAboveRating.get(0).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", alphabeticalMoviesAboveRating.get(1).equals("sabrina"));
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " for valid input");
        }
    }
    
    @Test
    public void testReturnMoviesAboveNotEqual() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)this.map, 1);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies' minimum rating equals threshold", 2L, (long)alphabeticalMoviesAboveRating.size());
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", alphabeticalMoviesAboveRating.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", alphabeticalMoviesAboveRating.contains("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", alphabeticalMoviesAboveRating.get(0).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", alphabeticalMoviesAboveRating.get(1).equals("sabrina"));
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " for valid input");
        }
    }
    
    @Test
    public void testAllMoviesBelowThreshold() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)this.map, 8);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies' minimum rating is below threshold");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when all movies' minimum rating is below threshold", alphabeticalMoviesAboveRating.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " when all movies' minimum rating is below threshold");
        }
    }
    
    @Test
    public void testAllMoviesAbove() {
        try {
            final List alphabeticalMoviesAboveRating = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating((TreeMap)this.map, 0);
            if (alphabeticalMoviesAboveRating == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies are above threshold");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when all movies are above threshold", 4L, (long)alphabeticalMoviesAboveRating.size());
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", alphabeticalMoviesAboveRating.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", alphabeticalMoviesAboveRating.contains("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", alphabeticalMoviesAboveRating.contains("inception"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", alphabeticalMoviesAboveRating.contains("ratatouille"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", alphabeticalMoviesAboveRating.get(0).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", alphabeticalMoviesAboveRating.get(1).equals("inception"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", alphabeticalMoviesAboveRating.get(2).equals("ratatouille"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", alphabeticalMoviesAboveRating.get(3).equals("sabrina"));
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + obj + " when all movies are above threshold");
        }
    }
}
