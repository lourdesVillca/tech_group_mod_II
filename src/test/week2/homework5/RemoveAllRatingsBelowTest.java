package week2.homework5;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 
// Decompiled by Procyon v0.5.36
// 

public class RemoveAllRatingsBelowTest
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
        value3.add(1);
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
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)null, 2);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow should return empty List when input is null");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty List when input is null", removeAllRatingsBelow.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testEmpty() {
        try {
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow(new TreeMap(), 2);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow should return empty List when input is empty");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty List when input is empty", removeAllRatingsBelow.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when input is empty");
        }
    }
    
    @Test
    public void testModifySomeMovies() {
        try {
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)this.map, 2);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 2, removeAllRatingsBelow.size());
            if (!removeAllRatingsBelow.containsKey("inception")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 1, removeAllRatingsBelow.get("inception"));
            if (!removeAllRatingsBelow.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 2, removeAllRatingsBelow.get("ratatouille"));
            Assert.assertEquals("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed", 4, this.map.size());
            final PriorityQueue<Integer> priorityQueue = this.map.get("inception");
            if (priorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
            }
            if (priorityQueue.size() != 1) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
            }
            if (priorityQueue.peek() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
            final PriorityQueue<Integer> priorityQueue2 = this.map.get("ratatouille");
            if (priorityQueue2 == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
            }
            if (priorityQueue2.size() != 3) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
            }
            if ((int)priorityQueue2.remove() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
            if ((int)priorityQueue2.remove() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when some movies have ratings to be removed");
        }
    }
    
    @Test
    public void testModifyNoMovies() {
        try {
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)this.map, 0);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow returns null when no movies have ratings to be removed");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty TreeMap when no movies have ratings to be removed", removeAllRatingsBelow.isEmpty());
            final PriorityQueue<Integer> priorityQueue = this.map.get("sabrina");
            if (priorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (priorityQueue.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            final PriorityQueue<Integer> priorityQueue2 = this.map.get("inception");
            if (priorityQueue2 == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (priorityQueue2.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            final PriorityQueue<Integer> priorityQueue3 = this.map.get("ratatouille");
            if (priorityQueue3 == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (priorityQueue3.size() != 5) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            final PriorityQueue<Integer> priorityQueue4 = this.map.get("grease");
            if (priorityQueue4 == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (priorityQueue4.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when no movies have ratings to be removed");
        }
    }
    
    @Test
    public void testRemoveAllRatings() {
        try {
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)this.map, 10);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow returns null when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when all ratings for all movies are to be removed", 4, removeAllRatingsBelow.size());
            if (!removeAllRatingsBelow.containsKey("sabrina")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2, removeAllRatingsBelow.get("sabrina"));
            if (!removeAllRatingsBelow.containsKey("inception")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2, removeAllRatingsBelow.get("inception"));
            if (!removeAllRatingsBelow.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 5, removeAllRatingsBelow.get("ratatouille"));
            if (!removeAllRatingsBelow.containsKey("grease")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2, removeAllRatingsBelow.get("grease"));
            Assert.assertTrue("removeAllRatingsBelow should return remove all elements from input TreeMap when all ratings for all movies are to be removed", this.map.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when all ratings for all movies are to be removed");
        }
    }
    
    @Test
    public void testRemoveBelowButNotEqual() {
        this.map.remove("sabrina");
        this.map.remove("grease");
        this.map.remove("inception");
        try {
            final TreeMap removeAllRatingsBelow = MovieRatingsProcessor.removeAllRatingsBelow((TreeMap)this.map, 4);
            if (removeAllRatingsBelow == null) {
                Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 1, removeAllRatingsBelow.size());
            if (!removeAllRatingsBelow.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings that are equal to threshold", 2, removeAllRatingsBelow.get("ratatouille"));
            final PriorityQueue<Integer> priorityQueue = this.map.get("ratatouille");
            if (priorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings equal to threshold");
            }
            if (priorityQueue.size() != 3) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings equal to threshold");
            }
        }
        catch (Exception obj) {
            Assert.fail("removeAllRatingsBelow throws " + obj + " when some movies have ratings to be removed");
        }
    }
}
