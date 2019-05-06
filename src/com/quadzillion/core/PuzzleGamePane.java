package com.quadzillion.core;

import com.quadzillion.core.levels.Level;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.PuzzlePiece;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PuzzleGamePane extends Pane {

    private MainBoard mainBoard;
    private TileMatrix tileMatrix;
    private MoveChecker moveChecker;
    public static int moveCounter = 0;
    public static Label counter;
    private int seconds;
    private int minutes;
    private AnimationTimer timer;

    public PuzzleGamePane(Level level) {

        MainBoard mainBoard = new MainBoard(level.getLocs(), 4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        int[][] solution = {
                {2, 7, 7, 7, 4, 4, 4, 11},
                {2, 7, 10, 7, 13, 4, 11, 11},
                {10, 10, 10, 13, 13, 4, 2, 11},
                {10, 9, 9, 13, 13, 12, 2, 11},
                {9, 9, 8, 6, 12, 12, 3, 3},
                {9, 2, 8, 6, 6, 12, 12, 3},
                {8, 8, 8, 14, 14, 5, 5, 3},
                {2, 14, 14, 14, 5, 5, 2, 3}
        };

        PuzzlePiece pc3 = new PuzzlePiece(moveChecker, solution, 3);
        PuzzlePiece pc4 = new PuzzlePiece(moveChecker, solution, 4);
        PuzzlePiece pc5 = new PuzzlePiece(moveChecker, solution, 5);
        PuzzlePiece pc6 = new PuzzlePiece(moveChecker, solution, 6);
        PuzzlePiece pc7 = new PuzzlePiece(moveChecker, solution, 7);
        PuzzlePiece pc8 = new PuzzlePiece(moveChecker, solution, 8);
        PuzzlePiece pc9 = new PuzzlePiece(moveChecker, solution, 9);
        PuzzlePiece pc10 = new PuzzlePiece(moveChecker, solution, 10);
        PuzzlePiece pc11 = new PuzzlePiece(moveChecker, solution, 11);
        PuzzlePiece pc12 = new PuzzlePiece(moveChecker, solution, 12);
        PuzzlePiece pc13 = new PuzzlePiece(moveChecker, solution, 13);
        PuzzlePiece pc14 = new PuzzlePiece(moveChecker, solution, 14);


        getChildren().add(mainBoard);
        getChildren().add(pc3);
        getChildren().add(pc4);
        getChildren().add(pc5);
        getChildren().add(pc6);
        getChildren().add(pc7);
        getChildren().add(pc8);
        getChildren().add(pc9);
        getChildren().add(pc10);
        getChildren().add(pc11);
        getChildren().add(pc12);
        getChildren().add(pc13);
        getChildren().add(pc14);

        counter = new Label();
        counter.setText("Move Count: " + moveCounter);
        counter.setLayoutX(450);
        counter.setLayoutY(50);

        getChildren().add(counter);


        //Timer
        Label lblTime = new Label("Time: 0m 0s");
        seconds = 0;
        minutes = 0;
        timer = new AnimationTimer() {

            private long lastTime = 0;

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
            }

        };
        timer.start();
        lblTime.setLayoutX(650);
        lblTime.setLayoutY(50);
        Font font = new Font("Times New Roman",25);
        lblTime.setFont(font);
        counter.setFont(font);
        lblTime.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73;");
        counter.setStyle("-fx-font-weight: bold; -fx-text-fill: #853c73 ;");

        Label label = new Label();




        getChildren().add(lblTime);


    }
}