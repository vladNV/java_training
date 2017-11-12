/*
 *  InputController
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.controller;

import kpi.fpm.view.View;
import java.util.Scanner;

/**
 * This class accompanies data entry.
 */
class InputController {

    /**
     * Visualization
     */
    private final View view;
    /**
     * Input stream.
     */
    private final Scanner scanner;

    InputController(final Scanner sc, final View view) {
        this.view = view;
        this.scanner = sc;
    }

    /**
     * If user enters N (No), program will finish work, otherwise
     * program continues its work.
     * @return true if entered N (NO), otherwise return false.
     */
    boolean finish() {
        view.println("Do you want to add one more person to the notebook? ");
        view.println("Y/N");
        view.println("Enter: ");
        String input = scanner.nextLine();
        return input.equals("N");
    }

    /**
     * Reads and checks the input value.
     * @param message the message for print to the console.
     * @param regex the regular expression.
     * @return correct value.
     */
    String inputNote(String message, String regex) {
        view.println(message);
        String input;
        while ( !(scanner.hasNextLine() && (input = scanner.nextLine()).matches(regex))) {
            view.printErr(message);
        }
        return input;
    }
}
