package com.quadzillion.core.pieces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

@SuppressWarnings("unused")
public class PieceYellow extends Piece
{
    public PieceYellow(int x, int y)
    {
        super(x, y);
        color = Color.YELLOW;
        data = new Piece.PieceData(2, 4);
        data.put(1, 0);
        data.put(0, 1);
        data.put(1, 1);
        data.put(1, 2);
        data.put(1, 3);
    }
}
