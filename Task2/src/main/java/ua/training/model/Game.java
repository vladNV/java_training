/*
 * Game
 *
 * 02.11.2017
 *
 * created by Vlad
 */

package ua.training.model;

import java.util.Random;

import static ua.training.model.GameConst.RAND_MAX;

public class Game {
    private int number;
    private int leftSide;
    private int rightSide;
    private StringBuilder statistics;

    /**
     * Adds user's actions
     * @param action string value
     */
    public void addAction(String action) {
        statistics.append(action).append("\n");
    }

    public String getStatistics() {
        return statistics.toString();
    }

    public void setNumber(int number) {
        this.number = number;
        leftSide = 0;
        rightSide = RAND_MAX;
        statistics = new StringBuilder();
    }

    public void changeLeftSide(int value) {
        this.leftSide = value;
    }

    public void changeRightSide(int value) {
        this.rightSide = value;
    }

    public int getLeftSide() {
        return leftSide;
    }

    public int getRightSide() {
        return rightSide;
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

    /**
     * Returns a random number in range (0, RAND_MAX).
     * @return a random number in range (0, RAND_MAX).
     */
    public int rand() {
        return getRandomNumber(0, RAND_MAX);
    }

    /**
     * Returns random value in range (min, max).
     * If, min > max, throws runtime exception with message.
     * @param min a left side in range.
     * @param max a right side in range.
     * @return a integer random number.
     */

    public int rand(int min, int max) {
        if (min < 0 || max < 0) {
            throw new RuntimeException("Min or Max cannot be negative!");
        }
        if (min > max) {
            throw new RuntimeException("Max value is less then Min value!");
        }
        return getRandomNumber(min, max);
    }

    /**
     * Returns a random number in range (min, max)
     * @param min - start range (inclusive)
     * @param max - end range (inclusive)
     * @return returns a random integer number in range (min, max)
     */

    private int getRandomNumber(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

}
