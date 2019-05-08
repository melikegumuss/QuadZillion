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
/*

        Image image = new Image("com/quadzillion/gui/resources/images/A.jpg");

        // simple displays ImageView the image as is
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(Constants.TILE_SIZE);
        iv.setFitWidth(Constants.TILE_SIZE);



        iv.setLayoutX(Constants.TILE_SIZE * pos2.get(0).getX());
        iv.setLayoutY(Constants.TILE_SIZE * pos2.get(0).getY());


        getChildren().add(iv);

        Image image2 = new Image("com/quadzillion/gui/resources/images/B.jpg");

        // simple displays ImageView the image as is
        ImageView iv2 = new ImageView();
        iv2.setImage(image2);
        iv2.setFitHeight(Constants.TILE_SIZE);
        iv2.setFitWidth(Constants.TILE_SIZE);



        iv2.setLayoutX(Constants.TILE_SIZE * pos2.get(1).getX());
        iv2.setLayoutY(Constants.TILE_SIZE * pos2.get(1).getY());


        getChildren().add(iv2);


        Image image3 = new Image("com/quadzillion/gui/resources/images/C.jpg");

        // simple displays ImageView the image as is
        ImageView iv3 = new ImageView();
        iv3.setImage(image3);
        iv3.setFitHeight(Constants.TILE_SIZE);
        iv3.setFitWidth(Constants.TILE_SIZE);



        iv3.setLayoutX(Constants.TILE_SIZE * pos2.get(2).getX());
        iv3.setLayoutY(Constants.TILE_SIZE * pos2.get(2).getY());


        getChildren().add(iv3);


        Image image4 = new Image("com/quadzillion/gui/resources/images/D.jpg");

        // simple displays ImageView the image as is
        ImageView iv4 = new ImageView();
        iv4.setImage(image4);
        iv4.setFitHeight(Constants.TILE_SIZE);
        iv4.setFitWidth(Constants.TILE_SIZE);


        iv4.setLayoutX(Constants.TILE_SIZE * pos2.get(3).getX());
        iv4.setLayoutY(Constants.TILE_SIZE * pos2.get(3).getY());


        getChildren().add(iv4);

   }

   */


}
