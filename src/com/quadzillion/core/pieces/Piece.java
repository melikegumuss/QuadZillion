package com.quadzillion.core.pieces;


import com.quadzillion.core.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class Piece extends Sprite
{
    public static class PieceData
    {
        private int width;
        private int height;
        private boolean[] data;

        public PieceData(int width, int height)
        {
            this.width = width;
            this.height = height;
            this.data = new boolean[width * height];
        }

        public void put(int x, int y)
        {
            data[(y) * width + (x)] = true;
        }

        public boolean get(int x, int y)
        {
            return data[(y) * width + (x)];
        }

        public int getWidth()
        {
            return width;
        }

        public int getHeight()
        {
            return height;
        }
    }

    protected PieceData data;
    protected int radius;

    public Piece(int x, int y)
    {
        super(x, y);
        radius = 50;
    }

    @Override
    public void init()
    {

    }

    @Override
    public void render(GraphicsContext g, int width, int height, double delta)
    {
        g.setFill(color);
        for (int i = 0; i < data.getHeight(); i++)
        {
            for (int j = 0; j < data.getWidth(); j++)
            {
                if (data.get(j, i))
                    g.fillOval(
                            (x - radius / 2) - (j - data.getHeight() / 2) * radius,
                            (y - radius / 2) - (i - data.getWidth() / 2) * radius,
                            radius,
                            radius);
            }
        }
    }

    @Override
    public void onMouseEvent(MouseEvent me)
    {
        int r2 = radius * radius;
        int mx = (int) me.getX();
        int my = (int) me.getY();

        if (me.getEventType() == MouseEvent.MOUSE_DRAGGED)
        {
            if (Math.pow(x - radius / 2 - mx, 2) <= r2 && Math.pow(y - radius / 2 - my, 2) <= r2)
            {
                x = mx;
                y = my;
            }
            /*
            for (int i = 0; i < data.getHeight(); i++)
            {
                for (int j = 0; j < data.getWidth(); j++)
                {
                    if (    data.get(j, i) &&
                            Math.pow(((mx - x - radius / 2) - (j - data.getHeight() / 2) * radius), 2) <= r2 &&
                            Math.pow(((my - y - radius / 2) - (i - data.getWidth() / 2) * radius), 2) <= r2)
                    {
                        x = mx;
                        y = my;
                    }
                }
            }
            */
        }

        oldMouseX = mx;
        oldMouseY = my;
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
