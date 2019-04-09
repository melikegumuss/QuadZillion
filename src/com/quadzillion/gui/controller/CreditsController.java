package com.quadzillion.gui.controller;
import com.quadzillion.gui.GameApplication;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import static com.quadzillion.gui.controller.MainMenuController.mp;
import static com.quadzillion.gui.GameApplication.getStage;

public class CreditsController implements Controllable
{
    private MainMenuController mc;

    @FXML
    private MediaPlayer mplay;

    @FXML
    private MediaView meView;

    @FXML
    private Hyperlink githubLink;

    @Override
    public void onCreate()
    {
        mplay = new MediaPlayer(new Media(Util.getMusicPathCredits()));
        meView = new MediaView();
        meView.setMediaPlayer(mplay);

        if(meView == null)
        {
            System.out.println("MEDIA IS NULL");
            return;
        }
        mplay.setAutoPlay(true);

        githubLink.setOnAction(e->handleLinkClick());
        mc = (MainMenuController) Util.getSceneController(Util.SCENE_MAIN_MENU);
    }

    @Override
    public void onDestroy()
    {
        if (mplay != null)
            mplay.dispose();
    }

    @Override
    public void onThemeChange()
    {

    }

    @FXML
    public void handleLinkClick(){
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/melikearslan/QuadZillion"));
        }
        catch(IOException e){
            e.printStackTrace();
        }catch (URISyntaxException e)
        {
            e.printStackTrace();
        }

    }

    public void onReturnToMainMenuButtonClicked()
    {
        mplay.stop();
        mp.play();
        Util.setScene(Util.SCENE_MAIN_MENU);
    }
}
