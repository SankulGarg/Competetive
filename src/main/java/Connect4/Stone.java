package Connect4;

enum Stone {
	EMPTY("."), RED("R"), YELLOW("Y");

	private final String image;

	Stone(String image) {
		this.image = image;

	}

	public String toString() {
		return String.format("[%s]", image);
	}
}