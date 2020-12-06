package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import game.MyTicTacToeGame;

public class GameInputsTest {

	@Test
	public void test() {
		MyTicTacToeGame game = new MyTicTacToeGame();
		Boolean s=true;
		for (int row = 0; row < game.getGameBoard().length; row++)  
			for (int col = 0; col < game.getGameBoard()[row].length; col++) {
			 if(game.getGameBoard()[row][col]!='-' && game.getGameBoard()[row][col]!='+' && game.getGameBoard()[row][col]!='|' && (game.getGameBoard()[row][col]<0 && game.getGameBoard()[row][col]>9))
			 {
				 s=false;
				 break;
			} 
		}
		assertEquals(true, s);
		
	}

}
