package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level6 extends Level {
    public Level6() {
        super();

        locs = new Point2D[4];

        locs[0] = new Point2D(2, 6);
        locs[1] = new Point2D(6, 6);
        locs[2] = new Point2D(6, 2);
        locs[3] = new Point2D(10, 6);

        forbidden = new Point2D[][]{
                {new Point2D(0, 1), new Point2D(0, 1)},
                {new Point2D(1, 0), new Point2D(3, 3)},
                {new Point2D(3, 1), new Point2D(3, 3)},
                {new Point2D(0, 0), new Point2D(2, 1)}};

    }


}
