package com.quadzillion.core.levels.extendedLevel;

import com.quadzillion.core.levels.ExtendedLevel;
import javafx.geometry.Point2D;

public class eLevel1 extends ExtendedLevel {

    public eLevel1() {
        super();


        int[][] temp = {
                {3, 2, 4, 4, 0, 0, 0, 0, 0, 0},
                {3, 3, 4, 4, 0, 0, 0, 0, 0, 0},
                {3, 5, 5, 6, 6, 6, 0, 0, 0, 0},
                {5, 5, 5, 5, 6, 7, 0, 0, 0, 0},
                {0, 0, 2, 8, 7, 7, 8, 9, 0, 0},
                {0, 0, 2, 8, 8, 8, 8, 9, 0, 0},
                {0, 0, 0, 0, 10, 2, 10, 9, 12, 2},
                {0, 0, 0, 0, 10, 10, 10, 9, 11, 12},
                {0, 0, 0, 0, 0, 0, 11, 11, 11, 12},
                {0, 0, 0, 0, 0, 0, 11, 11, 12, 2}
        };

        solution = temp.clone();

        locs = new Point2D[4];
        locs[0] = new Point2D(4, 4);
        locs[1] = new Point2D(6, 6);
        locs[2] = new Point2D(8, 8);
        locs[3] = new Point2D(10, 10);

        forbidden = new Point2D[][]{
                {new Point2D(1, 0), new Point2D(1, 0)},
                {new Point2D(0, 2), new Point2D(0, 3)},
                {new Point2D(1, 2), new Point2D(1, 2)},
                {new Point2D(3, 0), new Point2D(3, 3)}};

    }

}
