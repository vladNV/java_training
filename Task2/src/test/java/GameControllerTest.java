import org.junit.Before;
import org.junit.Test;
import ua.training.model.Game;


public class GameControllerTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test(expected = RuntimeException.class)
    public void testRandom() {
       game.rand(20,10);
    }

}
