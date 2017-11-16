/*
 *  InputController
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.controller;

import kpi.fpm.model.Model;
import kpi.fpm.view.View;

import java.util.Scanner;


/**
 * This class accompanies data entry.
 */
class InputController {

    private final Model model;
    /**
     * Visualization
     */
    private final View view;
    /**
     * Input stream.
     */
    private final Scanner scanner;

    InputController(final Scanner sc, final View view, final Model model) {
        this.view = view;
        this.scanner = sc;
        this.model = model;
    }

    /**
     * If user enters N (No), program will finish work, otherwise
     * program continues its work.
     * @return true if entered N (NO), otherwise return false.
     */
    boolean finish() {
        view.println("Do you want to add one more person to the notebook? ");
        view.println("Y/N");
        view.print("Enter: ");
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

    /**
     * Returns login, if it is correct and unique. If login isn't unique,
     * throws runtime exception, that such login already exists.
     * @param message the message for print to the console.
     * @param regex the regular expression.
     * @return correct and unique login.
     * @throws UniqueValueException if this login isn't unique.
     */
    String inputLogin(String message, String regex) throws UniqueValueException {
        String login = inputNote(message, regex);
        if(model.containsLogin(login))
            throw new UniqueValueException("Such login already exists!", login);
        return login;
    }

}
