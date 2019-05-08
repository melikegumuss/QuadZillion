package com.quadzillion.core.models;

public class Tile {

    public final static int VALID = 1;
    public final static int FORBID = 2;
    public final static int EMPTY = 0;


    public int getPiece() {
        return piece;
    }

    private int piece = -1;

    Tile(int piece) {
        this.piece = piece;
    }

    Tile piece(int piece) {
        this.piece = piece;
        return this;
    }

    public boolean equal(Tile tile) {
        return this == tile && tile.piece == this.piece;
    }


    @Override
    public String toString() {
        return super.toString() + piece;
    }
}
