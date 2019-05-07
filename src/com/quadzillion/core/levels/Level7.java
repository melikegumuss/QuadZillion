package com.quadzillion.core.levels;

import javafx.geometry.Point2D;

public class Level7 extends  Level {
    public Level7()
    {
        super();

        locs = new Point2D[4];

        /*locs[0] = new Point2D(4,4);
        locs[1] = new Point2D(8,4);
        locs[2] = new Point2D(4,8);
        locs[3] = new Point2D(8,8);*/

        locs[0] = new Point2D(4,4);
        locs[1] = new Point2D(6,4);
        locs[2] = new Point2D(6,8);
        locs[3] = new Point2D(8,8);


        /*forbidden = new Point2D[][]{
                {new Point2D(-100,-100),new Point2D(-100,-100)},
                {new Point2D(-100,-100),new Point2D(-100,-100)},
                {new Point2D(-100,-100),new Point2D(-100,-100)},
                {new Point2D(-100,-100),new Point2D(-100,-100)}};*/


        forbidden = new Point2D[][]{
                {new Point2D(0,0),new Point2D(0,1)},
                {new Point2D(2,2),new Point2D(2,3)},
                {new Point2D(1,1),new Point2D(0,3)},
                {new Point2D(2,3),new Point2D(2,3)}};

    }


}
