package com.quadzillion.core.levels;

import com.quadzillion.core.pieces.*;

public class LevelOne extends GameObjectContainer
{
    public LevelOne()
    {
        super(c ->
        {
            c.pieces.add(new BoardPiece(250, 150){
                @Override
                public void putData()
                {
                    data.put(0, 0);
                    data.put(2, 0);
                }
            });
            c.pieces.add(new BoardPiece(450, 250){
                @Override
                public void putData()
                {
                    data.put(0, 0);
                    data.put(2, 1);
                }
            });
            c.pieces.add(new BoardPiece(450, 450){
                @Override
                public void putData()
                {
                    data.put(0, 0);
                    data.put(2, 1);
                }
            });
            c.pieces.add(new BoardPiece(650, 450){
                @Override
                public void putData()
                {
                    data.put(3, 2);
                }
            });

            c.pieces.add(new PieceYellow(500, 500));
            c.pieces.add(new PieceMagenta(700, 500));
            c.pieces.add(new PieceRed(100, 50));
            c.pieces.add(new PieceLightRed(250, 500));
        });
    }
}
