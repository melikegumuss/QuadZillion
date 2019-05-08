package com.quadzillion.gui.controller;

import com.quadzillion.core.AbstractPane;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import com.quadzillion.core.PuzzleGamePane;
public class PlayController implements Controllable
{
    @FXML
    public Button backButton;
    @FXML
    public AnchorPane maxpayne;

    private Timeline endGameTimeline;
    private int iteration;

    @Override
    public void onCreate()
    {
        maxpayne.setVisible(false);
        AbstractPane.resetTimerAndStart();
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

        Util.setScene(Util.SCENE_MODES);
        PuzzleGamePane.moveCounter = 0;
        removeAll();



    }

    public void onGameSuccessfullyCompleted()
    {
        Scene currentScene = Util.getCurrentScene();
        maxpayne.setVisible(true);

        maxpayne.toFront();
        AbstractPane.stopTimer();
//        BoxBlur blurEffect = new BoxBlur();
//        blurEffect.setIterations(0);
//        iteration = 0;
//        float animationdurationMS = 2200;
//        int cycleCount = 20;
//
//        currentScene.getRoot().setEffect(blurEffect);
//
//
//        endGameTimeline = new Timeline(new KeyFrame(Duration.millis(animationdurationMS / cycleCount), actionEvent ->
//        {
//            iteration++;
//            blurEffect.setIterations(iteration);
//        }));
//        endGameTimeline.setCycleCount(cycleCount);
//        endGameTimeline.play();

    }

    public void onMainMenuClicked(){
        Util.setScene(Util.SCENE_MAIN_MENU);
        maxpayne.setVisible(false);
        removeAll();
    }

    // next level
    public void onModesClicked()
    {

        removeAll();
        Util.currentLevel = (Util.currentLevel + 1) % 3 ;
        onCreate();

        switch(Util.mode){
            case 1:
                Util.addVanillaGamePane();
                break;
            case 2:
                Util.addExtendedGamePane();
                break;
            case 3:
                Util.addPuzzleGamePanel();
                break;
        }
    }

    public void removeAll(){
        Util.removeExtendedChildren();
        Util.removePuzzleChildren();
        Util.removeVanillaChildren();
    }
}
