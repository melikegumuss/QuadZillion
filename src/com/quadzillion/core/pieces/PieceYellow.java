package com.quadzillion.core.pieces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class PieceYellow extends Piece
{
    public PieceYellow(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void render(GraphicsContext g, int width, int height, double delta)
    {
        g.setFill(color);
        g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        if (me.getEventType() == MouseEvent.MOUSE_DRAGGED)
        {

        }
    }
}
