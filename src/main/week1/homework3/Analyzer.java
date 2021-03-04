package week1.homework3;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        ArrayList<Sentence> sentences = new ArrayList<>();
        if (filename == null) return sentences;
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> {
                createSentence(line, sentences);
            });

        } catch (IOException e) {
            return sentences;
        }
        return sentences;
    }

    /**
     * Method that create a Sentence object and add the created object to the Sentence ArrayList
     *
     * @param line      String that represent the sentence
     * @param sentences ArrayList of Sentences
     */
    private static void createSentence(String line, ArrayList<Sentence> sentences) {
        if (line.matches("^-{0,1}[0-2]\\s.+$")) {
            int index = line.indexOf(" ");
            int score = Integer.parseInt(line.substring(0, index));
            String text = line.substring(index + 1);
            Sentence sentence = new Sentence(score, text);
            sentences.add(sentence);
        }
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {
        Set<Word> wordSet = new HashSet<>();
        if (sentences == null || sentences.isEmpty()) return wordSet;
        sentences.forEach(sentence -> {
            if (sentence != null) {
                String[] sentenceList = processSentence(sentence.text);
                for (String word : sentenceList) {
                    Word newWord = new Word(word);
                    wordSet.add(newWord);
                    newWord.increaseTotal(sentence.score);
                }
            }
        });
        return wordSet;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        Map<String, Double> wordScores = new HashMap<>();
        if (words == null || words.isEmpty()) return wordScores;
        for (Word w : words) {
            if (w != null) {
                wordScores.put(w.getText(), w.calculateScore());
            }
        }
        return wordScores;

    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        double sentenceScore = 0;
        if (sentence == null || sentence.isEmpty() || wordScores == null || wordScores.isEmpty()) return sentenceScore;
        String[] wordListFormatted = processSentence(sentence);
        for (String word : wordListFormatted) {
            Double score = wordScores.get(word);
            if (score != null) {
                sentenceScore += wordScores.get(word);
            }
        }
        return wordListFormatted.length == 0 ? sentenceScore : sentenceScore / wordListFormatted.length;
    }

    /**
     * Method that Split and process a Sentence String
     *
     * @param sentence Represents the sentence String
     * @return Array of valid Words
     */
    public static String[] processSentence(String sentence) {
        String[] formattedText = sentence.toLowerCase().split(" ");
        return Arrays.stream(formattedText)
                .filter(x -> x.matches("^[a-z]+$"))
                .toArray(String[]::new);
    }


    /*
     * This method is here to help you run your program. Y
     * You may modify it as needed.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify the name of the input file");
            System.exit(0);
        }
        String filename = args[0];
        System.out.print("Please enter a sentence: ");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        in.close();
        List<Sentence> sentences = Analyzer.readFile(filename);
        Set<Word> words = Analyzer.allWords(sentences);
        Map<String, Double> wordScores = Analyzer.calculateScores(words);
        double score = Analyzer.calculateSentenceScore(wordScores, sentence);
        System.out.println("The sentiment score is " + score);
    }
}
