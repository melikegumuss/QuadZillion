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
import static com.quadzillion.gui.controller.SettingsController.isThemeChanged;
import com.quadzillion.gui.controller.MainMenuController;
import static com.quadzillion.gui.GameApplication.getStage;

public class CreditsController implements Initializable {
    private MainMenuController mc;
    @FXML
    private MediaPlayer mplay;
    @FXML
    private Media med;

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

        githubLink.setOnAction(e->handleLinkClick());
        getStage().getScene().getStylesheets().add("credits.css");
        mc = new MainMenuController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        loader.setController(mc);
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
        if(isThemeChanged)
            mc.changeTheme();
        else
            mc.loadDefaultCSS();
        mplay.stop();
        mp.play();

    }
}
