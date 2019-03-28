package com.quadzillion.core.levels;

import com.quadzillion.core.pieces.*;

public class LevelOne extends Level
{
    public LevelOne()
    {
        super(c ->
        {
            c.pieces.add(new BoardPiece(250, 500){
                @Override
                public void putData()
                {

                }
            });

            c.pieces.add(new PieceYellow(500, 500));
            c.pieces.add(new PieceMagenta(700, 500));
            c.pieces.add(new PieceRed(100, 50));
            c.pieces.add(new PieceLightRed(250, 500));
        });
    }
}
