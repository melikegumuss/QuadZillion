package com.quadzillion.core.models;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PuzzleMainBoard extends MainBoard {

    public PuzzleMainBoard(Point2D[] loc, int gridNo, Point2D[][] forbiddenPts) {
        super(loc, gridNo, forbiddenPts);

    }


    public void putImageToPoints(ArrayList<String> imageUrls)
    {

        ArrayList<ImageView> views = new ArrayList<>();

        for(String imageUrl : imageUrls) {
            Image image = new Image(imageUrl);
            // simple displays ImageView the image as is
            ImageView iv1 = new ImageView();
            iv1.setImage(image);
            iv1.setFitHeight(Constants.TILE_SIZE);
            iv1.setFitWidth(Constants.TILE_SIZE);
            views.add(iv1);
        }


        for (int i = 0; i < getGridNo() ; i++) {
            for (int j = 0; j < 2 ; j++) {
                views.get(j + (2 * i)).setLayoutX(gridLocations[i][0] + Constants.TILE_SIZE * getForbiddenPoints()[i][j].getX());
                views.get(j + (2 * i)).setLayoutY(gridLocations[i][1] + Constants.TILE_SIZE * getForbiddenPoints()[i][j].getY());

                getChildren().add(views.get(j + (2 * i)));
            }
        }

    }



}

