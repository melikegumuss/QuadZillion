package com.quadzillion.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Renderer
{
    public interface Renderable
    {
        void init();
        void render(GraphicsContext g, int width, int height, double delta);
        void destroy();
    }

    public static void init()
    {
        for (Renderable r : Game.getCurrent().getCurrentLevel().getContainer().pieces)
            r.init();
    }

    public static void renderAll(GraphicsContext g, int width, int height, double delta)
    {
        clear(g, width, height);
        // Render boards then pieces

        for (Renderable r : Game.getCurrent().getCurrentLevel().getContainer().pieces)
            r.render(g, width, height, delta);
    }

    public static void destroy(GraphicsContext g, int width, int height)
    {
        for (Renderable r : Game.getCurrent().getCurrentLevel().getContainer().pieces)
            r.destroy();
        clear(g, width, height);
    }

    private static void clear(GraphicsContext graphics, int width, int height)
    {
        graphics.setFill(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setFill(Color.BLACK);
    }


}
