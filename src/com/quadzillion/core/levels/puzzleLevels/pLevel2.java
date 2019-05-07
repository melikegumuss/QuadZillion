package com.quadzillion.core.levels.puzzleLevels;

import com.quadzillion.core.levels.PuzzleLevel;
import javafx.geometry.Point2D;

public class pLevel2 extends PuzzleLevel {

    public pLevel2()
    {
        //68
        super();

        fileName = "pLevel2";

        int[][] temp = {
                { 10, 10, 12, 2, 3, 3, 3, 3},
                {8, 10, 12, 12, 12, 4, 14, 3},
                {8, 10, 10, 12, 2, 4, 14, 14},
                {8, 8, 8, 2, 4, 4, 4, 14},
                {5, 2, 2, 11, 2, 9, 9, 14},
                {5, 5, 11, 11, 11, 11, 9, 9},
                {7, 5, 7, 13, 13, 2, 6, 9},
                {7, 7, 7, 13, 13, 13, 6, 6}
        };

        solution = temp.clone();


        locs = new Point2D[4];

        locs[0] = new Point2D(4,4);
        locs[1] = new Point2D(8,4);
        locs[2] = new Point2D(4,8);
        locs[3] = new Point2D(8,8);


        forbidden = new Point2D[][]{
                {new Point2D(3,0),new Point2D(3,3)},
                {new Point2D(0,2),new Point2D(0,2)},
                {new Point2D(  1,0),new Point2D(2,0)},
                {new Point2D(0,0),new Point2D(1,2)}};

    }

}
