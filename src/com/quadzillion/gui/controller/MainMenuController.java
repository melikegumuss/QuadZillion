package com.quadzillion.gui.controller;

import com.quadzillion.gui.GameApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class MainMenuController implements Controllable {
    public static MediaPlayer mp;
    public static boolean isMuted = false;

    @FXML
    public ToggleButton tgl;
    @FXML
    private Button settingsButton;

    @Override
    public void onCreate() {
        if (mp == null) {
            mp = new MediaPlayer(new Media(Util.getMusicPath()));
            mp.setCycleCount(MediaPlayer.INDEFINITE);
            //mp.play();
        }


        settingsButton.setOnAction(e -> onSettingsButtonClicked());

        tgl.setOnAction(e -> toggleFunc());
        tgl.setSelected(isMuted);

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onThemeChange() {

    }

    public void toggleFunc() {
        if (tgl.isSelected()) {
            mp.setVolume(0);
            isMuted = true;
        } else {
            mp.setVolume(100);
            isMuted = false;
        }
    }

    public void onPlayButtonClicked() {
        Util.setScene(Util.SCENE_MODES);
    }

    public void onHowToPlayButtonClicked() {
        mp.pause();
        Util.setScene(Util.SCENE_HOW_TO_PLAY);
    }

    public void onSettingsButtonClicked() {
        Util.setScene(Util.SCENE_SETTINGS);
    }

    public void onCreditsButtonClicked() {
        mp.pause();
        Util.setScene(Util.SCENE_CREDITS);
    }

    public void onQuitButtonClicked() {
        mp.dispose();
        GameApplication.getStage().close();
    }



}

