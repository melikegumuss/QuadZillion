package com.quadzillion.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EndGameController implements Controllable {
    @FXML
    public Button replay;

    @FXML
    public Button home;

    @FXML
    public Button next;


    @Override
    public void onCreate() {
        replay.setOnAction(e ->
        {
            // TODO:
        });
        home.setOnAction(e -> Util.loadScene(Util.SCENE_MAIN_MENU));
        next.setOnAction(e -> {
        });
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onThemeChange() {

    }


}
