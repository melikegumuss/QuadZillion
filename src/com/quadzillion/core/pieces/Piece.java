package com.quadzillion.core.pieces;


import com.quadzillion.core.Sprite;
import javafx.scene.input.KeyEvent;

public abstract class Piece extends Sprite
{
    protected static class PieceData
    {
        public int width;
        public int height;

        public boolean[] pieceData;

        public PieceData(int widthOdd, int heightOdd, boolean[] pieceData)
        {
            this.width = widthOdd;
            this.height = heightOdd;

            if (pieceData.length != width * height)
                this.pieceData = new boolean[width * height];
            else
                this.pieceData = pieceData;
        }
    }

    protected PieceData data;
    protected int radius;

    public Piece(int x, int y)
    {
        super(x, y);
        radius = 30;
    }

    @Override
    public void init()
    {

    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void onKeyEvent(KeyEvent me)
    {

    }
}
