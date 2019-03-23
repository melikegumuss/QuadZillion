package com.quadzillion.core;

import com.quadzillion.gui.controller.Inputtable;
import javafx.scene.paint.Color;

public abstract class Sprite implements Renderer.Renderable, Inputtable
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    public Sprite()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        color = Color.AQUAMARINE;
    }
}
