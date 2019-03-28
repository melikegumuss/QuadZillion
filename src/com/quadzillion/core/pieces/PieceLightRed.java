package com.quadzillion.core.pieces;

import javafx.scene.paint.Color;

public class PieceLightRed extends Piece
{
    public PieceLightRed(int x, int y)
    {
        super(x, y);
        color = Color.RED;
        data = new Piece.PieceData(2, 4);
        data.put(0, 0);
        data.put(1, 0);
        data.put(1, 1);
        data.put(1, 2);
        data.put(1, 3);
    }
}
