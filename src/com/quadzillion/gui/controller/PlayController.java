package com.quadzillion.gui.controller;

import com.quadzillion.core.Game;
import com.quadzillion.gui.layout.LayoutUtil;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class PlayController
{
    @FXML
    public Canvas canvas;

    private GraphicsContext graphics;
    private Timeline timeline;

    @FXML
    public void initialize()
    {
        graphics = canvas.getGraphicsContext2D();
        double delay = 1000 / Game.getCurrent().getSettings().getWindowRFPS();
        int width = Game.getCurrent().getSettings().getWindowWidth();
        int height = Game.getCurrent().getSettings().getWindowHeight();

        timeline = new Timeline(new KeyFrame(Duration.millis(delay), ae ->
        {
            Game.getCurrent().getRenderer().renderAll(graphics, width, height, delay);
            // System.out.println("heheh");
        }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Game.getCurrent().getRenderer().init();
    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {
        exitGameLoop();
        LayoutUtil.setScene("main_menu");
    }

    public void onMouseDragged(MouseEvent m)
    {
        Game.getCurrent().getGameObjects().forEach(sprite -> sprite.onMouseEvent(m));
    }

    public void exitGameLoop()
    {
        timeline.stop();
        int width = Game.getCurrent().getSettings().getWindowWidth();
        int height = Game.getCurrent().getSettings().getWindowHeight();
        Game.getCurrent().getRenderer().destroy(graphics, width, height);
    }


}
