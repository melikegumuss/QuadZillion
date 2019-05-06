package com.quadzillion.core.pieces;

import com.quadzillion.core.models.Constants;
import com.quadzillion.core.models.MainBoard;
import com.quadzillion.core.move.MoveChecker;
import com.quadzillion.core.move.MoveType;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import com.quadzillion.core.PuzzleGamePane;
import java.util.ArrayList;

public abstract class Piece extends Group {


    protected double INIT_X;
    protected double INIT_Y ;

    MoveChecker  moveChecker;

    protected double x;
    protected double y;

    private double radious = Constants.TILE_SIZE/2;

    protected ArrayList<Point2D> pos;
    protected ArrayList<Node> nodes;


    protected Color color;
    protected int id;


    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public Piece( MoveChecker moveChecker)
    {
        nodes = new ArrayList<Node>();
    }


    public Piece( MoveChecker moveChecker, ArrayList<Point2D> pos, Color color, int id)
    {

    }

    public Piece( MoveChecker moveChecker, int[][] solution, int id, String fileName)
    {

    }


    public void createCircles( ArrayList<Point2D> pos2)
    {
        for (Point2D point :pos2)
        {
            double x = (point.getX() * 2 * radious) + radious;
            double y = (point.getY() * 2 * radious) + radious;

            Circle circle = new Circle(x,y,radious);

            circle.setFill(color);

            getChildren().add(circle);
        }

    }

