package week1.homework3;

import java.io.File;

import org.junit.Test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class ReadFileTest {
    protected static final String DIRECTORY = "./src/test/week1/homework3/";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNull() {
        try {
            final List file = Analyzer.readFile((String) null);
            if (file == null) {
                Assert.fail("readFile should return empty List when input filename is null");
            } else {
                Assert.assertTrue("readFile should return empty List when input filename is null", file.isEmpty());
            }
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when input filename is null");
        }
    }

    @Test
    public void testInvalidFilename() {
        try {
            final List file = Analyzer.readFile("invalid name!");
            if (file == null) {
                Assert.fail("readFile should return empty List when input file cannot be read");
            } else {
                Assert.assertTrue("readFile should return empty List when input file cannot be read", file.isEmpty());
            }
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when input file cannot be read");
        }
    }

    @Test
    public void testTextOneSentence() {
        if (!new File(DIRECTORY + "test1.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test1.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test1.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with one sentence");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with one sentence");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has one sentence");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(sentence.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with one sentence");
        }
    }

    @Test
    public void testScoreOneSentence() {
        if (!new File(DIRECTORY + "test2.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test2.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test2.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with one sentence");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with one sentence");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has one sentence");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 2 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(sentence.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with one sentence");
        }
    }

    @Test
    public void testMultipleSentencesPositiveScores() {
        if (!new File(DIRECTORY + "test3.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test3.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test3.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with multiple sentences");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with multiple sentences");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has multiple sentences");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "this is a test".equals(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(1);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has multiple sentences");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 1 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "dogs are so cute".equals(sentence2.getText()));
            final Sentence sentence3 = (Sentence) file.get(2);
            if (sentence3 == null) {
                Assert.fail("readFile contains null Sentence when file has multiple sentences");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 2 == sentence3.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "testing is boring".equals(sentence3.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with multiple sentences");
        }
    }

    @Test
    public void testMultipleSentencesNegativeScores() {
        if (!new File(DIRECTORY + "test4.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test4.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test4.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with multiple sentences");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with multiple sentences");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == file.size());
            final Sentence sentence = (Sentence) file.get(1);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has multiple sentences");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -1 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "dogs are so cute".equals(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(2);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has multiple sentences");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -2 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "testing is boring".equals(sentence2.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with multiple sentences");
        }
    }

    @Test
    public void testIgnoreInvalidSentenceWithNoScore() {
        if (!new File(DIRECTORY + "test5.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test5.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test5.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with invalid sentences that contain no score");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no score");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no score", 2 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "this is a test".equals(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(1);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 1 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "dogs are so cute".equals(sentence2.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with invalid sentences that contain no score");
        }
    }

    @Test
    public void testIgnoreInvalidSentenceWithNoText() {
        if (!new File(DIRECTORY + "test6.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test6.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test6.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with invalid sentences that contain no text");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no text");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no text", 2 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "this is a test".contains(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(1);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 1 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "dogs are so cute".contains(sentence2.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with invalid sentences that contain no text");
        }
    }

    @Test
    public void testIgnoreInvalidSentenceWithScoreOutsideRange() {
        if (!new File(DIRECTORY + "test7.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test7.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test7.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with sentences that have score outside valid range");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with invalid sentences that have score outside valid range");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score outside valid range", 2 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "this is a test".equals(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(1);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 1 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "dogs are so cute".equals(sentence2.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with sentences that have score outside valid range");
        }
    }

    @Test
    public void testIgnoreInvalidSentenceWithScoreNotAnInteger() {
        if (!new File(DIRECTORY + "test8.txt").exists()) {
            Assert.fail("Could not run test for readFile: be sure that test8.txt is in your project root directory or the directory where you started Java.");
        }
        try {
            final List file = Analyzer.readFile(DIRECTORY + "test8.txt");
            if (file == null) {
                Assert.fail("readFile returns null when processing file with sentences that have score that is not an integer");
            }
            if (file.isEmpty()) {
                Assert.fail("readFile returns empty List when processing file with invalid sentences that have score that is not an integer");
            }
            Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score that is not an integer", 2 == file.size());
            final Sentence sentence = (Sentence) file.get(0);
            if (sentence == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 0 == sentence.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "this is a test".equals(sentence.getText()));
            final Sentence sentence2 = (Sentence) file.get(1);
            if (sentence2 == null) {
                Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
            }
            Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 1 == sentence2.getScore());
            Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "dogs are so cute".equals(sentence2.getText()));
        } catch (Exception obj) {
            Assert.fail("readFile throws " + obj + " when processing file with sentences that have score that is not an integer");
        }
    }
}
