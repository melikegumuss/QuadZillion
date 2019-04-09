package com.quadzillion.core.levels;

import javafx.geometry.Point2D;
import javafx.scene.Group;


public abstract class Level{

    protected Point2D[] locs;

    protected Point2D[][] forbidden;

    public Level()
    {

    }

    public Point2D[] getLocs() {
        return locs;
    }

    public Point2D[][] getForbidden() {
        return forbidden;
    }


}
