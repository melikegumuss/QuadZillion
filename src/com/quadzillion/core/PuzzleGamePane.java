package com.quadzillion.core;

import com.quadzillion.core.levels.PuzzleLevel;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.PuzzleMainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.PieceFactory;
import com.quadzillion.core.pieces.PuzzlePiece;
import javafx.scene.Node;

public class PuzzleGamePane extends AbstractPane {

    private MainBoard mainBoard;
    private TileMatrix tileMatrix;
    private MoveChecker moveChecker;

    public PuzzleGamePane(PuzzleLevel level) {
        super();
        PuzzleMainBoard mainBoard = new PuzzleMainBoard(level.getLocs(), 4, level.getForbidden());
        TileMatrix tileMatrix = new TileMatrix(mainBoard);
        MoveChecker moveChecker = new MoveChecker(tileMatrix);

        mainBoard.putImageToPoints(level.forbiddenUrls());

        PieceFactory pieceFactory = new PieceFactory(level, moveChecker);
        getChildren().addAll(pieceFactory.buildPieces(PieceFactory.PUZZLE_PIECE));
        getChildren().add(mainBoard);


        for (Node piece : getChildren()) {
            if (piece instanceof PuzzlePiece) {
                for (int i = 0; i < (int) ((Math.random()) * 4); i++) {
                    ((PuzzlePiece) piece).turn();
                }

                if (Math.random() < 0.5)
                    ((PuzzlePiece) piece).flip();
            }

        }

    }
}
