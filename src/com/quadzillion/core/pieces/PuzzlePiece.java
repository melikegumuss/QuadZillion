package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.move.MoveChecker;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PuzzlePiece extends Piece {

    private String fileName;

    public PuzzlePiece(MoveChecker moveChecker, int[][] solution, int id, String fileName) {
        super(moveChecker);


        this.id = id;
        this.fileName = fileName;

        INIT_X = Constants.INIT_LOCATION[id - 3][0];
        INIT_Y = Constants.INIT_LOCATION[id - 3][1];

        x = INIT_X;
        y = INIT_Y;

        setLayoutX(INIT_X);
        setLayoutY(INIT_Y);


        pos = new ArrayList<Point2D>();

        solutionToPos(solution);


        this.moveChecker = moveChecker;

        //createCircles(pos);
        setListeners();
    }

    public void createCircles(ArrayList<Point2D> pos2) {


    }

    public void solutionToPos(int[][] solution) {
        ArrayList<Point2D> newPos = new ArrayList<>();

        ArrayList<ImageView> images = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (id == solution[j][i]) {
                    newPos.add(new Point2D(i, j));
                    Image image = new Image("com/quadzillion/gui/resources/images/puzzleLevels/" + fileName + "/" + j + i + ".jpg");


                    // simple displays ImageView the image as is
                    ImageView iv1 = new ImageView();
                    iv1.setImage(image);
                    iv1.setFitHeight(Constants.TILE_SIZE);
                    iv1.setFitWidth(Constants.TILE_SIZE);

                    images.add(iv1);
                }

            }
        }


        normalizeCoor(newPos);


        for (int i = 0; i < images.size(); i++) {

            ImageView iv1 = images.get(i);

            iv1.setLayoutX(Constants.TILE_SIZE * pos.get(i).getX());
            iv1.setLayoutY(Constants.TILE_SIZE * pos.get(i).getY());


            getChildren().add(iv1);

        }


    }



}
