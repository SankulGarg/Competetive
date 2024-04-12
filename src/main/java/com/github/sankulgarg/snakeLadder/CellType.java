package com.github.sankulgarg.snakeLadder;

public enum CellType {
    SNAKE(true), LADDER(true), NORMAL(false);
    boolean isSpecial;

    CellType(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }
}
