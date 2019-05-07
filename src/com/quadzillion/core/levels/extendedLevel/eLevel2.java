package com.quadzillion.core.levels.extendedLevel;
import com.quadzillion.core.levels.*;
import javafx.geometry.Point2D;

import com.quadzillion.core.levels.PuzzleLevel;
import javafx.geometry.Point2D;

public class eLevel2 extends ExtendedLevel {

    public eLevel2()
    {
        super();


        int[][] temp = {
                {3, 4, 5, 2, 0, 0, 2, 7, 8 ,8},
                {3, 4, 4, 5, 0, 0, 7, 2, 7, 8},
                {3, 4, 4, 5, 0, 0, 6, 7,8,8},
                {2, 3, 4, 6, 6, 6, 6, 8,8,8},
                {0, 0, 0, 9, 2, 10, 10, 0,0,0},
                {0, 0, 0, 9, 9, 10, 10, 0,0,0},
                {0, 0, 0, 10, 10, 10, 10, 10,12,12},
                {0, 0, 0, 0, 0, 0,2, 11,12,12},
                {0, 0, 0, 0, 0, 0, 11, 11,12,2},
                {0, 0, 0, 0, 0, 0, 11, 11,12,12}
        };

        solution = temp.clone();

        locs = new Point2D[4];
        locs[0] = new Point2D(4,4);
        locs[1] = new Point2D(7,7);
        locs[2] = new Point2D(10,4);
        locs[3] = new Point2D(10,10);

        forbidden = new Point2D[][]{
                {new Point2D(3,0),new Point2D(0,3)},
                {new Point2D(1,1),new Point2D(1,1)},
                {new Point2D(0,0),new Point2D(1,1)},
                {new Point2D(0,1),new Point2D(3,2)}};

    }

}
