package com.quadzillion.core;

import com.quadzillion.core.levels.Level;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.*;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {

    private MainBoard mainBoard;
    private TileMatrix tileMatrix;
    private MoveChecker moveChecker;

    public GamePane(Level level)
    {

        MainBoard mainBoard = new MainBoard(level.getLocs(),4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        Piece circle = new RedPiece(moveChecker);
        Piece tpiece = new GreenPiece(moveChecker);
        Piece lightBlue = new LightBluePiece(moveChecker);
        Piece blue = new BluePiece(moveChecker);
        Piece purple = new PurplePiece(moveChecker);
        Piece lightLime = new LightLimePiece(moveChecker);
        Piece orange = new OrangePiece(moveChecker);
        Piece pink = new PinkPiece(moveChecker);
        Piece yellow = new YellowPiece(moveChecker);
        Piece darkBlue = new DarkBluePiece(moveChecker);
        Piece maroonPiece = new MaroonPiece(moveChecker);
        Piece darkGreen = new DarkGreenPiece(moveChecker);

        getChildren().add(mainBoard);
        getChildren().add(darkGreen);
        getChildren().add(maroonPiece);
        getChildren().add(purple);
        getChildren().add(lightBlue);
        getChildren().add(tpiece);
        getChildren().add(blue);
        getChildren().add(circle);
        getChildren().add(lightLime);
        getChildren().add(orange);
        getChildren().add(pink);
        getChildren().add(yellow);
        getChildren().add(darkBlue);

    }


    public boolean isFinished()
    {
        return tileMatrix.isFinished();
    }

}
