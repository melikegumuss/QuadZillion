package com.quadzillion.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

@SuppressWarnings("unused")
public class Renderer
{
    public interface Renderable
    {
        void init();
        void render(GraphicsContext g, int width, int height, double delta);
        void destroy();
    }

    public Renderer()
    {
        Game.getCurrent().getGameObjects().add(new Piece()
        {
            @Override
            public void onMouseEvent(MouseEvent me)
            {
                if ((x - me.getX()) * (x - me.getX()) + (y - me.getY()) * (y - me.getY()) <= width * height)
                {
                    x = (int) me.getX();
                    y = (int) me.getY();
                }
            }

            @Override
            public void init()
            {
                x = 100;
                y = 100;
                width = height = 50;
            }

            @Override
            public void render(GraphicsContext g, int w, int h, double delta)
            {
                g.setFill(Color.AQUAMARINE);
                g.fillOval(x - width / 2.0, y - height / 2.0, width, height);
            }
        });
        System.out.println(Game.getCurrent().getGameObjects());
    }

    public void init()
    {
        for (Renderable r : Game.getCurrent().getGameObjects())
            r.init();
    }

    public void renderAll(GraphicsContext g, int width, int height, double delta)
    {
        clear(g, width, height);
        for (Renderable r : Game.getCurrent().getGameObjects())
            r.render(g, width, height, delta);
    }

    public void destroy(GraphicsContext g, int width, int height)
    {
        for (Renderable r : Game.getCurrent().getGameObjects())
            r.destroy();
        clear(g, width, height);
    }

    private void clear(GraphicsContext graphics, int width, int height)
    {
        graphics.setFill(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setFill(Color.BLACK);
    }


}
