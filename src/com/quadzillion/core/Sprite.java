package com.quadzillion.core;

import com.quadzillion.gui.controller.Inputable;
import javafx.scene.paint.Color;

public abstract class Sprite implements Renderer.Renderable, Inputable
{
    protected int x;
    protected int y;
    protected Color color;

    public Sprite()
    {
        x = 0;
        y = 0;
        color = Color.AQUAMARINE;
    }

    public Sprite(int x, int y)
    {
        this.x = x;
        this.y = x;
        color = Color.AQUAMARINE;
    }
}
