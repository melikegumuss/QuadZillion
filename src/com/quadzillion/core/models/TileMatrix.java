package com.quadzillion.core.models;


import com.quadzillion.gui.controller.Controllable;
import com.quadzillion.gui.controller.PlayController;
import com.quadzillion.gui.controller.Util;
import javafx.geometry.Point2D;

public class TileMatrix {

    private int[][] tileMatrix;
    MainBoard mainBoard;

    boolean isFinished;

    public TileMatrix(MainBoard mainBrd) {

        isFinished = false;
        mainBoard = mainBrd;
        tileMatrix = new int[16][16];
        init();


    }

    public void init() {

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {

                tileMatrix[i][j] = Tile.EMPTY;

                Point2D tempPoint = new Point2D(i, j);

                if (isGridLocation(tempPoint)) {
                    if (isForbiddenPoint(tempPoint)) {
                        tileMatrix[i][j] = Tile.FORBID;
                    } else {
                        tileMatrix[i][j] = Tile.VALID;
                    }


                }


            }
        }

    }

    public boolean isGridLocation(Point2D point) {
        for (Point2D gridCorner : mainBoard.getLocations()) {
            if (((gridCorner.getX() <= point.getX()) && gridCorner.getX() + 3 >= point.getX())
                    && ((gridCorner.getY() <= point.getY()) && gridCorner.getY() + 3 >= point.getY()))
                return true;
        }

        return false;

    }

    public boolean isForbiddenPoint(Point2D point) {
        for (int i = 0; i < 4; i++) {

            Point2D firstForbidden = new Point2D(mainBoard.getLocations()[i].getX() + mainBoard.getForbiddenPoints()[i][0].getX(),
                    mainBoard.getLocations()[i].getY() + mainBoard.getForbiddenPoints()[i][0].getY());

            Point2D secondForbidden = new Point2D(mainBoard.getLocations()[i].getX() + mainBoard.getForbiddenPoints()[i][1].getX(),
                    mainBoard.getLocations()[i].getY() + mainBoard.getForbiddenPoints()[i][1].getY());


            if (point.equals(firstForbidden) || point.equals(secondForbidden))
                return true;

        }

        return false;
    }

    public int get(int x, int y) {
        return tileMatrix[x][y];
    }

    public void updateMatrix(int x, int y, int tile) {
        tileMatrix[x][y] = tile;
        isFinished = finishTest();
        // isFinished = true;
        if (isFinished) {
            Controllable controllable = Util.getSceneController(Util.SCENE_PLAY_GAME);

            if (controllable != null && controllable instanceof PlayController)
                ((PlayController) controllable).onGameSuccessfullyCompleted();

        }
    }


    public boolean finishTest() {
        boolean finished = true;

        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 16; i++) {
                if (tileMatrix[i][j] == Tile.VALID)
                    finished = false;
            }
        }

        return finished;
    }

    public boolean isFinished() {
        return isFinished;
    }


}
