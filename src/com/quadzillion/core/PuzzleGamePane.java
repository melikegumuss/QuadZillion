package com.quadzillion.core;

import com.quadzillion.core.levels.Level;
import com.quadzillion.core.levels.PuzzleLevel;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.models.PuzzleMainBoard;
import com.quadzillion.core.models.TileMatrix;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.pieces.PuzzlePiece;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

        public class PuzzleGamePane extends Pane {

            private MainBoard mainBoard;
            private TileMatrix tileMatrix;
            private MoveChecker moveChecker;
            public static int moveCounter = 0;
            public static Label counter;

            public PuzzleGamePane(PuzzleLevel level)
            {

                PuzzleMainBoard mainBoard = new PuzzleMainBoard(level.getLocs(),4, level.getForbidden());
                TileMatrix tileMatrix = new TileMatrix(mainBoard);
                MoveChecker moveChecker = new MoveChecker(tileMatrix);

        int[][] solution = level.solution;


        mainBoard.putImageToPoints(level.forbiddenUrls());


        PuzzlePiece pc3 = new PuzzlePiece(moveChecker,solution,3, level.getFileName());
        PuzzlePiece pc4 = new PuzzlePiece(moveChecker,solution,4, level.getFileName());
        PuzzlePiece pc5 = new PuzzlePiece(moveChecker,solution,5, level.getFileName());
        PuzzlePiece pc6 = new PuzzlePiece(moveChecker,solution,6, level.getFileName());
        PuzzlePiece pc7 = new PuzzlePiece(moveChecker,solution,7, level.getFileName());
        PuzzlePiece pc8 = new PuzzlePiece(moveChecker,solution,8, level.getFileName());
        PuzzlePiece pc9 = new PuzzlePiece(moveChecker,solution,9, level.getFileName());
        PuzzlePiece pc10 = new PuzzlePiece(moveChecker,solution,10, level.getFileName());
        PuzzlePiece pc11 = new PuzzlePiece(moveChecker,solution,11, level.getFileName());
        PuzzlePiece pc12 = new PuzzlePiece(moveChecker,solution,12, level.getFileName());
        PuzzlePiece pc13 = new PuzzlePiece(moveChecker,solution,13, level.getFileName());
        PuzzlePiece pc14 = new PuzzlePiece(moveChecker,solution,14, level.getFileName());


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

        for ( Node piece : getChildren())
        {
            if( piece instanceof PuzzlePiece) {
                for (int i = 0; i < (int) ((Math.random()) * 4); i++) {
                    ((PuzzlePiece) piece).turn();
                }

                if (Math.random() < 0.5)
                    ((PuzzlePiece) piece).flip();
            }

        }

        counter = new Label();
        counter.setText("Move Count: " + moveCounter );
        counter.setLayoutX(500);
        counter.setLayoutY(50);

        getChildren().add(counter);

    }
}
