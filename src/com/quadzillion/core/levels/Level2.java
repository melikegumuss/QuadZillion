package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level2 extends  Level {
    public Level2()
    {
        super();

        locs = new Point2D[4];

        locs[0] = new Point2D(0,2);
        locs[1] = new Point2D(4,0);
        locs[2] = new Point2D(8,2);
        locs[3] = new Point2D(4,4);

        forbidden = new Point2D[][]{
                {new Point2D(1,0),new Point2D(3,0)},
                {new Point2D(3,1),new Point2D(3,2)},
                {new Point2D(0,2),new Point2D(0,2)},
                {new Point2D(3,0),new Point2D(0,2)}};

    }


}
