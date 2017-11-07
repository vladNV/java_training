/*
 *  View
 *  30.10.2017
 */

package ua.training;

/**
 * This class represents the visualization of the data that model contains.
 */
public class SentencesView {

    /**
     * This is sentences which is required
     */
    public static final String RULE = "Hello world!";

    public static final String INCORRECT_INPUT = "Incorrect value";
    public static final String PROMPT = "you must enter";

    /**
     * Prints message to the console
     * @param message the message is output to the console
     */
    public void display(String message) {
        System.out.println(message);
    }

}
