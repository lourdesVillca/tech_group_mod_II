package week1.homework3;
import java.util.HashSet;
import org.junit.Test;
import java.util.Map;
import org.junit.Assert;
import java.util.Set;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class CalculateScoresTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNull() {
        try {
            final Map calculateScores = Analyzer.calculateScores((Set)null);
            if (calculateScores == null) {
                Assert.fail("calculateScores should return empty Map when input is null");
            }
            Assert.assertTrue("calculateScores should return empty Map when input is null", calculateScores.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("calculateScores throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testEmpty() {
        try {
            final Map calculateScores = Analyzer.calculateScores((Set)new HashSet());
            if (calculateScores == null) {
                Assert.fail("calculateScores should return empty Map when input is empty");
            }
            Assert.assertTrue("calculateScores should return empty Map when input is empty", calculateScores.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("calculateScores throws " + obj + " when input is empty");
        }
    }
    
    @Test
    public void testSingleWord() {
        final Word word = new Word("apple");
        word.increaseTotal(2);
        word.increaseTotal(1);
        final HashSet<Word> set = new HashSet<Word>();
        set.add(word);
        try {
            final Map calculateScores = Analyzer.calculateScores((Set)set);
            if (calculateScores == null) {
                Assert.fail("calculateScores returns null when input has a single Word");
            }
            else if (calculateScores.isEmpty()) {
                Assert.fail("calculateScores returns empty Map when input has a single Word");
            }
            Assert.assertTrue("calculateScores has wrong number of elements when input has a single Word", 1 == calculateScores.size());
            Assert.assertTrue("calculateScores has wrong key for element when input has a single Word", calculateScores.containsKey("apple"));
            Assert.assertTrue("calculateScores has wrong score value for element when input has a single Word", Math.abs(1.5 - (Double)calculateScores.get("apple")) <= 1.0E-5);
        }
        catch (Exception obj) {
            Assert.fail("calculateScores throws " + obj + " when input has a single Word");
        }
    }
    
    @Test
    public void testMultipleWords() {
        final Word word = new Word("apple");
        word.increaseTotal(2);
        word.increaseTotal(1);
        final Word word2 = new Word("banana");
        word2.increaseTotal(1);
        final HashSet<Word> set = new HashSet<Word>();
        set.add(word);
        set.add(word2);
        try {
            final Map calculateScores = Analyzer.calculateScores((Set)set);
            if (calculateScores == null) {
                Assert.fail("calculateScores returns null when input has multiple Words");
            }
            else if (calculateScores.isEmpty()) {
                Assert.fail("calculateScores returns empty Map when input has multiple Words");
            }
            Assert.assertTrue("calculateScores has wrong number of elements when input has multiple Words", 2 == calculateScores.size());
            Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", calculateScores.containsKey("apple"));
            Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", calculateScores.containsKey("banana"));
            Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", Math.abs(1.5 - (Double)calculateScores.get("apple")) <= 1.0E-5);
            Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", 1.0 == (Double)calculateScores.get("banana"));
        }
        catch (Exception obj) {
            Assert.fail("calculateScores throws " + obj + " when input has multiple Words");
        }
    }
    
    @Test
    public void testIgnoreNullWord() {
        final Word word = new Word("apple");
        word.increaseTotal(2);
        word.increaseTotal(1);
        final HashSet<Word> set = new HashSet<Word>();
        set.add(word);
        set.add(null);
        try {
            final Map calculateScores = Analyzer.calculateScores((Set)set);
            if (calculateScores == null) {
                Assert.fail("calculateScores returns null when input contains a null Word");
            }
            else if (calculateScores.isEmpty()) {
                Assert.fail("calculateScores returns empty Map when input contains a null Word");
            }
            Assert.assertTrue("calculateScores has wrong number of elements when input contains a null Word", 1 == calculateScores.size());
            Assert.assertTrue("calculateScores has wrong key for element when input contains a null Word", calculateScores.containsKey("apple"));
            Assert.assertTrue("calculateScores has wrong score value for element when input contains a null Word", Math.abs(1.5 - (Double)calculateScores.get("apple")) < 1.0E-5);
        }
        catch (Exception obj) {
            Assert.fail("calculateScores throws " + obj + " when input contains a null Word");
        }
    }
}
