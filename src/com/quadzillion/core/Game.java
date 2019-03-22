package com.quadzillion.core;

import com.quadzillion.gui.GameApplication;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Game
{
    private static Game current;
    private GameApplication gameApp;
    private Settings settings;
    private Renderer renderer;

    private class Sphere implements Renderer.Renderable
    {
        int x;
        int y;
        int r;

        public Sphere(int radius)
        {
            x = 100;
            y = 100;
            r = radius;
        }

        @Override
        public void init()
        {
        }

        @Override
        public void render(GraphicsContext g, int width, int height, double delta)
        {
            g.setFill(Color.BLUE);
            g.fillOval(x - r/2, y - r/2, r, r);
            g.setFill(Color.BLACK);
        }

        @Override
        public void destroy()
        {

        }
    }

    public Game()
    {
        // get things from a config file
        settings = new Settings(settings ->
        {
            settings.WINDOW_WIDTH = 600;
            settings.WINDOW_HEIGHT = 400;
            settings.WINDOW_RFPS = 60;
        });

        // start the game application
        Game.current = this;


        GameApplication.launch(GameApplication.class, null);

        gameApp = GameApplication.getInstance();
        renderer = new Renderer();
        // Add objects to renderer

        Sphere s1 = new Sphere(45);
        renderer.addObject(s1);
    }

    public GameApplication getGameApplication()
    {
        return gameApp;
    }

    public static Game getCurrent()
    {
        return current;
    }

    public Settings getSettings()
    {
        return settings;
    }

    public Renderer getRenderer()
    {
        return renderer;
    }
}
