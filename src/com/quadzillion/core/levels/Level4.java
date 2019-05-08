package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level4 extends Level {
    public Level4() {
        super();

        locs = new Point2D[4];

        locs[0] = new Point2D(6, 3);
        locs[1] = new Point2D(10, 3);
        locs[2] = new Point2D(2, 7);
        locs[3] = new Point2D(6, 7);

        forbidden = new Point2D[][]{
                {new Point2D(3, 1), new Point2D(3, 2)},
                {new Point2D(3, 0), new Point2D(1, 1)},
                {new Point2D(0, 2), new Point2D(0, 2)},
                {new Point2D(1, 0), new Point2D(3, 0)}};

    }


}
