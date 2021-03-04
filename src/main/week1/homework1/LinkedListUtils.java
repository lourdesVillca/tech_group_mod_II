package week1.homework1;

import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
    /**
     * Method that insert elements in a linked list and then it will be sorted
     *
     * @param list  LinkedList to be updated
     * @param value value to be inserted in the linked list
     */
    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list == null) return;
        list.addLast(value);
        Collections.sort(list);
    }

    /**
     * Method that remove the N numbers of max values
     * @param list  LinkedList to be updated
     * @param N     Max number that will be removed
     */
    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list == null || list.isEmpty() || N < 0) return;
        if (N > list.size()) {
            list.clear();
            return;
        }
        while (N > 0) {
            String max = list.stream().max((a, b) -> a.compareTo(b)).get();
            list.removeIf(a -> a.equals(max));
            N--;
        }
    }

    /**
     * Method that verify if a LinkedList is a sublist of a second one.
     * @param one   Fisrt LinkedList
     * @param two  Second LinkedList
     * @return  True if the first list is a sublist of the second one, false otherwise.
     */
    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || one.isEmpty() || two == null || two.isEmpty()) return false;
        return Collections.indexOfSubList(one, two) != -1;
    }
}
