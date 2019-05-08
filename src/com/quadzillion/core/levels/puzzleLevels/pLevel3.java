package com.quadzillion.core.levels.puzzleLevels;

import com.quadzillion.core.levels.PuzzleLevel;
import javafx.geometry.Point2D;

public class pLevel3 extends PuzzleLevel {

    public pLevel3() {
        super();

        fileName = "pLevel3";

        int[][] temp = {
                {4, 3, 3, 3, 3, 7, 7, 7},
                {4, 4, 4, 2, 3, 7, 5, 7},
                {4, 14, 14, 14, 6, 6, 5, 5},
                {14, 14, 10, 2, 6, 2, 2, 5},
                {10, 10, 10, 12, 2, 8, 8, 8},
                {10, 9, 9, 12, 12, 8, 13, 13},
                {9, 9, 12, 12, 11, 8, 13, 13},
                {9, 2, 11, 11, 11, 11, 2, 13}
        };

        solution = temp.clone();

        locs = new Point2D[4];
        locs[0] = new Point2D(4, 4);
        locs[1] = new Point2D(8, 4);
        locs[2] = new Point2D(4, 8);
        locs[3] = new Point2D(8, 8);

        forbidden = new Point2D[][]{
                {new Point2D(3, 1), new Point2D(3, 3)},
                {new Point2D(1, 3), new Point2D(2, 3)},
                {new Point2D(1, 3), new Point2D(1, 3)},
                {new Point2D(0, 0), new Point2D(2, 3)}};

    }

}
