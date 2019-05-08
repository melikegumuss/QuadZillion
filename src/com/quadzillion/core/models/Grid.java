package com.quadzillion.core.models;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Grid extends Group {


    double xLayout;
    double yLayout;

    private int size;
    private Point2D[] forbiddenPoints;


    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public Grid(Point2D forbiddenPoint1, Point2D forbiddenPoint2) {
        super();
        forbiddenPoints = new Point2D[2];

        forbiddenPoints[0] = forbiddenPoint1;
        forbiddenPoints[1] = forbiddenPoint2;

        xLayout = 0;
        yLayout = 0;

        size = Constants.TILE_SIZE;

        createGrid();
    }

    public void setxLayout(double xLayout) {
        this.xLayout = xLayout;
        setLayoutX(xLayout);
    }

    public void setyLayout(double yLayout) {
        this.yLayout = yLayout;
        setLayoutY(yLayout);

    }

    public void createGrid() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                double x = xLayout + (i * size);
                double y = yLayout + (j * size);

                double x_circle = xLayout + size / 2 + (size * i);
                double y_circle = yLayout + size / 2 + (size * j);

                Rectangle rect = new Rectangle(x, y, size, size);
                Circle circle = new Circle(x_circle, y_circle, size / 2);

                if (forbiddenPoints[0].equals(new Point2D(i, j)) || forbiddenPoints[1].equals(new Point2D(i, j)))
                    circle.setFill(Color.WHITE);
                else
                    circle.setFill(Color.rgb(40, 40, 40));

                rect.setFill(Color.BLACK);


                getChildren().add(rect);
                getChildren().add(circle);

            }

        }


    }


}
