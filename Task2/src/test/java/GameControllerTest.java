import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.controller.GameController;
import ua.training.model.Game;
import ua.training.view.GameDisplay;

import static org.junit.Assert.*;

public class GameControllerTest {

    private GameController controller;

    @Before
    public void setUp() {
        controller = new GameController(new Game(), new GameDisplay());
    }

    @Test(expected = RuntimeException.class)
    public void testRandom() {
        controller.rand(20,10);
    }

}
