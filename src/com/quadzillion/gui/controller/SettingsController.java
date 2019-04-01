package com.quadzillion.gui.controller;
import com.quadzillion.gui.GameApplication;
import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.quadzillion.gui.GameApplication.getStage;
//import static com.quadzillion.gui.GameApplication.isTheme;
import static com.quadzillion.gui.controller.MainMenuController.isMuted;
import static com.quadzillion.gui.controller.MainMenuController.mp;
//import static com.quadzillion.gui.controller.MainMenuController.tgl;
import com.quadzillion.gui.controller.MainMenuController;
public class SettingsController implements Initializable
{
    @FXML
    Button changeButton;
    @FXML
    Button backButton;
    @FXML
    Button defaultTheme;
    @FXML
    ToggleButton tgl2;
    private MainMenuController mc;
    @FXML private MainMenuController mainController;
    public static boolean isThemeChanged = false;
    //@FXML
    //private final MainMenuController mc = new MainMenuController();
    //@FXML
    //private final FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));


     public void initialize(URL location, ResourceBundle resources ){

         mc = new MainMenuController();
         final FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
         loader.setController(mc);

        tgl2.setSelected(isMuted);
        changeButton.setOnAction(e->{
            mc.changeTheme();
            isThemeChanged = true;
            //getStage().getScene().getStylesheets().add("/mainmenualternative.css");
        });
        backButton.setOnAction(e->{
            LayoutUtil.setScene("main_menu");
            if(isThemeChanged) mc.changeTheme();
            else mc.loadDefaultCSS();


        });
        tgl2.setOnAction(e->{
            if(tgl2.isSelected()){
                mp.setVolume(0);
                //mainController.setToggle(false);
                //System.out.println(mc.getToggle());
                //mc.getToggle().setSelected(false);
                isMuted = true;
            }
            else {
                mp.setVolume(100);
                //System.out.println(mc.getToggle());
                //mainController.setToggle(true);
                isMuted = false;
                //mc.getToggle().setSelected(false);
                //mc.print();
            }
        });
        defaultTheme.setOnAction(e->{
                setSettingsDefault();
                isThemeChanged = false;
        });


        //getStage().getScene().getStylesheets().add("/mainmenualternative.css"));
        //getStylesheets().add("/mainmenualternative.css"));
    }
    public void init(MainMenuController mainController){
        mc = mainController;
    }

    public void changeSettingsTheme(){
        getStage().getScene().getStylesheets().clear();
        getStage().getScene().getStylesheets().add("/mainmenualternative.css");
    }

    public void setSettingsDefault(){
        getStage().getScene().getStylesheets().clear();
        getStage().getScene().getStylesheets().add("mainmenu.css");
    }

//    public void onChangeTheme(){
//        GameApplication.getStage().getScene().getStylesheets().add("mainmenu.css");
//        isTheme = !isTheme;
//    }
//    public void onReturnToMainMenuButtonClicked()
//    {
//        LayoutUtil.setScene("main_menu");
//
//    }
}

//            else{
//                getStage().getScene().getStylesheets().clear();
//                getStage().getScene().getStylesheets().add("/mainmenualternative.css");
//                isThemeChanged = true;
//            }