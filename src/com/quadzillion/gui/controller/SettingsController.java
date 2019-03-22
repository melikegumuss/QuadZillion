package com.quadzillion.gui.controller;

import com.quadzillion.gui.layout.LayoutUtil;
import javafx.event.ActionEvent;

public class SettingsController
{
    public void onReturnToMainMenuButtonClicked(ActionEvent ae)
    {
        LayoutUtil.setScene(ae, "main_menu");
    }
}
