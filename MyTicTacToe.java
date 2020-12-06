import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyTicTacToeGame {
	
	static ArrayList<Integer> playerXPositions = new ArrayList<Integer>();
	static ArrayList<Integer> playerOPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		System.out.println("Game Board Creation...");
		//Game Board
		char [][] gameBoard = {{' ','|', ' ', '|', ' '},
							{'-', '+', '-', '+', '-'},
							{' ','|', ' ', '|', ' '},
							{'-', '+', '-', '+', '-'},
							{' ','|', ' ', '|', ' '}};
		
		printGame(gameBoard);
		System.out.println();
		System.out.println("Board Created.");
		System.out.println("The game will start with player X");
		System.out.println();
		
		while(true) {
			Scanner scanX = new Scanner(System.in);
			System.out.println("Hi player X, enter your plosition:");
			int playerXPos = scanX.nextInt();
			while(playerXPos>9 || playerXPos<0) {
				System.out.println("Hi X, please enetr a position between 1 and 9:");
				playerXPos = scanX.nextInt();
			}
			while(playerXPositions.contains(playerXPos) || playerOPositions.contains(playerXPos))
			{
				System.out.println("Hey X,Position taken! Check the board and enter correct position...");
				playerXPos = scanX.nextInt();
			}
			fillSymbol(gameBoard, playerXPos, "playerX");
		
			String result = computeWinner();
			if(result.length()>0) {
				System.out.println();
				printGame(gameBoard);
				System.out.println(result);
				break;
			}
			
			Scanner scanO = new Scanner(System.in);
			System.out.println("Hi player O, enter your plosition:");
			int playerOPos = scanO.nextInt();
			while(playerOPos>9 || playerOPos<0) {
				System.out.println("Hi O, please enetr a position between 1 and 9:");
				playerOPos = scanO.nextInt();
			};
				
			while(playerXPositions.contains(playerOPos) || playerOPositions.contains(playerOPos))
			{
				System.out.println("o, Position taken! Check the borad and enter correct position...");
				playerOPos = scanO.nextInt();
			}
			fillSymbol(gameBoard, playerOPos, "playerO");
			
			printGame(gameBoard);
			result = computeWinner();
			if(result.length()>0) {
				System.out.println();
				printGame(gameBoard);
				System.out.println(result);
				break;
			}
		 }
		}
	public static void fillSymbol(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		if(user.equals("playerX")) {
			symbol = 'X';
			playerXPositions.add(pos);
		}
		else if(user.equals("playerO"))
		{
			symbol ='O';
			playerOPositions.add(pos);
		}
			
		
		switch(pos){
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
			}
	}
	
	public static String computeWinner()
	{
		List<Integer> firstRow = Arrays.asList(1,2,3);
		List<Integer> secondRow = Arrays.asList(4,5,6);
		List<Integer> thirdRow = Arrays.asList(7,8,9);
		List<Integer> firstColumn = Arrays.asList(1,4,7);
		List<Integer> secondColumn = Arrays.asList(2,5,8);
		List<Integer> thirdColumn = Arrays.asList(3,6,9);
		List<Integer> diagonal1 = Arrays.asList(1,5,9);
		List<Integer> diagonal2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(firstRow);
		winning.add(secondRow);
		winning.add(thirdRow);
		winning.add(firstColumn);
		winning.add(secondColumn);
		winning.add(thirdColumn);
		winning.add(diagonal1);
		winning.add(diagonal2);
		
		for(List l : winning) {
			if(playerXPositions.containsAll(l)) 
				return "PLAYER X WON";
			else if(playerOPositions.containsAll(l))
				return "PLAYER O WON!";
			else if(playerXPositions.size()+playerOPositions.size()==9)
				return "GAME ENDS WITH A DRAW!";
			
		}
		
				return "";
	}
	public static void printGame(char[][] gameBoard) {
	
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
