package com.quadzillion.gui.controller;

import com.quadzillion.core.Game;
import com.quadzillion.gui.GameApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LayoutUtil
{
    public static void setScene(String name)
    {

        try
        {
            Stage stage = GameApplication.getStage();
            //FXMLLoader fxmlLoader = GameApplication.class.getResource("./layout/" + name + ".fxml");
            Parent root = FXMLLoader.load(GameApplication.class.getResource("./layout/" + name + ".fxml"));
            Scene scene = new Scene(root,  Game.getCurrent().getSettings().getWindowWidth(), Game.getCurrent().getSettings().getWindowHeight());
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

  /*stage.setScene(new Scene(
                    FXMLLoader.load(GameApplication.class.getResource("./layout/" + name + ".fxml")),
                                    Game.getCurrent().getSettings().getWindowWidth(),
                                    Game.getCurrent().getSettings().getWindowHeight()));*/