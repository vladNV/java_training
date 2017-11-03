/*
 *  GameDisplay
 *
 *  02.11.2017
 *
 *  created by Vlad
 */

package ua.training.view;

import ua.training.model.Game;

public class GameDisplay {

    public static String INTRODUCTION =
            "How to play this game.\nComputer has generated a number between 0 and 100.\n" +
                    "You guess what number it is. If your guess is\ntoo high or too low, computer will give you a hint." +
                    "\nIt will answer 'MORE' or 'LESS'. Good luck!\n";
    public static String VICTORY = "\nYou won!";
    private static String NOT_IN_RANGE = "You should enter number in range ";
    public static String INCORRECT = "Value is incorrect!\nEnter number: ";
    public static String MY_NUMBER = "Computer's number was ";
    public static String SEPARATOR = "\n==============================================\n";
    public static String BRACKET_LEFT = "[";
    public static String BRACKET_RIGHT = "]";
    public static String COMMA = ",";
    public static String ENTER = "Enter number: ";
    public static String WROTE = " your wrote - ";
    public static String MORE = "Computer: More!";
    public static String LESS = "Computer: Less!";
    public static String SHARP = "#";

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(String msg){
        System.out.print(msg);
    }

    public void printWrongRange(Game game) {
        System.out.print(NOT_IN_RANGE + BRACKET_LEFT
                           + game.getLeftSide() + COMMA
                           + game.getRightSide() + BRACKET_RIGHT
                           + "\n" + ENTER);
    }

    public void printRange(Game game) {
        System.out.println(BRACKET_LEFT + game.getLeftSide()
                           + COMMA + game.getRightSide() + BRACKET_RIGHT);
    }

}
