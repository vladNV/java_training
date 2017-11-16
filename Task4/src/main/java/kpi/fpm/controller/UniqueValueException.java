/*
 *  UniqueValueException
 *
 *  14.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.controller;

class UniqueValueException extends Exception {

    /**
     * It isn't unique value.
     */
    private String dataAlreadyExist;

    /**
     * Constructs an <code>UniqueValueException</code> with the
     * specified detail message.
     * @param message the detail message.
     * @param input the ins't unique value.
     */
    UniqueValueException(String message, String input) {
        super(message);
        dataAlreadyExist = input;
    }

    String getDataAlreadyExist() {
        return dataAlreadyExist;
    }
}
