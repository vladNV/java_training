/*
 *  GameDisplay
 *
 *  02.11.2017
 *
 *  created by Vlad
 */

package ua.training.view;

public class GameDisplay {
    public static final String INTRODUCTION =
            "How to play this game.\nComputer has generated a number between 0 and 100.\n" +
            "You guess what number it is. If your guess is\ntoo high or too low, computer will give you a hint." +
            "\nIt will answer 'MORE' or 'LESS'. Good luck!";
    public static final String MORE = "Computer: More!";
    public static final String LESS = "Computer: Less!";
    public static final String WIN = "\nYou won!";
    public static final String INCORRECT = "Value is incorrect. You should enter number in range [0, 100].";
    public static final String MY_NUMBER = "Computer's number was ";
    public static final String SEPARATOR = "\n==============================================\n";

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(String msg){
        System.out.print(msg);
    }

}
