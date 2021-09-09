package com.github.sankulgarg.coinbase.connect4;

public enum Piece {

	E("."), R("R"), Y("Y");

	String representation;

	String getRep() {
		return representation;
	}
	Piece(String r) {
		this.representation = r;
	}

}
