/*
 *  GameController
 *
 *  02.11.2017
 *
 *  created by Vlad
 */

package ua.training.controller;

public class GameController {
    public static final int RAND_MAX = 0x64;

    public int rand() {
        return getRandomNumber(0, RAND_MAX);
    }

    public int rand(int min, int max) {
        if (min < 0 || max < 0) {
            throw new RuntimeException("Min or Max cannot be negative!");
        }
        if (min > max) {
            throw new RuntimeException("Max value is less then Min value!");
        }
        return getRandomNumber(min, max);
    }

    private int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }

}
