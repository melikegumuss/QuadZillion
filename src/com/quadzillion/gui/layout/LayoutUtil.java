package com.quadzillion.gui.layout;

import com.quadzillion.core.Game;
import com.quadzillion.gui.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LayoutUtil
{
    public static void setScene(ActionEvent ae, String name)
    {
        try
        {
            Stage stage = getStage(ae);
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

    public static Stage getStage(ActionEvent ae)
    {
        return (Stage)(((Node)(ae.getSource())).getScene().getWindow());
    }
}