    public void setListeners()
    {

        setOnMouseDragged(e -> {

            if (e.getButton() == MouseButton.PRIMARY) {
                double offsetX = e.getSceneX() - orgSceneX;
                double offsetY = e.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                toFront();

                setLayoutX(newTranslateX);
                x = newTranslateX;

                setLayoutY(newTranslateY);
                y = newTranslateY;
            }

        });

        setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.SECONDARY){
                turn();

                ArrayList<Point2D> point2ds = translateToBoard();

                MoveType type = moveChecker.move(point2ds,id);

                if( type == MoveType.VALID) {

                    double deltaX = getBoundsInParent().getMinX() - getLayoutX();
                    double deltaY = getBoundsInParent().getMinY() - getLayoutY();

                    Point2D minPnt = minPoint(point2ds);

                    x = MainBoard.xLayout + minPnt.getX() * MainBoard.TILE_SIZE;
                    y = MainBoard.yLayout + minPnt.getY() * MainBoard.TILE_SIZE;
                    setLayoutX(x - deltaX);
                    setLayoutY(y - deltaY);
                }
                else if( type == MoveType.EMPTY){}
                else
                {
                    x = INIT_X;
                    y = INIT_Y;
                    setLayoutX(x);
                    setLayoutY(y);
                }


            }
            else if ( e.getButton() == MouseButton.MIDDLE) {
                flip();

                 ArrayList<Point2D> point2ds = translateToBoard();

                MoveType type = moveChecker.move(point2ds, id);

                if (type == MoveType.VALID) {

                    double deltaX = getBoundsInParent().getMinX() - getLayoutX();
                    double deltaY = getBoundsInParent().getMinY() - getLayoutY();

                    Point2D minPnt = minPoint(point2ds);

                    x = MainBoard.xLayout + minPnt.getX() * MainBoard.TILE_SIZE;
                    y = MainBoard.yLayout + minPnt.getY() * MainBoard.TILE_SIZE;
                    setLayoutX(x - deltaX);
                    setLayoutY(y - deltaY);

                }
                else if( type == MoveType.EMPTY){}
                else {
                    x = INIT_X;
                    y = INIT_Y;
                    setLayoutX(x);
                    setLayoutY(y);
                }
            }
            else {
                orgSceneX = e.getSceneX();
                orgSceneY = e.getSceneY();
                orgTranslateX = getLayoutX(); //returns grubun baslangıc noktası
                orgTranslateY = getLayoutY();
                System.out.println(x + "," + y);
            }

        });



        setOnMouseReleased( e ->
        {
        ArrayList<Point2D> point2ds = translateToBoard();

            MoveType type = moveChecker.move(point2ds,id);

            System.out.println("point2ds: " + point2ds);


            if( type == MoveType.VALID) {

                double deltaX = getBoundsInParent().getMinX() - getLayoutX();
                double deltaY = getBoundsInParent().getMinY() - getLayoutY();

                Point2D minPnt = minPoint(point2ds);

                x = MainBoard.xLayout + minPnt.getX() * MainBoard.TILE_SIZE;
                y = MainBoard.yLayout + minPnt.getY() * MainBoard.TILE_SIZE;
                setLayoutX(x - deltaX);
                setLayoutY(y - deltaY);
                incrementCounter();


            }
            else if( type == MoveType.EMPTY){}
            else
            {

                x = INIT_X;
                y = INIT_Y;
                setLayoutX(x);
                setLayoutY(y);


            }

        });
    }

    public ArrayList<Point2D> translateToBoard()
    {
        double mainboardX = MainBoard.xLayout;
        double mainboardY = MainBoard.yLayout;

        System.out.println("MainBoard:  " + mainboardX + "," + mainboardY);

        System.out.println("MainBoard x,y:  " + getBoundsInParent().getMinX() + "," + getBoundsInParent().getMinY());

        ArrayList<Point2D> locationMap = new ArrayList<Point2D>();

        for(Point2D point  : pos){

            double realX;
            double realY;

            int xLoc;
            int yLoc;

            double x = getBoundsInParent().getMinX();
            double y = getBoundsInParent().getMinY();


            double centerX = (x + ((MainBoard.TILE_SIZE / 2) + point.getX() * MainBoard.TILE_SIZE));
            double centerY = (y + ((MainBoard.TILE_SIZE / 2) + point.getY() * MainBoard.TILE_SIZE));

            realX =  centerX - mainboardX;
            realY =  centerY - mainboardY;


            if( centerX - mainboardX < 0)
                xLoc = (int) ( realX / MainBoard.TILE_SIZE) - 1;
            else
                xLoc = (int) ( realX / MainBoard.TILE_SIZE);


            if( centerY - mainboardY < 0)
                yLoc = (int) ( realY / MainBoard.TILE_SIZE) - 1;
            else
                yLoc = (int) ( realY / MainBoard.TILE_SIZE);


            System.out.println( (centerX - mainboardX) + " ," + ( centerY - mainboardY));

            locationMap.add( new Point2D(xLoc,yLoc));
        }


        for(Point2D point : locationMap)
            System.out.println("point x: " + point.getX()+ " point y " + point.getY());

        return locationMap;

    }

    public void turn()
    {
            setRotate(getRotate() + 90);
            ArrayList<Point2D> pos2 = new ArrayList<Point2D>();

            //  circles.removeAll(getChildren());

            //getChildren().removeAll(getChildren());

            for (int i = 0; i  < pos.size(); i++) {

                double newX = -1 * pos.get(i).getY();
                double newY = pos.get(i).getX();
                Point2D newPoint = new Point2D(newX,newY);
                pos2.add(newPoint);

            }
            normalizeCoor(pos2);

            //createCircles(pos2);
        System.out.println("-----------------------");
            System.out.println(pos);
        System.out.println("-----------------------");
    }


    public void flip()
    {

        ArrayList<Point2D> pos2 = new ArrayList<Point2D>();

        if((getRotate() % 360) == 0 ||(getRotate() % 360)  == 180) {
              setScaleX( -getScaleX() );

        }
        else
        {
            setScaleY( -getScaleY() );
        }

        for (int i = 0; i < pos.size(); i++) {

            double newX = -1 * pos.get(i).getX();
            double newY = pos.get(i).getY();
            Point2D newPoint = new Point2D(newX, newY);
            pos2.add(newPoint);
        }

        System.out.println(getRotate());

        normalizeCoor(pos2);


    }

    protected void normalizeCoor(ArrayList<Point2D> pos2)
    {
        double xDelta;
        double yDelta;

        Point2D minPnt;

        ArrayList<Point2D> pos3 = new ArrayList<Point2D>();

        minPnt = minPoint(pos2);

        for ( Point2D point : pos2)
        {
            pos3.add( new Point2D(point.getX() - minPnt.getX(), point.getY() - minPnt.getY()));
        }

        pos = (ArrayList<Point2D>) pos3.clone();
    }

    protected Point2D minPoint(ArrayList<Point2D> pos2)
    {
        double minX = pos2.get(0).getX();
        double minY = pos2.get(0).getY();


        for ( Point2D point : pos2)
        {
            if (point.getX() < minX)
                minX = point.getX();

            if (point.getY() < minY)
                minY = point.getY();
        }

        return new Point2D(minX,minY);

    }

    public void incrementCounter(){
        PuzzleGamePane.moveCounter++;
        PuzzleGamePane.counter.setText("Move Count: " + PuzzleGamePane.moveCounter );
    }

}
