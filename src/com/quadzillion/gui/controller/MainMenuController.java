package com.quadzillion.gui.controller;

import com.quadzillion.gui.layout.LayoutUtil;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;


public class MainMenuController
{

    public void initialize()
    {

    }

    public void onPlayButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "play");
    }

    public void onHowToPlayButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "how_to_play");
    }

    public void onSettingsButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "settings");
    }

    public void onCreditsButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "credits");
    }

    public void onQuitButtonClicked(ActionEvent ae)
    {
        LayoutUtil.getStage(ae).close();
    }


}
