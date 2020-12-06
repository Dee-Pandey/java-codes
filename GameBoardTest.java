package testing;
import game.MyTicTacToeGame;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void test() {
		MyTicTacToeGame game = new MyTicTacToeGame();
		int size = 0;
		for (int row = 0; row < game.getGameBoard().length; row++) { 
			for (int col = 0; col < game.getGameBoard()[row].length; col++) {
			 if(game.getGameBoard()[row][col]!='-' && game.getGameBoard()[row][col]!='+' && game.getGameBoard()[row][col]!='|')
				size+=1;
				} 
		}
		assertEquals(9, size);

	}

}
