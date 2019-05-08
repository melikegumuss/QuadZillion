package com.quadzillion.core;

import com.quadzillion.gui.controller.MainMenuController;
import com.quadzillion.gui.controller.Util;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class AbstractPane extends Pane
{
    private static int seconds = 0;
    private static int minutes = 0;
    private static Label lblTime;
    private static AnimationTimer timer;

    public AbstractPane()
    {
        if (timer == null)
            createTimer();


        getChildren().add(lblTime);
    }

    public static void stopTimer()
    {
        if(timer!=null){
            timer.stop();
        }
    }

    public static void resetTimerAndStart()
    {
        minutes = 0;
        seconds = -1;
        lblTime.setText("Time: 0m 0s");
        if (timer != null)
            timer.start();
    }

    public static void createTimer()
    {
        lblTime = new Label("Time: 0m 0s");

        timer = new AnimationTimer() {

            long lastTime = 0;


            @Override
            public void handle(long now) {
                if (lastTime != 0) {
                    if (now > lastTime + 1_000_000_000) {
                        if(seconds < 59){
                            seconds++;
                        }
                        else{
                            seconds = 0;
                            minutes++;
                        }
                        lblTime.setText("Time: " + minutes + "m " + seconds + "s" );
                        lastTime = now;
                    }
                } else {
                    lastTime = now;
                }

                if (lblTime.getText().equals("Time: 59m 5s"))
                    ((MainMenuController)Util.getSceneController(Util.SCENE_MAIN_MENU)).onQuitButtonClicked();
            }

        };

        timer.start();
        lblTime.setLayoutX(700);
        lblTime.setLayoutY(50);
        Font font = new Font("Times New Roman",25);
        lblTime.setFont(font);
        lblTime.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73;");
    }

}
