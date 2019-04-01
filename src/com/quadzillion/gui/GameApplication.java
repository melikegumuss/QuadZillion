package com.quadzillion.gui;

import com.quadzillion.core.Settings;
import com.quadzillion.core.Game;
import com.quadzillion.gui.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GameApplication extends Application
{
    private static GameApplication instance;
    private static Stage primaryStage;
    public static Stage getStage(){
        return primaryStage;
    }
    
    public static GameApplication getInstance()
    {
        return instance;
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        GameApplication.instance = this;
        primaryStage = stage;
        Settings settings = Game.getCurrent().getSettings();
        Parent root = FXMLLoader.load(getClass().getResource("./layout/main_menu.fxml"));
        Scene scene = new Scene(
                root,
                settings.getWindowWidth(),
                settings.getWindowHeight());

        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/mainmenu.css").toExternalForm());
        primaryStage.setTitle("QuadZillion");
        primaryStage.show();

        // MainMenuController mc = fxmlLoader.getController();

        // primaryStage.setOnCloseRequest(e->mc.onQuitButtonClicked());
    }
}
