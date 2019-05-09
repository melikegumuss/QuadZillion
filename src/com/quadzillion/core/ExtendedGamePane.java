package com.quadzillion.core;

import com.quadzillion.core.levels.ExtendedLevel;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.GeneratedPiece;
import com.quadzillion.core.pieces.PieceFactory;
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



        PieceFactory pieceFactory = new PieceFactory(level, moveChecker);
        getChildren().addAll(pieceFactory.buildPieces(PieceFactory.EXTENDED_PIECE));
        getChildren().add(mainBoard);



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