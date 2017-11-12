/*
 *  ViewText
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.view;

/**
 * The interface, set of text constants.
 */

public interface ViewText {

    String FIRST_NAME =   "Enter first name, start with uppercase, use only letters and '-'.\n" +
                          "For example, 'John', 'Andrew'.";

    String SURNAME_NAME = "Enter surname name, start with uppercase, use only letters and '-'.\n" +
                          "For example, 'Simpson', 'Gosling'.";

    String SECOND_NAME =  "Enter second name, start with uppercase, use only letters and '-'.\n" +
                          "For example, 'Philip', 'Jay'.";

    String LOGIN =        "Create a username with only alphanumeric characters. and '_'.";

    String COMMENT =      "Enter a comment.";

    String MOBILE_UA =    "Enter phone number. In UA format.\n" +
                          "For example, +38099126375, 0503293200, 099-31-68-585, etc.";

    String EMAIL =        "Enter email. Please provide a valid email address.";

    String SKYPE =        "Enter skype with only alphanumeric characters.";

    String CITY =         "Enter city of residence. Start with uppercase.";

    String ADDRESS =      "Enter address with only letters, space, ',', '.' and '-'" +
                          "For example, 'Marine Pkwy'.";

    String HOUSE =        "Enter number of house, use 1-4 numbers and 1-2 letters, also can use /. and '-'\n" +
                          "For example, '23A', '9/3'.";

    String CONTACT_GROUP = "Select a group for this contact.\n" +
                          "For example, 'Coworker', 'Friend'";

    String INDEX =        "Enter index, only numbers.";

    String FLAT =         "Enter number of flat. If it is private house. Enter 0";


}
