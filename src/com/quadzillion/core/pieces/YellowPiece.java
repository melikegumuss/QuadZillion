package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class YellowPiece extends Piece {
    public YellowPiece(MoveChecker moveChecker) {
        super(moveChecker);

        INIT_X = Constants.MAINBOARD_X_LAYOUT + (Constants.COLUMN_NO + 2) * Constants.TILE_SIZE;
        INIT_Y = Constants.MAINBOARD_Y_LAYOUT + Constants.TILE_SIZE * 7;

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);

        pos = new ArrayList<Point2D>();

        pos.add(new Point2D(0, 0));
        pos.add(new Point2D(0, 1));
        pos.add(new Point2D(0, 2));
        pos.add(new Point2D(0, 3));
        pos.add(new Point2D(1, 1));


        color = Color.YELLOW;

        id = 11;

        this.moveChecker = moveChecker;

        createCircles(pos);
        setListeners();
    }
}