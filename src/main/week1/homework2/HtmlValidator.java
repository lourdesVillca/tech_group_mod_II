package week1.homework2;

import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
    /**
     * Method that return an empty stack if an HTML file is well formatted.
     *
     * @param tags Queue with the tags information.
     * @return return an stack with the status of tags.
     */
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> htmlTags = new Stack<>();
        for (HtmlTag tag : tags) {
            if (tag.isSelfClosing()) continue;
            if (htmlTags.isEmpty() && !tag.isOpenTag()) return null;
            if (tag.isOpenTag()) {
                htmlTags.push(tag);
            } else if (tag.matches(htmlTags.peek())) {
                htmlTags.pop();
            } else break;
        }
        return htmlTags;
    }
}
