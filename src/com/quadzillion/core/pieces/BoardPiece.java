package com.quadzillion.core.pieces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class BoardPiece extends Piece
{
    public BoardPiece(int x, int y)
    {
        super(x, y);
        color = Color.WHITE;
        data = new Piece.PieceData(4, 4);
    }

    @Override
    public void render(GraphicsContext g, int width, int height, double delta)
    {
        g.setFill(Color.BLACK);
        g.fillRect(x - radius / 2 - radius, y - radius - radius / 2, 4 * radius, 4 * radius);

        for (int i = 0; i < data.getHeight(); i++)
        {
            for (int j = 0; j < data.getWidth(); j++)
            {
                int xx = (x - radius / 2) - (j - data.getHeight() / 2) * radius;
                int yy = (y - radius / 2) - (i - data.getWidth() / 2) * radius;

                if (data.get(j, i))
                    g.setFill(color);
                else
                    g.setFill(Color.rgb(40, 40, 40));
                g.fillOval(xx, yy, radius, radius);
            }
        }
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {

    }

    public abstract void putData();
}
