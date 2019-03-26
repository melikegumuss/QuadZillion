package com.quadzillion.gui.controller;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditsController implements Initializable {

    @FXML
    private MediaPlayer mplay;
    @FXML
    private Media med;
    @FXML
    Slider cSlider;
    @FXML
    private MediaView meView;
    @FXML
    private Hyperlink githubLink;
    @FXML public void initialize(URL location, ResourceBundle resources)
    {

        String credits = new File("./res/sounds/creditsSong.mp3").getAbsolutePath();
        med = new Media(new File(credits).toURI().toString());
        mplay = new MediaPlayer(med);
        meView = new MediaView();
        meView.setMediaPlayer(mplay);
        if(meView == null) {
            System.out.println("MEDIA IS NULL");
            return;
        }
        mplay.setAutoPlay(true);
        cSlider.setValue(mplay.getVolume() * 100);

        cSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mplay.setVolume(cSlider.getValue() / 100);
            }
        });
    }

    @FXML
    public void handleLinkClick(){
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/melikearslan/QuadZillion"));
        }
        catch(IOException e){
            e.printStackTrace();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

    }

    public void onReturnToMainMenuButtonClicked()
    {
        LayoutUtil.setScene("main_menu");
        mplay.stop();
    }
}
