package com.quadzillion.core.pieces;

import com.quadzillion.core.levels.ExtendedLevel;
import com.quadzillion.core.levels.Level;
import com.quadzillion.core.levels.PuzzleLevel;
import com.quadzillion.core.move.MoveChecker;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PieceFactory {

    public static final int VANILLA_PIECE = 0;
    public static final int EXTENDED_PIECE = 1;
    public static final int PUZZLE_PIECE = 2;

    private Level level;
    private MoveChecker moveChecker;



    public PieceFactory(Level lvl, MoveChecker mvc)
    {
        level = lvl;
        moveChecker = mvc;
    }

    public ArrayList<Piece> buildPieces(int type)
    {


        if (type == VANILLA_PIECE)
        {
            ArrayList<Piece> vanillaPieces = new ArrayList<>();

            Piece circle = new RedPiece(moveChecker);
            Piece tpiece = new GreenPiece(moveChecker);
            Piece lightBlue = new LightBluePiece(moveChecker);
            Piece blue = new BluePiece(moveChecker);
            Piece purple = new PurplePiece(moveChecker);
            Piece lightLime = new LightLimePiece(moveChecker);
            Piece orange = new OrangePiece(moveChecker);
            Piece pink = new PinkPiece(moveChecker);
            Piece yellow = new YellowPiece(moveChecker);
            Piece darkBlue = new DarkBluePiece(moveChecker);
            Piece maroonPiece = new MaroonPiece(moveChecker);
            Piece darkGreen = new DarkGreenPiece(moveChecker);

            vanillaPieces.add(darkGreen);
            vanillaPieces.add(maroonPiece);
            vanillaPieces.add(purple);
            vanillaPieces.add(lightBlue);
            vanillaPieces.add(tpiece);
            vanillaPieces.add(blue);
            vanillaPieces.add(circle);
            vanillaPieces.add(lightLime);
            vanillaPieces.add(orange);
            vanillaPieces.add(pink);
            vanillaPieces.add(yellow);
            vanillaPieces.add(darkBlue);

            return vanillaPieces;

        }
        else if( type == EXTENDED_PIECE)
        {
            ArrayList<Piece> extendedPieces = new ArrayList<>();

            GeneratedPiece gp3 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.PURPLE, 3);
            GeneratedPiece gp4 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.PINK, 4);
            GeneratedPiece gp5 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.BLUE, 5);
            GeneratedPiece gp6 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.GREEN, 6);
            GeneratedPiece gp7 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.GOLD, 7);
            GeneratedPiece gp8 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.INDIGO, 8);
            GeneratedPiece gp9 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.NAVY, 9);
            GeneratedPiece gp10 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.HOTPINK, 10);
            GeneratedPiece gp11 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.CHOCOLATE, 11);
            GeneratedPiece gp12 = new GeneratedPiece(moveChecker, ((ExtendedLevel)level).solution, Color.YELLOW, 12);

            extendedPieces.add(gp3);
            extendedPieces.add(gp4);
            extendedPieces.add(gp5);
            extendedPieces.add(gp6);
            extendedPieces.add(gp7);
            extendedPieces.add(gp8);
            extendedPieces.add(gp9);
            extendedPieces.add(gp10);
            extendedPieces.add(gp11);
            extendedPieces.add(gp12);

            return extendedPieces;


        }
        else if( type == PUZZLE_PIECE)
        {
            ArrayList<Piece> puzzlePiece = new ArrayList<>();

            PuzzlePiece pc3 = new PuzzlePiece(moveChecker,  ((PuzzleLevel)level).solution, 3,  ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc4 = new PuzzlePiece(moveChecker,  ((PuzzleLevel)level).solution, 4, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc5 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 5, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc6 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 6, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc7 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 7, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc8 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 8, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc9 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 9, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc10 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 10, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc11 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 11, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc12 = new PuzzlePiece(moveChecker,((PuzzleLevel)level). solution, 12, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc13 = new PuzzlePiece(moveChecker,((PuzzleLevel)level). solution, 13, ((PuzzleLevel)level).getFileName());
            PuzzlePiece pc14 = new PuzzlePiece(moveChecker, ((PuzzleLevel)level).solution, 14, ((PuzzleLevel)level).getFileName());

            puzzlePiece.add(pc3);
            puzzlePiece.add(pc4);
            puzzlePiece.add(pc5);
            puzzlePiece.add(pc6);
            puzzlePiece.add(pc7);
            puzzlePiece.add(pc8);
            puzzlePiece.add(pc9);
            puzzlePiece.add(pc10);
            puzzlePiece.add(pc11);
            puzzlePiece.add(pc12);
            puzzlePiece.add(pc13);
            puzzlePiece.add(pc14);

            return puzzlePiece;

        }
        else
            return null;
    }


}
