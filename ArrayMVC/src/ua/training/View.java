/*
 *  View
 *  30.10.2017
 */

package ua.training;

import java.util.Arrays;

/**
 * This class represents the visualization of the data that model contains.
 */
public class View {

    public static final String OUR_ARRAY = "Array: ";
    public static final String INDEXES = "Indexes found: ";
    public static final String NUMBER = "Number: ";

    /**
     * Prints message to the console
     * @param message the message is output to the console.
     */
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * Prints array to the console
     * @param array the array is output to the console.
     */
    public void printArray(long[] array) {
        System.out.println(Arrays.toString(array));
    }

}
