/*
 *  View
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.view;

import java.util.List;

/**
 * This class represents the visualization of the data that model contains.
 */
public class View {

    /**
     * Prints message to the console.
     * @param message the message is output to the console.
     */
    public void println(String message){
        System.out.println(message);
    }

    /**
     * Prints enums to the console.
     * @param enums the array of enum is output to the console.
     */
    public void printEnum(Enum[] enums){
        for (Enum e : enums) {
            System.out.println(e);
        }
    }

    /**
     * Prints list to the console.
     * @param list the list is output to the console.
     */
    public void printList(List<?> list){
        list.forEach(System.out::println);
    }

    /**
     * Prints error message, to the console.
     * @param message the message in red text, it is output to the console.
     */
    public void printErr(String message){
        System.err.println(message);
    }

}
