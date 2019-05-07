package com.quadzillion.gui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class PuzzleLevelsController implements Controllable
{


    public static int puzzleLevel;

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
    public void onLevelSelected(ActionEvent ae)
    {
        puzzleLevel = Integer.valueOf(((Button)ae.getSource()).getText().split(" ")[1]) - 1;

        // DO STUFF ABOUT LEVEL
        Util.addPuzzleGamePanel();
        Util.setScene(Util.SCENE_PLAY_GAME);
    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {

        Util.removePuzzleChildren();
        Util.setScene(Util.SCENE_MODES);
    }
}
