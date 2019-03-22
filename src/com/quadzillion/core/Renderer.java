package com.quadzillion.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Renderer
{
    public interface Renderable
    {
        void init();
        void render(GraphicsContext g, int width, int height, double delta);
        void destroy();
    }

    private ArrayList<Renderable> renderables = new ArrayList<>();

    public void init()
    {
        for (Renderable r : renderables)
            r.init();
    }

    public void renderAll(GraphicsContext g, int width, int height, double delta)
    {
        clear(g, width, height);
        for (Renderable r : renderables)
            r.render(g, width, height ,delta);
    }

    public void destroy(GraphicsContext g, int width, int height)
    {
        for (Renderable r : renderables)
            r.destroy();
        clear(g, width, height);
    }

    public void addObject(Renderable r)
    {
        renderables.add(r);
    }

    private void clear(GraphicsContext graphics, int width, int height)
    {
        graphics.setFill(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setFill(Color.BLACK);
    }

}
