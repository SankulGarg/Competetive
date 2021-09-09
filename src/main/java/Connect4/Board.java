package Connect4;

import java.util.Arrays;

public class Board {
	int height;
	int cols;

	private final Stone[][] field;

	public Board(int h, int c) {
		height = h;
		cols = c;

		field = new Stone[cols][height];
		for (Stone[] line : field) {
			Arrays.fill(line, Stone.EMPTY);
		}
	}

	public Stone[][] getStone(){
		return field;
	}
	public Move moveAtCol(int c, Player p) throws Exception {

		if (c >= cols)
			throw new Exception("invalid Move");
		Stone[] line = field[c];
		for (int i = 0; i < height; i++)
			if (line[i] == Stone.EMPTY) {
				line[i] = p.stone;
				return new Move(c, i, p.stone);
			}
		throw new Exception("invalid Move");
	}

	public void show() {
		// TODO Auto-generated method stub
		
	}

}
