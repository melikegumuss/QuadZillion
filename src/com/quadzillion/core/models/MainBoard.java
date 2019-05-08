package com.quadzillion.core.models;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainBoard extends Group {

    public static final double xLayout = Constants.MAINBOARD_X_LAYOUT;

    public static final double yLayout = Constants.MAINBOARD_Y_LAYOUT;


    private Point2D[][] forbiddenPoints;

    protected double[][] gridLocations;


    public static final int TILE_SIZE = Constants.TILE_SIZE;

    final int ROW_NO = 16;
    final int COLUMN_NO = 16;

    private Point2D[] locations;
    private int gridNo;

    public MainBoard() {
    }

    public MainBoard(Point2D[] loc, int gridNo, Point2D[][] forbiddenPts) {
        gridLocations = new double[gridNo][2];


        this.locations = new Point2D[gridNo];
        System.arraycopy(loc, 0, this.locations, 0, gridNo);
        //this.locations = loc;
        this.gridNo = gridNo;

        forbiddenPoints = new Point2D[gridNo][2];

        for (int i = 0; i < gridNo; i++) {
            for (int j = 0; j < 2; j++) {
                forbiddenPoints[i][j] = forbiddenPts[i][j];

            }
        }

        Rectangle rect = new Rectangle(xLayout, yLayout, TILE_SIZE * ROW_NO, TILE_SIZE * COLUMN_NO);
        rect.setFill(Color.rgb(10, 13, 13, 0));

        getChildren().add(rect);

        createGrids();

    }


    public void createGrids() {
        for (int i = 0; i < gridNo; i++) {
            Grid grid = new Grid(forbiddenPoints[i][0], forbiddenPoints[i][1]);

            double x = xLayout + locations[i].getX() * TILE_SIZE;
            double y = yLayout + locations[i].getY() * TILE_SIZE;

            grid.setxLayout(x);
            grid.setyLayout(y);

            gridLocations[i][0] = x;
            gridLocations[i][1] = y;

            getChildren().add(grid);
        }

    }


    public Point2D[][] getForbiddenPoints() {
        return forbiddenPoints;
    }

    public Point2D[] getLocations() {
        return locations;
    }

    public int getGridNo() {
        return gridNo;
    }


}
