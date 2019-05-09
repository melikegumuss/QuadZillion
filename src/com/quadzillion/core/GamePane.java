package com.quadzillion.core;

import com.quadzillion.core.levels.Level;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.*;

import java.util.ArrayList;

public class GamePane extends AbstractPane {

    private MainBoard mainBoard;
    private TileMatrix tileMatrix;
    private MoveChecker moveChecker;

    public GamePane(Level level) {
        super();
        MainBoard mainBoard = new MainBoard(level.getLocs(), 4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        PieceFactory pieceFactory = new PieceFactory(level, moveChecker);

        getChildren().addAll(pieceFactory.buildPieces(PieceFactory.VANILLA_PIECE));
        getChildren().add(mainBoard);




    }


    public boolean isFinished() {
        return tileMatrix.isFinished();
    }

}
