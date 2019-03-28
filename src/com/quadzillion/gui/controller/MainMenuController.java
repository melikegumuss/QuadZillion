package com.quadzillion.gui.controller;

import com.quadzillion.gui.GameApplication;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable
{
    @FXML
    private MediaView mView;
    @FXML
    private MediaPlayer mp;
    @FXML
    private Media me;
    @FXML
    Slider volumeSlider;

    public void initialize(URL location, ResourceBundle resources)
    {
        String path = new File("./res/sounds/herbal.mp3").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mView.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        volumeSlider.setValue(mp.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mp.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }
    public  void stopMusic(){
        mp.stop();
    }
    public void onPlayButtonClicked()
    {
        stopMusic();
        LayoutUtil.setScene("play");

    }

    public void onHowToPlayButtonClicked()
    {

        LayoutUtil.setScene("how_to_play");
        stopMusic();

    }

    public void onSettingsButtonClicked()
    {
        LayoutUtil.setScene("settings");
        stopMusic();
    }

    public void onCreditsButtonClicked()
    {

        LayoutUtil.setScene("credits");
        mp.stop();

    }
    //Clicking X button also calls this method
    public void onQuitButtonClicked()
    {
        GameApplication.getStage().close();
        
        System.out.println("Quit button clicked");
    }


}
