package com.quadzillion.core;

import com.quadzillion.gui.controller.MainMenuController;
import com.quadzillion.gui.controller.Util;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class AbstractPane extends Pane {
    private static int seconds = 0;
    private static int minutes = 0;
    private static int moveCount = 0;
    private static Label lblTime;
    private static AnimationTimer timer;

    public AbstractPane() {
        if (timer == null)
            createTimer();


        getChildren().add(lblTime);
    }

    public static void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    public static void resetTimerAndStart() {
        minutes = 0;
        seconds = 0;
        moveCount = 0;
        if (timer != null)
            timer.start();
    }

    public static void incrementMove() {
        moveCount++;
    }

    public static void createTimer() {
        lblTime = new Label("Move Count: 0 \tTime: 0m 0s");

        timer = new AnimationTimer() {

            long lastTime = 0;


            @Override
            public void handle(long now) {
                lblTime.setText("Move Count: " + moveCount + "\t Time: " + minutes + "m " + seconds + "s");
                if (lastTime != 0) {
                    if (now > lastTime + 1_000_000_000) {
                        if (seconds < 59) {
                            seconds++;
                        } else {
                            seconds = 0;
                            minutes++;
                        }
                        lblTime.setText("Move Count: " + moveCount + "\t Time: " + minutes + "m " + seconds + "s");
                        lastTime = now;
                    }
                } else {
                    lastTime = now;
                }

                if (minutes == 59 && seconds == 59)
                    ((MainMenuController) Util.getSceneController(Util.SCENE_MAIN_MENU)).onQuitButtonClicked();
            }

        };

        timer.start();
        lblTime.setLayoutX(450);
        lblTime.setLayoutY(50);
        Font font = new Font("Times New Roman", 25);
        lblTime.setFont(font);
        lblTime.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73;");
    }

}
