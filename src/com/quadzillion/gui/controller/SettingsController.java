package com.quadzillion.gui.controller;
import com.quadzillion.core.Game;
import com.quadzillion.gui.GameApplication;
import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.quadzillion.gui.GameApplication.getStage;
//import static com.quadzillion.gui.GameApplication.isTheme;
import static com.quadzillion.gui.controller.MainMenuController.isMuted;
import static com.quadzillion.gui.controller.MainMenuController.mp;
//import static com.quadzillion.gui.controller.MainMenuController.tgl;
import com.quadzillion.gui.controller.MainMenuController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SettingsController implements Controllable
{
    @FXML
    Button backButton;
    @FXML
    Slider slider;
    @FXML
    ToggleButton tgl2;

    @FXML
    ListView<String> themeList;

    ObservableList<String> themes;

    private String selectedTheme;


    @Override
    public void onCreate()
    {
        tgl2.setSelected(isMuted);

        backButton.setOnAction(e ->
        {
            Util.setScene(Util.SCENE_MAIN_MENU);
        });

        // Get available themes here!
        themes = FXCollections.observableArrayList("Vanilla", "Exotic", "Dark");
        themeList.setItems(themes);
        themeList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> selectedTheme = t1);

        slider.setValue(mp.getVolume());

        slider.setMin(0);
        slider.setMax(1);
        slider.setOnMouseDragged(mouseEvent -> slider());
        slider.setOnMouseClicked(mouseEvent -> slider());

        tgl2.setOnAction(e ->
        {
            if (tgl2.isSelected())
            {
                mp.setVolume(0);
                slider.setValue(0);
                isMuted = true;
            }
            else
            {
                mp.setVolume(100);
                slider.setValue(100);
                isMuted = false;
            }
        });
    }


    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onThemeChange()
    {

    }

    public void onApplyThemeButtonClicked()
    {
        if (selectedTheme != null)
            if (selectedTheme.equals("Vanilla"))
                Util.applyTheme(Util.THEME_VANILLA);
            else if (selectedTheme.equals("Dark"))
                Util.applyTheme(Util.THEME_DARK);
            else if (selectedTheme.equals("Exotic"))
                Util.applyTheme(Util.THEME_EXOTIC);
    }

    public void slider(){
        mp.setVolume(slider.getValue());
        if (slider.getValue() == 0)
        {
            isMuted = true;
            tgl2.setSelected(true);
        }
        else
        {
            tgl2.setSelected(false);
        }
    }


}