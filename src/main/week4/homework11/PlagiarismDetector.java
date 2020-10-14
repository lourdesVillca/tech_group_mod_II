package week4.homework11;

import java.io.File;
import java.util.*;

/*
 * SD2x Homework #11
 * Improve the efficiency of the code below according to the guidelines in the assignment description.
 * Please be sure not to change the signature of the detectPlagiarism method!
 * However, you may modify the signatures of any of the other methods as needed.
 */

public class PlagiarismDetector {

    public static Map<String, Integer> detectPlagiarism(String dirName, int windowSize, int threshold) {
        File dirFile = new File(dirName);
        String[] files = dirFile.list();

        Map<String, Integer> numberOfMatches = new HashMap<>();

        Map<String, Set<String>> filePhrases = new HashMap<>();
        for (String file : files) {
            if (file != null) {
                filePhrases.put(file, createPhrases(String.format("%s/%s", dirName, file), windowSize));
            }
        }

        for (int i = 0; i < files.length - 1; i++) {
            String file1 = files[i];

            Set<String> file1Phrases = filePhrases.get(file1);
            if (file1Phrases == null) {
                return null;
            }

            for (int j = i + 1; j < files.length; j++) {
                String file2 = files[j];

                Set<String> file2Phrases = filePhrases.get(file2);
                if (file2Phrases == null)
                    return null;

                int matches = findMatches(file1Phrases, file2Phrases);
                if (matches > threshold) {
                    String key = file1 + "-" + file2;
                    numberOfMatches.put(key, matches);
                }
            }
        }

        return sortResults(numberOfMatches);
    }


    /*
     * This method reads the given file and then converts it into a Collection of Strings.
     * It does not include punctuation and converts all words in the file to uppercase.
     */
    protected static List<String> readFile(String filename) {
        if (filename == null) return null;
        List<String> words = new ArrayList<>();

        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNext()) {
                words.add(in.next().replaceAll("[^a-zA-Z]", "").toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return words;
    }


    /*
     * This method reads a file and converts it into a List of distinct phrases,
     * each of size "window". The Strings in each phrase are whitespace-separated.
     */
    protected static Set<String> createPhrases(String filename, int window) {
        if (filename == null || window < 1) return null;

        List<String> words = readFile(filename);

        Set<String> phrases = new HashSet<String>();

        for (int i = 0; i < words.size() - window + 1; i++) {
            StringBuilder phrase = new StringBuilder();
            for (int j = 0; j < window; j++) {
                phrase.append(words.get(i + j));
                phrase.append(" ");
            }
            phrases.add(phrase.toString());
        }
        return phrases;
    }


    /*
     * Returns the number of Strings that occur in both of the List parameters.
     */
    protected static int findMatches(Set<String> myPhrases, Set<String> yourPhrases) {
        return (int) myPhrases.stream().
                filter(s -> yourPhrases.contains(s))
                .count();
    }

    /*
     * Returns a LinkedHashMap in which the elements of the Map parameter
     * are sorted according to the value of the Integer, in non-ascending order.
     */
    protected static LinkedHashMap<String, Integer> sortResults(Map<String, Integer> possibleMatches) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        possibleMatches.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }

    /*
     * This method is here to help you measure the execution time and get the output of the program.
     * You do not need to consider it for improving the efficiency of the detectPlagiarism method.
     */
    public static void main(String[] args) {
    	/*if (args.length == 0) {
    		System.out.println("Please specify the name of the directory containing the corpus.");
    		System.exit(0);
    	}*/
        String directory = "./src/main/week4/homework11/corpus/";
        long start = System.currentTimeMillis();
        Map<String, Integer> map = PlagiarismDetector.detectPlagiarism(directory, 4, 5);
        long end = System.currentTimeMillis();
        double timeInSeconds = (end - start) / (double) 1000;
        System.out.println("Execution time (wall clock): " + timeInSeconds + " seconds");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
