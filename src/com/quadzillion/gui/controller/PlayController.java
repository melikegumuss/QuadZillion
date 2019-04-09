package com.quadzillion.gui.controller;

import com.quadzillion.core.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class PlayController implements Controllable
{
    @FXML
    public Button backButton;

    private Timeline endGameTimeline;
    private int iteration;

    @Override
    public void onCreate()
    {

    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onThemeChange()
    {

    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {
        Util.setScene(Util.SCENE_MAIN_MENU);
    }

    public void onGameSuccessfullyCompleted()
    {
        Scene currentScene = Util.getCurrentScene();
        BoxBlur blurEffect = new BoxBlur();
        blurEffect.setIterations(0);
        iteration = 0;
        float animationdurationMS = 2200;
        int cycleCount = 20;

        currentScene.getRoot().setEffect(blurEffect);


        endGameTimeline = new Timeline(new KeyFrame(Duration.millis(animationdurationMS / cycleCount), actionEvent ->
        {
            iteration++;
            blurEffect.setIterations(iteration);
        }));
        endGameTimeline.setCycleCount(cycleCount);
        endGameTimeline.play();
    }
}
