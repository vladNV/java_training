/*
 *  GameController
 *
 *  02.11.2017
 *
 *  created by Vlad
 */

package ua.training.controller;

import ua.training.model.Game;
import ua.training.view.GameDisplay;

import java.util.Scanner;

public class GameController {

    /** Max value in range. 0x64 = 100 */
    public static final int RAND_MAX = 0x64;

    private Game game;
    private GameDisplay display;
    private StringBuilder statistics;

    public GameController(Game game, GameDisplay display) {
        this.game = game;
        this.display = display;
        statistics = new StringBuilder();
    }

    //Start game
    public void start() {
        final Scanner sc = new Scanner(System.in);

        // Computer generates a number;
        game.setNumber(rand());
        // You should guess it;
        display.println(GameDisplay.INTRODUCTION);
        inputNumber(sc);
        display.println(statistics.toString());
        // End
    }

    private void inputNumber(Scanner sc) {
        int enteredNumber;
        int actionNum = 0;
        String buffer;
        boolean finish = false;
        statistics.append(GameDisplay.SEPARATOR);
        while (!finish){
            display.print("\nEnter number: ");
            buffer = sc.nextLine();
            if (isGoodNumber(buffer)
                    && (enteredNumber = Integer.parseInt(buffer)) <= RAND_MAX) {
                statistics.append("#").append(++actionNum).append(":")
                        .append(" you wrote - ")
                        .append(enteredNumber).append("\n");
                switch (game.compareNumber(enteredNumber)) {
                    case  1:
                        display.println(GameDisplay.LESS);
                        break;
                    case  0:
                        display.println(GameDisplay.WIN);
                        display.println(GameDisplay.MY_NUMBER + game.getNumber());
                        finish = true;
                        break;
                    case  -1:
                        display.println(GameDisplay.MORE);
                        break;
                    default:
                        break;
                }
            } else {
                display.print(GameDisplay.INCORRECT);
            }
        }
    }

    /**
     * Checks input value. Check length and value of input.
     * @param input string value
     * @return true, if length of input less then RAND_MAX.length() + 1
     * and all chars are integer numbers, otherwise false.
     */
    private boolean isGoodNumber(String input) {
        if(input.length() < String.valueOf(RAND_MAX).length() + 1) {
            char inputArr[] = input.toCharArray();
            for (int i = 0; i < input.length(); i++) {
                if(inputArr[i] < '0' || inputArr[i] > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

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

    /**
     * Returns a random number in range (min, max)
     * @param min - start range (inclusive)
     * @param max - end range (inclusive)
     * @return returns a random integer number in range (min, max)
     */

    private int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }

}
