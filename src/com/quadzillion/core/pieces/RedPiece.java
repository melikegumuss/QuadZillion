package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class RedPiece extends Piece {
    public RedPiece(MoveChecker moveChecker)
    {
        super(moveChecker);

        INIT_X = Constants.MAINBOARD_X_LAYOUT - 3 * Constants.TILE_SIZE;
        INIT_Y = Constants.MAINBOARD_Y_LAYOUT;

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);

        System.out.println(getLayoutX() + " , " + getLayoutY());

        pos = new ArrayList<Point2D>();

        pos.add(new Point2D(0,0));
        pos.add(new Point2D(0,1));
        pos.add(new Point2D(0,2));
        pos.add(new Point2D(0,3));
        pos.add(new Point2D(1,3));


        color = Color.RED;

        id = 3;

        this.moveChecker = moveChecker;


        createCircles(pos);
        setListeners();
    }
}
