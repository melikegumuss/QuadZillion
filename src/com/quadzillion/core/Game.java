package com.quadzillion.core;

import com.quadzillion.core.levels.Level;
import com.quadzillion.gui.GameApplication;

public class Game
{
    private static Game current;
    private GameApplication gameApp;
    private Settings settings;
    private Renderer renderer;

    private Level gameLevel;

    public Game()
    {
        // get things from a config file
        settings = new Settings(settings ->
        {
            settings.WINDOW_WIDTH = 1280;
            settings.WINDOW_HEIGHT = 720;
            settings.WINDOW_RFPS = 60;
        });

        // start the game application
        Game.current = this;

        renderer = new Renderer();
        gameApp = GameApplication.getInstance();
        // Add pieces to render here!

        GameApplication.launch(GameApplication.class, "");
    }

    @SuppressWarnings("unused")
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

    public Level getCurrentLevel()
    {
        return gameLevel;
    }
}
