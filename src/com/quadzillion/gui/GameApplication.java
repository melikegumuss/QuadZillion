package com.quadzillion.gui;

import com.quadzillion.core.Settings;
import com.quadzillion.core.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GameApplication extends Application
{
    private static GameApplication instance;

    public static GameApplication getInstance()
    {
        return instance;
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        GameApplication.instance = this;
        Settings settings = Game.getCurrent().getSettings();
        Parent root = FXMLLoader.load(getClass().getResource("./layout/main_menu.fxml"));
        Scene scene = new Scene(
                root,
                settings.getWindowWidth(),
                settings.getWindowHeight());
        stage.setScene(scene);
        stage.setTitle("QuadZillion");
        stage.show();
    }
}
