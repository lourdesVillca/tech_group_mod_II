package week1.homework3;
import java.util.HashMap;
import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class CalculateSentenceScoreTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNullMap() {
        try {
            Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is null", 0.0 == Analyzer.calculateSentenceScore((Map)null, "This is a test ."));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input Map is null");
        }
    }
    
    @Test
    public void testEmptyMap() {
        try {
            Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is empty", 0.0 == Analyzer.calculateSentenceScore((Map)new HashMap(), "This is a test ."));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input Map is empty");
        }
    }
    
    @Test
    public void testNullSentence() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is null", 0.0 == Analyzer.calculateSentenceScore((Map)hashMap, (String)null));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input sentence is null");
        }
    }
    
    @Test
    public void testEmptySentence() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is empty", 0.0 == Analyzer.calculateSentenceScore((Map)hashMap, ""));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input sentence is empty");
        }
    }
    
    @Test
    public void testSentenceContainsNoValidWords() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence contains no valid words", 0.0 == Analyzer.calculateSentenceScore((Map)hashMap, "$"));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input sentence contains no valid words");
        }
    }
    
    @Test
    public void testAllWordsInSentenceAndScoresAreInts() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 2.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have integer scores", 2.0 == Analyzer.calculateSentenceScore((Map)hashMap, "dog cat"));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when all words in Map are in sentence and have integer scores");
        }
    }
    
    @Test
    public void testAllWordsInSentenceAndScoresAreDoubles() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 1.7);
        hashMap.put("cat", 1.9);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have floating-point scores", Math.abs(1.8 - Analyzer.calculateSentenceScore((Map)hashMap, "dog cat")) < 1.0E-6);
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when all words in Map are in sentence and have floating-point scores");
        }
    }
    
    @Test
    public void testSomeWordsNotInMap() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 1.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when some words in sentence are not in input Map", 1.0 == Analyzer.calculateSentenceScore((Map)hashMap, "dog cat gorilla"));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when some words in sentence are not in input Map");
        }
    }
    
    @Test
    public void testIgnoreInvalidWords() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 0.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains invalid words", 1.0 == Analyzer.calculateSentenceScore((Map)hashMap, "dog $pig cat"));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input sentence contains invalid words");
        }
    }
    
    @Test
    public void testCaseInsensitivity() {
        final HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("dog", 2.0);
        hashMap.put("cat", 0.0);
        try {
            Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains words with uppercase letters", 1.0 == Analyzer.calculateSentenceScore((Map)hashMap, "DOG cat"));
        }
        catch (Exception obj) {
            Assert.fail("calculateSentenceScore throws " + obj + " when input sentence contains words with uppercase letters");
        }
    }
}
