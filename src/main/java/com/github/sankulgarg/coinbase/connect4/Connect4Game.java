package com.github.sankulgarg.coinbase.connect4;

import java.util.Random;

public class Connect4Game {

	private Player[] players = { new Player("P1", Piece.R), new Player("P2", Piece.Y) };
	private Board board;
	private Move lastMove;
	private int currPlayer;
	Random ran = new Random();

	public Connect4Game() {
		super();

		board = new Board();
		currPlayer = 0;

	}

	private void play() {
		boolean winner = false;
		while (!board.isFull() && !winner) {
			winner = makeMove();
			if (!winner)
				currPlayer = (currPlayer + 1) % 2;

		}
		if (winner)
			System.out.println("winner is: " + players[currPlayer].name);
		else
			System.out.println("tied");
		board.show();
	}

	private boolean makeMove() {

		int c = getRandomInput();

		try {
			lastMove = board.moveAtCol(players[currPlayer], c);
		} catch (Exception e) {
			makeMove();
		}
		return WinningStrategy.checkWinningMove(board, lastMove);

	}

	public static void main(String[] args) {
		Connect4Game game = new Connect4Game();
		game.play();
	}

	private int getRandomInput() {
		return ran.nextInt(7);

	}

}
