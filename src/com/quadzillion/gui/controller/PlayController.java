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
import com.quadzillion.core.PuzzleGamePane;
public class PlayController implements Controllable
{
    @FXML
    public Button backButton;

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
        Util.setScene(Util.SCENE_MODES);
        PuzzleGamePane.moveCounter = 0;
        Util.removeExtendedChildren();
        Util.removePuzzleChildren();
        Util.removeVanillaChildren();
    }

    public void onGameSuccessfullyCompleted()
    {

    }
}
