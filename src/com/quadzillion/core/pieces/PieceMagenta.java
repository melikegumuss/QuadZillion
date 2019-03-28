package com.quadzillion.core.pieces;

import javafx.scene.paint.Color;

public class PieceMagenta extends Piece
{
    public PieceMagenta(int x, int y)
    {
        super(x, y);
        color = Color.DARKMAGENTA;
        data = new Piece.PieceData(3, 3);
        data.put(0, 0);
        data.put(1, 0);
        data.put(1, 1);
        data.put(2, 1);
        data.put(2, 2);
    }
}
