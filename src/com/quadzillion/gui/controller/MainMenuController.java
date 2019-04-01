package com.quadzillion.gui.controller;

import com.quadzillion.gui.GameApplication;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import static com.quadzillion.gui.controller.SettingsController.isThemeChanged;

import static com.quadzillion.gui.GameApplication.getStage;



public class MainMenuController implements Initializable
{
    //Controllers
    //@FXML
    SettingsController sc;
    @FXML HowToPlayController ht;
    //@FXML CreditsController cr;
    static int counter = 0;
    //Buttons
    //@FXML
    //private static  MediaView mView;

    private static final String PATH = new File("./res/sounds/herbal.mp3").getAbsolutePath();
    private static final Media me = new Media(new File(PATH).toURI().toString());
    public static final  MediaPlayer mp = new MediaPlayer(me);
    public static boolean isMuted = false;



    @FXML
    public  ToggleButton tgl;
    @FXML
    private  Button settingsButton;

    public void initialize(URL location, ResourceBundle resources)
    {
        //if(counter == 0) counter++;
        createMediaPlayer();

        //sc.init(this);

        sc = new SettingsController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        loader.setController(sc);
//
        ht = new HowToPlayController();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("settings.fxml"));
        loader2.setController(ht);
//
//
//        cr = new CreditsController();
//        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("settings.fxml"));
//        loader3.setController(cr);


        settingsButton.setOnAction(e-> onSettingsButtonClicked());

        tgl.setOnAction(e-> toggleFunc());
        tgl.setSelected(isMuted);

    }

    public void setToggle(boolean value){
        tgl.setSelected(value);
    }

    public ToggleButton getToggle(){
        return tgl;
    }
    public void print(){

        System.out.println("SELECTED");
            System.out.println("NOT SELECTED");
    }
    public void changeTheme(){
        getStage().getScene().getStylesheets().clear();
        getStage().getScene().getStylesheets().add("/mainmenualternative.css");
    }

    public void toggleFunc(){
        if(tgl.isSelected()) {
            mute();
            isMuted = true;
        }
        else {
            unmute();
            isMuted = false;
        }
    }

    public void onPlayButtonClicked()
    {
        LayoutUtil.setScene("play");
        mp.dispose();
    }

    public void loadDefaultCSS(){
        getStage().getScene().getStylesheets().clear();
        getStage().getScene().getStylesheets().add("/mainmenu.css");
    }

    public void destroy(){
        mp.dispose();
    }
    public void onHowToPlayButtonClicked()
    {
        LayoutUtil.setScene("how_to_play");
        ht.setTheme();
        mp.pause();
    }

    public void mute(){
        mp.setVolume(0);
    }
    public void unmute(){
        mp.setVolume(100);
    }
    public void onSettingsButtonClicked()
    {
        LayoutUtil.setScene("settings");
        if(isThemeChanged) sc.changeSettingsTheme();
        else sc.setSettingsDefault();
        //destroy();
    }

    public void onCreditsButtonClicked()
    {
        LayoutUtil.setScene("credits");

        mp.pause();

    }
    //Clicking X button also calls this method
    public void onQuitButtonClicked()
    {
        GameApplication.getStage().close();
        System.out.println("Quit button clicked");
    }

    public  void pauseMusic(){
        mp.pause();
    }
    public void playMusic(){ mp.play(); }
    public void stopMusic( ){ mp.stop(); }
    public void createMediaPlayer(){

        //mView.setMediaPlayer(mp);
        //mp.play();
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
    }
}

