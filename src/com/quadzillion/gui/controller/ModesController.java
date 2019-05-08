package com.quadzillion.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.fxml.Initializable;

public class ModesController implements Controllable {


    public static int mode;

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
    public void onModeSelected(ActionEvent ae)
    {
        Util.mode = Integer.valueOf(((Button)ae.getSource()).getId());
        switch(Util.mode){
            case 1:
                Util.setScene(Util.SCENE_VANILLA_LEVELS);
                break;
            case 2:
                Util.setScene(Util.SCENE_EXTENDED_LEVELS);
                break;
            case 3:
                Util.setScene(Util.SCENE_PUZZLE_LEVELS);
                break;
        }


//        mode = Integer.valueOf(((Button)ae.getSource()).getText().split(" ")[1]) - 1;
//
//        // DO STUFF ABOUT MODE
//        Util.removeChildren();
//        Util.addGamePanel();
//        Util.setScene(Util.SCENE_PLAY_GAME);


    }

    @FXML
    public void onReturnToMainMenuButtonClicked()
    {
        Util.setScene(Util.SCENE_MAIN_MENU);
    }
}
