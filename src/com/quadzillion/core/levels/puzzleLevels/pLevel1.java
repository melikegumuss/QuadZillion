package com.quadzillion.core.levels.puzzleLevels;

import com.quadzillion.core.levels.PuzzleLevel;
import javafx.geometry.Point2D;

public class pLevel1 extends PuzzleLevel {

    public pLevel1() {
        super();

        fileName = "pLevel1";

        int[][] temp = {
                {2, 7, 7, 7, 4, 4, 4, 11},
                {2, 7, 10, 7, 13, 4, 11, 11},
                {10, 10, 10, 13, 13, 4, 2, 11},
                {10, 9, 9, 13, 13, 12, 2, 11},
                {9, 9, 8, 6, 12, 12, 3, 3},
                {9, 2, 8, 6, 6, 12, 12, 3},
                {8, 8, 8, 14, 14, 5, 5, 3},
                {2, 14, 14, 14, 5, 5, 2, 3}
        };

        solution = temp.clone();

        locs = new Point2D[4];

        locs[0] = new Point2D(4, 4);
        locs[1] = new Point2D(8, 4);
        locs[2] = new Point2D(4, 8);
        locs[3] = new Point2D(8, 8);

        forbidden = new Point2D[][]{
                {new Point2D(0, 0), new Point2D(0, 1)},
                {new Point2D(2, 2), new Point2D(2, 3)},
                {new Point2D(1, 1), new Point2D(0, 3)},
                {new Point2D(2, 3), new Point2D(2, 3)}};


    }


}
