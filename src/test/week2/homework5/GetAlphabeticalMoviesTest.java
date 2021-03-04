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

public class GetAlphabeticalMoviesTest
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
    }
    
    @Test
    public void testNull() {
        try {
            final List alphabeticalMovies = MovieRatingsProcessor.getAlphabeticalMovies((TreeMap)null);
            if (alphabeticalMovies == null) {
                Assert.fail("getAlphabeticalMovies should return empty List when input is null");
            }
            Assert.assertTrue("getAlphabeticalMovies should return empty List when input is null", alphabeticalMovies.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMovies throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testEmpty() {
        try {
            final List alphabeticalMovies = MovieRatingsProcessor.getAlphabeticalMovies(new TreeMap());
            if (alphabeticalMovies == null) {
                Assert.fail("getAlphabeticalMovies should return empty List when input is empty");
            }
            Assert.assertTrue("getAlphabeticalMovies should return empty List when input is empty", alphabeticalMovies.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMovies throws " + obj + " when input is empty");
        }
    }
    
    @Test
    public void testValidInput() {
        try {
            final List alphabeticalMovies = MovieRatingsProcessor.getAlphabeticalMovies((TreeMap)this.map);
            if (alphabeticalMovies == null) {
                Assert.fail("getAlphabeticalMovies returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMovies returns List with incorrect number of entries for valid input", 3L, (long)alphabeticalMovies.size());
            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", alphabeticalMovies.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", alphabeticalMovies.contains("inception"));
            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", alphabeticalMovies.contains("ratatouille"));
            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", alphabeticalMovies.get(0).equals("inception"));
            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", alphabeticalMovies.get(1).equals("ratatouille"));
            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", alphabeticalMovies.get(2).equals("sabrina"));
        }
        catch (Exception obj) {
            Assert.fail("getAlphabeticalMovies throws " + obj + " for valid input");
        }
    }
}
