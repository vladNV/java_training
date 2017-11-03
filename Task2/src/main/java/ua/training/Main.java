package ua.training;

import ua.training.controller.GameController;
import ua.training.model.Game;
import ua.training.view.GameDisplay;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        GameDisplay display = new GameDisplay();
        GameController controller = new GameController(game, display);

        controller.play();

    }
}
