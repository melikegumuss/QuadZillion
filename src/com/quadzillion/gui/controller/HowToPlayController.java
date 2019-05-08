package com.quadzillion.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import static com.quadzillion.gui.controller.MainMenuController.mp;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;

public class HowToPlayController implements Controllable {
    private MainMenuController mc;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnStop;

    @FXML
    private MediaView mediaView;

    @FXML
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        mediaPlayer = new MediaPlayer(new Media(Util.getVideoPath()));

        mediaView.setFitHeight(700);
        mediaView.setFitWidth(1000);
        mediaView.setMediaPlayer(mediaPlayer);

        mc = (MainMenuController) Util.getSceneController(Util.SCENE_MAIN_MENU);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onThemeChange() {

    }

    @FXML
    private void onClickStop() {
        mediaPlayer.pause();
    }

    @FXML
    private void onClickPlay() {
        if (mediaPlayer.getStatus() == PLAYING) {
            mediaPlayer.stop();
            mediaPlayer.play();
        } else {
            mediaPlayer.play();
        }

    }

    public void onReturnToMainMenuButtonClicked() {
        mp.play();
        mediaPlayer.pause();
        Util.setScene(Util.SCENE_MAIN_MENU);
    }
}
