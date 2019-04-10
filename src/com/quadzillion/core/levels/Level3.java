package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level3 extends Level {
    public Level3()
    {
        super();

        locs = new Point2D[4];

        locs[0] = new Point2D(4,3);
        locs[1] = new Point2D(4,7);
        locs[2] = new Point2D(8,5);
        locs[3] = new Point2D(8,9);

        forbidden = new Point2D[][]{
                {new Point2D(0,3),new Point2D(3,3)},
                {new Point2D(3,1),new Point2D(3,1)},
                {new Point2D(0,1),new Point2D(0,2)},
                {new Point2D(0,0),new Point2D(2,3)}};

    }

}