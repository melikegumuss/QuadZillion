package com.quadzillion.gui.controller;
import com.quadzillion.gui.layout.LayoutUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;

public class HowToPlayController implements Initializable {
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnStop;
    @FXML
    private MediaView mediaView;
    @FXML
    MediaPlayer mediaPlayer;

    public void initialize(URL url, ResourceBundle rb){
        //String videoUrl = "file:/C:/Users/berk/Desktop/tutorialVideo.mp4";
        String videoUrl = new File("src/Media/tutorialVideo.mp4").getAbsolutePath();
        Media media = new Media(new File(videoUrl).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setFitHeight(700);
        mediaView.setFitWidth(1000);
        mediaView.setMediaPlayer(mediaPlayer);

    }
    @FXML
    private void onClickStop(){
        mediaPlayer.pause();
    }
    @FXML
    private void onClickPlay(){
        if(mediaPlayer.getStatus() == PLAYING){
            mediaPlayer.stop();
            mediaPlayer.play();
        }
        else{
            mediaPlayer.play();
        }

    }

    public void onReturnToMainMenuButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "main_menu");
        mediaPlayer.stop();
    }
}
