package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level5 extends Level {
    public Level5() {
        super();

        locs = new Point2D[4];

        locs[0] = new Point2D(3, 0);
        locs[1] = new Point2D(1, 4);
        locs[2] = new Point2D(5, 6);
        locs[3] = new Point2D(7, 2);

        /*forbidden = new Point2D[][]{
                {new Point2D(0,0),new Point2D(3,0)},
                {new Point2D(2,3),new Point2D(2,3)},
                {new Point2D(0,1),new Point2D(0,2)},
                {new Point2D(3,0),new Point2D(1,1)}};*/

        forbidden = new Point2D[][]{
                {new Point2D(-100, -100), new Point2D(-100, -100)},
                {new Point2D(-100, -100), new Point2D(-100, -100)},
                {new Point2D(-100, -100), new Point2D(-100, -100)},
                {new Point2D(-100, -100), new Point2D(-100, -100)}};


    }


}
