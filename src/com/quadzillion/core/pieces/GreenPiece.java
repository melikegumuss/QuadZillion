package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GreenPiece extends Piece {
    public GreenPiece(MoveChecker moveChecker) {
        super(moveChecker);

        id = 7;

        INIT_X = Constants.INIT_LOCATION[id][0];
        INIT_Y = Constants.INIT_LOCATION[id][1];

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);

        pos = new ArrayList<Point2D>();

        pos.add(new Point2D(0, 0));
        pos.add(new Point2D(1, 0));
        pos.add(new Point2D(1, 1));
        pos.add(new Point2D(1, 2));
        pos.add(new Point2D(0, 2));


        color = Color.GREEN;


        this.moveChecker = moveChecker;


        createCircles(pos);
        setListeners();
    }
}

