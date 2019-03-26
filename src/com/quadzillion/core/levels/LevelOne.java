package com.quadzillion.core.levels;

import com.quadzillion.core.pieces.PieceYellow;

public class LevelOne extends Level
{
    public LevelOne()
    {
        super(c ->
        {
            c.pieces.add(new PieceYellow(500, 500));
            c.pieces.add(new PieceYellow(700, 500));
        });
    }
}
