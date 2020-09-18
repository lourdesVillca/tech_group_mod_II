package week1.homework3;
import java.util.LinkedList;
import org.junit.Test;
import java.util.Set;
import org.junit.Assert;
import java.util.List;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class AllWordsTest
{
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testNull() {
        try {
            final Set allWords = Analyzer.allWords((List)null);
            if (allWords == null) {
                Assert.fail("allWords should return empty Set when input is null");
            }
            Assert.assertTrue("allWords should return empty Set when input is null", allWords.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when input is null");
        }
    }
    
    @Test
    public void testEmpty() {
        try {
            final Set allWords = Analyzer.allWords((List)new LinkedList());
            if (allWords == null) {
                Assert.fail("allWords should return empty Set when input is empty");
            }
            Assert.assertTrue("allWords should return empty Set when input is empty", allWords.isEmpty());
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when input is empty");
        }
    }
    
    @Test
    public void testAllWordsDistinct() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when all words in List are distinct");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when all words in List are distinct");
            }
            Assert.assertEquals("allWords contains incorrect number of elements when all words are distinct", 4L, (long)allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            final Word word2 = new Word("dog");
            word2.increaseTotal(0);
            final Word word3 = new Word("cat");
            word3.increaseTotal(0);
            final Word word4 = new Word("monkey");
            word4.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word3));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct", allWords.contains(word4));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when all words in List are distinct");
        }
    }
    
    @Test
    public void testIgnoreNullSentenceInList() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(null);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when a Sentence in List is null");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when a Sentence in List is null");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when a Sentence in List is null", 4 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            final Word word2 = new Word("dog");
            word2.increaseTotal(0);
            final Word word3 = new Word("cat");
            word3.increaseTotal(0);
            final Word word4 = new Word("monkey");
            word4.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", allWords.contains(word3));
            Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", allWords.contains(word4));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when a Sentence in List is null");
        }
    }
    
    @Test
    public void testCorrectTotalAllWordsDistinctScoresPositive() {
        final Sentence sentence = new Sentence(1, "word dog ");
        final Sentence sentence2 = new Sentence(2, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when all words are distinct");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when all words are distinct");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(1);
            final Word word2 = new Word("dog");
            word2.increaseTotal(1);
            final Word word3 = new Word("cat");
            word3.increaseTotal(2);
            final Word word4 = new Word("monkey");
            word4.increaseTotal(2);
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word3));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", allWords.contains(word4));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when all words are distinct");
        }
    }
    
    @Test
    public void testCorrectTotalAllWordsDistinctScoresNegative() {
        final Sentence sentence = new Sentence(-1, "word dog ");
        final Sentence sentence2 = new Sentence(-2, "cat monkey ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when all words are distinct");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when all words are distinct");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(-1);
            final Word word2 = new Word("dog");
            word2.increaseTotal(-1);
            final Word word3 = new Word("cat");
            word3.increaseTotal(-2);
            final Word word4 = new Word("monkey");
            word4.increaseTotal(-2);
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word3));
            Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", allWords.contains(word4));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when all words are distinct");
        }
    }
    
    @Test
    public void testSomeWordsAppearMoreThanOnce() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words appear more than once");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words appear more than once");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            final Word word2 = new Word("dog");
            word2.increaseTotal(0);
            final Word word3 = new Word("cat");
            word3.increaseTotal(0);
            word2.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", allWords.contains(word3));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words appear more than once");
        }
    }
    
    @Test
    public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresPositive() {
        final Sentence sentence = new Sentence(1, "word dog ");
        final Sentence sentence2 = new Sentence(2, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words appear more than once");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words appear more than once");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(1);
            final Word word2 = new Word("dog");
            word2.increaseTotal(1);
            final Word word3 = new Word("cat");
            word3.increaseTotal(2);
            word2.increaseTotal(2);
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", allWords.contains(word3));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words appear more than once");
        }
    }
    
    @Test
    public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresNegative() {
        final Sentence sentence = new Sentence(-1, "word dog ");
        final Sentence sentence2 = new Sentence(-2, "cat dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words appear more than once");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words appear more than once");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(-1);
            final Word word2 = new Word("dog");
            word2.increaseTotal(-1);
            final Word word3 = new Word("cat");
            word3.increaseTotal(-2);
            word2.increaseTotal(-2);
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", allWords.contains(word3));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words appear more than once");
        }
    }
    
    @Test
    public void testIgnoreWordThatStartsWithCharacterThatIsNotALetter() {
        final Sentence sentence = new Sentence(0, "word $dog ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words start with character that is not a letter");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words start with character that is not a letter");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words start with character that is not a letter", 1 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when some words start with character that is not a letter", allWords.contains(word));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words start with character that is not a letter");
        }
    }
    
    @Test
    public void testIgnoreWordThatIsSingleCharacterThatIsNotALetter() {
        final Sentence sentence = new Sentence(0, "word dog ?");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words are single character that is not a letter");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words are single character that is not a letter");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words are single character that is not a letter", 2 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            final Word word2 = new Word("word");
            word2.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", allWords.contains(word2));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words are single character that is not a letter");
        }
    }
    
    @Test
    public void testCaseInsensitivity() {
        final Sentence sentence = new Sentence(0, "word dog ");
        final Sentence sentence2 = new Sentence(0, "cat DOG ");
        final LinkedList<Sentence> list = new LinkedList<Sentence>();
        list.add(sentence);
        list.add(sentence2);
        try {
            final Set allWords = Analyzer.allWords((List)list);
            if (allWords == null) {
                Assert.fail("allWords returns null when some words are same ignoring case");
            }
            else if (allWords.isEmpty()) {
                Assert.fail("allWords returns empty Set when some words are same ignoring case");
            }
            Assert.assertTrue("allWords contains incorrect number of elements when some words are same ignoring case", 3 == allWords.size());
            final Word word = new Word("word");
            word.increaseTotal(0);
            final Word word2 = new Word("dog");
            word2.increaseTotal(0);
            final Word word3 = new Word("cat");
            word3.increaseTotal(0);
            word2.increaseTotal(0);
            Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", allWords.contains(word));
            Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", allWords.contains(word2));
            Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", allWords.contains(word3));
        }
        catch (Exception obj) {
            Assert.fail("allWords throws " + obj + " when some words are same ignoring case");
        }
    }
}
