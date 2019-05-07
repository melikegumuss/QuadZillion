package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class GeneratedPiece extends Piece
{
    public GeneratedPiece(MoveChecker moveChecker, int[][] solution, Color color, int id)
    {
        super(moveChecker);


        INIT_X = Constants.INIT_LOCATION[id - 3][0];
        INIT_Y = Constants.INIT_LOCATION[id - 3][1];

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);


        this.pos = new ArrayList<Point2D>();


        this.color = color;

        this.id = id;

        this.moveChecker = moveChecker;


        solutionToPos(solution);
        setListeners();
    }

    public void solutionToPos(int[][] solution) {
        ArrayList<Point2D> newPos = new ArrayList<>();

        ArrayList<Circle> circles = new ArrayList<>();

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                if ( id == solution[j][i]) {
                    newPos.add(new Point2D(i, j));

                    Circle circle = new Circle();
                    circle.setRadius(Constants.TILE_SIZE/2);
                    circle.setFill(color);
                    circles.add(circle);
                }

            }
        }


        normalizeCoor(newPos);


        for (int i = 0; i < circles.size(); i++) {

            Circle circle = circles.get(i);

            circle.setLayoutX(Constants.TILE_SIZE * pos.get(i).getX());
            circle.setLayoutY(Constants.TILE_SIZE * pos.get(i).getY());


            getChildren().add(circle);

        }


    }
}