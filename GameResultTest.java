package testing;
import game.MyTicTacToeGame;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameResultTest {

	@Test
	public void test() {
		MyTicTacToeGame game = new MyTicTacToeGame();
		String result = game.computeWinner();
		assertNotNull(result);
	}
}
