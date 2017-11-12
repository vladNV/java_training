/*
 *  Controller
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.controller;

import kpi.fpm.model.ContactGroup;
import kpi.fpm.model.Model;
import kpi.fpm.model.Note;
import kpi.fpm.view.View;
import kpi.fpm.view.ViewText;
import static kpi.fpm.controller.RegularExpression.*;

import java.util.Scanner;

/**
 * This class provides data into the model and updates the view whenever
 * data changes. This class also checks data for correctness.
 */
public class Controller {

    /**
     * Model's visualization.
     */
    private View view;
    /**
     * Business logic. Notebook.
     */
    private Model model;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    // start program
    public void userProcess() {

        Scanner scanner = new Scanner(System.in);
        InputController input  = new InputController(scanner, view);

        while (true) {
            // about person
            String firstName = input.inputNote(ViewText.FIRST_NAME, REGEXP_NAME);
            String surname = input.inputNote(ViewText.SURNAME_NAME, REGEXP_NAME);
            String secondName = input.inputNote(ViewText.SECOND_NAME, REGEXP_NAME);
            String login = input.inputNote(ViewText.LOGIN, REGEXP_LOGIN);
            String comment = input.inputNote(ViewText.COMMENT, REGEXP_COMMENT);
            view.println("-----Group-----");
            view.printEnum(ContactGroup.values());
            view.println("---------------");
            ContactGroup contact = ContactGroup.valueOf(
                    input.inputNote(ViewText.CONTACT_GROUP,
                            REGEXP_CONTACT_GROUP));
            String mobilePhone = input.inputNote(ViewText.MOBILE_UA,
                    REGEXP_MOBILE_NUMBER_UA);
            String email = input.inputNote(ViewText.EMAIL, REGEXP_EMAIL);
            String skype = input.inputNote(ViewText.SKYPE, REGEXP_SKYPE);

            // person address
            int index = Integer.valueOf(input.inputNote(ViewText.INDEX, REGEXP_NUMBER));
            String city = input.inputNote(ViewText.CITY, REGEXP_CITY);
            String street = input.inputNote(ViewText.ADDRESS, REGEXP_ADDRESS);
            String house = input.inputNote(ViewText.HOUSE, REGEXP_NUM_HOUSE);
            String flat = input.inputNote(ViewText.FLAT, REGEXP_NUMBER);

            Note note = new Note(firstName, surname, secondName, login,
                    comment, contact, mobilePhone, skype,
                    email, index, city, street, house, flat);
            model.add(note);

            // it is all?
            if(input.finish()) break;
        }
        view.printList(model.getNotebook());
        scanner.close();


    }


}
