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

        int k = 0;

        for (int i = 0; i < getGridNo() ; i++) {



            if (getForbiddenPoints()[i][0].equals(getForbiddenPoints()[i][1]))
            {
                views.get(k).setLayoutX(gridLocations[i][0] + Constants.TILE_SIZE * getForbiddenPoints()[i][0].getX());
                views.get(k).setLayoutY(gridLocations[i][1] + Constants.TILE_SIZE * getForbiddenPoints()[i][0].getY());

                getChildren().add(views.get(k));
                k++;

            }
            else
            {
                views.get(k).setLayoutX(gridLocations[i][0] + Constants.TILE_SIZE * getForbiddenPoints()[i][0].getX());
                views.get(k).setLayoutY(gridLocations[i][1] + Constants.TILE_SIZE * getForbiddenPoints()[i][0].getY());

                getChildren().add(views.get(k));
                k++;

                views.get(k).setLayoutX(gridLocations[i][0] + Constants.TILE_SIZE * getForbiddenPoints()[i][1].getX());
                views.get(k).setLayoutY(gridLocations[i][1] + Constants.TILE_SIZE * getForbiddenPoints()[i][1].getY());


                getChildren().add(views.get(k));
                k++;

            }

        }

    }



}

