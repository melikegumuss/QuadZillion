package com.quadzillion.gui.controller;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public interface Inputable
{
    void onMouseEvent(MouseEvent me);
    void onKeyEvent(KeyEvent me);
}