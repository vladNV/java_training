/*
 * Game
 *
 * 02.11.2017
 *
 * created by Vlad
 */

package ua.training.model;

public class Game {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * This method compares the param number and the guess number.
     * @param number is a integer number
     * @return 0 if the param number and the guess number are equal, 1 if
     * the param number more then the guess number, and -1 if the param
     * number less then the guess number.
     */
    public int compareNumber(int number) {
        if(number == this.number) return 0;
        int dif = this.number - number;
        return -dif/Math.abs(dif);
    }

}
