package Connect4;

public class Player {
	String name;
	Stone stone;

	public Player(String name, Stone stone) {
		this.name = name;
		this.stone = stone;
	}

	public String name() {
		return name;
	}

	public Stone getStone() {
		return stone;
	}
}
