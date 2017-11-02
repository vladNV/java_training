import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.Game;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testCompareNumber() {
        game.setNumber(20);
        Assert.assertEquals(0, game.compareNumber(20));
        Assert.assertEquals(1, game.compareNumber(21) );
        Assert.assertEquals(-1, game.compareNumber(19) );
    }

}
