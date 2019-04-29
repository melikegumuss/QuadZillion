package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GeneratedPiece extends Piece
{
    public GeneratedPiece(MoveChecker moveChecker, ArrayList<Point2D> pos, Color color, int id)
    {
        super(moveChecker);


        INIT_X = Constants.MAINBOARD_X_LAYOUT - 7 *  Constants.TILE_SIZE + 10;
        INIT_Y = Constants.MAINBOARD_Y_LAYOUT + 70;

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);


        this.pos = pos;


        this.color = color;

        this.id = id;

        this.moveChecker = moveChecker;


        createCircles(pos);
        setListeners();
    }
}