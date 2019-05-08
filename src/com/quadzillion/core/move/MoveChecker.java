package com.quadzillion.core.move;

import com.quadzillion.core.AbstractPane;
import com.quadzillion.core.models.Tile;
import com.quadzillion.core.models.TileMatrix;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class MoveChecker {
    TileMatrix tileMatrix;

    public MoveChecker(TileMatrix tm) {
        tileMatrix = tm;

    }

    public MoveType move(ArrayList<Point2D> locationMap, int pieceID) {

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (tileMatrix.get(i, j) == pieceID) {
                    tileMatrix.updateMatrix(i, j, Tile.VALID);
                }
            }
        }

        if (isValid(locationMap)) {
            for (Point2D point : locationMap) {
                tileMatrix.updateMatrix((int) point.getX(), (int) point.getY(), pieceID);
            }


            return MoveType.VALID;
        } else {
            if (isAllEMpty(locationMap)) {

                return MoveType.EMPTY;
            } else {

                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        if (tileMatrix.get(i, j) == pieceID) {
                            tileMatrix.updateMatrix(i, j, Tile.VALID);
                        }
                    }
                }


                return MoveType.INVALID;
            }
        }
    }


    private boolean isValid(ArrayList<Point2D> locationMap) {
        boolean valid = true;

        for (Point2D point : locationMap) {
            if (point.getX() < 0 || point.getY() < 0)
                return false;

            if (point.getX() > 15 || point.getY() > 15)
                return false;
        }

        for (Point2D point : locationMap) {
            if (tileMatrix.get((int) point.getX(), (int) point.getY()) != Tile.VALID)
                valid = false;

        }
        return valid;
    }

    private boolean isAllEMpty(ArrayList<Point2D> locationMap) {
        boolean isAnyOut = true;
        boolean isEmpty = true;

        int k = 0;

        for (Point2D point : locationMap) {
            if (isOut((int) point.getX(), (int) point.getY())) {
                k++;
            } else {
                if (tileMatrix.get((int) point.getX(), (int) point.getY()) == Tile.EMPTY)
                    k++;
            }

        }

        if (k == locationMap.size())
            return true;
        else {
            return false;
        }
    }

    public boolean isOut(int x, int y) {

        if (x < 0 || y < 0 || x > 15 || y > 15)
            return true;
        else
            return false;

    }


}
