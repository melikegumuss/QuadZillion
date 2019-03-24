package com.quadzillion.gui.controller;

import com.quadzillion.gui.layout.LayoutUtil;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

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
        String path = new File("src/Media/herbal.mp3").getAbsolutePath();
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
    public void onPlayButtonClicked(ActionEvent ae)
    {
        stopMusic();
        LayoutUtil.setScene(ae, "play");

    }

    public void onHowToPlayButtonClicked(ActionEvent ae)
    {

        LayoutUtil.setScene(ae, "how_to_play");
        stopMusic();

    }

    public void onSettingsButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "settings");
        stopMusic();
    }

    public void onCreditsButtonClicked(ActionEvent ae)
    {

        LayoutUtil.setScene(ae, "credits");
        mp.stop();

    }

    public void onQuitButtonClicked(ActionEvent ae)
    {

        LayoutUtil.getStage(ae).close();
        stopMusic();

    }


}
