package com.quadzillion.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;


public class ExtendedLevelsController implements Controllable
{


    public static int extendedLevel;

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
        extendedLevel = Integer.valueOf(((Button)ae.getSource()).getText().split(" ")[1]) - 1;

        // DO STUFF ABOUT LEVEL
        Util.addExtendedGamePane();
        Util.setScene(Util.SCENE_PLAY_GAME);
    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {
        Util.removeExtendedChildren();
        Util.setScene(Util.SCENE_MODES);
    }
}