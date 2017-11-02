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

    public int compareNumber(int number) {
        if(number == this.number) return 0;
        int dif = this.number - number;
        return -dif/Math.abs(dif);
    }

}
