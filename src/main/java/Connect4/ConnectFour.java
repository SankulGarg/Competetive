package Connect4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// we are going to create a simple 2-players Connect Four implementation in Java 8
public class ConnectFour {

	Scanner scanner = new Scanner(System.in);
	// we define characters for players (R for Red, Y for Yellow)
	private static final Player[] PLAYERS = { new Player("1", Stone.RED), new Player("2", Stone.YELLOW) };

	// grid for the board
	private final Board board;
	// we store last move made by a player
	private Move lastMove;
	private int currentPlayer;

	public ConnectFour(int h, int c) {

		board = new Board(h, c);

	}

	private void play() {
		Player winner = null;
		while (winner == null) {

			winner = nextMove();
			currentPlayer = (currentPlayer + 1) % 2;
		}
	}

	private Player nextMove() {
		board.show();
		int playersColumn = getUserInput();
		try {
			lastMove = board.moveAtCol(playersColumn, PLAYERS[currentPlayer]);

		} catch (Exception e) {
			System.out.println("try again");
			nextMove();
		}
		return winningMove(lastMove) ? PLAYERS[currentPlayer] : null;
	}

	private boolean winningMove(Move move) {
	
		return checkLine(move)||checkHorizontal(move);
	}
	
	private boolean checkHorizontal(Move move) {
		
		
		return false;
	}

	private boolean checkLine(Move lastMove) {
		int ind= lastMove.h;
		int count=0;
		Stone[] line = board.getStone()[lastMove.c];
		while(ind>=0&&line[ind]==lastMove.stone)
		{
			count++;
			ind--;
		}
		return count>=4;
	}

	private int getUserInput() {
		System.out.print(String.format("%s, please select a column", PLAYERS[currentPlayer].name()));
		int playersColumn = scanner.nextInt() - 1;
		return playersColumn;
	}

}