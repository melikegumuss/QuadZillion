package com.quadzillion.core;

import com.quadzillion.core.levels.ExtendedLevel;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.GeneratedPiece;
import com.quadzillion.core.pieces.PuzzlePiece;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class ExtendedGamePane extends AbstractPane {


    /* public  int moveCounter = 0;
    public  Label counter;*/
    private int seconds;
    private int minutes;
    private AnimationTimer timer;

    public ExtendedGamePane(ExtendedLevel level) {
        super();
        MainBoard mainBoard = new MainBoard(level.getLocs(), 4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        int[][] solution = level.solution;

        GeneratedPiece gp3 = new GeneratedPiece(moveChecker, solution, Color.PURPLE, 3);
        GeneratedPiece gp4 = new GeneratedPiece(moveChecker, solution, Color.PINK, 4);
        GeneratedPiece gp5 = new GeneratedPiece(moveChecker, solution, Color.BLUE, 5);
        GeneratedPiece gp6 = new GeneratedPiece(moveChecker, solution, Color.GREEN, 6);
        GeneratedPiece gp7 = new GeneratedPiece(moveChecker, solution, Color.GOLD, 7);
        GeneratedPiece gp8 = new GeneratedPiece(moveChecker, solution, Color.INDIGO, 8);
        GeneratedPiece gp9 = new GeneratedPiece(moveChecker, solution, Color.NAVY, 9);
        GeneratedPiece gp10 = new GeneratedPiece(moveChecker, solution, Color.HOTPINK, 10);
        GeneratedPiece gp11 = new GeneratedPiece(moveChecker, solution, Color.CHOCOLATE, 11);
        GeneratedPiece gp12 = new GeneratedPiece(moveChecker, solution, Color.YELLOW, 12);


        getChildren().add(mainBoard);
        getChildren().add(gp3);
        getChildren().add(gp4);
        getChildren().add(gp5);
        getChildren().add(gp6);
        getChildren().add(gp7);
        getChildren().add(gp8);
        getChildren().add(gp9);
        getChildren().add(gp10);
        getChildren().add(gp11);
        getChildren().add(gp12);


        for (Node piece : getChildren()) {
            if (piece instanceof GeneratedPiece) {
                for (int i = 0; i < (int) ((Math.random()) * 4); i++) {
                    ((GeneratedPiece) piece).turn();
                }

                if (Math.random() < 0.5)
                    ((GeneratedPiece) piece).flip();
            }

        }
    }


}