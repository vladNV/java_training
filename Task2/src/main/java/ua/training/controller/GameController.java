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
    private Game game;
    private GameDisplay display;

    public GameController(Game game, GameDisplay display) {
        this.game = game;
        this.display = display;
    }

    //Play game
    public void play() {
        final Scanner sc = new Scanner(System.in);

        // Computer generates a number;
        game.setNumber(game.rand());
        // You should guess it;
        display.println(GameDisplay.INTRODUCTION);

        int attempt = 0;
        boolean finish = false;
        int number;
        game.addAction(GameDisplay.SEPARATOR);
        while (!finish) {
            display.print(GameDisplay.ENTER);
            switch ((game.compareNumber(number = inputNumber(sc)))) {
                case -1:
                    display.println(GameDisplay.MORE);
                    game.changeLeftSide(number);
                    display.printRange(game);
                    break;
                case  0:
                    finish = true;
                    break;
                case  1:
                    display.println(GameDisplay.LESS);
                    game.changeRightSide(number);
                    display.printRange(game);
                    break;
                default:
                    break;
            }
            game.addAction(GameDisplay.SHARP + (++attempt)
                           + GameDisplay.WROTE + number);
        }

        display.println(GameDisplay.VICTORY);
        display.println(game.getStatistics());

        // End
    }

    /**
     * Checks input value.
     * @param sc is input stream
     * @return the entered number in range.
     */
    private int inputNumber(Scanner sc) {
        int enteredNumber;
        while (true) {
            while (!sc.hasNextInt()) {
                display.print(GameDisplay.INCORRECT);
                sc.next();
            }
            if ((enteredNumber = sc.nextInt()) < game.getLeftSide()
                    || enteredNumber > game.getRightSide()) {
                display.printWrongRange(game);
                continue;
            }
            break;
        }
        return enteredNumber;
    }

}
