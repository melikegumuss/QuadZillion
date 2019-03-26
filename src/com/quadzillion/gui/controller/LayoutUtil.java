package com.quadzillion.gui.controller;

import com.quadzillion.core.Game;
import com.quadzillion.gui.GameApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LayoutUtil
{
    public static void setScene(String name)
    {
        try
        {
            Stage stage = GameApplication.getStage();
            stage.setScene(new Scene(
                    FXMLLoader.load(GameApplication.class.getResource("./layout/" + name + ".fxml")),
                    Game.getCurrent().getSettings().getWindowWidth(),
                    Game.getCurrent().getSettings().getWindowHeight()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
